package SistemaInscripciones;

import Interfaces.ColaTDA;

public class ListaEsperaMateria implements ColaTDA {
    private static final int MAX = 100;
    private String[] legajosAlumnos;
    private int cantidadAlumnos;

    @Override
    public void InicializarCola() {
        legajosAlumnos = new String[MAX];
        cantidadAlumnos = 0;
    }

    @Override
    public void Acolar(String x) {
        if (cantidadAlumnos < MAX) {
            legajosAlumnos[cantidadAlumnos] = x;
            cantidadAlumnos++;
        }
    }

    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            for (int i = 0; i < cantidadAlumnos - 1; i++) {
                legajosAlumnos[i] = legajosAlumnos[i + 1];
            }
            cantidadAlumnos--;
        }
    }

    @Override
    public String Primero() {
        return legajosAlumnos[0];
    }

    @Override
    public boolean ColaVacia() {
        return cantidadAlumnos == 0;
    }

    public boolean ColaLlena(){return (legajosAlumnos.length>=MAX);}
}


