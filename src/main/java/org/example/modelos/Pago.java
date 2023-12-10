package org.example.modelos;

import java.util.Date;

public abstract class Pago {
    private int monto;
    private Date fecha;

    public Pago(int monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public abstract String toStringPago();

}
