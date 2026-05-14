## COSTOS
Aquí se adjuntan los Ejercicios de las clases 8 y 9

<br>

## Clase 8

[Cuadro Comparativo entre TDAs](Costos_TDAs.pdf)

<br>

## Clase 9

Consignas:
EJERCICIO 1: Análisis de ciclos anidados con condición
Determiná la familia de complejidad temporal del siguiente método en el peor caso. Justificá analizando el comportamiento de los índices.

EJERCICIO 2: Comparativa de "Fierros" (TDAs Estáticos)
Analizá la operación Acolar(x) en:
1.ColaPU (Estática): El nuevo elemento va siempre a la posición 0.
2.ColaPI (Estática): El nuevo elemento va al final del arreglo.
3.ColaLD (Dinámica): Usa nodos con punteros al primero y último. Indica el costo temporal para cada una y justifica por qué la implementación estática "PU" es distinta a las demás.

EJERCICIO 3: El algoritmo integrador filtrar
Un método recibe una Cola de n elementos, extrae todos para identificar los mayores a un "límite" (guardándolos en una cola nueva) y luego restaura la original volcando los datos desde una estructura auxiliar tmp. Determina: (a) Complejidad temporal O(n) y (b) Complejidad espacial O(n).

EJERCICIO 4: Regla de la Suma (Código Secuencial)
Analizá el siguiente método y determiná su familia de complejidad desglosando el costo de cada bloque independiente.

EJERCICIO 5: Regla del Producto (Matrices)
Analizá la complejidad de recorrer una matriz cuadrada n X n para buscar un número par. Identificá el peor caso.

EJERCICIO 6: Jerarquía de Dominancia
Determiná la familia de complejidad total del siguiente bloque de código aplicando las reglas de simplificación.

EJERCICIO 7: Divide y Vencerás 
Explicá matemáticamente por qué la Búsqueda Binaria sobre un arreglo ordenado de n elementos pertenece a la familia O(log n). Utilizá el concepto de divisiones sucesivas de la tanda de datos.

EJERCICIO 8: El costo oculto del TDA Conjunto
Se desea calcular la intersección de dos Conjuntos (A y B) de tamaño n cada uno usando implementaciones estáticas. El algoritmo recorre A y por cada elemento llama a B.Pertenece(x). Si es true, lo agrega a un conjunto resultado usando Agregar(x). ¿Cuál es la complejidad temporal real considerando las validaciones internas del TDA?.

EJERCICIO 9: Parámetros múltiples (Cola con Prioridad)
Analizá la operación Desacolar() en una Cola con Prioridad implementada con K subcolas. Justificá por qué su complejidad es O(K) y por qué se dice que es independiente de la cantidad total de elementos n.

EJERCICIO 10: Análisis de algoritmo con recursión doble
Dada la implementación recursiva de Fibonacci:

Sin realizar el cálculo matemático exacto, indicá a qué familia de costo (jerarquía) pertenece (¿Constante, Lineal o Exponencial?) y justificá basándote en el crecimiento de las llamadas.


