package org.example.modelos;

public enum PrecioAsiento {
    Cama(1.5F), SemiCama(1);

    private float precio;

    PrecioAsiento(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    
}
