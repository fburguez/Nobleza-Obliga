package Implementacion;

import Interface.DiccionarioMultipleTDA;

// Consigna: Sistema de Tags de Facultad: un Diccionario donde la clave es el
// nombre de la carrera (ej: "Licenciatura en Bioinformática") y el valor es un
// Conjunto de materias obligatorias.
//
// Implementa DiccionarioMultipleTDA:
//   clave  = carrera (String)
//   valores = materias (ConjuntoEstatico por carrera)

public class TagsFacultad implements DiccionarioMultipleTDA {

    private static final int MAX_CARRERAS = 100;

    private String[] carreras;
    private ConjuntoEstatico[] materias; // cada carrera tiene su propio ConjuntoEstatico
    private int cantCarreras;

    @Override
    public void InicializarDiccionario() {
        carreras = new String[MAX_CARRERAS];
        materias = new ConjuntoEstatico[MAX_CARRERAS];
        cantCarreras = 0;
    }

    // Agrega una materia a la carrera. Si la carrera no existe, la crea.
    @Override
    public void Agregar(String carrera, String materia) {
        int pos = buscarCarrera(carrera);

        if (pos == -1) {
            if (cantCarreras < MAX_CARRERAS) {
                carreras[cantCarreras] = carrera;
                ConjuntoEstatico conjunto = new ConjuntoEstatico();
                conjunto.InicializarConjunto();
                conjunto.Agregar(materia);
                materias[cantCarreras] = conjunto;
                cantCarreras++;
            }
        } else {
            materias[pos].Agregar(materia);
        }
    }

    // Elimina una materia del conjunto de la carrera. Si queda vacío, elimina la carrera.
    @Override
    public void EliminarValor(String carrera, String materia) {
        int pos = buscarCarrera(carrera);

        if (pos != -1) {
            materias[pos].Sacar(materia);

            if (materias[pos].ConjuntoVacio()) {
                Eliminar(carrera);
            }
        }
    }

    // Elimina una carrera con todo su conjunto de materias.
    @Override
    public void Eliminar(String carrera) {
        int pos = buscarCarrera(carrera);

        if (pos != -1) {
            carreras[pos] = carreras[cantCarreras - 1];
            materias[pos] = materias[cantCarreras - 1];
            cantCarreras--;
        }
    }

    // Devuelve las materias de la carrera como String[] (extrae los elementos del Conjunto).
    @Override
    public String[] Recuperar(String carrera) {
        int pos = buscarCarrera(carrera);

        if (pos == -1) return new String[0];

        // Copia temporal del conjunto para no destruir el original al iterar
        ConjuntoEstatico copia = copiarConjunto(materias[pos]);
        int total = contarElementos(materias[pos]);

        String[] resultado = new String[total];
        int i = 0;
        while (!copia.ConjuntoVacio()) {
            String m = copia.Elegir();
            resultado[i++] = m;
            copia.Sacar(m);
        }
        return resultado;
    }

    @Override
    public String[] Claves() {
        String[] resultado = new String[cantCarreras];
        for (int i = 0; i < cantCarreras; i++) {
            resultado[i] = carreras[i];
        }
        return resultado;
    }

    private int buscarCarrera(String carrera) {
        for (int i = 0; i < cantCarreras; i++) {
            if (carreras[i].equals(carrera)) return i;
        }
        return -1;
    }

    private int contarElementos(ConjuntoEstatico conjunto) {
        ConjuntoEstatico copia = copiarConjunto(conjunto);
        int count = 0;
        while (!copia.ConjuntoVacio()) {
            copia.Sacar(copia.Elegir());
            count++;
        }
        return count;
    }

    private ConjuntoEstatico copiarConjunto(ConjuntoEstatico original) {
        ConjuntoEstatico copia = new ConjuntoEstatico();
        copia.InicializarConjunto();

        ConjuntoEstatico temp = new ConjuntoEstatico();
        temp.InicializarConjunto();

        // Vaciar original en temp, copiando a copia
        while (!original.ConjuntoVacio()) {
            String elem = original.Elegir();
            copia.Agregar(elem);
            temp.Agregar(elem);
            original.Sacar(elem);
        }
        // Restaurar original
        while (!temp.ConjuntoVacio()) {
            String elem = temp.Elegir();
            original.Agregar(elem);
            temp.Sacar(elem);
        }
        return copia;
    }
}
