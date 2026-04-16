package Interface;

public interface DiccionarioMultipleTDA {
    void InicializarDiccionario();
    void Agregar(String clave, String valor);
    void EliminarValor(String clave, String valor);
    void Eliminar(String clave);
    String[] Recuperar(String clave);
    String[] Claves();
}