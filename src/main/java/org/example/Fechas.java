package org.example;
import java.util.ArrayList;
import java.util.HashMap;

public class Fechas {
    private HashMap<String, Buses> busesPorHora;
    private String Fecha;

    public Fechas(String Fecha){
        this.Fecha=Fecha;
        busesPorHora = new HashMap<String, Buses>();
    }
    public String getFecha(){
        return this.Fecha;
    }

    public void agregarBus(String hora, Buses bus){//“HH:MM”
        busesPorHora.put(hora, bus);
    }

    public Buses getBus(String hora){
        return busesPorHora.get(hora);
    }
}