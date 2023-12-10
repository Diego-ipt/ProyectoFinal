package org.example.modelos;

/**
 * El enum {@code HorarioSalidaBus} representa una lista de horarios de salida disponibles para un sistema de transporte.
 * Cada horario tiene asociada una hora específica.
 * Se utiliza para identificar y gestionar los horarios de salida de los buses en el sistema.
 *
 * Los horarios de salida disponibles son:
 * - MAÑANA ("8:00")
 * - MEDIODIA ("12:00")
 * - MEDIATARDE ("15:00")
 * - TARDE ("19:00")
 * - NOCHE ("22:00")
 * - MEDIANOCHE ("00:00")
 *
 * Cada horario tiene una cadena de hora asociada, que se puede obtener mediante el método {@code getHora()}.
 */
public enum HorarioSalidaBus {
    MAÑANA("8:00"),
    MEDIODIA("12:00"),
    MEDIATARDE("15:00"),
    TARDE("19:00"),
    NOCHE("22:00"),
    MEDIANOCHE("00:00");

    /**
     * Cadena de hora asociada al horario de salida.
     */
    private final String hora;

    /**
     * Constructor privado para inicializar un horario de salida con su cadena de hora.
     *
     * @param hora Cadena de hora asociada al horario de salida.
     */
    HorarioSalidaBus(String hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la cadena de hora asociada al horario de salida.
     *
     * @return La cadena de hora asociada al horario de salida.
     */
    public String getHora() {
        return hora;
    }
}
