package org.example.modelos;

import java.util.Date;

public class Pasaje {
    private int valor;
    private Date fecha;
    private String hora;
    private int asiento;
    private Pago pago;

    //por qué se le pasa un int de asiento y no la clase Asiento?
    public Pasaje(int asiento, String hora, FechasYTramo fechaytramo, Pago pago) throws AsientoNoDisponibleException {
        this.asiento = asiento;
        this.fecha = fechaytramo.getFecha();
        this.hora = hora;
        this.pago=pago;
        fechaytramo.getBus(hora).OcuparAsiento(asiento);
    }
    public String InfoPasaje(){
        return "Asiento: " + this.asiento + ", Hora: " + this.hora + ", Fecha: " + this.fecha + ", Valor: " + this.valor;
    }
    public String InfoPAgo(){
        return pago.toStringPago();
    }
    public int getValor(){
        return this.valor;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public String getHora(){
        return this.hora;
    }

    public int getAsiento(){
        return this.asiento;
    }
    public Pago getPago(){
        return this.pago;
    }
}