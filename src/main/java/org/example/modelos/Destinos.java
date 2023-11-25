package org.example.modelos;

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

    private int numero_ciudad;

    Destinos(int numero_ciudad) {
        this.numero_ciudad = numero_ciudad;
    }
    
    public int getNumCiudad() {
        return numero_ciudad;
    }

}
