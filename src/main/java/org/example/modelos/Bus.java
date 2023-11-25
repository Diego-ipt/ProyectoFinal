package org.example.modelos;

import java.util.ArrayList;

public class Bus {
    private ArrayList<Asiento> Asientos;

    public Bus(int pisos){//solo 1 o 2 pisos
        //que pasa si el int q recibe es > 2?
        Asientos = new ArrayList<Asiento>();
        int numAsientos = (pisos == 1) ? 40 : 70;
        int numSalonCama = numAsientos / 3;

        for(int i = 0; i < numAsientos; i++){
            if(i < numSalonCama){
                Asientos.add(new AsientoCama(i+1));
            } else {
                Asientos.add(new AsientoSemiCama(i+1));
            }
        }
    }

    //este metodo debería ir acá?
    public void OcuparAsiento(int numero) throws AsientoNoDisponibleException {
        if(numero > 0 && numero <= Asientos.size()){
            Asiento asiento = Asientos.get(numero - 1);
            if(!asiento.getDisponibilidad()){
                throw new AsientoNoDisponibleException("El asiento " + numero + " ya está ocupado.");
            } else {
                asiento.setDisponibilidad(false);
            }
        }
    }

    public Asiento getAsiento(int Asiento){
        return Asientos.get(Asiento);
    }

    public Bus getIdBus() {
        return this;
    }
}
