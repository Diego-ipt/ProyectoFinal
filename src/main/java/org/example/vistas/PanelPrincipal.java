package org.example.vistas;


import org.example.modelos.DestinoNoDisponibleException;

import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

class PanelPrincipal extends JPanel {

    CardLayout cardLayout;
    JPanel cards;
    private Mediador mediador;

    private PanelFechaDestino panelFechaDestino;
    private PanelHorarios panelHorarios;
    private PanelCompra panelcompra;

    public PanelPrincipal () throws DestinoNoDisponibleException {
        this.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        this.mediador= new Mediador();
        panelFechaDestino = new PanelFechaDestino(cardLayout, cards);
        panelHorarios = new PanelHorarios(cardLayout, cards);
        panelcompra = new PanelCompra(cardLayout, cards);
        this.mediador.RefreshAllPaneles(panelFechaDestino, panelHorarios, panelcompra);
        panelHorarios.refreshMediador(mediador);
        panelFechaDestino.refreshMediador(mediador);
        panelcompra.refreshMediador(mediador);//actualiza cada panel con el mediador

        cards.add(panelFechaDestino, "panelFechaDestino");
        cards.add(panelHorarios,"panelHorarios");
        cards.add(panelcompra,"panelCompra");
        this.add(cards, BorderLayout.CENTER);

    }

}