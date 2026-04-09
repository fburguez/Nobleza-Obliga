package Implementacion;

import Interface.ConjuntoTDA;

public class Legajos implements ConjuntoTDA {

    private static final int MAX = 100;
    private String[] legajo;
    private int cantidad;

    @Override
    public void InicializarConjunto() {
        legajo = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(String x) {
        if (cantidad < MAX && !Pertenece(x)) {
            legajo[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public void Sacar(String x) {
        int i = 0;
        while (i < cantidad && !legajo[i].equals(x)) {
            i++;
        }

        if (i < cantidad) {
            legajo[i] = legajo[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public boolean Pertenece(String x) {
        int i = 0;
        while (i < cantidad) {
            if (legajo[i].equals(x)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public String Elegir() {
        return legajo[0];
    }
}
