package org.example.vistas;
import org.example.modelos.*;

import java.util.ArrayList;

public class Mediador {
    private PanelFechaDestino panelFechaDestino;
    private PanelHorarios panelHorarios;
    private PanelCompra panelcompra;
    private PanelPasajes panelpasajes;
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
    public void refresh(String hora){
        this.hora=hora;
        this.bus=this.fechaytramo.getBusPorHora(hora);
        this.panelcompra.setbus(bus);
    }
    public void refresh(ArrayList<Asiento> Asientos, Pago pago) throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        this.Asientos=Asientos;
        this.panelpasajes.setPasaje(Asientos, hora, fechaytramo, pago);
    }
    public void RefreshAllPaneles(PanelFechaDestino panelFechaDestino, PanelHorarios panelHorarios, PanelCompra panelcompra,PanelPasajes panelpasajes){
        this.panelcompra=panelcompra;
        this.panelHorarios=panelHorarios;
        this.panelFechaDestino=panelFechaDestino;
        this.panelpasajes=panelpasajes;
    }
    public FechasYTramo getFechaytramo() {
        return this.fechaytramo;
    }
    public String getHora() {
        return this.hora;
    }
    public ArrayList<Asiento> getAsientos(){
        return this.Asientos;
    }
}
