package org.example.modelos;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class FechasYTramo {
    private HashMap<String, Bus> busesPorHora;
    private Date fecha;
    private Tramo tramo;

    public FechasYTramo(Date fecha, int origen, int destino) throws DestinoNoDisponibleException, IllegalArgumentException {
        if(origen == destino) {
            throw new DestinoNoDisponibleException("Por favor, seleccione un destino distinto");
        }
        this.tramo = new Tramo(origen, destino);
        this.fecha=fecha;
        busesPorHora = new HashMap<String, Bus>();

        for (HorarioSalidaBus horario : HorarioSalidaBus.values()) {
            Random r = new Random(1);
            int random = r.nextInt(2) + 1;
            busesPorHora.put(horario.getHora(), new Bus(random));
        }

    }
    public Date getFecha(){
        return this.fecha;
    }

    public Bus getBus(String hora) throws HorarioNoDisponibleException {
        Bus bus = busesPorHora.get(hora);
        if(bus == null) {
            throw new HorarioNoDisponibleException("No hay buses disponibles a esta hora: " + hora);
        }
        return bus;
    }

    public Tramo getTramo() {
        return tramo;
    }

    public int precioTramo() {
        return tramo.getPrecioTramo();
    }
}