package org.example.modelos;

/**
 * La clase {@code AsientoSemiCama} representa un tipo específico de asiento que es de tipo semi cama.
 * Extiende la clase abstracta {@code Asiento} e implementa los métodos abstractos definidos en ella.
 */
public class AsientoSemiCama extends Asiento {

    /**
     * Constructor que inicializa un nuevo objeto {@code AsientoSemiCama} con el número de asiento especificado.
     *
     * @param numAsiento El número único asignado al asiento.
     */
    public AsientoSemiCama(int numAsiento) {
        super(numAsiento);
    }

    /**
     * Devuelve una representación en cadena del objeto {@code AsientoSemiCama}.
     * Incluye el tipo de asiento y su número.
     *
     * @return Una representación en cadena del objeto {@code AsientoSemiCama}.
     */
    @Override
    public String toStringAsiento() {
        return "Tipo de Asiento: " + tipoAsiento() + ", Número: " + getNumero();
    }

    /**
     * Devuelve el tipo de asiento, que en este caso es "SemiCama".
     *
     * @return Una cadena que representa el tipo de asiento ("SemiCama").
     */
    @Override
    public String tipoAsiento() {
        return "SemiCama";
    }
}

