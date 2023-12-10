package org.example.vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.*;
import org.example.modelos.*;


public class PanelCompra extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;
    private Bus bus;
    private Mediador mediador;
    private JPanel panelInfo;
    private JPanel panelPisos;
    private JButton Tarjeta;
    private JButton Efectivo;
    
    public PanelCompra(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.setLayout(new BorderLayout());
    }
    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }
    public void setbus(Bus bus){
        this.bus=bus;
        if(bus!=null){
            panelInfo = new JPanel();
            panelPisos = new JPanel();
            panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.Y_AXIS));
            Tarjeta = new JButton("Tarjeta");
            Efectivo = new JButton("Efectivo");
            panelInfo.add(Tarjeta);
            panelInfo.add(Efectivo);
            if(bus.tamañoAsientos()==70){
                panelPisos.setLayout(new BoxLayout(panelPisos,BoxLayout.Y_AXIS));
                panelPisos.add(new panelAsientos(40,40));
                panelPisos.add(new panelAsientos(30,23));
            } else if (bus.tamañoAsientos()==40) {
                panelPisos.setLayout(new BorderLayout());
                panelPisos.add(new panelAsientos(40,13));
            }
            this.add(panelInfo, BorderLayout.NORTH);
            this.add(panelPisos, BorderLayout.CENTER);
        }
    }
}
