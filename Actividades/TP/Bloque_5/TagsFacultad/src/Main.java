import Implementacion.TagsFacultad;

public class Main {
    public static void main(String[] args) {

        TagsFacultad sistema = new TagsFacultad();
        sistema.InicializarDiccionario();

        // clave = carrera, valores = materias obligatorias
        sistema.Agregar("Licenciatura en Bioinformática", "Biología Celular");
        sistema.Agregar("Licenciatura en Bioinformática", "Algoritmos y Estructuras de Datos");
        sistema.Agregar("Licenciatura en Bioinformática", "Estadística");
        sistema.Agregar("Licenciatura en Bioinformática", "Programación 1");

        sistema.Agregar("Ingeniería en Informática", "Algoritmos y Estructuras de Datos");
        sistema.Agregar("Ingeniería en Informática", "Programación 1");
        sistema.Agregar("Ingeniería en Informática", "Arquitectura de Computadoras");
        sistema.Agregar("Ingeniería en Informática", "Redes");

        sistema.Agregar("Licenciatura en Sistemas", "Programación 1");
        sistema.Agregar("Licenciatura en Sistemas", "Base de Datos");
        sistema.Agregar("Licenciatura en Sistemas", "Ingeniería de Software");

        System.out.println("=== SISTEMA DE TAGS - FACULTAD ===\n");

        for (String carrera : sistema.Claves()) {
            System.out.println("Carrera: " + carrera);
            System.out.print("  Materias obligatorias: ");
            String[] materias = sistema.Recuperar(carrera);
            for (int i = 0; i < materias.length; i++) {
                System.out.print(materias[i]);
                if (i < materias.length - 1) System.out.print(", ");
            }
            System.out.println("\n");
        }
    }
}
