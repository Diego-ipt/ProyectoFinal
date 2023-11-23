package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusesTest {
    @Test
    public void testOcuparAsiento() {
        Buses bus = new Buses(1);
        try {
            bus.OcuparAsiento(1);
            Asiento asiento = bus.getseat(0);
            assertEquals("Ocupado", asiento.getDisponibilidad());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testOcuparAsientoAlreadyOccupied() {
        Buses bus = new Buses(1);
        try {
            bus.OcuparAsiento(1);
            bus.OcuparAsiento(1);
            fail("Exception should be thrown");
        } catch (Exception e) {
            assertEquals("Error: El asiento 1 ya está ocupado.", e.getMessage());
        }
    }
}
