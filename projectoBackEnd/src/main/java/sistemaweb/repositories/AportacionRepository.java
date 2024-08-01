package sistemaweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaweb.entitys.Aportacion;

public interface AportacionRepository extends JpaRepository<Aportacion, Long> {
    // Método de búsqueda de tipo de inversión por tipo

    // Otros métodos de búsqueda si es necesario
}
