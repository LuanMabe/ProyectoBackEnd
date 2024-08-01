package sistemaweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.diego.sistemaweb.services.SocioService;
import sistemaweb.controllers.response.InfoRest;
import sistemaweb.controllers.response.SocioResponse;
import sistemaweb.entitys.Socio;
import sistemaweb.repositories.SocioRepository;

import org.springframework.transaction.annotation.Transactional;
// @Service
public class SocioServicelmpl implements SocioService{
    @Autowired
    private SocioRepository socioRepository;

    
    @Override
    @Transactional(readOnly = true)
    public SocioResponse consultar() {
        var socioResponse= new SocioResponse();        
        var data = (List<Socio>) this.socioRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;
    }
    
    @Override
    @Transactional(readOnly = true)
    public SocioResponse buscarPorId(Long id) {
        var socioResponse= new SocioResponse();        
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.socioRepository.findById(id);
        if(socioBuscada.isPresent()){
            data.add(socioBuscada.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;
    }

    // @Override
    @Transactional
    public SocioResponse crear(Socio socio) {
        var socioResponse= new SocioResponse(); 
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.socioRepository.save(socio));
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;
    }

    @Override
    @Transactional
    public SocioResponse modificar(Socio socio, Long id) {
        var socioResponse= new SocioResponse();        
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.socioRepository.findById(id);
        if(socioBuscada.isPresent()){
            socioBuscada.get().setNombre(socio.getNombre());
            socioBuscada.get().setDescripcion(socio.getDescripcion());
            data.add(this.socioRepository.save(socioBuscada.get()));
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;  
    }

    @Override
    @Transactional
    public SocioResponse eliminar(Long id) {
        var socioResponse= new SocioResponse();        
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.socioRepository.findById(id);
        if(socioBuscada.isPresent()){
            this.socioRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;  
    }
        @Override
    @Transactional
    public SocioResponse restarInversionConAportacion(Long id_socio, Float cantidadAportacion) {
        SocioResponse socioResponse = new SocioResponse();
        List<Socio> data = new ArrayList<>();
        List<InfoRest> infoList = new ArrayList<>();

        Socio socio = socioRepository.findById(id_socio).orElse(null);

        if (socio == null) {
            infoList.add(new InfoRest(1, "Socio no encontrado", 1));
        } else {
            // Restar la cantidad de aportación de la inversión total
            float nuevaInversion = socio.getInversionTotal() - cantidadAportacion;
            socio.setInversionTotal(nuevaInversion);
            // Guardar el socio actualizado
            socioRepository.save(socio);
            data.add(socio);
        }

        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);

        return socioResponse;
    }
}
