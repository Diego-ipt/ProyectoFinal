package org.example.vistas;
import org.example.modelos.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * La clase {@code Mediador} actúa como un mediador entre varios paneles en una interfaz de usuario.
 *
 * Se utiliza para coordinar la interacción entre diferentes componentes de la interfaz de usuario,
 * como paneles de fecha y destino, horarios, compra y pasajes.
 *
 * El mediador tiene la capacidad de actualizar y refrescar la información en los diferentes paneles.
 * Además, almacena información sobre la fecha, tramo, bus, hora y asientos seleccionados durante la interacción.
 *
 * @author [Tu nombre]
 * @version 1.0
 */
public class Mediador {
    /**
     * Panel que muestra la fecha y el destino.
     */
    private PanelFechaDestino panelFechaDestino;

    /**
     * Panel que muestra los horarios disponibles.
     */
    private PanelHorarios panelHorarios;

    /**
     * Panel que facilita la compra de pasajes.
     */
    private PanelCompra panelcompra;

    /**
     * Panel que muestra la información de los pasajes comprados.
     */
    private PanelPasajes panelpasajes;

    /**
     * Información de fecha y tramo asociada a la interacción.
     */
    private FechasYTramo fechaytramo;

    /**
     * Bus seleccionado asociado a la hora seleccionada.
     */
    private Bus bus;

    /**
     * Lista de asientos seleccionados durante la interacción.
     */
    private ArrayList<Asiento> Asientos;

    /**
     * Hora seleccionada durante la interacción.
     */
    private String hora;

    /**
     * Constructor por defecto de la clase {@code Mediador}.
     */
    public Mediador() {
    }

    /**
     * Actualiza la información de fecha y tramo asociada al mediador.
     * Refresca el panel de horarios con la nueva información.
     *
     * @param fechaytramo Información de fecha y tramo.
     */
    public void refresh(FechasYTramo fechaytramo) {
        this.fechaytramo = fechaytramo;
        this.panelHorarios.setFechaYTramo(fechaytramo);
    }

    /**
     * Actualiza la hora seleccionada y el bus asociado.
     * Refresca el panel de compra con la nueva información.
     *
     * @param hora Hora seleccionada.
     */
    public void refresh(String hora) {
        this.hora = hora;
        this.bus = this.fechaytramo.getBusPorHora(hora);
        this.panelcompra.setbus(bus);
    }

    /**
     * Actualiza la lista de asientos seleccionados y la información de pago.
     * Refresca el panel de pasajes con la nueva información.
     *
     * @param Asientos Lista de asientos seleccionados.
     * @param pago     Información de pago asociada.
     * @throws AsientoNoDisponibleException Si algún asiento no está disponible.
     * @throws HorarioNoDisponibleException Si no hay buses disponibles a la hora seleccionada.
     */
    public void refresh(ArrayList<Asiento> Asientos, Pago pago)
            throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        this.Asientos = Asientos;
        this.panelpasajes.setPasaje(Asientos, hora, fechaytramo, pago);
    }

    /**
     * Establece la asociación con los paneles de la interfaz de usuario.
     *
     * @param panelFechaDestino Panel que muestra la fecha y el destino.
     * @param panelHorarios    Panel que muestra los horarios disponibles.
     * @param panelcompra      Panel que facilita la compra de pasajes.
     * @param panelpasajes     Panel que muestra la información de los pasajes comprados.
     */
    public void RefreshAllPaneles(PanelFechaDestino panelFechaDestino, PanelHorarios panelHorarios,
                                  PanelCompra panelcompra, PanelPasajes panelpasajes) {
        this.panelFechaDestino = panelFechaDestino;
        this.panelHorarios = panelHorarios;
        this.panelcompra = panelcompra;
        this.panelpasajes = panelpasajes;
    }

    /**
     * Obtiene la información de fecha y tramo asociada al mediador.
     *
     * @return La información de fecha y tramo.
     */
    public FechasYTramo getFechaytramo() {
        return this.fechaytramo;
    }

    /**
     * Obtiene la hora seleccionada durante la interacción.
     *
     * @return La hora seleccionada.
     */
    public String getHora() {
        return this.hora;
    }

    /**
     * Obtiene la lista de asientos seleccionados durante la interacción.
     *
     * @return La lista de asientos seleccionados.
     */
    public ArrayList<Asiento> getAsientos() {
        return this.Asientos;
    }

    /**
     * Asegura la superpocision de paneles al retroceder al panel anterior dependiendo del origen del panel.
     *
     * @param origenpanel Panel de origen.
     */
    public void backPanel(JPanel origenpanel) {
        if (origenpanel.equals(this.panelHorarios)) {
            this.panelHorarios.removeAll();
            this.panelcompra.removeAll();
            this.panelpasajes.removeAll();
        } else if (origenpanel.equals(this.panelcompra)) {
            this.panelcompra.removeAll();
            this.panelpasajes.removeAll();
        }
    }

    /**
     * Reinicia todos los paneles.
     */
    public void restartpanels() {
        this.panelHorarios.removeAll();
        this.panelcompra.removeAll();
        this.panelpasajes.removeAll();
    }
}