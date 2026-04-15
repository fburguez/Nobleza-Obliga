package Implementacion;

import Interface.DiccionarioSimpleTDA;
//Agenda de Contactos:
//TDA: Simple.
//Modelado: Clave: [Nombre] / Valor: [Teléfono]
public class AgendaContactos implements DiccionarioSimpleTDA {

    private static final int MAX = 100;
    private String[] claves;   // nombres
    private String[] valores;  // teléfonos
    private int cantidad;

    @Override
    public void InicializarDiccionario() {
        claves = new String[MAX];
        valores = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(String clave, String valor) {
        int posClave = buscarClave(clave);

        if (posClave != -1) {
            valores[posClave] = valor; // Actualiza el teléfono si el contacto ya existe
        } else if (cantidad < MAX) {
            claves[cantidad] = clave;
            valores[cantidad] = valor;
            cantidad++;
        }
    }

    @Override
    public void Eliminar(String clave) {
        int posClave = buscarClave(clave);

        if (posClave != -1) {
            claves[posClave] = claves[cantidad - 1];
            valores[posClave] = valores[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public String Recuperar(String clave) {
        int posClave = buscarClave(clave);

        if (posClave == -1) {
            return null;
        }
        return valores[posClave];
    }

    @Override
    public String[] Claves() {
        String[] aux = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            aux[i] = claves[i];
        }
        return aux;
    }

    private int buscarClave(String clave) {
        int i = 0;
        while (i < cantidad && !claves[i].equals(clave)) {
            i++;
        }

        if (i < cantidad) {
            return i;
        }
        return -1; // Devuelve -1 si no se encuentra
    }
}
