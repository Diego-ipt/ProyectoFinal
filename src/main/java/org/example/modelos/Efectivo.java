package org.example.modelos;

import java.util.Date;

public class Efectivo extends Pago {
    private int montoRecibido;

    public Efectivo(int montoAPagar, Date fecha, int montoRecibido) {
        super(montoAPagar, fecha);
        this.montoRecibido = montoRecibido;
    }

    @Override
    public String toStringPago() {
        return "Método: Efectivo, Monto a pagar: " + getMonto() + ", Monto recibido: " + montoRecibido + ", Vuelto: " + calcDevolucion();
    }

    private int calcDevolucion() {
        return montoRecibido - getMonto();
    }
    
}
