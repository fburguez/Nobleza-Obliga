package Implementacion;

import Interface.ConjuntoTDA;

///

public class FinDeCursadaParty implements ConjuntoTDA {

    private static final int MAX = 100;
    private String[] invitados;
    private int cantidad;

    @Override
    public void InicializarConjunto() {
        invitados = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(String x) {
        /// Si se intenta añadir a un invitado que ya esta dentro pasa por el metodo Pertenece
        if (cantidad < MAX && !Pertenece(x)) {
            invitados[cantidad] = x;
            cantidad++;
        }
        /// Si estaba dentro de la fiesta no lo mete, y si no estaba lo dejan pasar
    }

    @Override
    public void Sacar(String x) {
        int i = 0;
        while (i < cantidad && invitados[i] != x) {
            i++;
        }

        if (i < cantidad) {
            invitados[i] = invitados[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public boolean Pertenece(String x) {
        ///  Se fija que el invitado este o no dentro, y devuelve un si o no
        int i = 0;
        while (i < cantidad) {
            if (invitados[i] == x) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public String Elegir() {
        return invitados[0];
    }
}
