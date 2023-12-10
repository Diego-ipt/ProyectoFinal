package org.example.modelos;

/**
 * La clase {@code DestinoNoDisponibleException} es una excepción específica que se lanza
 * cuando se intenta realizar una operación con un destino que no está disponible.
 * Extiende la clase {@code Exception}.
 */
public class DestinoNoDisponibleException extends Exception {

    /**
     * Constructor que inicializa un nuevo objeto {@code DestinoNoDisponibleException} con el mensaje de error especificado.
     *
     * @param mensaje El mensaje que describe la excepción.
     */
    public DestinoNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}