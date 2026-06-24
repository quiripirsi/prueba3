package prueba3.cine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaCine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroSalon;

    @Column
    private int aforo;

    @Column
    private boolean salonXD;
}
