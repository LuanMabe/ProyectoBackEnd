package sistemaweb.services;


import org.springframework.stereotype.Service;

import sistemaweb.controllers.response.AportacionResponse;
import sistemaweb.entitys.Aportacion;

@Service
public interface /*class*/ AportacionService {
    public AportacionResponse consultar();

    public AportacionResponse buscarPorId(Long id);

    public AportacionResponse crear(Aportacion aportacion);

    public AportacionResponse modificar(Aportacion aportacion, Long id);

    public AportacionResponse eliminar(Long id);




    // Otras operaciones relacionadas con el socio
}