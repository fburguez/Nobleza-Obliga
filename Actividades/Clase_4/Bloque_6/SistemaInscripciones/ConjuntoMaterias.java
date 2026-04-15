package SistemaInscripciones;

import Interfaces.ConjuntoTDA;

public class ConjuntoMaterias implements ConjuntoTDA {
    private static final int MAX = 60;
    private String[] nombreMateriasExistentes;
    private int cantidadMateriasExistentes;
    private ConjuntoMaterias instancia;

    public ConjuntoMaterias getInstance() {
        if (instancia != null) {
            return instancia;
        } else {
            this.instancia = new ConjuntoMaterias();
            return this.instancia;
        }
    }

    @Override
    public void InicializarConjunto() {
        nombreMateriasExistentes = new String[MAX];
        cantidadMateriasExistentes = 0;
    }

    @Override
    public void Agregar(String x) {
        if (cantidadMateriasExistentes < MAX && !Pertenece(x)) {
            nombreMateriasExistentes[cantidadMateriasExistentes] = x;
            cantidadMateriasExistentes++;
        }
    }

    @Override
    public void Sacar(String x) {
        int i = 0;
        while (i < cantidadMateriasExistentes && nombreMateriasExistentes[i] != x) {
            i++;
        }

        if (i < cantidadMateriasExistentes) {
            nombreMateriasExistentes[i] = nombreMateriasExistentes[cantidadMateriasExistentes - 1];
            cantidadMateriasExistentes--;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return cantidadMateriasExistentes == 0;
    }

    @Override
    public boolean Pertenece(String x) {
        int i = 0;
        while (i < cantidadMateriasExistentes) {
            if (nombreMateriasExistentes[i] == x) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public String Elegir() {
        return nombreMateriasExistentes[0];
    }

    public String[] getNombreMaterias(){return nombreMateriasExistentes;}
}
