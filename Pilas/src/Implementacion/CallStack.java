package Implementacion;

import Interfaces.PilaTDA;

// Consigna: Representar la pila de llamadas.
// Cada vez que una función llama a otra, se apila. La función que está en ejecución es el Tope().
// Cuando una función termina, se desapila.

public class CallStack implements PilaTDA {

    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;

    public void InicializarPila() {
        this.datos = new String[MAX];
        this.cantidad = 0;
    }

    public void Apilar(String x) {
        if (this.cantidad < MAX) {
            this.datos[this.cantidad] = x;
            this.cantidad++;
        }
    }

    public void Desapilar() {
        if (!this.PilaVacia()) {
            this.cantidad--;
        }
    }

    public String Tope() {
        if (!PilaVacia()) {
            return this.datos[this.cantidad - 1];
        }
        return "";
    }

    public boolean PilaVacia() {
        return this.cantidad == 0;
    }

    // Funciones del sistema
    public void LlamarFuncion(String nombreFuncion){
        Apilar(nombreFuncion);
    }

    public void TerminarFuncion(){
        Desapilar();
    }

    public String FuncionActual(){
        return Tope();
    }
}