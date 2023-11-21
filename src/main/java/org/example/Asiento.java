package org.example;

public class Asiento {
    private int numero;
    private String tipo;
    private String disponibilidad;

    public Asiento(int number, String seat){
        this.numero = number;
        this.tipo = seat;
        this.disponibilidad = "Libre";
    }

    public int getNumero(){
        return this.numero;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getDisponibilidad(){
        return this.disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad){
        this.disponibilidad = disponibilidad;
    }
}
