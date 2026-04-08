package Implementacion;

import Interfaces.PilaTDA;

// Consigna: Usar una pila para controlar el balanceo de paréntesis.
// Cada vez que aparece un paréntesis que abre, se apila. Cada vez que aparece un paréntesis que cierra,
// se desapila. Si al final la pila queda vacía, significa que están balanceados.

public class BalanceoDeParentesis implements PilaTDA {

    private static final int MAX = 9;
    private String[] pila;
    private int cantidad;

    @Override
    public void InicializarPila() {
        pila = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Apilar(String parentesis) {
        if (cantidad < MAX) {
            pila[cantidad] = parentesis;
            cantidad++;
        }
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()) {
            cantidad--;
        }
    }

    @Override
    public String Tope() {
        if (!PilaVacia()) {
            return pila[cantidad - 1];
        }
        return "";
    }

    @Override
    public boolean PilaVacia() {
        return cantidad == 0;
    }


    // Funciones del sistema

    public void LeerCaracter(String caracter) {
        if (caracter.equals("(")) {
            Apilar(caracter);
        }

        if (caracter.equals(")")) {
            if (!PilaVacia()) {
                Desapilar();
            }
        }
    }

    public boolean EstaBalanceado() {
        return PilaVacia();
    }
}