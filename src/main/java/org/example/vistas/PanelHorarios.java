package org.example.vistas;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.example.modelos.Bus;
import org.example.modelos.FechasYTramo;
import org.example.modelos.HorarioNoDisponibleException;
import org.example.modelos.HorarioSalidaBus;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 * La clase {@code PanelHorarios} es un subpanel que muestra los horarios disponibles para un tramo específico.
 * Permite al usuario seleccionar un horario y ver los pasajes disponibles para ese horario.
 *
 * Se comunica con un {@code Mediador} para coordinar la interacción con otros subpaneles.
 */
public class PanelHorarios extends JPanel {

    /**
     * Objeto {@code FechasYTramo} que contiene la información del tramo y la fecha seleccionada.
     */
    private FechasYTramo fechasYTramo;

    /**
     * Layout de tarjetas utilizado para alternar entre los subpaneles.
     */
    private CardLayout cardLayout;

    /**
     * Panel que contiene los subpaneles gestionados por el {@code CardLayout}.
     */
    private JPanel cards;

    /**
     * Objeto mediador que coordina la interacción entre los subpaneles.
     */
    private Mediador mediador;

    /**
     * Tabla que muestra los horarios disponibles.
     */
    private JTable tabla;

    /**
     * Modelo de la tabla.
     */
    private DefaultTableModel modeloTabla;

    /**
     * Constructor de la clase {@code PanelHorarios}.
     *
     * @param cardLayout Layout de tarjetas utilizado para alternar entre los subpaneles.
     * @param cards      Panel que contiene los subpaneles gestionados por el {@code CardLayout}.
     */
    public PanelHorarios(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.setLayout(new BorderLayout());
    }

    /**
     * Establece la información de {@code FechasYTramo} en el panel y actualiza la visualización.
     *
     * @param fechaytramo Objeto {@code FechasYTramo} con la información del tramo y la fecha seleccionada.
     */
    public void setFechaYTramo(FechasYTramo fechaytramo) {
        this.fechasYTramo = fechaytramo;
        if (fechasYTramo != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formato.format(fechasYTramo.getFecha());
            String origen = fechasYTramo.getTramo().getOrigen();
            String destino = fechasYTramo.getTramo().getDestino();

            JLabel labelFecha = new JLabel("Fecha: " + fecha);
            JLabel labelOrigen = new JLabel("Origen: " + origen);
            JLabel labelDestino = new JLabel("Destino: " + destino);

            // Configuración de estilo para las etiquetas
            labelFecha.setForeground(Color.DARK_GRAY);
            labelOrigen.setForeground(Color.DARK_GRAY);
            labelDestino.setForeground(Color.DARK_GRAY);

            // Panel que contiene las etiquetas informativas
            JPanel panelLabels = new JPanel();
            panelLabels.add(labelOrigen);
            panelLabels.add(labelDestino);
            panelLabels.add(labelFecha);

            // Configuración del título y estilos para el panel norte
            JLabel labelTitulo = new JLabel("Horarios disponibles");
            labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.BOLD, 20));
            labelTitulo.setForeground(Color.DARK_GRAY);

            JPanel panelNorte = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            panelNorte.add(labelTitulo, gbc);

            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            panelNorte.add(labelOrigen, gbc);
            gbc.gridy = 2;
            panelNorte.add(labelDestino, gbc);
            gbc.gridy = 3;
            panelNorte.add(labelFecha, gbc);

            // Configuración y creación de la tabla
            crearTabla();

            JPanel panelCentral = new JPanel(new BorderLayout());
            JTableHeader header = tabla.getTableHeader();

            // Configuración del estilo del encabezado de la tabla
            header.setDefaultRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    label.setBackground(Color.LIGHT_GRAY);
                    label.setForeground(Color.DARK_GRAY);
                    label.setFont(label.getFont().deriveFont(Font.BOLD)); // Fuente en negrita
                    return label;
                }
            });

            panelCentral.add(header, BorderLayout.NORTH);
            panelCentral.add(tabla, BorderLayout.CENTER);
            panelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));

            // Configuración del botón de volver atrás
            // JButton botonVolver = new JButton("Volver Atrás");
            // botonVolver.addActionListener(e -> {
            //     cardLayout.previous(cards);
            // });

            // JPanel panelSur = new JPanel();
            // panelSur.add(botonVolver);
            // panelSur.setBorder(new EmptyBorder(10, 10, 10, 10));

            // Añadir los componentes al panel principal
            this.add(panelCentral, BorderLayout.CENTER);
            this.add(panelNorte, BorderLayout.NORTH);
            // this.add(panelSur, BorderLayout.SOUTH);
        }
    }

    /**
     * Crea la tabla de horarios disponible para la visualización.
     */
    public void crearTabla() {
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // No se pueden editar las celdas
                return false;
            }
        };

        tabla = new JTable();

        String[] columnas = new String[]{"Seleccionar", "Hora de salida", "Id_Bus", "Número de pisos"};
        modeloTabla.setColumnIdentifiers(columnas);

        // Itera sobre los horarios disponibles y crea las filas de la tabla
        for (HorarioSalidaBus horario : HorarioSalidaBus.values()) {
            Bus bus;
            try {
                bus = fechasYTramo.getBus(horario.getHora());

                JButton botonSeleccionar = new JButton("Ver pasajes");

                botonSeleccionar.addActionListener(e -> {
                    // Pasa al siguiente panel
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

    /**
     * Actualiza el mediador asociado con el panel.
     *
     * @param mediador Objeto mediador que coordina la interacción entre los subpaneles.
     */
    public void refreshMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    /**
     * Maneja el evento de clic en la tabla.
     * Si la celda seleccionada es un botón, realiza la acción asociada al botón.
     *
     * @param e Objeto de evento de ratón.
     */
    private void tablaMouseClicked(java.awt.event.MouseEvent e) {
        int columna = tabla.getColumnModel().getColumnIndexAtX(e.getX());
        int fila = e.getY() / tabla.getRowHeight();
        if (fila < tabla.getRowCount() && fila >= 0 && columna < tabla.getColumnCount() && columna >= 0) {
            Object value = tabla.getValueAt(fila, columna);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
            }
        }
    }
}

