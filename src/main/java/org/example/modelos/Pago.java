package org.example.modelos;

import java.util.Date;

import java.util.Date;

/**
 * La clase abstracta {@code Pago} representa un pago genérico con información sobre el monto y la fecha del pago.
 * Se utiliza como base para clases específicas de pagos, como pagos con tarjeta o transferencias.
 *
 * Los pagos tienen un monto asociado y una fecha en la que fueron realizados.
 *
 * Las clases que extienden esta clase deben implementar el método abstracto {@code toStringPago()} para proporcionar
 * una representación en cadena específica del tipo de pago.
 */
public abstract class Pago {
    /**
     * Monto del pago.
     */
    private int monto;

    /**
     * Fecha en la que se realizó el pago.
     */
    private Date fecha;

    /**
     * Constructor que inicializa un nuevo objeto {@code Pago} con el monto y la fecha especificados.
     *
     * @param monto Monto del pago.
     * @param fecha Fecha en la que se realizó el pago.
     */
    public Pago(int monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    /**
     * Obtiene el monto del pago.
     *
     * @return El monto del pago.
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Obtiene la fecha en la que se realizó el pago.
     *
     * @return La fecha en la que se realizó el pago.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método abstracto que debe ser implementado por las clases que extienden {@code Pago}.
     * Proporciona una representación en cadena específica del tipo de pago.
     *
     * @return Una representación en cadena del pago.
     */
    public abstract String toStringPago();
}

