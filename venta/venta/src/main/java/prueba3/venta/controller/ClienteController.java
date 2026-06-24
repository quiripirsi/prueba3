package prueba3.venta.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba3.venta.model.Cliente;
import prueba3.venta.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes")
public class ClienteController {

    @Autowired
    private ClienteService css;

    @Operation(summary = "Registrar un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente registrado"),
            @ApiResponse(responseCode = "400", description = "Error en el registro")
    })
    @PostMapping
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = css.registro(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @Operation(summary = "Clientes")
    @ApiResponse(responseCode = "200", description = "Lista clientees")
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = css.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar un cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente eliminado"),
            @ApiResponse(responseCode = "500", description = "Error con la peticion")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        css.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}