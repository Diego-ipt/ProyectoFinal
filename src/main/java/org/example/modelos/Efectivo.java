package org.example.modelos;

import java.util.Date;

public class Efectivo extends Pago {

    public Efectivo(Date fecha, int montoRecibido) {
        super(montoRecibido, fecha);
    }

    @Override
    public String toStringPago() {
        return "Método: Efectivo, Monto recibido: " + getMonto();
    }
}
