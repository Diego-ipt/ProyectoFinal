package org.example.vistas;

import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.*;
import org.example.modelos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;


public class PanelCompra extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;
    private Bus bus;
    private Mediador mediador;
    private JPanel panelInfo;
    private JPanel panelPisos;
    private JButton Tarjeta;
    private JButton Efectivo;
    private JPanel panelAsientos1;
    private JPanel panelAsientos2;
    private ArrayList<Asiento> asientosSeleccionados;
    private Pago pago;
    
    public PanelCompra(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.setLayout(new BorderLayout());
        asientosSeleccionados = new ArrayList<>();
    }
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
        mediador.refresh(asientosSeleccionados,pago);
        cardLayout.next(cards);
    }
    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }
    public void setbus(Bus bus){
        this.bus=bus;
        if(bus!=null){
            this.panelInfo = new JPanel();
            this.panelPisos = new JPanel();
            this.panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.X_AXIS));
            this.Tarjeta = new JButton("Tarjeta");
            this.Efectivo = new JButton("Efectivo");
            this.panelInfo.add(Tarjeta);
            this.panelInfo.add(Efectivo);
            Tarjeta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pago= new Tarjeta(999, new Date(), "Débito");
                    //handlePaymentMethodSelection();
                }
            });
            Efectivo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pago= new Efectivo(new Date(),999);
                    //handlePaymentMethodSelection();
                }
            });
            if(bus.tamañoAsientos()==72){
                this.panelPisos.setLayout(new BoxLayout(panelPisos,BoxLayout.X_AXIS));
                this.panelAsientos1 = new JPanel(new GridLayout(10, 4));
                ((GridLayout) panelAsientos1.getLayout()).setHgap(10);
                this.panelAsientos2 = new JPanel(new GridLayout(8, 4));
                ((GridLayout) panelAsientos2.getLayout()).setHgap(10);
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
            this.add(panelInfo, BorderLayout.NORTH);
            this.add(panelPisos, BorderLayout.CENTER);
        }
    }
    private JComponent createSeatComponent(int seatNumber, String seatType, boolean disponibilidad) {
        if (!disponibilidad) {
            // Seat is occupied, display a label
            return new JLabel("Asiento " + seatNumber + " - " + seatType + "." + "ocupado");
        } else {
            // Seat is available, create a checkbox
            JCheckBox checkBox = new JCheckBox("Asiento " + seatNumber + " - " + seatType + "." + "libre");
            checkBox.addActionListener(e -> {
                try {
                    if (checkBox.isSelected()) {
                        // Attempt to occupy the seat
                        bus.OcuparAsiento(seatNumber);
                    } else {
                        // Release the seat if it was selected and is now unselected
                        bus.getAsiento(seatNumber - 1).setDisponibilidad(true);
                    }
                } catch (AsientoNoDisponibleException ex) {
                    // Display an error message if the seat is already occupied
                    checkBox.setSelected(false);
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            return checkBox;
        }
    }
    private int extractSeatNumberFromCheckBoxText(String checkBoxText) {
        String[] parts = checkBoxText.split(" ");
        return Integer.parseInt(parts[1]);
    }
}
