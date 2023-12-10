package org.example.modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
public class PasajeTest {

    private FechasYTramo fechasYTramo;
    private Pago tarjetaPago;
    private Pago efectivoPago;

    @BeforeEach
    public void setUp() throws DestinoNoDisponibleException {
        Date fecha = new Date();
        fechasYTramo = new FechasYTramo(fecha, 1, 2);
        tarjetaPago = new Tarjeta(1800, fecha, "Débito");
        efectivoPago = new Efectivo(fecha, 1800);
    }

    @Test
    public void testCrearPasajeConTarjeta() throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        // Choose a known hour, for example, "12:00"
        Pasaje pasaje = new Pasaje(1, "12:00", fechasYTramo, tarjetaPago);
        assertEquals(1800, pasaje.getValor());
        assertEquals(1, pasaje.getAsiento());
        assertEquals("12:00", pasaje.getHora());
        assertEquals(fechasYTramo.getFecha(), pasaje.getFecha());
        assertEquals(tarjetaPago, pasaje.getPago());
    }


    @Test
    public void testCrearPasajeConEfectivo() throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        Pasaje pasaje = new Pasaje(12, "8:00", fechasYTramo, efectivoPago);
        assertEquals(1800, pasaje.getValor());  // El valor debe ser el monto del tramo * precio del asiento
        assertEquals(12, pasaje.getAsiento());
        assertEquals("8:00", pasaje.getHora());
        assertEquals(fechasYTramo.getFecha(), pasaje.getFecha());
        assertEquals(efectivoPago, pasaje.getPago());
    }
}
