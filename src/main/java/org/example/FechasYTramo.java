package org.example;
import java.util.HashMap;

public class FechasYTramo {
    private HashMap<String, Buses> busesPorHora;
    private String Fecha;
    private Tramo tramo;

    public FechasYTramo(String Fecha, Tramo tramo){
        this.Fecha=Fecha;
        this.tramo=tramo;
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