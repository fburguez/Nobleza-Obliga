package Implementacion;

import Interfaces.ColaPrioridadTDA;

//Fila para el sanguchito de milanesa
//Consigna: ¿Qué operación de TDA Cola usás para asegurar que no se cuele ningún "vibe coder"?
//La fila del buffet es por orden de llegada, por lo cual usamos un metodo FIFO sin prioridades.
//En este caso usamos la prioridad para índicar si el alumno es vibe coder (1) o no (0),
//si es vibe coder, no entra en la fila. Si es alumno, entra con prioridad 0 (FIFO)
//usamos el número de legajo como datos
public class Buffet implements ColaPrioridadTDA {

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
        //Si es prioridad 1, es vibecoder, no entra a la cola.
        if (prioridad == 1){
            System.out.println("Legajo " + numero + " es vibe coder, no entra.");
            return;
        }
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
