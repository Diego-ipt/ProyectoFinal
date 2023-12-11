package org.example.vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        
        JPanel panelSur = new JPanel();
        JButton terminar= new JButton("Confirmar");

        JLabel labelTitulo = new JLabel("Detalles de la compra");
        labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.BOLD, 20));
        labelTitulo.setForeground(Color.DARK_GRAY);

        JLabel labelPago = new JLabel("Método de pago: " + pago.toStringPago());
        labelPago.setForeground(Color.DARK_GRAY);

        JPanel panelNorte = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        panelNorte.add(labelTitulo, gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panelNorte.add(labelPago, gbc);

        terminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediador.restartpanels();
                cardLayout.show(cards, "panelFechaDestino");
                //refreshallpanels???
            }
        });

        panelSur.add(terminar);

        panelNorte.setBorder(new EmptyBorder(10,10,10,10));
        panelSur.setBorder(new EmptyBorder(10,10,10,10));
        pasajes.setBorder(new EmptyBorder(10,15,10,15));


        this.add(panelSur,BorderLayout.SOUTH);
        this.add(pasajes, BorderLayout.CENTER);
        this.add(panelNorte, BorderLayout.NORTH);
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

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        JLabel asientoLabel = new JLabel("Asiento: " + pasaje.getAsiento());
        JLabel horaLabel = new JLabel("Hora: " + pasaje.getHora());
        JLabel fechaLabel = new JLabel("Fecha: " + formato.format(pasaje.getFecha()));
        JLabel valorLabel = new JLabel("Precio: $" + pasaje.getValor());
        JLabel labelOrigen = new JLabel("Origen: "+ pasaje.getFYT().getTramo().getOrigen());
        JLabel labelDestino = new JLabel("Destino: "+pasaje.getFYT().getTramo().getDestino());
        panel.add(labelOrigen);
        panel.add(labelDestino);
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
