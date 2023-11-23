package org.example.modelos;

public class AsientoCama extends Asiento {

    public AsientoCama(int numAsiento) {
        super(numAsiento);
    }

    @Override
    public String toStringAsiento() {
        return "Tipo de Asiento: " + tipoAsiento() + ", Número: " + getNumero();
    }

    @Override
    public String tipoAsiento() {
        return "Cama";
    }
    
}
    
