package org.example.vistas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.example.modelos.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * La clase {@code PanelCompra} representa un subpanel que facilita la compra de pasajes.
 * Permite al usuario seleccionar asientos, elegir un método de pago y realizar la compra.
 *
 * Se comunica con un {@code Mediador} para coordinar la interacción con otros subpaneles.
 */
public class PanelCompra extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;
    private Bus bus;
    private Mediador mediador;

    private JPanel panelPisos;

    private JPanel panelAsientos1;
    private JPanel panelAsientos2;
    private ArrayList<Asiento> asientosSeleccionados;
    private Pago pago;
    /**
     * Constructor de la clase {@code PanelCompra}.
     *
     * @param cardLayout Layout de tarjetas utilizado para alternar entre los subpaneles.
     * @param cards      Panel que contiene los subpaneles gestionados por el {@code CardLayout}.
     */
    public PanelCompra(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.setLayout(new BorderLayout());
        asientosSeleccionados = new ArrayList<>();
    }
    /**
     * Establece el autobús asociado al panel y actualiza la visualización.
     *
     * @param bus Objeto {@code Bus} que representa el autobús seleccionado.
     */
    public void setbus(Bus bus){
        this.bus=bus;
        if(bus!=null){
            JPanel panelBotones = new JPanel();
            JPanel panelNorte = new JPanel(new GridBagLayout());
            panelPisos = new JPanel();

            panelPisos.setBorder(new EmptyBorder(10, 10, 10, 10));
            panelNorte.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel labelTitulo = new JLabel("Asientos");
            labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.BOLD, 20));
            labelTitulo.setForeground(Color.DARK_GRAY);

            JLabel labelIdBus = new JLabel("Id_Bus " + bus.getIdBus());
            labelIdBus.setForeground(Color.DARK_GRAY);

            JLabel labelPisosBus = new JLabel("Número de pisos: " + bus.getNumPisos());
            labelPisosBus.setForeground(Color.DARK_GRAY);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            panelNorte.add(labelTitulo, gbc);

            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            panelNorte.add(labelPisosBus, gbc);
            gbc.gridy = 2;
            panelNorte.add(labelIdBus, gbc);


            panelBotones.setLayout(new GridLayout(4, 1));
            JRadioButton tarjeta = new JRadioButton("Tarjeta");
            JRadioButton efectivo = new JRadioButton("Efectivo");

            ButtonGroup grupoBotones = new ButtonGroup();

            grupoBotones.add(efectivo);
            grupoBotones.add(tarjeta);

            tarjeta.setSelected(true);

            JButton botonComprar = new JButton("Comprar");
            botonComprar.addActionListener(e -> {
                
                if(tarjeta.isSelected()) {
                    pago = new Tarjeta(999, new Date(), "Débito"); //siempre se acepta el pago, por eso 999
                } else if(efectivo.isSelected()) {
                    pago = new Efectivo(new Date(), 999);
                }

                try {
                    handlePaymentMethodSelection();                    
                } catch (AsientoNoDisponibleException error1) {
                    JOptionPane.showMessageDialog(this, "Error, uno de los asientos ya está ocupado");
                } catch (HorarioNoDisponibleException error2) {

                }

            });
            JButton botonVolver = new JButton("Volver Atrás");
            botonVolver.addActionListener(e -> {
                mediador.backPanel(this);
                mediador.refresh(mediador.getFechaytramo());
                cardLayout.previous(cards);
            });

            JPanel panelbotonCompra = new JPanel();
            panelbotonCompra.add(botonVolver);
            panelbotonCompra.add(botonComprar);

            JLabel textoSeleccion = new JLabel("Seleccione su método de pago");
            textoSeleccion.setForeground(Color.DARK_GRAY);
            textoSeleccion.setFont(new Font(textoSeleccion.getFont().getName(), Font.BOLD, 14));


            panelBotones.add(textoSeleccion);
            panelBotones.add(tarjeta);
            panelBotones.add(efectivo);
            panelBotones.add(panelbotonCompra);

            panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10));


            if(bus.tamañoAsientos()==72){
                this.panelPisos.setLayout(new BoxLayout(panelPisos,BoxLayout.X_AXIS));
                this.panelAsientos1 = new JPanel(new GridLayout(10, 4, 10, 10));

                // ((GridLayout) panelAsientos1.getLayout()).setHgap(10);
                this.panelAsientos2 = new JPanel(new GridLayout(8, 4, 10, 10));
                // ((GridLayout) panelAsientos2.getLayout()).setHgap(10);
                
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 4; j++) {
                        int seatNumber = i * 4 + j + 1;
                        Asiento seat = bus.getAsiento(seatNumber - 1);
                        panelAsientos1.add(createSeatComponent(seatNumber, seat.tipoAsiento(), seat.getDisponibilidad()));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        int seatNumber = 10 * 4 + i * 4 + j + 1;
                        Asiento seat = bus.getAsiento(seatNumber - 1);
                        panelAsientos2.add(createSeatComponent(seatNumber, seat.tipoAsiento(), seat.getDisponibilidad()));
                    }
                }
                this.panelPisos.add(panelAsientos1);
                this.panelPisos.add(panelAsientos2);
            } else if (bus.tamañoAsientos()==40) {
                this.panelPisos.setLayout(new BorderLayout());
                this.panelAsientos1 = new JPanel(new GridLayout(10, 4));
                ((GridLayout) panelAsientos1.getLayout()).setHgap(10);
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 4; j++) {
                        int seatNumber = i * 4 + j + 1;
                        Asiento seat = bus.getAsiento(seatNumber - 1);
                        panelAsientos1.add(createSeatComponent(seatNumber, seat.tipoAsiento(), seat.getDisponibilidad()));
                    }
                }
                this.panelPisos.add(panelAsientos1, BorderLayout.CENTER);
            }

            panelNorte.setBackground(Color.decode("#D3EFE9"));
            panelBotones.setBackground(Color.decode("#D3EFE9"));
            panelPisos.setBackground(Color.decode("#D3EFE9"));

            this.add(panelNorte, BorderLayout.NORTH);
            this.add(panelBotones, BorderLayout.SOUTH);
            this.add(panelPisos, BorderLayout.CENTER);

        }
        resetState();
    }
    /**
     * Crea un componente visual para un asiento específico.
     *
     * @param seatNumber    Número del asiento.
     * @param seatType      Tipo de asiento.
     * @param disponibilidad Disponibilidad del asiento.
     * @return Componente visual para el asiento.
     */
    private JComponent createSeatComponent(int seatNumber, String seatType, boolean disponibilidad) {
        if (!disponibilidad) {
            return new JLabel(seatNumber + " - " + seatType + " - " + "ocupado");
        } else {
            JCheckBox checkBox = new JCheckBox(seatNumber + " - " + seatType + " - " + "libre");
            return checkBox;
        }
    }
    /**
     * Extrae el número del asiento a partir del texto del CheckBox.
     *
     * @param checkBoxText Texto del CheckBox.
     * @return Número del asiento.
     */
    private int extractSeatNumberFromCheckBoxText(String checkBoxText) {
        String[] parts = checkBoxText.split(" ");
        return Integer.parseInt(parts[0]);
    }
    /**
     * Reinicia el estado del panel.
     */

    private void resetState() {
        asientosSeleccionados.clear();

    }
    /**
     * Maneja la selección del método de pago y realiza acciones correspondientes.
     *
     * @throws AsientoNoDisponibleException Si algún asiento no está disponible.
     * @throws HorarioNoDisponibleException Si no hay buses disponibles a la hora seleccionada.
     */
    private void handlePaymentMethodSelection() throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        for (Component component : panelPisos.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panelAsientos = (JPanel) component;
                for (Component seatComponent : panelAsientos.getComponents()) {
                    if (seatComponent instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) seatComponent;
                        if (checkBox.isSelected()) {
                            int seatNumber = extractSeatNumberFromCheckBoxText(checkBox.getText());
                            Asiento seat = bus.getAsiento(seatNumber - 1);
                            asientosSeleccionados.add(seat);
                        }
                    }
                }
            }
        }

        if(asientosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un asiento");
        } else {
            mediador.refresh(asientosSeleccionados,pago);
            cardLayout.next(cards);
        }
    }
    /**
     * Actualiza el mediador asociado con el panel y reinicia el estado.
     *
     * @param mediador Objeto {@code Mediador} que coordina la interacción entre los subpaneles.
     */
    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
        resetState();
    }
}
