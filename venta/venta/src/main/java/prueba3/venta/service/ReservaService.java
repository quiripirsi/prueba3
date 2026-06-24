package prueba3.venta.service;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba3.venta.model.PeliculaDTO;
import prueba3.venta.model.Reserva;
import prueba3.venta.openfeing.PeliculaOP;
import prueba3.venta.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository rr;
    @Autowired
    private PeliculaOP po;

    public Reserva guardar(Reserva reserva){
        try{
            PeliculaDTO peliculaOk = po.peliculaPorId(reserva.getPeliculaId());
            return rr.save(reserva);
        } catch (FeignException.NotFound np){
            throw new RuntimeException("Pelicula no en cartelera");
        }
    }

    public void eliminar(Long id){
        rr.deleteById(id);
    }

    public List<Reserva> listar(){
        return rr.findAll();
    }
}
