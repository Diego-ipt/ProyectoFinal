package org.example;

public class Pasaje {
    private int valor;
    private String fecha;
    private String hora;
    private int asiento;
    public void Pasaje(int asiento, String hora, Fechas fecha) throws Exception {
        this.asiento=asiento;
        this.fecha=fecha.getFecha();
        this.hora=hora;
        fecha.getBus(hora).OcuparAsiento(asiento);
        if(fecha.getBus(hora).getseat(asiento).getTipo()=="Estandar"){
            valor=4000;
        }else{
            valor=6000;
        }
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