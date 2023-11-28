package org.example.vistas;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    
    public Ventana() {
        super();
        this.setTitle("Venta de pasajes de Bus");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new PanelPrincipal());
        this.setSize(900,500);
        this.setVisible(true); 
    }
}
