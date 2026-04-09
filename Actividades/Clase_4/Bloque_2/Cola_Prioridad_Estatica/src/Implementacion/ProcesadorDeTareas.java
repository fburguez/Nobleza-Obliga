package Implementacion;

import Interfaces.ColaPrioridadTDA;

//Procesador de Tareas (OS Scheduler): El sistema operativo maneja
//procesos del sistema (Prioridad 50) y procesos del usuario como el Spotify (Prioridad 10).
//Consigna: Asigná prioridades y explicá qué pasa si el sistema se sobrecarga.
//En este caso, usamos una cola con prioridad estática convencional, si la prioridad es mayor a 10,
//el proceso por detras de los de sistema pero por delante de los de usuario.
public class ProcesadorDeTareas implements ColaPrioridadTDA {

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
        if (cantidad >= MAX) {
            System.out.println("Cola de procesos llena. El proceso " + numero + " será descartado, espere a que termine el proceso actual.");
            return;
        } else {
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
