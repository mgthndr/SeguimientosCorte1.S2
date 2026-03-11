public class arrayChar {
    private char[] array;

    // Función para inicializar el array
    public void inicializar(String texto) {
        array = texto.toCharArray();
    }

    // Función para convertir a mayúsculas
    public void aMayusculas() {
        for (int i = 0; i < array.length; i++) {
            array[i] = Character.toUpperCase(array[i]);
        }
    }

    // Función para contar vocales
    public int contarVocales() {
        int count = 0;
        for (char c : array) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Función para revertir el array
    public void revertir() {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    // Función para imprimir
    public void imprimir() {
        System.out.println(new String(array));
    }

    public static void main(String[] args) {
        arrayChar ejemplo = new arrayChar();
        ejemplo.inicializar("hola mundo");
        ejemplo.imprimir(); // Salida: hola mundo
        System.out.println("Vocales: " + ejemplo.contarVocales()); // Vocales: 4
        ejemplo.aMayusculas();
        ejemplo.imprimir(); // Salida: HOLA MUNDO
        ejemplo.revertir();
        ejemplo.imprimir(); // Salida: ODNUM ALOH
    }
}