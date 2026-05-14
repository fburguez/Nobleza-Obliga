package SistemaInscripciones;

public class Alumno {
    private String nombreCompleto;
    private String legajo;
    private int prioridadInscripcion = 0;
    private ConjuntoMaterias materiasAprobadas;

    public void setLegajo(String legajo){
        this.legajo = legajo;
    }

    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }

    public void setPrioridadInscripcion(String departamento){
        switch (departamento) {
            case "Tecnología": this.prioridadInscripcion = 1; break;
            default: this.prioridadInscripcion = 0; break;

        }
    }

    public Alumno(String nombre, String legajo, String departamento){
        this.nombreCompleto = nombre;
        this.legajo = legajo;
        setPrioridadInscripcion(departamento);
    }

    public String getLegajo(){return this.legajo;}
    public int getPrioridad(){return this.prioridadInscripcion;}
    public ConjuntoMaterias getMateriasAprobadas(){return materiasAprobadas;}

}
