package org.example;
import java.util.ArrayList;
public class Buses {
    private ArrayList<Asiento> Asientos;
    public Buses(int pisos){//solo 1 o 2 pisos
        Asientos = new ArrayList<Asiento>();
        int numAsientos = (pisos == 1) ? 40 : 70;
        int numSalonCama = numAsientos / 3;

        for(int i = 0; i < numAsientos; i++){
            if(i < numSalonCama){
                Asientos.add(new Asiento(i+1, "SalonCama"));
            } else {
                Asientos.add(new Asiento(i+1, "Estandar"));
            }
        }
    }
    public void OcuparAsiento(int numero) throws Exception{
        if(numero > 0 && numero <= Asientos.size()){
            Asiento asiento = Asientos.get(numero - 1);
            if(asiento.getDisponibilidad().equals("Ocupado")){
                throw new Exception("Error: El asiento " + numero + " ya está ocupado.");
            } else {
                asiento.setDisponibilidad("Ocupado");
            }
        }
    }
    public Asiento getseat(int seat){
        return Asientos.get(seat);
    }
}
