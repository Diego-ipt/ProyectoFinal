package org.example.modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class FechasYTramoTest {
    @BeforeEach

    @Test
    public void testGetFecha() {
        Date fecha = new Date();
        FechasYTramo fechasYTramo = null;
        try {
            fechasYTramo = new FechasYTramo(fecha, 1, 5);
        } catch (DestinoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(fecha, fechasYTramo.getFecha());
    }

    @Test
    public void testGetBus() {
        Date fecha = new Date();
        FechasYTramo fechasYTramo = null;
        try {
            fechasYTramo = new FechasYTramo(fecha, 1, 5);
            assertNotNull(fechasYTramo.getBus("08:00"));
        } catch (DestinoNoDisponibleException | HorarioNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testInvalidHora() {
        Date fecha = new Date();
        FechasYTramo fechasYTramo = null;
        try {
            fechasYTramo = new FechasYTramo(fecha, 1, 5);
        } catch (DestinoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
        FechasYTramo finalFechasYTramo = fechasYTramo;
        assertThrows(HorarioNoDisponibleException.class, () -> {
            finalFechasYTramo.getBus("99:99");
        });
    }
    @Test
    public void testGetTramo() {
        Date fecha = new Date();
        FechasYTramo fechasYTramo = null;
        try {
            fechasYTramo = new FechasYTramo(fecha, 1, 5);
        } catch (DestinoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
        assertNotNull(fechasYTramo.getTramo());
    }

    @Test
    public void testPrecioTramo() {
        Date fecha = new Date();
        FechasYTramo fechasYTramo = null;
        try {
            fechasYTramo = new FechasYTramo(fecha, 1, 5);
        } catch (DestinoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(4800, fechasYTramo.precioTramo());
    }

    @Test
    public void testInvalidDestino() {
        Date fecha = new Date();
        assertThrows(DestinoNoDisponibleException.class, () -> {
            new FechasYTramo(fecha, 1, 1);
        });
    }

    @Test
    public void testInvalidCiudad() {
        Date fecha = new Date();
        assertThrows(IllegalArgumentException.class, () -> {
            new FechasYTramo(fecha, 1, 15);
        });
    }
}
