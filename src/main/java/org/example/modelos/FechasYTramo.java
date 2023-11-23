package org.example.modelos;
import java.util.HashMap;

public class FechasYTramo {
    private HashMap<String, Bus> busesPorHora;
    //la fecha debería ser Date o String?
    private String Fecha;
    private Tramo tramo;

    public FechasYTramo(String Fecha, Tramo tramo){
        this.Fecha=Fecha;
        this.tramo=tramo;
        busesPorHora = new HashMap<String, Bus>();
    }
    public String getFecha(){
        return this.Fecha;
    }

    //no deberían ser horarios predeterminados de salida?
    //ejemplo: 15:00 17:00, 19:30, con un enum?
    public void agregarBus(String hora, Bus bus){//“HH:MM”
        busesPorHora.put(hora, bus);
    }

    public Bus getBus(String hora){
        return busesPorHora.get(hora);
    }
}