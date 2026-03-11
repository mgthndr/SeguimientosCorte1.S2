public class arrayBoolean {
    private boolean[] array;

    // Función para inicializar el array
    public void inicializar(int tamaño) {
        array = new boolean[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = (i % 2 == 0); // Ejemplo: true, false, true...
        }
    }

    // Función para contar verdaderos
    public int contarVerdaderos() {
        int count = 0;
        for (boolean b : array) {
            if (b) {
                count++;
            }
        }
        return count;
    }

    // Función para invertir valores
    public void invertir() {
        for (int i = 0; i < array.length; i++) {
            array[i] = !array[i];
        }
    }

    // Función para verificar si todos son verdaderos
    public boolean todosVerdaderos() {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    // Función para imprimir
    public void imprimir() {
        for (boolean b : array) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arrayBoolean ejemplo = new arrayBoolean();
        ejemplo.inicializar(5);
        ejemplo.imprimir(); // Salida: true false true false true 
        System.out.println("Verdaderos: " + ejemplo.contarVerdaderos()); // Verdaderos: 3
        System.out.println("Todos verdaderos: " + ejemplo.todosVerdaderos()); // Todos verdaderos: false
        ejemplo.invertir();
        ejemplo.imprimir(); // Salida: false true false true false 
    }
}