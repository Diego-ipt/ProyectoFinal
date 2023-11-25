package org.example.modelos;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        try {
            FechasYTramo fyt = new FechasYTramo(new Date(), 3, 4);
        } catch (DestinoNoDisponibleException e) {
            
        }

        

    }
}