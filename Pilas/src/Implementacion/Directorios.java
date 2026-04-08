package Implementacion;

import Interfaces.PilaTDA;

// Consigna: Usar una Pila para recordar las carpetas por las que voy pasando,
// de forma que cuando el usuario presiona "Subir un nivel",
// pueda volver a la carpeta anterior (última en la que estaba).

// Cada vez que entro a una carpeta apilo el directorio actual (si lo hay) y luego actualizo el
// directorioActual. Para subir un nivel, tomo el tope de la pila y desapilo.

public class Directorios implements PilaTDA {
    private static final int MAX = 5;
    private String[] pila; //
    private int aux; //
    private String directorioActual; // guarda el directorio en el que estoy

    @Override
    public void InicializarPila() {
        pila = new String[MAX];
        aux = 0;
        directorioActual = "C:/";
    }

    @Override
    public boolean PilaVacia() {
        return aux == 0;
    }

    @Override
    public String Tope(){
        if (!PilaVacia()){
            return pila[aux - 1];
        }
        return "";
    }

    @Override
    public void Apilar(String x) {
        if (aux < MAX){
            pila[aux] = x;
            aux++;
        }
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()) {
            aux--;
        }
    }


    // Funciones del sistema
    public void EntrarDirectorio(String nuevoDirectorio){
        if (directorioActual != null){
            Apilar(directorioActual); // guardo el directorio actual
        }
        directorioActual = nuevoDirectorio; // paso al nuevo
    }

    public String SubirNivel(){
        if (!PilaVacia()){
            directorioActual = Tope();
            Desapilar();
        }
        return directorioActual;
    }
}