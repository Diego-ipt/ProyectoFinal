package org.example.vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.example.modelos.FechasYTramo;

public class PanelHorarios extends JPanel{
    //segundo panel q se muestra

    private FechasYTramo fechasYTramo;
    private CardLayout cardLayout;
    private JPanel cards;
    private Mediador mediador;
    
    public PanelHorarios(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.setLayout(new BorderLayout());



    }

    public void setFechasYTramo(FechasYTramo fechasYTramo) {
         if(fechasYTramo != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
            String fecha = formato.format(fechasYTramo.getFecha());
            String origen = fechasYTramo.getTramo().getOrigen();
            String destino = fechasYTramo.getTramo().getDestino();

            JLabel labelFecha = new JLabel("Fecha: " + fecha);
            JLabel labelOrigen = new JLabel("Origen: " + origen);
            JLabel labelDestino = new JLabel("Destino: " + destino);

            JPanel panelLabels = new JPanel(new GridLayout(1, 3));
            panelLabels.add(labelOrigen);
            panelLabels.add(labelDestino);
            panelLabels.add(labelFecha);

            JPanel panelNorte = new JPanel();
            JPanel panelLabel = new JPanel();
            JLabel labelTitulo = new JLabel("Horarios disponibles");
            panelLabel.add(labelTitulo);

            panelNorte.add(panelLabel, BorderLayout.CENTER);
            panelNorte.add(panelLabels, BorderLayout.SOUTH);

            this.add(panelNorte, BorderLayout.NORTH);
        }
    }
    public void setFechaYTramo(FechasYTramo fechaytramo) {
        this.fechasYTramo = fechaytramo;
    }
    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }
}
