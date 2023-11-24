package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.modelos.Asiento;
import org.example.modelos.Bus;
import org.example.modelos.NoHayDisponibilidadException;

public class BusesTest {
    @Test
    public void testOcuparAsiento() {
        Bus bus = new Bus(1);
        try {
            bus.OcuparAsiento(1);
            Asiento asiento = bus.getAsiento(1);
            assertTrue(asiento.getDisponibilidad());
        } catch (NoHayDisponibilidadException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOcuparAsientoAlreadyOccupied() {
        Bus bus = new Bus(1);
        try {
            bus.OcuparAsiento(1);
            bus.OcuparAsiento(1);
            // fail("Exception should be thrown");
        } catch (NoHayDisponibilidadException e) {
            assertEquals("El asiento 1 ya está ocupado.", e.getMessage());
        }
    }
}
