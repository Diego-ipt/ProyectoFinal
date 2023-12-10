package org.example.vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import org.example.modelos.*;

public class PanelCompra extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;
    private Bus bus;
    private Mediador mediador;
    
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
            JPanel panelInfo = new JPanel();
            JPanel panelAsientos = new JPanel();
            if(bus.tamañoAsientos()==70){

            } else if (bus.tamañoAsientos()==40) {

            }
            this.add(panelInfo, BorderLayout.NORTH);
            this.add(panelAsientos, BorderLayout.CENTER);
        }
    }
}
