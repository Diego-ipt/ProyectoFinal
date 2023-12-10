package org.example.vistas;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;
import javax.swing.table.*;

import org.example.modelos.Bus;
import org.example.modelos.FechasYTramo;
import org.example.modelos.HorarioNoDisponibleException;
import org.example.modelos.HorarioSalidaBus;
import org.w3c.dom.events.MouseEvent;

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
            JTableHeader header = tabla.getTableHeader();
            header.setDefaultRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    label.setBackground(Color.LIGHT_GRAY);  // Color RGB azul
                    label.setForeground(Color.DARK_GRAY); // Texto en color blanco
                    label.setFont(label.getFont().deriveFont(Font.BOLD)); // Fuente en negrita
                    return label;
                }
            });
            panelCentral.add(header, BorderLayout.NORTH);
            panelCentral.add(tabla, BorderLayout.CENTER);
            panelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));

            // Botón "Volver Atrás"
            JButton botonVolver = new JButton("Volver Atrás");

            botonVolver.addActionListener(e -> {
                cardLayout.previous(cards);
            });

            JPanel panelSur = new JPanel();
            panelSur.add(botonVolver);
            panelSur.setBorder(new EmptyBorder(10, 10, 10, 10));

            this.add(panelCentral, BorderLayout.CENTER);
            this.add(panelNorte, BorderLayout.NORTH);
            this.add(panelSur, BorderLayout.SOUTH);

        }
    }

    public void crearTabla() {

        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //no se pueden editar las celdas
                return false;
            }
        };

        tabla = new JTable();

        String [] columnas = new String[] {"Seleccionar", "Hora de salida", "Id_Bus", "Número de pisos"};
        modeloTabla.setColumnIdentifiers(columnas);

        for(HorarioSalidaBus horario : HorarioSalidaBus.values()) {
            Bus bus;
            try {
                bus = fechasYTramo.getBus(horario.getHora());

                JButton botonSeleccionar = new JButton("Ver pasajes");

                botonSeleccionar.addActionListener(e -> {
                    //pasa al siguiente panel
                    mediador.refresh(horario.getHora());

                    cardLayout.next(cards);
                    
                });
                
                modeloTabla.addRow(new Object[]{botonSeleccionar, horario.getHora(), bus.getIdBus(), bus.getNumPisos()});


            } catch (HorarioNoDisponibleException e) {
                continue;
            }
        }

        tabla.setDefaultRenderer(Object.class, new RenderizarTabla());
        tabla.setModel(modeloTabla);
        tabla.setRowHeight(40);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                tablaMouseClicked(e);
            }
        });

    }

    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }

    private void tablaMouseClicked(java.awt.event.MouseEvent e) {
        int columna = tabla.getColumnModel().getColumnIndexAtX(e.getX());
        int fila = e.getY()/tabla.getRowHeight();
        if(fila < tabla.getRowCount() && fila >= 0 && columna < tabla.getColumnCount() && columna >= 0) {
            Object value = tabla.getValueAt(fila, columna);
            if(value instanceof JButton) {
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
            }
        }
    }
}

