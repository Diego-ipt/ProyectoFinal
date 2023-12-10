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
        
    }
    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }
    public void setbus(Bus bus){
        this.bus=bus;
    }
}
