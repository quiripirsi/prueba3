package prueba3.cine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba3.cine.model.Pelicula;
import prueba3.cine.service.PeliculaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/peliculas")
@Tag(name = "Peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Operation(summary = "Guardar una nueva pelicula")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pelicula guardada"),
            @ApiResponse(responseCode = "400", description = "Error al guardar")
    })
    @PostMapping
    public ResponseEntity<Pelicula> guardar(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.guardar(pelicula);
        return new ResponseEntity<>(nuevaPelicula, HttpStatus.CREATED);
    }

    @Operation(summary = "Peliculas")
    @ApiResponse(responseCode = "200", description = "Cartelera")
    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() {
        List<Pelicula> lista = peliculaService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar una pelicula")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Película eliminada"),
            @ApiResponse(responseCode = "500", description = "Error al eliminar")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}