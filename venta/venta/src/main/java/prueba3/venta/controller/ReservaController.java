package prueba3.venta.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba3.venta.model.Reserva;
import prueba3.venta.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
@Tag(name = "Reservas")
public class ReservaController {

    @Autowired
    private ReservaService rs;

    @Operation(summary = "Generar una nueva reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Se ha hecho una reserva"),
            @ApiResponse(responseCode = "400", description = "Error al crear reserva")
    })
    @PostMapping
    public ResponseEntity<Reserva> guardar(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = rs.guardar(reserva);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

    @Operation(summary = "Reservas")
    @ApiResponse(responseCode = "200", description = "Lista Reservas")
    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        List<Reserva> lista = rs.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Cancelar una reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva cancelada"),
            @ApiResponse(responseCode = "500", description = "Error en el proceso")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rs.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}