package prueba3.cine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba3.cine.model.SalaCine;
import prueba3.cine.repository.SalaCineRepository;

import java.util.List;

@Service
public class SalaCineService {

    @Autowired
    private SalaCineRepository scr;

    public SalaCine guardar(SalaCine salacine){
        return scr.save(salacine);
    }

    public void eliminar(Long id){
        scr.deleteById(id);
    }

    public List<SalaCine> listar(){
        return scr.findAll();
    }
}
