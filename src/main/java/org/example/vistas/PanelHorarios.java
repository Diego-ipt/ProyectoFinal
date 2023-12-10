package org.example.vistas;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import org.example.modelos.Bus;
import org.example.modelos.FechasYTramo;
import org.example.modelos.HorarioNoDisponibleException;
import org.example.modelos.HorarioSalidaBus;

public class PanelHorarios extends JPanel{
    //segundo panel q se muestra
    private FechasYTramo fechasYTramo;
    private CardLayout cardLayout;
    private JPanel cards;
    private Mediador mediador;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public PanelHorarios(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.setLayout(new BorderLayout());
    }

    public void setFechaYTramo(FechasYTramo fechaytramo) {
        this.fechasYTramo = fechaytramo;
        if(fechasYTramo != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formato.format(fechasYTramo.getFecha());
            String origen = fechasYTramo.getTramo().getOrigen();
            String destino = fechasYTramo.getTramo().getDestino();

            JLabel labelFecha = new JLabel("Fecha: " + fecha);
            JLabel labelOrigen = new JLabel("Origen: " + origen);
            JLabel labelDestino = new JLabel("Destino: " + destino);

            JPanel panelLabels = new JPanel();
            panelLabels.add(labelOrigen);
            panelLabels.add(labelDestino);
            panelLabels.add(labelFecha);

            JPanel panelNorte = new JPanel();
            JPanel panelTitulo = new JPanel();
            JLabel labelTitulo = new JLabel("Horarios disponibles");
            panelTitulo.add(labelTitulo);

            panelNorte.add(panelTitulo, BorderLayout.CENTER);
            panelNorte.add(panelLabels, BorderLayout.SOUTH);
            panelNorte.setBorder(new EmptyBorder(10, 10, 10, 10));

            crearTabla();

            // Quitar el JScrollPane y agregar la tabla directamente al panelCentral
            JPanel panelCentral = new JPanel(new BorderLayout());
            panelCentral.add(tabla.getTableHeader(), BorderLayout.NORTH);
            panelCentral.add(tabla, BorderLayout.CENTER);
            panelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));

            this.add(panelCentral, BorderLayout.CENTER);
            this.add(panelNorte, BorderLayout.NORTH);

        }
    }

    public void crearTabla() {

        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que todas las celdas sean no editables (no seleccionables)
                return false;
            }
        };

        tabla = new JTable();

        String [] columnas = new String[] {"Seleccionar", "Hora de salida", "Id_Bus", "Número de pisos"};
        modeloTabla.setColumnIdentifiers(columnas);
        tabla.setModel(modeloTabla);

        ButtonGroup botones = new ButtonGroup();

        for(HorarioSalidaBus horario : HorarioSalidaBus.values()) {
            Bus bus;
            try {
                bus = fechasYTramo.getBus(horario.getHora());
                JRadioButton botonSeleccionar = new JRadioButton("hola");
                botones.add(botonSeleccionar);

                modeloTabla.addRow(new Object[]{botonSeleccionar, horario.getHora(), bus.getIdBus(), bus.getNumPisos()});


            } catch (HorarioNoDisponibleException e) {
                
            }
        }
    }

    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }

}