package sistemaweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import sistemaweb.entitys.Egreso;

public interface EgresoRepository extends JpaRepository<Egreso, Long>{
    
}
