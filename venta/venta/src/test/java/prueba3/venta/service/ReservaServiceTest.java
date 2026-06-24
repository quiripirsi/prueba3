package prueba3.venta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import feign.FeignException;
import prueba3.venta.model.Reserva;
import prueba3.venta.model.Cliente;
import prueba3.venta.repository.ReservaRepository;
import prueba3.venta.openfeing.PeliculaOP;
import prueba3.venta.model.PeliculaDTO;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @Mock
    private ReservaRepository rr;
    @Mock
    private PeliculaOP pop;

    @InjectMocks
    private ReservaService rs;
    private Reserva reservaMock;
    private PeliculaDTO peliculaMock;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        reservaMock = new Reserva();
        reservaMock.setId(1L);
        reservaMock.setCantidadPersonas(2);
        reservaMock.setPeliculaId(5L);
        reservaMock.setCliente(cliente);

        peliculaMock = new PeliculaDTO();
        peliculaMock.setId(5L);
        peliculaMock.setNombre("BACKROOMS");
    }

    @Test
    void guardarReserva_Exito() {
        when(pop.peliculaPorId(5L)).thenReturn(peliculaMock);
        when(rr.save(any(Reserva.class))).thenReturn(reservaMock);
        Reserva resultado = rs.guardar(reservaMock);
        assertNotNull(resultado);
        assertEquals(5L, resultado.getPeliculaId());
        verify(pop, times(1)).peliculaPorId(5L);
        verify(rr, times(1)).save(reservaMock);
    }

    @Test
    void guardarReserva_PeliculaNoExiste() {
        FeignException.NotFound exceptionMock = mock(FeignException.NotFound.class);
        when(pop.peliculaPorId(5L)).thenThrow(exceptionMock);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            rs.guardar(reservaMock);
        });
        assertEquals("Error la pelicula no esta disponible", exception.getMessage());
        verify(rr, never()).save(any(Reserva.class));
    }
}