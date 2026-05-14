import Implementacion.HospitalPremium;

public class Main {
    public static void main(String[] args) {

        HospitalPremium guardia = new HospitalPremium();
        guardia.InicializarColaPrioridad();

        // Agregar pacientes con su nivel de prioridad
        guardia.AcolarPrioridad("Carlos", 2);  // Urgente
        guardia.AcolarPrioridad("Ana", 3);     // Crítico
        guardia.AcolarPrioridad("Luis", 1);    // Leve
        guardia.AcolarPrioridad("María", 3);   // Crítico (después que Ana)

        // Registrar síntomas de cada paciente (se guardan en Pila: último en entrar, primero en verse)
        guardia.RegistrarSintoma("Carlos", "Dolor en el brazo");
        guardia.RegistrarSintoma("Carlos", "Inflamación notable");
        guardia.RegistrarSintoma("Carlos", "Fractura visible");

        guardia.RegistrarSintoma("Ana", "Dolor en el pecho");
        guardia.RegistrarSintoma("Ana", "Presión arterial alta");
        guardia.RegistrarSintoma("Ana", "Dificultad para respirar");

        guardia.RegistrarSintoma("Luis", "Congestion nasal");
        guardia.RegistrarSintoma("Luis", "Fiebre leve");

        guardia.RegistrarSintoma("María", "Pérdida de conciencia breve");
        guardia.RegistrarSintoma("María", "Golpe en la cabeza");

        while (!guardia.ColaVacia()) {
            System.out.println("Paciente: " + guardia.Primero());
            System.out.println("Prioridad: " + guardia.Prioridad());
            System.out.println("Último síntoma: " + guardia.UltimoSintoma());
            guardia.LlamarSiguiente();
        }

        System.out.println("No quedan más pacientes en la guardia.");
    }
}
