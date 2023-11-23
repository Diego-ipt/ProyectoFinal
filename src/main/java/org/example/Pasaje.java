package org.example;

public class Pasaje {
    private int valor;
    private String fecha;
    private String hora;
    private int asiento;
    public void Pasaje(int asiento, String hora, FechasYTramo fechaytramo) throws Exception {
        this.asiento=asiento;
        this.fecha=fechaytramo.getFecha();
        this.hora=hora;
        fechaytramo.getBus(hora).OcuparAsiento(asiento);
        if(fechaytramo.getBus(hora).getseat(asiento).getTipo()=="Estandar"){
            valor=4000;
        }else{
            valor= (int) (4000*1.25);
        }
    }
    public String InfoPasaje(){
        return "Asiento: " + this.asiento + ", Hora: " + this.hora + ", Fecha: " + this.fecha + ", Valor: " + this.valor;
    }
    public int getValor(){
        return this.valor;
    }

    public String getFecha(){
        return this.fecha;
    }

    public String getHora(){
        return this.hora;
    }

    public int getAsiento(){
        return this.asiento;
    }
}