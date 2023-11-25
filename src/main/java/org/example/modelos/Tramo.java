package org.example.modelos;
import java.util.ArrayList;

public class Tramo {
    private String origen;
    private String destino;
    private int precio;
    
    public Tramo(int origen, int destino) {
        this.origen = getDestino(origen);
        this.destino = getDestino(destino);

        int dif = Math.abs(origen - destino);
        //precio a agregar por tramo
        precio=dif*1200;
    }

    private String getDestino(int ciudad) throws IllegalArgumentException {
        String nombre = null;
        switch (ciudad) {
            case 1:
                nombre = "Arica";
                break;
            case 2:
                nombre = "Iquique";
                break;
            case 3:
                nombre = "Calama";
                break;
            case 4:
                nombre = "Antofagasta";
                break;
            case 5:
                nombre = "Copiapó";
                break;
            case 6:
                nombre = "La Serena";
                break;
            case 7:
                nombre = "Santiago";
                break;
            case 8:
                nombre = "Rancagua";
                break;
            case 9:
                nombre = "Talca";
                break;
            case 10:
                nombre = "Concepción";
                break;
            case 11:
                nombre = "Temuco";
                break;
            case 12:
                nombre = "Valdivia";
                break;
            case 13:
                nombre = "Puerto Montt";
                break;
            default:
                throw new IllegalArgumentException("Valor de ciudad no válido: " + ciudad);
        }

        return nombre;
    }

    public int getPrecioTramo() {
        return precio;
    }
    public String getOrigen(){
        return this.origen;
    }

    public String getDestino(){
        return this.destino;
    }
}

