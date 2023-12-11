package org.example.vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.*;

import org.example.modelos.*;

public class PanelPasajes extends JPanel {
    private CardLayout cardLayout;
    private JPanel cards;
    private Mediador mediador;
    private JPanel pasajes;

    public PanelPasajes(CardLayout cardLayout, JPanel cards) {
        this.cardLayout = cardLayout;
        this.cards = cards;
    }
    public void setPasaje(ArrayList<Asiento> Asientos,String hora,FechasYTramo fechaytramo, Pago pago) throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        // Configurar el GridLayout
        setLayout(new BorderLayout());
        pasajes= new JPanel();
        pasajes.setLayout(new GridLayout((int) Math.ceil(Asientos.size() / 3.0)+1, 3, 10, 10));
        JButton terminar= new JButton("¿Terminar?");
        terminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediador.restartpanels();
                cardLayout.show(cards, "panelFechaDestino");
                //refreshallpanels???
            }
        });
        this.add(terminar,BorderLayout.NORTH);
        this.add(pasajes, BorderLayout.CENTER);
        // Crear y agregar paneles de pasaje al GridLayout
        for (Asiento asiento : Asientos) {
            // Crear un panel de pasaje y mostrar la información
            JPanel pasajePanel = createPasajePanel(new Pasaje(asiento.getNumero(), hora, fechaytramo, pago));
            this.pasajes.add(pasajePanel);
        }
    }
    private JPanel createPasajePanel(Pasaje pasaje) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel asientoLabel = new JLabel("Asiento: " + pasaje.getAsiento());
        JLabel horaLabel = new JLabel("Hora: " + pasaje.getHora());
        JLabel fechaLabel = new JLabel("Fecha: " + pasaje.getFecha());
        JLabel valorLabel = new JLabel("Valor: " + pasaje.getValor());
        JLabel tramo = new JLabel("Origen: "+ pasaje.getFYT().getTramo().getOrigen()+ ", Destino: "+pasaje.getFYT().getTramo().getDestino() );
        panel.add(tramo);
        panel.add(asientoLabel);
        panel.add(horaLabel);
        panel.add(fechaLabel);
        panel.add(valorLabel);

        return panel;
    }
    public void refreshMediador(Mediador mediador){
        this.mediador=mediador;
    }
}
