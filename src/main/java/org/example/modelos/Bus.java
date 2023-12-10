package org.example.modelos;

import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;

/**
 * La clase {@code Bus} representa un vehículo de transporte con asientos distribuidos en uno o dos pisos.
 * Cada asiento en el bus puede ser de tipo cama o semi cama. La clase incluye métodos para ocupar asientos,
 * obtener información sobre los asientos y características del bus.
 */
public class Bus {
    /**
     * Lista de asientos en el bus.
     */
    private ArrayList<Asiento> Asientos;

    /**
     * Número de pisos en el bus (1 o 2).
     */
    private int pisos;

    /**
     * Identificador único del bus, generado a partir del toString del objeto.
     */
    private String id;

    /**
     * Constructor que inicializa un nuevo objeto {@code Bus} con el número de pisos especificado.
     * Si el número de pisos es diferente de 1 o 2, se lanzará una excepción.
     *
     * @param pisos Número de pisos del bus (1 o 2).
     * @throws IllegalArgumentException Si el número de pisos no es 1 ni 2.
     */
    public Bus(int pisos) throws IllegalArgumentException {
        if (pisos != 1 && pisos != 2) {
            throw new IllegalArgumentException("El número de pisos debe ser 1 o 2.");
        }

        Asientos = new ArrayList<Asiento>();
        int numAsientos = (pisos == 1) ? 40 : 72;
        int numSalonCama = numAsientos / 4;
        this.pisos = pisos;
        this.id = this.toString().substring(24);

        for (int i = 0; i < numAsientos; i++) {
            if (i < numSalonCama) {
                Asientos.add(new AsientoCama(i + 1));
            } else {
                Asientos.add(new AsientoSemiCama(i + 1));
            }
        }
    }

    /**
     * Ocupa el asiento con el número especificado.
     *
     * @param numero Número del asiento a ocupar.
     * @throws AsientoNoDisponibleException Si el asiento no está disponible.
     * @throws IllegalArgumentException     Si el número de asiento es inválido.
     */
    public void OcuparAsiento(int numero) throws AsientoNoDisponibleException, IllegalArgumentException {
        if (numero > 0 && numero <= Asientos.size()) {
            Asiento asiento = Asientos.get(numero - 1);
            if (!asiento.getDisponibilidad()) {
                throw new AsientoNoDisponibleException("El asiento " + numero + " ya está ocupado.");
            } else {
                asiento.setDisponibilidad(false);
            }
        } else {
            throw new IllegalArgumentException("El número de asiento " + numero + " es inválido.");
        }
    }

    /**
     * Obtiene el objeto {@code Asiento} correspondiente al número de asiento especificado.
     *
     * @param Asiento Número de asiento.
     * @return El objeto {@code Asiento} correspondiente al número especificado.
     */
    public Asiento getAsiento(int Asiento) {
        return Asientos.get(Asiento);
    }

    /**
     * Obtiene el identificador único del bus.
     *
     * @return El identificador único del bus.
     */
    public String getIdBus() {
        return id;
    }

    /**
     * Obtiene el número total de asientos en el bus.
     *
     * @return El número total de asientos en el bus.
     */
    public int tamañoAsientos() {
        return this.Asientos.size();
    }

    /**
     * Obtiene el número de pisos del bus.
     *
     * @return El número de pisos del bus.
     */
    public int getNumPisos() {
        return pisos;
    }
}
