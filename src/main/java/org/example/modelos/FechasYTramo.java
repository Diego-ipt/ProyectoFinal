package org.example.modelos;
import java.util.Date;
import java.util.HashMap;

public class FechasYTramo {
    private HashMap<String, Bus> busesPorHora;
    //la fecha debería ser Date o String?
    private Date fecha;
    private Tramo tramo;

    public FechasYTramo(Date fecha, int origen, int destino) throws DestinoNoDisponibleException {
        if(origen == destino) {
            throw new DestinoNoDisponibleException("Por favor, seleccione un destino distinto");
        }
        this.tramo = new Tramo(origen, destino);
        this.fecha=fecha;
        busesPorHora = new HashMap<String, Bus>();

        for (HorarioSalidaBus horario : HorarioSalidaBus.values()) {
            busesPorHora.put(horario.getHora(), new Bus(1));
            busesPorHora.put(horario.getHora(), new Bus(2));
        }

    }
    public Date getFecha(){
        return this.fecha;
    }

    public Bus getBus(String hora){
        if(busesPorHora.get(hora) == null) {
            return null;
        }
        return busesPorHora.get(hora);
    }

    public Tramo getTramo() {
        return tramo;
    }

    public int precioTramo() {
        return tramo.getPrecioTramo();
    }
}