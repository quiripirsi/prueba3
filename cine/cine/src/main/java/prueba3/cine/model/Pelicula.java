package prueba3.cine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pelicula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String duracion;

    private String categoria;

    private String publicoDirigido;
}
