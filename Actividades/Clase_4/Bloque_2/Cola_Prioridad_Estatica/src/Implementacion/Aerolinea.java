package Implementacion;

import Interfaces.ColaPrioridadTDA;

public class Aerolinea implements ColaPrioridadTDA {

    private static final int MAX = 100;
    private String[] nombres;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void InicializarColaPrioridad(){
        nombres = new String[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(String x, int prioridad){
        if (cantidad < MAX) {
            int i = cantidad - 1;
            while (i >= 0 && prioridades[i] < prioridad) {
                nombres[i + 1] = nombres[i];
                prioridades[i + 1] = prioridades[i];
                i--;
            }
            nombres[i + 1] = x;
            prioridades[i + 1] = prioridad;
            cantidad++;
        }
    }

    @Override
    public void Desacolar(){
        if (!ColaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) {
                nombres[i] = nombres[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            cantidad--;
        }
    }

    @Override
    public String Primero(){
        return nombres[0];
    }

    @Override
    public int Prioridad() {
        return prioridades[0];
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }

}
