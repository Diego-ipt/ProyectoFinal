package org.example.modelos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * La clase {@code TramoTest} contiene métodos de prueba para la clase {@code Tramo}.
 */
public class TramoTest {

    @Test
    public void testGetPrecioTramo() {
        // Prueba para verificar el cálculo correcto del precio del tramo
        Tramo tramo = new Tramo(1, 5);
        assertEquals(4800, tramo.getPrecioTramo());
    }

    @Test
    public void testGetOrigen() {
        // Prueba para verificar la obtención correcta del origen del tramo
        Tramo tramo = new Tramo(1, 5);
        assertEquals("Arica", tramo.getOrigen());
    }

    @Test
    public void testGetDestino() {
        // Prueba para verificar la obtención correcta del destino del tramo
        Tramo tramo = new Tramo(1, 5);
        assertEquals("Copiapó", tramo.getDestino());
    }

    @Test
    public void testInvalidCiudad() {
        // Prueba para verificar si se lanza una excepción al proporcionar una ciudad no válida
        assertThrows(IllegalArgumentException.class, () -> {
            new Tramo(1, 15);
        });
    }
}