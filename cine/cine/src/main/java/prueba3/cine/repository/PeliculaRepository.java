package prueba3.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba3.cine.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
