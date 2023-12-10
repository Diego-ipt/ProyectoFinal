package org.example.modelos;

/**
 * La clase {@code AsientoNoDisponibleException} es una excepción específica que se lanza
 * cuando se intenta realizar una operación en un asiento que no está disponible.
 * Extiende la clase {@code Exception}.
 */
public class AsientoNoDisponibleException extends Exception {

    /**
     * Constructor que inicializa un nuevo objeto {@code AsientoNoDisponibleException} con el mensaje de error especificado.
     *
     * @param mensaje El mensaje que describe la excepción.
     */
    public AsientoNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}