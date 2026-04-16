package Implementacion;

import Interfaces.ColaTDA;

public class FilaCajero implements ColaTDA {
    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;

    public void InicializarCola() {
        this.datos = new String[100];
        this.cantidad = 0;
    }

    public void Acolar(String x) {
        if (this.cantidad < 100) {
            this.datos[this.cantidad] = x;
            ++this.cantidad;
        }

    }

    public void Desacolar() {
        if (!this.ColaVacia()) {
            for(int i = 0; i < this.cantidad - 1; ++i) {
                this.datos[i] = this.datos[i + 1];
            }

            --this.cantidad;
        }

    }

    public String Primero() {
        return this.datos[0];
    }

    public boolean ColaVacia() {
        return this.cantidad == 0;
    }
}
