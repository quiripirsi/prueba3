package prueba3.venta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "confiteria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Confiteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;

    private Float precio;

    private boolean comestible;

    private String combo;
}
