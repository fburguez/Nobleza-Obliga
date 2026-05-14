package Implementacion;

import Interfaces.ColaTDA;

// Consigna: Si la impresora recibe 5 archivos, ¿Cuál es el orden de salida?
// Básicamente la impresora recibirá los arhivos formando una cola según el orden de llegada,
// por tanto irá impriendo desde el que llegó primero hasta el último que llegó, imprimiendo y sacando de la
// cola uno a uno

public class ImpresoraDeLaboratorio implements ColaTDA {


    private static final int MAX = 100;
    private String[] colaDeImpresion;
    private int cantidad;

    /////// Funciones de la Pila
    @Override
    public void InicializarCola() {
        colaDeImpresion = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Acolar(String archivo) {
        if (cantidad < MAX) {
            colaDeImpresion[cantidad] = archivo;
            cantidad++;
        }
    }

    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) {
                colaDeImpresion[i] = colaDeImpresion[i + 1];
            }
            cantidad--;
        }
    }

    @Override
    public String Primero() {
        return colaDeImpresion[0];
    }

    public boolean ColaVacia() {
        return cantidad == 0;
    }

    /////// Funciones de la Pila
    public String Imprimir() {
        if (!ColaVacia()){
        String i = Primero();
        Desacolar();
        return i;}
        else {
            return "";
        }
    }

}


