package Implementacion;

import Interfaces.PilaTDA;

// Consigna: Usar una pila para guardar las páginas visitadas,
// de forma que al presionar "Atrás" se pueda volver
// a la última página en la que se estaba.

// En este caso, cada vez que el usuario entra a una nueva página, se apila la página actual (si la hay)
// y luego se actualiza la paginaActual. Cuando el usuario presiona "Atrás",
// se recupera el Tope() y luego se desapila.

public class Historial implements PilaTDA {

    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;
    private String paginaActual;

    public void InicializarPila(){
        datos = new String[MAX];
        cantidad = 0;
        paginaActual = "";
    }

    public void Apilar(String x){
        if (cantidad < MAX){
            datos[cantidad] = x;
            cantidad++;
        }
    }

    public void Desapilar(){
        if (!PilaVacia()){
            cantidad--;
        }
    }

    public String Tope(){
        if (!PilaVacia()){
            return datos[cantidad - 1];
        }
        return "";
    }

    public boolean PilaVacia(){
        return cantidad == 0;
    }


    // Funciones del sistema


    public void VisitarPagina(String nuevaPagina){
        if (!paginaActual.isEmpty()){
            Apilar(paginaActual);
        }
        paginaActual = nuevaPagina;
    }

    public String VolverAtras(){
        if (!PilaVacia()){
            paginaActual = Tope();
            Desapilar();
        }
        return paginaActual;
    }
}