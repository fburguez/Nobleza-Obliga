package Implementacion;

import Interfaces.ColaPrioridadTDA;

// Consigna: Modelar una guardia donde los pacientes se atienden por prioridad
// (Cola de Prioridad), pero cada paciente tiene un historial de síntomas
// que se guarda en una Pila (para ver el último síntoma detectado primero).
//
// Prioridad 3: Crítico  (ej: infarto, trauma grave)
// Prioridad 2: Urgente  (ej: fractura, fiebre alta)
// Prioridad 1: Leve     (ej: gripe, dolor de cabeza)

public class HospitalPremium implements ColaPrioridadTDA {

    private static final int MAX = 100;
    private String[] nombres;
    private int[] prioridades;
    private PilaEstatica[] sintomas; // cada paciente tiene su propia pila de síntomas
    private int cantidad;

    @Override
    public void InicializarColaPrioridad() {
        nombres = new String[MAX];
        prioridades = new int[MAX];
        sintomas = new PilaEstatica[MAX];
        cantidad = 0;
    }

    // Agrega un paciente a la guardia respetando el orden por prioridad
    @Override
    public void AcolarPrioridad(String nombre, int prioridad) {
        if (cantidad < MAX) {
            int i = cantidad - 1;

            // desplaza a la derecha mientras la prioridad nueva sea mayor
            while (i >= 0 && prioridades[i] < prioridad) {
                nombres[i + 1] = nombres[i];
                prioridades[i + 1] = prioridades[i];
                sintomas[i + 1] = sintomas[i];
                i--;
            }

            nombres[i + 1] = nombre;
            prioridades[i + 1] = prioridad;

            PilaEstatica pila = new PilaEstatica();
            pila.InicializarPila();
            sintomas[i + 1] = pila;
            cantidad++;
        }
    }

    // Registra un síntoma en la pila del paciente indicado
    public void RegistrarSintoma(String nombre, String sintoma) {
        for (int i = 0; i < cantidad; i++) {
            if (nombres[i].equals(nombre)) {
                sintomas[i].Apilar(sintoma);
                return;
            }
        }
    }

    // Atiende (y retira) al primer paciente de la guardia
    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) {
                nombres[i] = nombres[i + 1];
                prioridades[i] = prioridades[i + 1];
                sintomas[i] = sintomas[i + 1];
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
        return nombres[0];
    }

    @Override
    public int Prioridad() {
        return prioridades[0];
    }

    // Devuelve el último síntoma registrado del primer paciente en la guardia
    public String UltimoSintoma() {
        if (!ColaVacia()) {
            return sintomas[0].Tope();
        }
        return "";
    }

    // Llama al siguiente paciente por orden de prioridad y lo retira de la guardia
    public String LlamarSiguiente() {
        if (!ColaVacia()) {
            String nombre = Primero();
            Desacolar();
            return nombre;
        }
        return "";
    }
}
