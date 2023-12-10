package org.example.modelos;
/**
 * La clase abstracta {@code Asiento} representa un asiento genérico en un lugar determinado, con información
 * sobre su número y disponibilidad.
 */
public abstract class Asiento {
    /**
     * Número único asignado al asiento.
     */
    private int numero;

    /**
     * Indica si el asiento está disponible o no.
     */
    private boolean disponibilidad;

    /**
     * Constructor que inicializa un nuevo objeto {@code Asiento} con el número especificado.
     *
     * @param numero El número único asignado al asiento.
     */
    public Asiento(int numero){
        this.numero = numero;
        this.disponibilidad = true;
    }

    /**
     * Obtiene el número del asiento.
     *
     * @return El número del asiento.
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Obtiene la disponibilidad del asiento.
     *
     * @return {@code true} si el asiento está disponible, {@code false} si no lo está.
     */
    public boolean getDisponibilidad(){
        return this.disponibilidad;
    }

    /**
     * Establece la disponibilidad del asiento.
     *
     * @param disponibilidad {@code true} para marcar el asiento como disponible, {@code false} si no está disponible.
     */
    public void setDisponibilidad(boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }

    /**
     * Devuelve una representación en cadena del objeto {@code Asiento}.
     *
     * @return Una representación en cadena del objeto {@code Asiento}.
     */
    public abstract String toStringAsiento();

    /**
     * Devuelve el tipo de asiento.
     *
     * @return Una cadena que representa el tipo de asiento.
     */
    public abstract String tipoAsiento();
}
