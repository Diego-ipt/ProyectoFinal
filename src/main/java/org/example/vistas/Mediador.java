package org.example.vistas;
import org.example.modelos.*;

public class Mediador {
    private PanelFechaDestino panelFechaDestino;
    private PanelHorarios panelHorarios;
    private PanelCompra panelcompra;
    private FechasYTramo fechaytramo;
    private Bus bus;
    private Pasaje pasaje;
    public Mediador(){
    }
    public void refresh(FechasYTramo fechaytramo){
        this.fechaytramo=fechaytramo;
        this.panelHorarios.setFechaYTramo(fechaytramo);
    }
    public void refresh(String hora) throws HorarioNoDisponibleException {
        this.bus=this.fechaytramo.getBus(hora);
        this.panelcompra.setbus(bus);
    }
    public void refresh(Pasaje pasaje){
        //this.pasaje=pasaje;
        //this.panelpasaje.setpasaje(pasaje);
    }
    public void RefreshAllPaneles(PanelFechaDestino panelFechaDestino, PanelHorarios panelHorarios, PanelCompra panelcompra){
        this.panelcompra= panelcompra;
        this.panelHorarios=panelHorarios;
        this.panelFechaDestino=panelFechaDestino;
    }
}
