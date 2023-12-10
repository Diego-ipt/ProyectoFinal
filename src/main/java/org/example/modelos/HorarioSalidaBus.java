package org.example.modelos;

public enum HorarioSalidaBus {
    MAÑANA("8:00"),
    MEDIODIA("12:00"),
    MEDIATARDE("15:00"),
    TARDE("19:00"),
    NOCHE("22:00"),
    MEDIANOCHE("00:00");

    private String hora;

    HorarioSalidaBus(String hora) {
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }
}
