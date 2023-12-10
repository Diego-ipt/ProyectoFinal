package org.example.modelos;

/**
 * El enum {@code PrecioAsiento} representa los precios relativos de los diferentes tipos de asientos en un sistema de transporte.
 * Cada tipo de asiento tiene asociado un factor de precio que se utiliza para calcular el precio total del asiento.
 *
 * Los precios relativos disponibles son:
 * - Cama (factor de precio: 1.5F)
 * - SemiCama (factor de precio: 1.0F)
 *
 * Cada precio relativo tiene un factor de precio asociado, que se puede obtener mediante el método {@code getPrecio()}.
 */
public enum PrecioAsiento {
    /**
     * Representa el precio relativo de un asiento de tipo Cama.
     */
    Cama(1.5F),

    /**
     * Representa el precio relativo de un asiento de tipo SemiCama.
     */
    SemiCama(1.0F);

    /**
     * Factor de precio asociado al tipo de asiento.
     */
    private float precio;

    /**
     * Constructor privado para inicializar un tipo de asiento con su factor de precio.
     *
     * @param precio Factor de precio asociado al tipo de asiento.
     */
    PrecioAsiento(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el factor de precio asociado al tipo de asiento.
     *
     * @return El factor de precio asociado al tipo de asiento.
     */
    public float getPrecio() {
        return precio;
    }
}

