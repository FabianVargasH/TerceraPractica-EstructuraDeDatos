import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public MinHeap(ArrayList<Integer> datos) {
        this.heap = new ArrayList<>(datos);
        heapify();
    }

    public void insertar(int valor) {
        heap.add(valor);
        upHeapify(heap.size() - 1);
        System.out.println("Insertado: " + valor);
    }

    //Tecnica de los 3 vasos :)
    private void intercambiar(int a, int b) {
        int tmp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, tmp);
    }

    private void upHeapify(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (heap.get(i) < heap.get(padre)) {
                intercambiar(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    public int eliminarMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("El montículo está vacío");
        }
        int minimo = heap.get(0);
        int ultimo = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0);
        }
        return minimo;
    }

    private void downHeapify(int i) {
        int n = heap.size();
        while (true) {
            int izquierdo = 2 * i + 1;
            int derecho = 2 * i + 2;
            int menor = i;
            if (izquierdo < n && heap.get(izquierdo) < heap.get(menor)) {
                menor = izquierdo;
            }
            if (derecho < n && heap.get(derecho) < heap.get(menor)) {
                menor = derecho;
            }
            if (menor != i) {
                intercambiar(i, menor);
                i = menor;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("El montículo está vacío");
        }
        return heap.get(0);
    }

    public void heapify() {
        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
        System.out.println("Heapify aplicado. Arreglo convertido en min-heap.");
    }
    public void heapify(ArrayList<Integer> datos) {
        this.heap = new ArrayList<>(datos);
        heapify();
    }


    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    @Override
    public String toString() {
        if (heap.isEmpty()) {
            return "(montículo vacío)";
        }

        String resultado = "Arreglo : " + heap + "\n";
        resultado += "Árbol (por niveles):\n";
        int nivel = 0;
        int inicio = 0;
        int n = heap.size();
        while (inicio < n) {
            int cantidadPorNivel = 1;
            for (int i = 0; i < nivel; i++) {
                cantidadPorNivel *= 2;
            }
            int fin = Math.min(inicio + cantidadPorNivel, n);
            resultado += "    Nivel " + nivel + ": ";
            for (int i = inicio; i < fin; i++) {
                resultado += heap.get(i);
                if (i < fin - 1) resultado += "  ";
            }
            resultado += "\n";
            inicio = fin;
            nivel++;
        }
        return resultado;
    }
}