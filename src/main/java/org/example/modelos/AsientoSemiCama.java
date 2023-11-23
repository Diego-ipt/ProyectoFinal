package org.example.modelos;

public class AsientoSemiCama extends Asiento {
    public AsientoSemiCama(int numAsiento) {
        super(numAsiento);
    }

    @Override
    public String toStringAsiento() {
        return "Tipo de Asiento: " + tipoAsiento() + ", Número: " + getNumero();
    }

    @Override
    public String tipoAsiento() {
        return "SemiCama";
    }
}
