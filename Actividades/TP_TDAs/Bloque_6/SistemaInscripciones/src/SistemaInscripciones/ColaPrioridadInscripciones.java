package SistemaInscripciones;

import Interfaces.ColaPrioridadTDA;

public class ColaPrioridadInscripciones implements ColaPrioridadTDA {
    private static final int MAX = 35;
    private String[] legajosAlumnos;
    private int[] prioridades;
    private int cantidadAlumnosInscriptos;

    @Override
    public void InicializarColaPrioridad() {
        legajosAlumnos = new String[MAX];
        prioridades = new int[MAX];
        cantidadAlumnosInscriptos = 0;
    }

    @Override
    public void AcolarPrioridad(String x, int prioridad) {
        if (cantidadAlumnosInscriptos < MAX) {
            int i = cantidadAlumnosInscriptos - 1;

            // mueve a la derecha mientras la prioridad nueva sea mayor
            while (i >= 0 && prioridades[i] < prioridad) {
                legajosAlumnos[i + 1] = legajosAlumnos[i];
                prioridades[i + 1] = prioridades[i];
                i--;
            }

            legajosAlumnos[i + 1] = x;
            prioridades[i + 1] = prioridad;
            cantidadAlumnosInscriptos++;
        }
    }

    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            for (int i = 0; i < cantidadAlumnosInscriptos - 1; i++) {
                legajosAlumnos[i] = legajosAlumnos[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            cantidadAlumnosInscriptos--;
        }
    }

    @Override
    public boolean ColaVacia() {
        return cantidadAlumnosInscriptos == 0;
    }

    @Override
    public String Primero() {
        return legajosAlumnos[0];
    }

    @Override
    public int Prioridad() {
        return prioridades[0];
    }

    public boolean ColaLlena() {return legajosAlumnos.length>=MAX;}

    public int getCantidadAlumnosInscriptos(){return cantidadAlumnosInscriptos;}
}
