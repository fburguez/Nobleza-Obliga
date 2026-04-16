package Implementacion;

import Interfaces.PilaTDA;

public class Estrategia_Balanceo implements PilaTDA {

    private static final int MAX = 100;
    private int[] datos;

    @Override
    public void InicializarPila() {
        datos = new int[MAX + 1]; //creas la lista como objeto
        datos[0] = 0; // Usamos la posición 0 para contar cuántos paréntesis hay abiertos
    }

    @Override
    public void Apilar(int x) {
// Apilas cada vez que encuentre un (
// En la expresion ((a+b)*c) lo harias 2 veces
        if (datos[0] < MAX) {
            datos[0]++;
            datos[datos[0]] = x;
            System.out.println("Se encontro un '(' Apilando marcador. Total abiertos: " + datos[0]);
        }
    }

    @Override
    public void Desapilar() {
//Desapilas cuando el parentesis se cierro
//Primero se debe verificar que la pila no este vacia con su metodo
        if (!PilaVacia()) {
            datos[0]--;
            System.out.println("Se encontro un ')' Desapilando. Quedan por cerrar: " + datos[0]);
        } else {
            System.out.println("Error se intentó desapilar un ')' sin su '(' correspondiente.");
        }
    }

    @Override
    public int Tope() {
        // Devuelve el último elemento abierto
        return datos[datos[0]];
    }

    @Override
    public boolean PilaVacia() {
        // Si es true, significa que todo lo que se abrió se cerró
        return datos[0] == 0;
    }

}