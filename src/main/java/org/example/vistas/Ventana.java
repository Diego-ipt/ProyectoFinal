package org.example.vistas;

import org.example.modelos.DestinoNoDisponibleException;

import javax.swing.JFrame;

/**
 * La clase {@code Ventana} representa la ventana principal de la aplicación para la venta de pasajes de bus.
 */
public class Ventana extends JFrame {

    /**
     * Construye una nueva instancia de la clase {@code Ventana}.
     *
     * @throws DestinoNoDisponibleException Si ocurre un error relacionado con destinos no disponibles.
     */
    public Ventana() throws DestinoNoDisponibleException {
        super();
        this.setTitle("Venta de pasajes de Bus");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new PanelPrincipal());
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
