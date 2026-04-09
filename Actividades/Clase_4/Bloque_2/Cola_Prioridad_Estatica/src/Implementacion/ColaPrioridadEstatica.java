package Implementacion;

import Interfaces.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {

    private static final int MAX = 100;
    private String[] datos;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void InicializarColaPrioridad() {
        datos = new String[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(String numero, int prioridad) {
        if (cantidad < MAX) {
            int i = cantidad - 1;

            // mueve a la derecha mientras la prioridad nueva sea mayor
            while (i >= 0 && prioridades[i] < prioridad) {
                datos[i + 1] = datos[i];
                prioridades[i + 1] = prioridades[i];
                i--;
            }

            datos[i + 1] = numero;
            prioridades[i + 1] = prioridad;
            cantidad++;
        }
    }

    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) {
                datos[i] = datos[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            cantidad--;
        }
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }

    @Override
    public String Primero() {
        return datos[0];
    }

    @Override
    public int Prioridad() {
        return prioridades[0];
    }
}
