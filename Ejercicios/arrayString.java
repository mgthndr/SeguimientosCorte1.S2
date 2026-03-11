import java.util.Arrays;

public class arrayString{
    private String[] array;

    // Función para inicializar el array
    public void inicializar(String[] valores) {
        array = valores;
    }

    // Función para concatenar todos los elementos
    public String concatenar() {
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }

    // Función para buscar una cadena
    public int buscar(String objetivo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(objetivo)) {
                return i;
            }
        }
        return -1;
    }

    // Función para ordenar alfabéticamente
    public void ordenar() {
        Arrays.sort(array);
    }

    // Función para imprimir
    public void imprimir() {
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arrayString ejemplo = new arrayString();
        ejemplo.inicializar(new String[]{"manzana", "banana", "cereza"});
        ejemplo.imprimir(); // Salida: manzana banana cereza 
        System.out.println("Concatenado: " + ejemplo.concatenar()); // Concatenado: manzana banana cereza
        System.out.println("Posición de 'banana': " + ejemplo.buscar("banana")); // Posición de 'banana': 1
        ejemplo.ordenar();
        ejemplo.imprimir(); // Salida: banana cereza manzana 
    }
}