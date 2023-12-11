package org.example.modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La clase {@code BusesTest} contiene métodos de prueba para la clase {@code Bus}.
 */
public class BusesTest {

    /**
     * Prueba la ocupación de un asiento en un bus.
     */
    @Test
    public void testOcuparAsiento() {
        Bus bus = new Bus(1);
        try {
            bus.OcuparAsiento(1);
            Asiento asiento = bus.getAsiento(1);
            assertTrue(asiento.getDisponibilidad());
        } catch (AsientoNoDisponibleException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    /**
     * Prueba la ocupación de un asiento que ya está ocupado.
     */
    @Test
    public void testOcuparAsientoAlreadyOccupied() {
        Bus bus = new Bus(1);
        try {
            bus.OcuparAsiento(1);
            bus.OcuparAsiento(1);
            fail("Se esperaba una excepción");
        } catch (AsientoNoDisponibleException e) {
            assertEquals("El asiento 1 ya está ocupado.", e.getMessage());
        }
    }
}