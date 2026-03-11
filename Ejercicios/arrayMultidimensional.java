public class arrayMultidimensional {
    private int[][] array;

    // Función para inicializar el array (matriz 3x3 por ejemplo)
    public void inicializar() {
        array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }

    // Función para sumar una fila específica
    public int sumarFila(int fila) {
        int suma = 0;
        for (int col = 0; col < array[fila].length; col++) {
            suma += array[fila][col];
        }
        return suma;
    }

    // Función para transponer la matriz
    public void transponer() {
        int[][] temp = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                temp[j][i] = array[i][j];
            }
        }
        array = temp;
    }

    // Función para encontrar máximo en una columna
    public int maximoColumna(int col) {
        int max = array[0][col];
        for (int fila = 1; fila < array.length; fila++) {
            if (array[fila][col] > max) {
                max = array[fila][col];
            }
        }
        return max;
    }

    // Función para imprimir
    public void imprimir() {
        for (int[] fila : array) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        arrayMultidimensional ejemplo = new arrayMultidimensional();
        ejemplo.inicializar();
        ejemplo.imprimir(); 
        // Salida:
        // 1 2 3 
        // 4 5 6 
        // 7 8 9 
        System.out.println("Suma fila 1: " + ejemplo.sumarFila(1)); // Suma fila 1: 15
        System.out.println("Máximo columna 0: " + ejemplo.maximoColumna(0)); // Máximo columna 0: 7
        ejemplo.transponer();
        ejemplo.imprimir();
        // Salida transpuesta:
        // 1 4 7 
        // 2 5 8 
        // 3 6 9 
    }
}