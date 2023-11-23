package org.example.modelos;
import java.util.ArrayList;

public class Tramo {
    private String origen;
    private String destino;
    
    public Tramo(String origen, String destino){
        this.origen = origen;
        this.destino = destino;
    }
    public String getOrigen(){
        return this.origen;
    }

    public String getDestino(){
        return this.destino;
    }
}

