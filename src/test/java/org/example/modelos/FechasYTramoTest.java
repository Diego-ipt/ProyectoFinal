package org.example.modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 * La clase {@code FechasYTramoTest} contiene métodos de prueba para la clase {@code FechasYTramo}.
 */
public class FechasYTramoTest {

    @BeforeEach
    public void setUp() {
        // Configuración común para las pruebas
    }

    @Test
    public void testGetFecha() {
        // Prueba para asegurar que la fecha devuelta por getFecha sea la misma que la proporcionada en el constructor.
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
        // Prueba para asegurar que se devuelve un objeto Bus válido para una hora específica.
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
        // Prueba para verificar que se lanza una excepción HorarioNoDisponibleException para una hora inválida.
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
        // Prueba para asegurar que se devuelve un objeto Tramo válido.
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
        // Prueba para verificar que el precio del tramo se calcula correctamente.
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
        // Prueba para verificar que se lanza una excepción DestinoNoDisponibleException para un destino inválido.
        Date fecha = new Date();
        assertThrows(DestinoNoDisponibleException.class, () -> {
            new FechasYTramo(fecha, 1, 1);
        });
    }

    @Test
    public void testInvalidCiudad() {
        // Prueba para verificar que se lanza una excepción IllegalArgumentException para una ciudad inválida.
        Date fecha = new Date();
        assertThrows(IllegalArgumentException.class, () -> {
            new FechasYTramo(fecha, 1, 15);
        });
    }
}