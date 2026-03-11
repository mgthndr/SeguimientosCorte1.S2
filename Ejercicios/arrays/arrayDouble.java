public class arrayDouble {
    private double[] array;

    // Función para inicializar el array
    public void inicializar(int tamaño) {
        array = new double[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = i * 1.5; // Ejemplo de llenado
        }
    }

    // Función para calcular promedio
    public double calcularPromedio() {
        double suma = 0;
        for (double num : array) {
            suma += num;
        }
        return suma / array.length;
    }

    // Función para encontrar el mínimo
    public double encontrarMinimo() {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Función para redondear valores
    public void redondear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.round(array[i]);
        }
    }

    // Función para imprimir
    public void imprimir() {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arrayDouble ejemplo = new arrayDouble();
        ejemplo.inicializar(4);
        ejemplo.imprimir(); // Salida: 0.0 1.5 3.0 4.5 
        System.out.println("Promedio: " + ejemplo.calcularPromedio()); // Promedio: 2.25
        System.out.println("Mínimo: " + ejemplo.encontrarMinimo()); // Mínimo: 0.0
        ejemplo.redondear();
        ejemplo.imprimir(); // Salida: 0.0 2.0 3.0 5.0 
    }
}