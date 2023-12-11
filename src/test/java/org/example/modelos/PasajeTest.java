package org.example.modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
/**
 * La clase {@code PasajeTest} contiene métodos de prueba para la clase {@code Pasaje}.
 */
public class PasajeTest {

    private FechasYTramo fechasYTramo;
    private Pago tarjetaPago;
    private Pago efectivoPago;

    @BeforeEach
    public void setUp() throws DestinoNoDisponibleException {
        // Configuración común para las pruebas
        Date fecha = new Date();
        fechasYTramo = new FechasYTramo(fecha, 1, 2);
        tarjetaPago = new Tarjeta(1800, fecha, "Débito");
        efectivoPago = new Efectivo(fecha, 1800);
    }

    @Test
    public void testCrearPasajeConTarjeta() throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        // Prueba para verificar la creación de un pasaje con pago con tarjeta
        Pasaje pasaje = new Pasaje(1, "12:00", fechasYTramo, tarjetaPago);
        assertEquals(1800, pasaje.getValor());
        assertEquals(1, pasaje.getAsiento());
        assertEquals("12:00", pasaje.getHora());
        assertEquals(fechasYTramo.getFecha(), pasaje.getFecha());
        assertEquals(tarjetaPago, pasaje.getPago());
    }

    @Test
    public void testCrearPasajeConEfectivo() throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        // Prueba para verificar la creación de un pasaje con pago en efectivo
        Pasaje pasaje = new Pasaje(12, "8:00", fechasYTramo, efectivoPago);
        assertEquals(1800, pasaje.getValor());  // El valor debe ser el monto del tramo * precio del asiento
        assertEquals(12, pasaje.getAsiento());
        assertEquals("8:00", pasaje.getHora());
        assertEquals(fechasYTramo.getFecha(), pasaje.getFecha());
        assertEquals(efectivoPago, pasaje.getPago());
    }
}