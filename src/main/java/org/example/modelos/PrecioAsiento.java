package org.example.modelos;

public enum PrecioAsiento {
    CAMA(1.5F), SEMICAMA(1);

    private float precio;

    PrecioAsiento(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    
}
