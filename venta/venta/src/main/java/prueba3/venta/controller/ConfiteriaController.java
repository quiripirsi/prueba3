package prueba3.venta.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba3.venta.model.Confiteria;
import prueba3.venta.service.ConfiteriaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/confiteria")
@Tag(name = "Confiteria")
public class ConfiteriaController {

    @Autowired
    private ConfiteriaService cs;

    @Operation(summary = "Guardar un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto guardado"),
            @ApiResponse(responseCode = "400", description = "Error al registrar producto")
    })
    @PostMapping
    public ResponseEntity<Confiteria> guardar(@RequestBody Confiteria confiteria) {
        Confiteria nuevoProducto = cs.guardar(confiteria);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @Operation(summary = "Confiteria")
    @ApiResponse(responseCode = "200", description = "Inventario de confiteria")
    @GetMapping
    public ResponseEntity<List<Confiteria>> listar() {
        List<Confiteria> lista = cs.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado"),
            @ApiResponse(responseCode = "500", description = "Error con la peticion")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cs.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}