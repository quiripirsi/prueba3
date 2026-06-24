package prueba3.venta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba3.venta.model.Cliente;
import prueba3.venta.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository cr;

    public Cliente registro(Cliente cliente){
        return cr.save(cliente);
    }

    public void eliminar(Long id){
        cr.deleteById(id);
    }

    public List<Cliente> listar(){
        return cr.findAll();
    }
}
