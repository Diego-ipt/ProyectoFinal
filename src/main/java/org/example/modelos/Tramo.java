package org.example.modelos;

/**
 * La clase {@code Tramo} representa un tramo de viaje entre dos ciudades, con información sobre el origen,
 * el destino y el precio asociado al tramo.
 *
 * Se utiliza para gestionar y obtener información sobre los tramos en un sistema de transporte.
 *
 * Cada tramo se crea especificando el origen y el destino mediante números de ciudad (1 a 13) y calcula
 * automáticamente el precio del tramo en función de la diferencia entre los destinos.
 *
 * También proporciona métodos para obtener el precio del tramo, el nombre del origen, el nombre del destino
 * y convertir entre el nombre de la ciudad y su número asociado.
 */
public class Tramo {
    /**
     * Nombre de la ciudad de origen del tramo.
     */
    private String origen;

    /**
     * Nombre de la ciudad de destino del tramo.
     */
    private String destino;

    /**
     * Precio asociado al tramo calculado en función de la diferencia entre los destinos.
     */
    private int precio;

    /**
     * Constructor que inicializa un nuevo objeto {@code Tramo} con el origen y destino especificados.
     *
     * @param origen  Número de ciudad correspondiente al origen del tramo.
     * @param destino Número de ciudad correspondiente al destino del tramo.
     * @throws IllegalArgumentException Si el número de ciudad no es válido.
     */
    public Tramo(int origen, int destino) throws IllegalArgumentException {
        this.origen = getDestino(origen);
        this.destino = getDestino(destino);

        int dif = Math.abs(origen - destino);
        // Precio a agregar por tramo
        precio = dif * 1200;
    }

    /**
     * Obtiene el nombre del destino asociado al número de ciudad especificado.
     *
     * @param ciudad Número de ciudad.
     * @return El nombre del destino asociado al número de ciudad.
     * @throws IllegalArgumentException Si el número de ciudad no es válido.
     */
    private String getDestino(int ciudad) throws IllegalArgumentException {
        String nombre = null;
        switch (ciudad) {
            case 1:
                nombre = "Arica";
                break;
            case 2:
                nombre = "Iquique";
                break;
            case 3:
                nombre = "Calama";
                break;
            case 4:
                nombre = "Antofagasta";
                break;
            case 5:
                nombre = "Copiapó";
                break;
            case 6:
                nombre = "La Serena";
                break;
            case 7:
                nombre = "Santiago";
                break;
            case 8:
                nombre = "Rancagua";
                break;
            case 9:
                nombre = "Talca";
                break;
            case 10:
                nombre = "Concepción";
                break;
            case 11:
                nombre = "Temuco";
                break;
            case 12:
                nombre = "Valdivia";
                break;
            case 13:
                nombre = "Puerto Montt";
                break;
            default:
                throw new IllegalArgumentException("Valor de ciudad no válido: " + ciudad);
        }

        return nombre;
    }

    /**
     * Obtiene el precio asociado al tramo.
     *
     * @return El precio asociado al tramo.
     */
    public int getPrecioTramo() {
        return precio;
    }

    /**
     * Obtiene el nombre de la ciudad de origen del tramo.
     *
     * @return El nombre de la ciudad de origen del tramo.
     */
    public String getOrigen() {
        return this.origen;
    }

    /**
     * Obtiene el nombre de la ciudad de destino del tramo.
     *
     * @return El nombre de la ciudad de destino del tramo.
     */
    public String getDestino() {
        return this.destino;
    }

    /**
     * Convierte el nombre de la ciudad en su número asociado.
     *
     * @param ciudad Nombre de la ciudad.
     * @return El número de la ciudad asociado al nombre.
     * @throws IllegalArgumentException Si el nombre de la ciudad no es válido.
     */
    public int CiudadNum(String ciudad) throws IllegalArgumentException {
        switch (ciudad) {
            case "Arica":
                return 1;
            case "Iquique":
                return 2;
            case "Calama":
                return 3;
            case "Antofagasta":
                return 4;
            case "Copiapó":
                return 5;
            case "La Serena":
                return 6;
            case "Santiago":
                return 7;
            case "Rancagua":
                return 8;
            case "Talca":
                return 9;
            case "Concepción":
                return 10;
            case "Temuco":
                return 11;
            case "Valdivia":
                return 12;
            case "Puerto Montt":
                return 13;
            default:
                throw new IllegalArgumentException("Nombre de ciudad no válido: " + ciudad);
        }
    }
}

