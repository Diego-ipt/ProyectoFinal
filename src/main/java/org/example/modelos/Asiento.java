package org.example.modelos;

public abstract class Asiento {
    private int numero;
    private boolean disponibilidad;

    public Asiento(int number){
        this.numero = number;
        this.disponibilidad = true;
    }

    public int getNumero(){
        return this.numero;
    }

    public boolean getDisponibilidad(){
        return this.disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }

    public abstract String toStringAsiento();

    //una función para saber qué tipo de asiento es
    public abstract String tipoAsiento();
}
