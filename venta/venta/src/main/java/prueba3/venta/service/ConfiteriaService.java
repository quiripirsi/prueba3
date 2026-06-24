package prueba3.venta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba3.venta.model.Confiteria;
import prueba3.venta.repository.ConfiteriaRepository;

import java.util.List;

@Service
public class ConfiteriaService {

    @Autowired
    private ConfiteriaRepository crr;

    public Confiteria guardar(Confiteria confiteria){
        return crr.save(confiteria);
    }

    public void eliminar(Long id){
        crr.deleteById(id);
    }

    public List<Confiteria> listar(){
        return crr.findAll();
    }
}
