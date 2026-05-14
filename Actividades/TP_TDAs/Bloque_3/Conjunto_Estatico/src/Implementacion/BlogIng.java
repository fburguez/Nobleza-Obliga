package Implementacion;

import Interfaces.ConjuntoTDA;

public class BlogIng implements ConjuntoTDA {

    private static final int MAX = 100;
    private int[] etiqueta;
    private int cantidad;

    public void iniciarConjunto() {
        etiqueta = new int[MAX];
        cantidad = 0;
    }

    public void agregar(int x) {
        if (cantidad < MAX && !pertenece(x)) {
            etiqueta[cantidad] = x;
            cantidad++;
        }
    }

    public void sacar(int x) {
        int i = 0;
        while (i < cantidad && etiqueta[i] != x) {
            i++;
        }

        if (i < cantidad) {
            etiqueta[i] = etiqueta[cantidad - 1];
            cantidad--;
        }
    }

    public boolean conjuntoVacio() {
        return cantidad == 0;
    }

    public boolean pertenece(int x) {
        int i = 0;
        while (i < cantidad) {
            if (etiqueta[i] == x) {
                return true;
            }
            i++;
        }
        return false;
    }
    public int elegir() {
        return etiqueta[0];
    }
}

