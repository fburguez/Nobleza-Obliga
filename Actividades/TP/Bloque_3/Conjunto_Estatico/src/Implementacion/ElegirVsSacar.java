package Implementacion;

import Interface.ConjuntoTDA;

/* Pregunta Técnica: Si llamás a Elegir dos veces seguidas sin llamar a
* Sacar, ¿te devuelve el mismo elemento? (Pista: Es arbitrario, no
* necesariamente aleatorio).
*
* Te devuelve un valor siguiendo la implmentación que se haya realizado, es decir, en este caso Elegir devuelve
* siempre el valor que está en primera posición, por tanto, si se ejecuta reiteradas veces el método sin haber
* realizado o ejecutado un Sacar(), entonces seguirá devolviendo el mismo valor ya que la primer posición justamente
* sigue valiendo lo mismo. En otras palabras, si no modificas el orden o valores, con esta implementación, elegis siempre el mismo
*
 */

public class ElegirVsSacar implements ConjuntoTDA {
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
        if (cantidad < MAX && !Pertenece(x)) {
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
            if (datos[i] == x) {
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

