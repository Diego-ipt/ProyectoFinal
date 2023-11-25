package org.example.modelos;

import java.util.Date;

public class Pasaje {
    private int valor;
    private Date fecha;
    private String hora;
    private int asiento;
    private Pago pago;

    public Pasaje(int asiento, String hora, FechasYTramo fechaytramo, Pago pago) throws AsientoNoDisponibleException, HorarioNoDisponibleException {
        this.asiento = asiento;
        this.fecha = fechaytramo.getFecha();
        this.hora = hora;
        this.pago=pago;
        if (fechaytramo.getBus(hora).getAsiento(asiento).tipoAsiento().equals("SemiCama")) {
            this.valor = (int) (PrecioAsiento.SemiCama.getPrecio()*fechaytramo.precioTramo());
        } else {
            this.valor = (int) (PrecioAsiento.Cama.getPrecio()*fechaytramo.precioTramo());
        }
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