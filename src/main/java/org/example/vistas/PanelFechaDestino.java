package org.example.vistas;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.example.modelos.*;

/**
 * La clase {@code PanelFechaDestino} es un subpanel que permite al usuario seleccionar el origen, destino y fecha del viaje.
 *
 * Muestra campos de entrada y un botón para buscar pasajes. Se comunica con un {@code Mediador} para coordinar la interacción.
 */
public class PanelFechaDestino extends JPanel implements ActionListener {

    /**
     * Campo de texto para la entrada de la fecha del viaje.
     */
    private JTextField textfecha;

    /**
     * Lista desplegable para la selección del origen del viaje.
     */
    private JComboBox<Destinos> origenes;

    /**
     * Lista desplegable para la selección del destino del viaje.
     */
    private JComboBox<Destinos> destinos;

    /**
     * Botón para iniciar la búsqueda de pasajes.
     */
    private JButton buscarButton;

    /**
     * Layout de tarjetas utilizado para alternar entre los subpaneles.
     */
    private CardLayout cardLayout;

    /**
     * Panel que contiene los subpaneles gestionados por el {@code CardLayout}.
     */
    private JPanel cards;

    /**
     * Lista de fechas y tramos disponibles para la búsqueda.
     */
    private ArrayList<FechasYTramo> fechasYTramo;

    /**
     * Objeto mediador que coordina la interacción entre los subpaneles.
     */
    private Mediador mediador;

    /**
     * Constructor de la clase {@code PanelFechaDestino}.
     *
     * @param cardLayout Layout de tarjetas utilizado para alternar entre los subpaneles.
     * @param cards      Panel que contiene los subpaneles gestionados por el {@code CardLayout}.
     * @throws DestinoNoDisponibleException Si el destino no está disponible.
     */
    public PanelFechaDestino(CardLayout cardLayout, JPanel cards) throws DestinoNoDisponibleException {
        this.fechasYTramo = new ArrayList<>();
        this.fechasYTramo.add(new FechasYTramo(new Date(), 1, 5)); // Para que el vector no sea null
        this.cardLayout = cardLayout;
        this.cards = cards;

        this.setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 2, 0, 50));
        panelCentral.setBorder(new EmptyBorder(10, 10, 0, 10)); // Espaciado de 10 píxeles en cada lado

        JLabel labelTitulo = new JLabel("Ingrese su recorrido");
        labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.BOLD, 20));
        labelTitulo.setForeground(Color.DARK_GRAY);

        JPanel panelNorte = new JPanel(new GridBagLayout());
        panelNorte.setBorder(new EmptyBorder(10, 10, 0, 10)); // Espaciado de 10 píxeles en cada lado

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        panelNorte.add(labelTitulo, gbc);

        JLabel labelorigen = new JLabel("Seleccione su origen: ");
        JLabel labeldestino = new JLabel("Seleccione su destino: ");
        JLabel labelfecha = new JLabel("Fecha de viaje (DD/MM/AAAA): ");
        textfecha = new JTextField(10);

        origenes = new JComboBox<>(Destinos.values());
        destinos = new JComboBox<>(Destinos.values());

        buscarButton = new JButton("Buscar pasajes");

        buscarButton.addActionListener(this);

        panelCentral.add(labelorigen);
        panelCentral.add(origenes);
        panelCentral.add(labeldestino);
        panelCentral.add(destinos);
        panelCentral.add(labelfecha);
        panelCentral.add(textfecha);

        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnPanel.add(buscarButton);

        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.SOUTH);
    }

    /**
     * Maneja el evento de clic en el botón de búsqueda de pasajes.
     * Obtiene la información seleccionada por el usuario y actualiza el mediador con la información relevante.
     *
     * @param e Objeto de evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Destinos origenSeleccionado = (Destinos) origenes.getSelectedItem();
        Destinos destinoSeleccionado = (Destinos) destinos.getSelectedItem();
        String fechaSeleccionada = textfecha.getText();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        if (destinoSeleccionado != null && origenSeleccionado != null && fechaSeleccionada != null) {
            String mensajeError = "";

            try {
                Date fechaFormateada = formato.parse(fechaSeleccionada);

                try {
                    boolean encontrado = false;
                    FechasYTramo fechasyT = null;
                    for (FechasYTramo fyt : fechasYTramo) {
                        if (fyt.getFecha().equals(fechaFormateada)
                                && (fyt.getTramo().CiudadNum(fyt.getTramo().getOrigen()) == origenSeleccionado.getNumCiudad())
                                && (fyt.getTramo().CiudadNum(fyt.getTramo().getDestino()) == destinoSeleccionado.getNumCiudad())) {

                            fechasyT = fyt;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        FechasYTramo fechasTramo = new FechasYTramo(fechaFormateada, origenSeleccionado.getNumCiudad(), destinoSeleccionado.getNumCiudad());
                        fechasYTramo.add(fechasTramo);
                        fechasyT = fechasTramo;
                    }
                    mediador.refresh(fechasyT);
                    cardLayout.next(cards);

                } catch (DestinoNoDisponibleException error) {
                    mensajeError = error.getMessage();

                    JOptionPane.showMessageDialog(this, mensajeError);
                }

            } catch (ParseException e1) {
                mensajeError = "Error con la fecha seleccionada. Inténtelo de nuevo";

                JOptionPane.showMessageDialog(this, mensajeError);
            }

        }
    }

    /**
     * Actualiza el mediador asociado con el panel.
     *
     * @param mediador Objeto mediador que coordina la interacción entre los subpaneles.
     */
    public void refreshMediador(Mediador mediador) {
        this.mediador = mediador;
    }
}