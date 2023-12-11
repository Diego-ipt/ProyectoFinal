package org.example.modelos;

import java.util.Date;

import java.util.Date;

/**
 * La clase {@code Efectivo} representa un tipo de pago realizado en efectivo.
 * Extiende la clase {@code Pago} e implementa los métodos abstractos definidos en ella.
 *
 * El pago en efectivo tiene un monto recibido y se utiliza para representar transacciones en efectivo.
 */
public class Efectivo extends Pago {

    /**
     * Constructor que inicializa un nuevo objeto {@code Efectivo} con la fecha y el monto recibido especificados.
     *
     * @param fecha         Fecha en la que se realizó el pago en efectivo.
     * @param montoRecibido Monto recibido en efectivo.
     */
    public Efectivo(Date fecha, int montoRecibido) {
        super(montoRecibido, fecha);
    }

    /**
     * Devuelve una representación en cadena del objeto {@code Efectivo}.
     * Incluye el método de pago.
     *
     * @return Una representación en cadena del objeto {@code Efectivo}.
     */
    @Override
    public String toStringPago() {
        return "Efectivo";
    }
}
