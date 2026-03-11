public class arrayEnteros {
    private int[] array;

    // Función para inicializar el array
    public void inicializar(int tamaño) {
        array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = i * 2; // Ejemplo de llenado
        }
    }

    // Función para sumar los elementos
    public int sumar() {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        return suma;
    }

    // Función para encontrar el máximo
    public int encontrarMaximo() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Función para ordenar (usando bubble sort)
    public void ordenar() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Función para imprimir
    public void imprimir() {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arrayEnteros ejemplo = new arrayEnteros();
        ejemplo.inicializar(5);
        ejemplo.imprimir(); // Salida: 0 2 4 6 8 
        System.out.println("Suma: " + ejemplo.sumar()); // Suma: 20
        System.out.println("Máximo: " + ejemplo.encontrarMaximo()); // Máximo: 8
        ejemplo.ordenar(); // Ya está ordenado
        ejemplo.imprimir();
    }
}