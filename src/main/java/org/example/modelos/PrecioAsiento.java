package org.example.modelos;

public enum PrecioAsiento {
    CAMA(15000), SEMICAMA(10000);

    private int precio;

    PrecioAsiento(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    
}
