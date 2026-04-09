package Implementacion;

import Interfaces.PilaTDA;

//Consigna: Explicá el proceso de meter letra por letra en la Pila y
//cómo quedan al sacarlas

// Básicamente lo que hacemos es ir apilando letra por letra, ya sea individualmente o partiendo de la palabra completa
// En caso de que tengamos la palabra completa, recorremos los caracteres 1 a 1 apilandolos como String
// Finalmente al pedir Tope reiteradas veces, se nos iran dando una a una las letras en orden contrario al inicial.
public class ReversionDeString implements PilaTDA {
    private static final int MAX = 100;
    private String[] cadena;
    private int cantidad;

    /// ////// Funciones de la Pila
    @Override
    public void InicializarPila() {
        cadena = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Apilar(String x) {
        if (cantidad + x.length() < MAX) {
            for (int i = 0; i<x.length(); i++){
                cadena[cantidad] = String.valueOf(x.charAt(i));
            }

            cadena[cantidad] = x;
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
            return cadena[cantidad];
        }
        return "";
    }

    @Override
    public boolean PilaVacia() {
        return cantidad == 0;
    }

}
