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

public class PanelFechaDestino extends JPanel implements ActionListener {
    //primer panel que se muestra
    private JTextField textfecha;
    private JComboBox<Destinos> origenes;
    private JComboBox<Destinos> destinos;
    private JButton buscarButton;

    private CardLayout cardLayout;
    private JPanel cards;

    private ArrayList<FechasYTramo> fechasYTramo;

    public PanelFechaDestino(CardLayout cardLayout, JPanel cards) throws DestinoNoDisponibleException {
        ArrayList<FechasYTramo> fechasYTramo = new ArrayList<>();
        fechasYTramo.add(new FechasYTramo(new Date(), 1, 5));//para que el vector no sea null
        this.cardLayout = cardLayout;
        this.cards = cards;

        this.setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,2));

        JLabel labelorigen = new JLabel("Seleccione su origen: ");
        JLabel labeldestino = new JLabel("Seleccione su destino: ");
        JLabel labelfecha = new JLabel("Fecha de viaje (DD/MM/AAAA): ");
        textfecha = new JTextField (10);

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
        btnPanel.add(buscarButton);

        this.add(panelCentral, BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.SOUTH);

    }


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
                    for (FechasYTramo fyt : fechasYTramo) {
                        if (fyt.getFecha().equals(fechaFormateada)
                                && (fyt.getTramo().CiudadNum(fyt.getTramo().getOrigen()) == origenSeleccionado.getNumCiudad())
                                && (fyt.getTramo().CiudadNum(fyt.getTramo().getDestino()) == destinoSeleccionado.getNumCiudad())) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        fechasYTramo.add(new FechasYTramo(fechaFormateada, origenSeleccionado.getNumCiudad(), destinoSeleccionado.getNumCiudad()));
                    }
                    cardLayout.next(cards);

                } catch(DestinoNoDisponibleException error) {
                    mensajeError = error.getMessage();

                    JOptionPane.showMessageDialog(this, mensajeError);
                }
            
            } catch (ParseException e1) {
                mensajeError = "Error con la fecha seleccionada. Inténtelo de nuevo";

                JOptionPane.showMessageDialog(this, mensajeError);
            }

        }

    }

    public FechasYTramo getFechasYTramo() {
        return fechasYTramo;
    }

}
