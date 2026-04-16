package SistemaInscripciones;

import Interfaces.ConjuntoTDA;

public class ConjuntoLegajos implements ConjuntoTDA {
    private static final int MAX = 100;
    private String[] legajosExistentes;
    private int cantidadLegajosExistentes;
    private ConjuntoLegajos instancia;

    public ConjuntoLegajos getInstance(){
        if (instancia!=null){
            return instancia;
        }
        else {
                this.instancia = new ConjuntoLegajos();
                return this.instancia;}
    }

    @Override
    public void InicializarConjunto() {
        legajosExistentes = new String[MAX];
        cantidadLegajosExistentes = 0;
    }

    @Override
    public void Agregar(String x) {
        if (cantidadLegajosExistentes < MAX && !Pertenece(x)) {
            legajosExistentes[cantidadLegajosExistentes] = x;
            cantidadLegajosExistentes++;
        }
    }

    @Override
    public void Sacar(String x) {
        int i = 0;
        while (i < cantidadLegajosExistentes && legajosExistentes[i] != x) {
            i++;
        }

        if (i < cantidadLegajosExistentes) {
            legajosExistentes[i] = legajosExistentes[cantidadLegajosExistentes - 1];
            cantidadLegajosExistentes--;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidadLegajosExistentes == 0;
    }

    @Override
    public boolean Pertenece(String x) {
        int i = 0;
        while (i < cantidadLegajosExistentes) {
            if (legajosExistentes[i] == x) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public String Elegir() {
        return legajosExistentes[0];
    }
}
