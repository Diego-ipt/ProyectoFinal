package org.example.modelos;

public class NoHayDisponibilidadException extends Exception {
    public NoHayDisponibilidadException(String mensaje) {
        super(mensaje);
    }
}
