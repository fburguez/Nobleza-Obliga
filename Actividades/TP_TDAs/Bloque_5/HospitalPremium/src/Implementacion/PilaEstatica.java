package Implementacion;

import Interfaces.PilaTDA;

public class PilaEstatica implements PilaTDA {

    private static final int MAX = 50;
    private String[] datos;
    private int cantidad;

    @Override
    public void InicializarPila() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Apilar(String x) {
        if (cantidad < MAX) {
            datos[cantidad] = x;
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
            return datos[cantidad - 1];
        }
        return "";
    }

    @Override
    public boolean PilaVacia() {
        return cantidad == 0;
    }
}
