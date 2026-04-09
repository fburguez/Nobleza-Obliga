package Implementacion;
import Interface.ConjuntoTDA;

public class InvitadosFiesta implements ConjuntoTDA {
    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;

    @Override
    public void InicializarConjunto() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(String x) {
        if (cantidad < MAX && !Pertenece(x)) { // Al poner !Pertenece(x)), no permite repetidos
                                               // Ni cambia el tamaño del conjunto
            datos[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public void Sacar(String x) {
        int i = 0;
        while (i < cantidad && datos[i] != x) {
            i++;
        }

        if (i < cantidad) {
            datos[i] = datos[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public boolean Pertenece(String x) {
        int i = 0;
        while (i < cantidad) {
            if (datos[i].equals(x)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public String Elegir() {
        return datos[0];
    }
}
