package org.example.modelos;

/**
 * El enum {@code Destinos} representa una lista de destinos disponibles para un sistema de transporte.
 * Cada destino tiene asociado un número de ciudad único.
 * Se utiliza para identificar y gestionar los destinos en el sistema.
 *
 * Los destinos disponibles son:
 * - ARICA (1)
 * - IQUIQUE (2)
 * - CALAMA (3)
 * - ANTOFAGASTA (4)
 * - COPIAPO (5)
 * - LA_SERENA (6)
 * - SANTIAGO (7)
 * - RANCAGUA (8)
 * - TALCA (9)
 * - CONCEPCION (10)
 * - TEMUCO (11)
 * - VALDIVIA (12)
 * - PUERTO_MONTT (13)
 *
 * Cada destino tiene un número de ciudad único asociado, que se puede obtener mediante el método {@code getNumCiudad()}.
 */
public enum Destinos {
    ARICA(1),
    IQUIQUE(2),
    CALAMA(3),
    ANTOFAGASTA(4),
    COPIAPO(5),
    LA_SERENA(6),
    SANTIAGO(7),
    RANCAGUA(8),
    TALCA(9),
    CONCEPCION(10),
    TEMUCO(11),
    VALDIVIA(12),
    PUERTO_MONTT(13);

    /**
     * Número de ciudad asociado al destino.
     */
    private final int numero_ciudad;

    /**
     * Constructor privado para inicializar un destino con su número de ciudad.
     *
     * @param numero_ciudad Número de ciudad asociado al destino.
     */
    Destinos(int numero_ciudad) {
        this.numero_ciudad = numero_ciudad;
    }

    /**
     * Obtiene el número de ciudad asociado al destino.
     *
     * @return El número de ciudad asociado al destino.
     */
    public int getNumCiudad() {
        return numero_ciudad;
    }
}

