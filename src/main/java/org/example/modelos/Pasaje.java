package org.example.modelos;

import java.util.Date;

public class Pasaje {
    private int valor;
    private Date fecha;
    private Date hora;
    private int asiento;

    //por qué se le pasa un int de asiento y no la clase Asiento?
    public Pasaje(int asiento, Date hora, FechasYTramo fechaytramo) throws NoHayDisponibilidadException {
        this.asiento = asiento;
        this.fecha = fechaytramo.getFecha();
        this.hora = hora;
        //acá debería verificar si el precio es suficiente, si no está ocupado, si eligió un asiento nulo o incorrecto, etc
        fechaytramo.getBus(hora).OcuparAsiento(asiento);

        //esto no es necesario con el enum
        // if(fechaytramo.getBus(hora).getAsiento(asiento).getTipo()=="Estandar"){
        //     valor=4000;
        // }else{
        //     valor= (int) (4000*1.25);
        // }
    }
    public String InfoPasaje(){
        return "Asiento: " + this.asiento + ", Hora: " + this.hora + ", Fecha: " + this.fecha + ", Valor: " + this.valor;
    }
    public int getValor(){
        return this.valor;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public Date getHora(){
        return this.hora;
    }

    public int getAsiento(){
        return this.asiento;
    }
}