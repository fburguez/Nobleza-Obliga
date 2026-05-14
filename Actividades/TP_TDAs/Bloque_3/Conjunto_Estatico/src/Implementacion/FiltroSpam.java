package Implementacion;

import Interface.ConjuntoTDA;

/* Consigna: ¿Como verificas que un mail no contenga palabras prohíbidas como "Crypto" o "Ganá"
* Entonces, cuando llega un mail, deberíamos juntar todas sus palabras en un String[]
* y con ese mismo validamos una a una que ninguna de ellas se encuentre en nuestro conjunto, en caso contrario
* será considerado como Spam
* */
//////Funciones del Conjunto
public class FiltroSpam implements ConjuntoTDA {
    private static final int MAX = 100;
    private String[] palabrasProhibidas;
    private int cantidad;
    private String[] palabrasMail;

    @Override
    public void InicializarConjunto() {
        palabrasProhibidas = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(String x) {
        if (cantidad < MAX && !Pertenece(x)) {
            palabrasProhibidas[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public void Sacar(String x) {
        int i = 0;
        while (i < cantidad && palabrasProhibidas[i] != x) {
            i++;
        }

        if (i < cantidad) {
            palabrasProhibidas[i] = palabrasProhibidas[cantidad - 1];
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
            if (palabrasProhibidas[i] == x) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public String Elegir() {
        return palabrasProhibidas[0];
    }

///// Funciones del Filtro
    public boolean esSpam(String[] palabrasMail) {
        if (!(palabrasProhibidas == null || palabrasMail.length == 0) && !ConjuntoVacio()) {
            for (int i = 0;i<palabrasMail.length; i++){
                for (int j = cantidad-1; j > -1; j--) {
                    if (palabrasProhibidas[j].equals(palabrasMail[i])){return true;}
                }
            }
        }
        return false;
    }
    }

