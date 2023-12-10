package org.example.modelos;

import java.util.Date;

import java.util.Date;

/**
 * La clase {@code Pasaje} representa un pasaje de un viaje en un bus en una fecha y hora específicas,
 * asociado a un asiento, un valor, un pago y la información del tramo y bus correspondiente.
 *
 * Se utiliza para gestionar la información relacionada con la compra de pasajes, incluyendo detalles sobre el asiento,
 * la fecha, la hora, el valor del pasaje, el pago realizado y la información del tramo y bus asociado.
 */
public class Pasaje {
    /**
     * Valor del pasaje.
     */
    private int valor;

    /**
     * Fecha del pasaje.
     */
    private Date fecha;

    /**
     * Hora del pasaje.
     */
    private String hora;

    /**
     * Número de asiento del pasaje.
     */
    private int asiento;

    /**
     * Pago asociado al pasaje.
     */
    private Pago pago;

    /**
     * Información de fecha, tramo y buses asociados al pasaje.
     */
    private FechasYTramo fechaytramo;

    /**
     * Constructor que inicializa un nuevo objeto {@code Pasaje} con el número de asiento, la hora,
     * la información de fecha y tramo, y el pago especificados.
     *
     * @param asiento     Número de asiento del pasaje.
     * @param hora        Hora del pasaje.
     * @param fechaytramo Información de fecha, tramo y buses asociados al pasaje.
     * @param pago        Pago asociado al pasaje.
     * @throws AsientoNoDisponibleException Si el asiento no está disponible.
     * @throws HorarioNoDisponibleException Si no hay buses disponibles a la hora especificada.
     */
    public Pasaje(int asiento, String hora, FechasYTramo fechaytramo, Pago pago)
            throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        this.asiento = asiento;
        this.fechaytramo = fechaytramo;
        this.fecha = fechaytramo.getFecha();
        this.hora = hora;
        this.pago = pago;

        if (fechaytramo.getBus(hora).getAsiento(asiento).tipoAsiento().equals("SemiCama")) {
            this.valor = (int) (PrecioAsiento.SemiCama.getPrecio() * fechaytramo.precioTramo());
        } else {
            this.valor = (int) (PrecioAsiento.Cama.getPrecio() * fechaytramo.precioTramo());
        }

        fechaytramo.getBus(hora).OcuparAsiento(asiento);
    }

    /**
     * Obtiene una representación en cadena de la información del pasaje, incluyendo el asiento, la hora, la fecha y el valor.
     *
     * @return Una representación en cadena de la información del pasaje.
     */
    public String InfoPasaje() {
        return "Asiento: " + this.asiento + ", Hora: " + this.hora + ", Fecha: " + this.fecha + ", Valor: " + this.valor;
    }

    /**
     * Obtiene una representación en cadena de la información del pago asociado al pasaje.
     *
     * @return Una representación en cadena de la información del pago.
     */
    public String InfoPago() {
        return pago.toStringPago();
    }

    /**
     * Obtiene el valor del pasaje.
     *
     * @return El valor del pasaje.
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * Obtiene la fecha del pasaje.
     *
     * @return La fecha del pasaje.
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Obtiene la hora del pasaje.
     *
     * @return La hora del pasaje.
     */
    public String getHora() {
        return this.hora;
    }

    /**
     * Obtiene el número de asiento del pasaje.
     *
     * @return El número de asiento del pasaje.
     */
    public int getAsiento() {
        return this.asiento;
    }

    /**
     * Obtiene el pago asociado al pasaje.
     *
     * @return El pago asociado al pasaje.
     */
    public Pago getPago() {
        return this.pago;
    }

    /**
     * Obtiene la información de fecha, tramo y buses asociados al pasaje.
     *
     * @return La información de fecha, tramo y buses asociados al pasaje.
     */
    public FechasYTramo getFYT() {
        return this.fechaytramo;
    }
}
