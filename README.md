<img align="right" width="111" height="105" alt="Logo Cenfotec Actual (1)" src="https://github.com/user-attachments/assets/783b8894-d7e1-4b07-b66f-2e3b519621be" />

# Implementación de Min-Heap


## Descripción

Implementación de un min-heap utilizando `ArrayList`. Un min-heap es una estructura de datos tipo árbol donde cada nodo es menor o igual que sus hijos, garantizando que el elemento mínimo siempre está en la raíz.

## Estructura

Representación en arreglo donde para un nodo en índice `i`:
- Hijo izquierdo: `2i + 1`
- Hijo derecho: `2i + 2`
- Padre: `(i - 1) / 2`

## Métodos Principales

| Método | Propósito | 
|--------|-----------|
| `insertar(int valor)` | Añade elemento y ejecuta `upHeapify()` | 
| `eliminarMin()` | Retorna y elimina la raíz, ejecuta `downHeapify()` | 
| `peek()` | Retorna el mínimo sin eliminarlo | O(1) |
| `heapify()` | Convierte un arreglo en min-heap válido | 

## Métodos Auxiliares

- **`upHeapify`**: Intercambia el nodo con su padre mientras sea menor que él. Se ejecuta exhaustivamente hasta encontrar la posición correcta.
- **`downHeapify`**: Intercambia el nodo con su hijo más pequeño mientras sea mayor que él. Se ejecuta exhaustivamente hasta encontrar la posición correcta.

## Características

- Duplicados permitidos
- Arreglo dinámico (`ArrayList`)
- Mantiene invariante: cada nodo ≤ sus hijos
- Operaciones logarítmicas en tiempo

## Autor

Fabián Vargas Hidalgo

Curso: Estructura de datos

Universidad Cenfotec
