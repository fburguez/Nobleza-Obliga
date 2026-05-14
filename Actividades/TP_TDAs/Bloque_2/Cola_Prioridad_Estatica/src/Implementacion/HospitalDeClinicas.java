package Implementacion;

import Interfaces.ColaPrioridadTDA;

// Consigna: Definí los valores de prioridad para 3 casos a elección
// Prioridad 1: Dolor de cabeza leve
// Prioridad 2: Corte superficial
// Prioridad 3: Fractura

public class HospitalDeClinicas implements ColaPrioridadTDA {
    private static final int MAX = 100;
    private String[] datos;
    private int[] prioridades;
    private int cantidad;

    //////Funciones de la Cola con Prioridad
    @Override
    public void InicializarColaPrioridad() {
        datos = new String[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(String x, int prioridad) {
        if (cantidad < MAX) {
            int i = cantidad - 1;

            // mueve a la derecha mientras la prioridad nueva sea mayor
            while (i >= 0 && prioridades[i] < prioridad) {
                datos[i + 1] = datos[i];
                prioridades[i + 1] = prioridades[i];
                i--;
            }

            datos[i + 1] = x;
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

    //////Funciones del Hospital
    public String LlamarPaciente(){ // Los pacientes son llamados a partir de la fila realizada que contempla su prioridad
        if (!ColaVacia()){
            String paciente = Primero();
            Desacolar();
            return paciente;
        }
        else return "";
    }

}


