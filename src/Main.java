import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        MinHeap heap = new MinHeap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("\n========== MENÚ MIN-HEAP ==========");
                System.out.println("1. Insertar elemento");
                System.out.println("2. Eliminar mínimo");
                System.out.println("3. Ver mínimo (peek)");
                System.out.println("4. Heapify (convertir arreglo en min-heap)");
                System.out.println("5. Ver tamaño del montículo");
                System.out.println("6. Verificar si está vacío");
                System.out.println("7. Mostrar montículo");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");

                String opcion = br.readLine();

                switch (opcion) {
                    case "1":
                        System.out.print("Ingrese el valor a insertar: ");
                        int valor = Integer.parseInt(br.readLine());
                        heap.insertar(valor);
                        break;

                    case "2":
                        try {
                            int minimo = heap.eliminarMin();
                            System.out.println("Elemento mínimo eliminado: " + minimo);
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case "3":
                        try {
                            int min = heap.peek();
                            System.out.println("Elemento mínimo (raíz): " + min);
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case "4":
                        System.out.print("Ingrese la cantidad de números: ");
                        int cantidad = Integer.parseInt(br.readLine());
                        ArrayList<Integer> datos = new ArrayList<>();
                        for (int i = 0; i < cantidad; i++) {
                            System.out.print("Número " + (i + 1) + ": ");
                            datos.add(Integer.parseInt(br.readLine()));
                        }
                        heap.heapify(datos);
                        System.out.println("Nuevo montículo creado a partir del arreglo ingresado.");
                        break;

                    case "5":
                        System.out.println("Tamaño del montículo: " + heap.size());
                        break;

                    case "6":
                        if (heap.isEmpty()) {
                            System.out.println("El montículo está vacío.");
                        } else {
                            System.out.println("El montículo NO está vacío.");
                        }
                        break;

                    case "7":
                        System.out.println(heap);
                        break;

                    case "8":
                        System.out.println("Saliendo del programa...");
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
                //Excepciones para el ingreso de los datos
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}