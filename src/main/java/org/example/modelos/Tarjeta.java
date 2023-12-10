package org.example.modelos;

import java.util.Date;
import java.util.Random;

/**
 * La clase {@code Tarjeta} representa un pago realizado con tarjeta, que es una forma específica de pago.
 * Extiende la clase abstracta {@code Pago} e implementa los métodos abstractos definidos en ella.
 *
 * Los pagos con tarjeta tienen un tipo de tarjeta asociado, un número de transacción generado automáticamente,
 * un monto y una fecha en la que fueron realizados.
 */
public class Tarjeta extends Pago {

    /**
     * Tipo de tarjeta asociado al pago.
     */
    private String tipo;

    /**
     * Número de transacción generado automáticamente.
     */
    private int numTransaccion;

    /**
     * Constructor que inicializa un nuevo objeto {@code Tarjeta} con el monto, la fecha y el tipo de tarjeta especificados.
     *
     * @param monto Monto del pago.
     * @param fecha Fecha en la que se realizó el pago.
     * @param tipo Tipo de tarjeta asociado al pago.
     */
    public Tarjeta(int monto, Date fecha, String tipo) {
        super(monto, fecha);
        this.tipo = tipo;
    }

    /**
     * Método privado que calcula y establece el número de transacción mediante un valor aleatorio.
     *
     * @return El número de transacción generado.
     */
    private int calcNumTransaccion() {
        Random r = new Random();
        numTransaccion = r.nextInt(100);
        return numTransaccion;
    }

    /**
     * Devuelve una representación en cadena del objeto {@code Tarjeta}, incluyendo el tipo de tarjeta,
     * el monto pagado y el número de transacción.
     *
     * @return Una representación en cadena del objeto {@code Tarjeta}.
     */
    @Override
    public String toStringPago() {
        return "Método: Tarjeta " + tipo + ", Monto pagado: " + getMonto() + ", Número de Transacción: " + calcNumTransaccion();
    }
}