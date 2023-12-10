package org.example.vistas;


import org.example.modelos.DestinoNoDisponibleException;

import javax.swing.*;
import java.awt.*;

/**
 * La clase {@code PanelPrincipal} es un panel principal que utiliza un {@code CardLayout} para mostrar diferentes subpaneles.
 *
 * Sirve como la interfaz principal que contiene subpaneles para la selección de fecha y destino, horarios, compra de pasajes y visualización de pasajes.
 * Se comunica con un {@code Mediador} para coordinar la interacción entre los subpaneles.
 */
public class PanelPrincipal extends JPanel {

    /**
     * Layout de tarjetas utilizado para alternar entre los subpaneles.
     */
    CardLayout cardLayout;

    /**
     * Panel que contiene los subpaneles gestionados por el {@code CardLayout}.
     */
    JPanel cards;

    /**
     * Objeto mediador que coordina la interacción entre los subpaneles.
     */
    private Mediador mediador;

    /**
     * Subpanel para la selección de fecha y destino.
     */
    private PanelFechaDestino panelFechaDestino;

    /**
     * Subpanel para la visualización de horarios disponibles.
     */
    private PanelHorarios panelHorarios;

    /**
     * Subpanel para la compra de pasajes.
     */
    private PanelCompra panelcompra;

    /**
     * Subpanel para la visualización de pasajes comprados.
     */
    private PanelPasajes panelpasaje;

    /**
     * Constructor de la clase {@code PanelPrincipal}.
     *
     * @throws DestinoNoDisponibleException Si el destino no está disponible.
     */
    public PanelPrincipal() throws DestinoNoDisponibleException {
        this.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        this.mediador = new Mediador();
        panelFechaDestino = new PanelFechaDestino(cardLayout, cards);
        panelHorarios = new PanelHorarios(cardLayout, cards);
        panelcompra = new PanelCompra(cardLayout, cards);
        panelpasaje = new PanelPasajes(cardLayout, cards);

        this.mediador.RefreshAllPaneles(panelFechaDestino, panelHorarios, panelcompra, panelpasaje);
        panelHorarios.refreshMediador(mediador);
        panelFechaDestino.refreshMediador(mediador);
        panelcompra.refreshMediador(mediador);
        panelpasaje.refreshMediador(mediador); // Actualiza cada panel con el mediador

        cards.add(panelFechaDestino, "panelFechaDestino");
        cards.add(panelHorarios, "panelHorarios");
        cards.add(panelcompra, "panelCompra");
        cards.add(panelpasaje, "panelpasaje");
        this.add(cards, BorderLayout.CENTER);
    }
}