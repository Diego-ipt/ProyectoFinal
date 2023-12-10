package org.example.vistas;
import org.example.modelos.*;

import java.util.ArrayList;

public class Mediador {
    private PanelFechaDestino panelFechaDestino;
    private PanelHorarios panelHorarios;
    private PanelCompra panelcompra;
    private FechasYTramo fechaytramo;
    private Bus bus;
    private ArrayList<Asiento> Asientos;
    private String hora;
    public Mediador(){
    }
    public void refresh(FechasYTramo fechaytramo){
        this.fechaytramo=fechaytramo;
        this.panelHorarios.setFechaYTramo(fechaytramo);
    }
    public void refresh(String hora) throws HorarioNoDisponibleException {
        this.hora=hora;
        this.bus=this.fechaytramo.getBus(hora);
        this.panelcompra.setbus(bus);
    }
    public void refresh(ArrayList<Asiento> Asientos){
        //this.pasaje=pasaje;
        //this.panelpasaje.setpasaje(pasaje);
    }
    public void RefreshAllPaneles(PanelFechaDestino panelFechaDestino, PanelHorarios panelHorarios, PanelCompra panelcompra){
        this.panelcompra= panelcompra;
        this.panelHorarios=panelHorarios;
        this.panelFechaDestino=panelFechaDestino;
    }
    public FechasYTramo getFechaytramo() {
        return this.fechaytramo;
    }
    public String getHora() {
        return this.hora;
    }
}
