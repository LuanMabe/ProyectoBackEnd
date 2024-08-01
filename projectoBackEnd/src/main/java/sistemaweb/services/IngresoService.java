package sistemaweb.services;

import org.springframework.stereotype.Service;


import sistemaweb.controllers.response.IngresoResponse;

import sistemaweb.entitys.Ingreso;

@Service
public interface IngresoService {
    public IngresoResponse consultar();

    public IngresoResponse buscarPorId(Long id);

    public IngresoResponse crear(Ingreso ingreso);

    public IngresoResponse modificar(Ingreso ingreso, Long id);

    public IngresoResponse eliminar(Long id);

    public void info(String string);

 

}
