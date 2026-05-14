package SistemaInscripciones;

public class Materia {
    private int cupo = 30;
    private String nombre;
    private String codigoDeMateria;
    private ListaEsperaMateria listaEspera;
    private ColaPrioridadInscripciones inscripciones;
    private ConjuntoMaterias materiasCorrelativas;
    private Alumno[] alumnos;
    private int cantidadAlumnos = 0;

    public ListaEsperaMateria getListaEspera(){ return listaEspera;}

    public void inscribirListaEsperaAlumno(String legajo){
        listaEspera.Acolar(legajo);
    }

    public void inscribirMateriaAlumno(String legajo, int prioridad){
        inscripciones.AcolarPrioridad(legajo, prioridad);
    }

    public void inscribirAlumno(String legajo, int prioridad){
        if (!inscripciones.ColaLlena()){
            inscribirMateriaAlumno(legajo, prioridad);
        }
        else {
            inscribirListaEsperaAlumno(legajo);
        }
    }

    public ConjuntoMaterias getMateriasCorrelativas(){
        return materiasCorrelativas;
    }

    public int getCupo(){return cupo;}

    public Alumno[] getAlumnos(){return alumnos;}

    public ColaPrioridadInscripciones getInscripciones(){return inscripciones;}

    public void agregarAlumno(Alumno alumno){
        alumnos[cantidadAlumnos] = alumno;
        cantidadAlumnos++;
    }
}
