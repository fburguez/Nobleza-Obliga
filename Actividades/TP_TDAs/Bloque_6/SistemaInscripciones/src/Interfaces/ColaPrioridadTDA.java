package Interfaces;

public interface ColaPrioridadTDA {
    void InicializarColaPrioridad();
    void AcolarPrioridad(String numero, int prioridad);
    void Desacolar();
    boolean ColaVacia();
    String Primero();
    int Prioridad();
}
