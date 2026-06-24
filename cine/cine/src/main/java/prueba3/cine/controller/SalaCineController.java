package prueba3.cine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba3.cine.model.SalaCine;
import prueba3.cine.service.SalaCineService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salas")
@Tag(name = "Salas de Cine")
public class SalaCineController {

    @Autowired
    private SalaCineService scs;

    @Operation(summary = "Crear sala de cine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sala creada"),
            @ApiResponse(responseCode = "400", description = "Error al crear el salon")
    })
    @PostMapping
    public ResponseEntity<SalaCine> guardar(@RequestBody SalaCine salaCine) {
        SalaCine nuevaSala = scs.guardar(salaCine);
        return new ResponseEntity<>(nuevaSala, HttpStatus.CREATED);
    }

    @Operation(summary = "Salones")
    @ApiResponse(responseCode = "200", description = "Lista de salas")
    @GetMapping
    public ResponseEntity<List<SalaCine>> listar() {
        List<SalaCine> lista = scs.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar una sala")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sala eliminada"),
            @ApiResponse(responseCode = "500", description = "Error al eliminar")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        scs.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}