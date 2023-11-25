package org.example.modelos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TramoTest {

    @Test
    public void testGetPrecioTramo() {
        Tramo tramo = new Tramo(1, 5);
        assertEquals(4800, tramo.getPrecioTramo());
    }

    @Test
    public void testGetOrigen() {
        Tramo tramo = new Tramo(1, 5);
        assertEquals("Arica", tramo.getOrigen());
    }

    @Test
    public void testGetDestino() {
        Tramo tramo = new Tramo(1, 5);
        assertEquals("Copiapó", tramo.getDestino());
    }

    @Test
    public void testInvalidCiudad() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Tramo(1, 15);
        });
    }
}