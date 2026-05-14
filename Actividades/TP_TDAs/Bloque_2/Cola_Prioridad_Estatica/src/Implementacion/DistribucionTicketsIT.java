package Implementacion;

import Interfaces.ColaPrioridadTDA;

/// Tenemos problemas con sus prioridades0
/// 4 se rompio un servidor [49]
/// 3 se quiere mejorar el fondo de panralla [0]
/// 2 se debe agregar seguridad a la bd [40]
/// 1 se requiere realizar un sistema de registro de asistencia de empleados [35]

public class DistribucionTicketsIT implements ColaPrioridadTDA {

    private static final int MAX = 50;
    private String[] tickets;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void InicializarColaPrioridad() {
        tickets = new String[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(String numero, int prioridad) {
        /// Tenes [3,1,2][0,35,40] va ingresando -> (4,49)
        if (cantidad < MAX) {
            int i = cantidad - 1;

            // mueve a la derecha mientras la prioridad nueva sea mayor
            while (i >= 0 && prioridades[i] < prioridad) {
                tickets[i + 1] = tickets[i];
                prioridades[i + 1] = prioridades[i];
                i--;
            }

            tickets[i + 1] = numero;
            prioridades[i + 1] = prioridad;
            cantidad++;
            System.out.println("Se añadio el ticket respetando su prioridad");
        }
    }
    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) {
                tickets[i] = tickets[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            cantidad--;
            System.out.println("Se saco el ticket de la lista");
        }
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }

    @Override
    public String Primero() {
        return tickets[0];
    }

    @Override
    public int Prioridad() {
        return prioridades[0];
    }


}
