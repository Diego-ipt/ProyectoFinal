package org.example.modelos;

import org.example.vistas.Ventana;

/**
 * La clase {@code Main} contiene el método principal que inicia la aplicación.
 *
 * Este programa crea una instancia de la clase {@code Ventana}, que representa la interfaz gráfica de la aplicación,
 * para gestionar la compra de pasajes en un sistema de transporte.
 *
 * El método {@code main} se encarga de iniciar la aplicación y puede lanzar la excepción {@code DestinoNoDisponibleException}
 * si se encuentra un error al intentar crear la ventana.
 */
public class Main {
    /**
     * Método principal que inicia la aplicación creando una instancia de la clase {@code Ventana}.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este programa).
     * @throws DestinoNoDisponibleException Si ocurre un error al intentar crear la ventana.
     */
    public static void main(String[] args) throws DestinoNoDisponibleException {
        // Se crea una instancia de la clase Ventana para gestionar la interfaz gráfica.
        Ventana ventana = new Ventana();
    }
}
