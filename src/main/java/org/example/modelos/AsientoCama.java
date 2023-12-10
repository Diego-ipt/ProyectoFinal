package org.example.modelos;

/**
 * La clase {@code AsientoCama} representa un tipo específico de asiento que es de tipo cama.
 * Extiende la clase abstracta {@code Asiento} e implementa los métodos abstractos definidos en ella.
 */
public class AsientoCama extends Asiento {

    /**
     * Constructor que inicializa un nuevo objeto {@code AsientoCama} con el número de asiento especificado.
     *
     * @param numAsiento El número único asignado al asiento.
     */
    public AsientoCama(int numAsiento) {
        super(numAsiento);
    }

    /**
     * Devuelve una representación en cadena del objeto {@code AsientoCama}.
     * Incluye el tipo de asiento y su número.
     *
     * @return Una representación en cadena del objeto {@code AsientoCama}.
     */
    @Override
    public String toStringAsiento() {
        return "Tipo de Asiento: " + tipoAsiento() + ", Número: " + getNumero();
    }

    /**
     * Devuelve el tipo de asiento, que en este caso es "Cama".
     *
     * @return Una cadena que representa el tipo de asiento ("Cama").
     */
    @Override
    public String tipoAsiento() {
        return "Cama";
    }
}

    
