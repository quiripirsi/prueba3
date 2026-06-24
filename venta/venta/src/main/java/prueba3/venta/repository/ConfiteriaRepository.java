package prueba3.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba3.venta.model.Confiteria;

@Repository
public interface ConfiteriaRepository extends JpaRepository<Confiteria, Long> {
}
