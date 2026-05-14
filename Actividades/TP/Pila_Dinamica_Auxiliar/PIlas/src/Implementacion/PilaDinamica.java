package Implementacion;

import Interfaces.PilaTDA;

public class PilaDinamica implements PilaTDA {

    private Node tope;

    @Override
    public void InicializarPila() { tope = null;}

    @Override
    public void Apilar(int x) {
      Node node = new Node(x,tope);
      tope = node;
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()) {
            tope = tope.getNext();
        }
    }

    @Override
    public int Tope() {
        return tope.getData();
    }

    @Override
    public boolean PilaVacia() {
        return tope == null;
    }
}
