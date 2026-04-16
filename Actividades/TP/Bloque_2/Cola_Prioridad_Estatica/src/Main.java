import Implementacion.ColaPrioridadEstatica;
import Interfaces.ColaPrioridadTDA;

public class Main {
    public static void main(String[] args) {
        ColaPrioridadTDA cola = new ColaPrioridadEstatica();

        cola.InicializarColaPrioridad();

        System.out.println("¿Cola vacía?: " + cola.ColaVacia());

        cola.AcolarPrioridad("10", 1);
        cola.AcolarPrioridad("20", 3);
        cola.AcolarPrioridad("30", 2);
        cola.AcolarPrioridad("40", 3);

        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());

        cola.Desacolar();
        System.out.println("Luego de desacolar:");
        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());

        cola.Desacolar();
        System.out.println("Luego de desacolar:");
        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());

        cola.Desacolar();
        System.out.println("Luego de desacolar:");
        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());

        cola.Desacolar();
        System.out.println("¿Cola vacía?: " + cola.ColaVacia());
    }
}