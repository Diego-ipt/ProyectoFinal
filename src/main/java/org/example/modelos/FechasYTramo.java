package org.example.modelos;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
/**
 * La clase {@code FechasYTramo} representa una combinación de fecha, tramo de viaje y buses disponibles en diferentes horarios.
 *
 * Se utiliza para gestionar información sobre la disponibilidad de buses en diferentes horarios para un tramo específico en una fecha determinada.
 *
 * La clase crea buses aleatorios para cada horario de salida disponible y asocia esos buses con sus respectivos horarios.
 */
public class FechasYTramo {
    /**
     * Mapa que asocia horarios de salida con buses disponibles.
     */
    private HashMap<String, Bus> busesPorHora;

    /**
     * Fecha para la que se gestiona la disponibilidad de buses.
     */
    private Date fecha;

    /**
     * Tramo de viaje asociado a la fecha.
     */
    private Tramo tramo;

    /**
     * Constructor que inicializa un nuevo objeto {@code FechasYTramo} con la fecha y los destinos del tramo especificados.
     *
     * @param fecha   Fecha para la que se gestiona la disponibilidad de buses.
     * @param origen  Número de ciudad correspondiente al origen del tramo.
     * @param destino Número de ciudad correspondiente al destino del tramo.
     * @throws DestinoNoDisponibleException Si el destino no está disponible.
     * @throws IllegalArgumentException      Si los destinos son iguales.
     */
    public FechasYTramo(Date fecha, int origen, int destino) throws DestinoNoDisponibleException, IllegalArgumentException {
        if (origen == destino) {
            throw new DestinoNoDisponibleException("Por favor, seleccione un destino distinto");
        }
        this.tramo = new Tramo(origen, destino);
        this.fecha = fecha;
        busesPorHora = new HashMap<String, Bus>();

        for (HorarioSalidaBus horario : HorarioSalidaBus.values()) {
            Random r = new Random();
            int random = r.nextInt(2) + 1;
            busesPorHora.put(horario.getHora(), new Bus(random));
        }
    }

    /**
     * Obtiene la fecha para la que se gestiona la disponibilidad de buses.
     *
     * @return La fecha asociada a la gestión de disponibilidad de buses.
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Obtiene el bus disponible en el horario especificado.
     *
     * @param hora Horario de salida del bus.
     * @return El bus disponible en el horario especificado.
     * @throws HorarioNoDisponibleException Si no hay buses disponibles a la hora especificada.
     */
    public Bus getBus(String hora) throws HorarioNoDisponibleException {
        Bus bus = busesPorHora.get(hora);
        if (bus == null) {
            throw new HorarioNoDisponibleException("No hay buses disponibles a esta hora: " + hora);
        }
        return bus;
    }

    /**
     * Obtiene el bus disponible en el horario especificado sin verificar la disponibilidad.
     *
     * @param hora Horario de salida del bus.
     * @return El bus disponible en el horario especificado, o null si no hay bus en ese horario.
     */
    public Bus getBusPorHora(String hora) {
        return busesPorHora.get(hora);
    }

    /**
     * Obtiene el tramo asociado a la fecha.
     *
     * @return El tramo asociado a la fecha.
     */
    public Tramo getTramo() {
        return tramo;
    }

    /**
     * Obtiene el precio del tramo asociado a la fecha.
     *
     * @return El precio del tramo asociado a la fecha.
     */
    public int precioTramo() {
        return tramo.getPrecioTramo();
    }
}
