package SistemaInscripciones;

public class Sistema {
    private Alumno[] alumnosRegistrados = new Alumno[30000];
    private ConjuntoLegajos legajosRegistrados;
    private Materia[] materias = new Materia[1000];

    public void registrarAlumno(String nombre, String legajo, String departamento) {
        if (!legajosRegistrados.Pertenece(legajo)) {
            alumnosRegistrados[(alumnosRegistrados.length) - 1] = new Alumno(nombre, legajo, departamento);
        }
    }

    public void inscribirAlumnoMateria(Materia materia, Alumno alumno) {
        if (alumnoPuedeCursarMateria(materia,alumno)){
        materia.inscribirAlumno(alumno.getLegajo(), alumno.getPrioridad());
    }
    }
    private boolean alumnoPuedeCursarMateria(Materia materia, Alumno alumno){
        ConjuntoMaterias correlativas = materia.getMateriasCorrelativas();
        ConjuntoMaterias aprobadas = alumno.getMateriasAprobadas();
        boolean bandera = false;
        for (int i=0; i<correlativas.getNombreMaterias().length; i++){
            for(int j=0; j<aprobadas.getNombreMaterias().length; j++){
                if (correlativas.getNombreMaterias()[i].equals(aprobadas.getNombreMaterias()[j])){
                    bandera = true;
                }
            }
            if (!bandera){return false;}
            bandera = false;
        }
        return true;
    }

    private Alumno buscarAlumnoPorLegajo(String legajo){
        for (int i=0; i<alumnosRegistrados.length;i++){
            if(alumnosRegistrados[i].getLegajo().equals(legajo)){
                return alumnosRegistrados[i];
            }
        }
        return new Alumno("","","");
    }

    public void procesarInscripciones(Materia materia){
        /// /// Siempre y cuando queden lugares, sigue pasando gente de las inscripciones a la materia.
        for (int i = 0; materia.getCupo()<materia.getAlumnos().length; i++) {
            String legajoAlumno = materia.getInscripciones().Primero();
            materia.getInscripciones().Desacolar();
            Alumno alumno = buscarAlumnoPorLegajo(legajoAlumno);
            if (!alumno.getLegajo().equals("")){
                materia.agregarAlumno(alumno);
            }
        }

        /// /// Cuando ya se agotó el cupo/lugares
        for (int i = 0; i<materia.getInscripciones().getCantidadAlumnosInscriptos();i++){
            ColaPrioridadInscripciones inscripciones = materia.getInscripciones();
            String legajoAlumno = inscripciones.Primero();
            inscripciones.Desacolar();
            materia.inscribirListaEsperaAlumno(legajoAlumno);
        }

    }
}
