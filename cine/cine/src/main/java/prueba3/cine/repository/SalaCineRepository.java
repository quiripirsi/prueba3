package prueba3.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba3.cine.model.SalaCine;

@Repository
public interface SalaCineRepository extends JpaRepository<SalaCine, Long> {
}
