package org.example.vistas;

import org.example.modelos.DestinoNoDisponibleException;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    public Ventana() throws DestinoNoDisponibleException {
        super();
        this.setTitle("Venta de pasajes de Bus");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new PanelPrincipal());
        this.setSize(500,500);
        this.setVisible(true); 
    }
}
