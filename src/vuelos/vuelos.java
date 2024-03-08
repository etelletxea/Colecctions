package vuelos;

import java.util.*;

public class vuelos {

    private String numeroVuelo;
    private String origenVuelo;
    private String destinoVuelo;
    private String diaVuelo;
    private String claseVuelo;

    public vuelos(String numero, String origen, String destino, String dia, String clase) {
        this.numeroVuelo = numero;
        this.origenVuelo = origen;
        this.destinoVuelo = destino;
        this.diaVuelo = dia;
        this.claseVuelo = clase;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getOrigenVuelo() {
        return origenVuelo;
    }

    public String getDestinoVuelo() {
        return destinoVuelo;
    }

    public String getDiaVuelo() {
        return diaVuelo;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    @Override
    public String toString() {
        return
                "numero: " + numeroVuelo +
                        ", origen: " + origenVuelo +
                        ", destino: " + destinoVuelo +
                        ", dia: " + diaVuelo +
                        ", clase: " + claseVuelo;
    }

}

