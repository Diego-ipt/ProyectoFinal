package org.example.modelos;
import java.util.Date;
import java.util.HashMap;

public class FechasYTramo {
    private HashMap<Date, Bus> busesPorHora;
    //la fecha debería ser Date o String?
    private Date Fecha;

    public FechasYTramo(Date Fecha){
        this.Fecha=Fecha;
        busesPorHora = new HashMap<Date, Bus>();
    }
    public Date getFecha(){
        return this.Fecha;
    }

    //no deberían ser horarios predeterminados de salida?
    //ejemplo: 15:00 17:00, 19:30, con un enum?
    public void agregarBus(Date hora, Bus bus){//“HH:MM”
        busesPorHora.put(hora, bus);
    }

    public Bus getBus(Date hora){
        return busesPorHora.get(hora);
    }
}