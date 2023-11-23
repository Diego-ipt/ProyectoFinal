package org.example.modelos;

import java.util.Date;
import java.util.Random;

public class Tarjeta extends Pago {

    private String tipo;
    private int numTransaccion;

    public Tarjeta(int monto, Date fecha, String tipo) {
        super(monto, fecha);
        this.tipo = tipo;
    }

    private int calcNumTransaccion() {
        Random r = new Random();
        numTransaccion = r.nextInt(100);
        return numTransaccion;
    }

    @Override
    public String toStringPago() {
        return "Método: Tarjeta " + tipo + ", Monto pagado: " + getMonto() + ", Número de Transacción: " + calcNumTransaccion();
    }
    
    
}
