package Implementacion;

import Interfaces.PilaTDA;

//Consigna: Decribí qué estado del código deberías Apilar cada vez que el usuario hace un cambio y
// como recuperas el estado anterior

// En este caso, cada vez que el usuario hace un cambio, apilas la version anterior del
// codigo (estado actual hasta ese momento) si la hay
// y recién ahí asignas la version actual a la variable codigoActual

public class EditorDeCodigo implements PilaTDA {
    private static final int MAX = 100;
    private String[] historial;
    private int cantidad; // variable auxiliar: cantidad de elementos
    private String codigoActual;

    ///////// Funciones de la Pila
    @Override
    public void InicializarPila() {
    historial = new String[MAX];
    cantidad = 0;
    }

    @Override
    public void Apilar(String x) {
        if (cantidad<MAX){
            historial[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()){
            cantidad--;
        }
    }

    @Override
    public String Tope() {
        if (!PilaVacia()){
            return historial[cantidad];
        }
        return "";
    }

    @Override
    public boolean PilaVacia() {
        return cantidad==0;
    }

    //////////////////////// Funciones del Editor
    public void Escribir(String nuevoCodigo){
        if (codigoActual!= null){
            Apilar(codigoActual);
            codigoActual = nuevoCodigo;
        }
        else {Apilar(nuevoCodigo);};
    }

    public String Deshacer(){
        if (!PilaVacia()){return Tope();}
        return "";
    }


}
