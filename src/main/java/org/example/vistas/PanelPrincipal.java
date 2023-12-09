package org.example.vistas;


import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

class PanelPrincipal extends JPanel {

    CardLayout cardLayout;
    JPanel cards;

    private PanelFechaDestino panelFechaDestino;
    private PanelHorarios panelHorarios;

    public PanelPrincipal () {
        this.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        panelFechaDestino = new PanelFechaDestino(cardLayout, cards);
        panelHorarios = new PanelHorarios(panelFechaDestino, cardLayout, cards);

        cards.add(panelFechaDestino, "panelFechaDestino");
        cards.add(panelHorarios,"panelHorarios");
        this.add(cards, BorderLayout.CENTER);

    }

}