package org.example.modelos;
/**
 * La clase {@code HorarioNoDisponibleException} es una excepción específica que se lanza
 * cuando se intenta realizar una operación con un horario que no está disponible.
 * Extiende la clase {@code Exception}.
 *
 * Esta excepción puede ser utilizada para indicar que un horario específico no está disponible
 * para realizar una operación determinada.
 */
public class HorarioNoDisponibleException extends Exception {

    /**
     * Constructor que inicializa un nuevo objeto {@code HorarioNoDisponibleException} con el mensaje de error especificado.
     *
     * @param message El mensaje que describe la excepción.
     */
    public HorarioNoDisponibleException(String message) {
        super(message);
    }
}
