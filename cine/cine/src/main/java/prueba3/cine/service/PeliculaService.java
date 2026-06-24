package prueba3.cine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba3.cine.model.Pelicula;
import prueba3.cine.repository.PeliculaRepository;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository pr;

    public Pelicula guardar(Pelicula pelicula){
        return pr.save(pelicula);
    }

    public void eliminar(Long id){
        pr.deleteById(id);
    }

    public List<Pelicula> listar(){
        return pr.findAll();
    }
}
