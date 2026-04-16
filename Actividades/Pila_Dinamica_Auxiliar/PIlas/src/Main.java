import Implementacion.Node;
import Implementacion.PilaEstatica;
import Implementacion.PilaDinamica;
import Interfaces.PilaTDA;

public class Main {
    public static void main(String[] args) {

        PilaTDA p1 = new PilaEstatica();
        PilaTDA p2 = new PilaEstatica();
        PilaTDA aux = new PilaDinamica();

        p1.InicializarPila();
        System.out.println("Iniciando pila estatica");
        p2.InicializarPila();
        System.out.println(("Iniciando pila dinamica"));
        aux.InicializarPila();

        // cargar pila
        System.out.println("Apilando en Pila Estaticas");
        p1.Apilar(1);
        p1.Apilar(2);
        p1.Apilar(3);
        p1.Apilar(4);
        copiarPila(p1, p2, aux);
        System.out.println("Contenido de p1:");
        mostrarPila(p1);
    }
    public static void mostrarPila(PilaTDA p) {
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();

        while (!p.PilaVacia()) {
            int x = p.Tope();
            System.out.println(x);
            p.Desapilar();
            aux.Apilar(x);

        }

        while (!aux.PilaVacia()) {
            int x = aux.Tope();
            aux.Desapilar();
            p.Apilar(x);
        }

    }


    public static void copiarPila(PilaTDA p1, PilaTDA p2, PilaTDA aux) {

        //  p1 -> aux
        while (!p1.PilaVacia()) {
            int x = p1.Tope();
            p1.Desapilar();
            aux.Apilar(x);
        }
        System.out.println("Contenido de la pila auxiliar:");
        mostrarPila(aux);

        // aux -> p1 y p2
        while (!aux.PilaVacia()) {
            int x = aux.Tope();
            aux.Desapilar();
            p1.Apilar(x); // restaura
            p2.Apilar(x); // copia
        }
        System.out.println("Contenido de p2:");
        mostrarPila(p2);
    }
}