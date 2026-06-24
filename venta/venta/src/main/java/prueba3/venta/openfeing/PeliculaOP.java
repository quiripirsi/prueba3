package prueba3.venta.openfeing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import prueba3.venta.model.PeliculaDTO;

@FeignClient(name = "cine", url = "http://localhost:8081/api/v1/peliculas")
public interface PeliculaOP {

    @GetMapping("/{id}")
    PeliculaDTO peliculaPorId(@PathVariable("id") Long id);
}
