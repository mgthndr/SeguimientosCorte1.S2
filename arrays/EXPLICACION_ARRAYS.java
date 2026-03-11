/*
 * ============================================================================
 * GUÍA COMPLETA: ARRAYS EN JAVA
 * ============================================================================
 * 
 * Este archivo explica paso a paso cada concepto sobre Arrays.
 * 
 * ============================================================================
 * 1. ¿QUÉ ES UN ARRAY?
 * ============================================================================
 * 
 * Un ARRAY es una estructura de datos que almacena múltiples valores del
 * MISMO TIPO en posiciones consecutivas en memoria.
 * 
 * Características:
 * - Almacena múltiples elementos
 * - Todos los elementos son del mismo tipo
 * - Acceso rápido por índice
 * - Tamaño fijo (se define al crear)
 * - El índice comienza en 0
 * 
 * 
 * ============================================================================
 * 2. DECLARACIÓN DE ARRAYS
 * ============================================================================
 * 
 * OPCIÓN 1: Declarar e inicializar vacío
 * 
 *    int[] numeros = new int[5];
 *    
 *    Explicación:
 *    - int[] = tipo de dato y notación de array
 *    - numeros = nombre de la variable
 *    - new int[5] = crear array de 5 espacios de tipo int
 * 
 * 
 * OPCIÓN 2: Declarar e inicializar con valores
 * 
 *    int[] numeros = {10, 20, 30, 40, 50};
 *    
 *    Explicación:
 *    - El compilador cuenta automáticamente: 5 elementos
 * 
 * 
 * OPCIÓN 3: Solo declarar (sin inicializar)
 * 
 *    int[] numeros;  // No tiene memoria asignada todavía
 *    numeros = new int[5];  // Ahora sí tiene 5 espacios
 * 
 * 
 * ============================================================================
 * 3. TIPOS DE ARRAYS
 * ============================================================================
 * 
 * a) ARRAY DE PRIMITIVOS:
 * 
 *    int[] enteros = {1, 2, 3, 4, 5};
 *    double[] decimales = {1.5, 2.5, 3.5};
 *    boolean[] flags = {true, false, true};
 *    char[] caracteres = {'a', 'b', 'c'};
 * 
 * 
 * b) ARRAY DE STRINGS:
 * 
 *    String[] nombres = {"Juan", "María", "Pedro"};
 * 
 * 
 * c) ARRAY DE OBJETOS:
 * 
 *    // Si tienes una clase Persona
 *    Persona[] personas = new Persona[3];
 *    personas[0] = new Persona("Juan", 25);
 * 
 * 
 * ============================================================================
 * 4. ACCEDER A ELEMENTOS DEL ARRAY
 * ============================================================================
 * 
 * ÍNDICES (posiciones comienzan en 0):
 * 
 *    int[] numeros = {10, 20, 30, 40, 50};
 *    
 *    numeros[0] = 10   (primer elemento)
 *    numeros[1] = 20   (segundo elemento)
 *    numeros[2] = 30   (tercer elemento)
 *    numeros[3] = 40   
 *    numeros[4] = 50   (último elemento)
 *    
 * 
 * GET (obtener valor):
 * 
 *    int valor = numeros[2];  // Obtiene 30
 *    System.out.println(valor);
 * 
 * 
 * SET (cambiar valor):
 * 
 *    numeros[2] = 35;  // Cambia de 30 a 35
 * 
 * 
 * ============================================================================
 * 5. PROPIEDAD LENGTH
 * ============================================================================
 * 
 * Cada array tiene una propiedad LENGTH que devuelve su tamaño.
 * 
 *    int[] numeros = {10, 20, 30, 40, 50};
 *    
 *    System.out.println(numeros.length);  // Imprime: 5
 *    
 * USO EN CICLO:
 * 
 *    for (int i = 0; i < numeros.length; i++) {
 *        System.out.println(numeros[i]);
 *    }
 * 
 * 
 * ============================================================================
 * 6. RECORRER UN ARRAY
 * ============================================================================
 * 
 * a) CICLO FOR TRADICIONAL:
 * 
 *    int[] numeros = {10, 20, 30, 40, 50};
 *    
 *    for (int i = 0; i < numeros.length; i++) {
 *        System.out.println(numeros[i]);
 *    }
 * 
 * 
 * b) CICLO FOR-EACH (mejorado):
 * 
 *    int[] numeros = {10, 20, 30, 40, 50};
 *    
 *    for (int num : numeros) {  // Para cada num en numeros
 *        System.out.println(num);
 *    }
 * 
 *    Ventaja: No necesitas índice, es más simple
 *    Desventaja: No puedes modificar el array durante el ciclo
 * 
 * 
 * c) CICLO WHILE:
 * 
 *    int[] numeros = {10, 20, 30, 40, 50};
 *    int i = 0;
 *    
 *    while (i < numeros.length) {
 *        System.out.println(numeros[i]);
 *        i++;
 *    }
 * 
 * 
 * ============================================================================
 * 7. ARRAYS CON DIFERENTES TIPOS
 * ============================================================================
 * 
 * ARRAY DE BOOLEAN:
 * 
 *    boolean[] flags = {true, false, true, false};
 *    
 *    for (boolean flag : flags) {
 *        System.out.println(flag);
 *    }
 * 
 * 
 * ARRAY DE CHAR:
 * 
 *    char[] caracteres = {'a', 'b', 'c', 'd'};
 *    
 *    for (char car : caracteres) {
 *        System.out.println(car);
 *    }
 * 
 * 
 * ARRAY DE DOUBLE:
 * 
 *    double[] decimales = {1.5, 2.5, 3.5, 4.5};
 *    
 *    for (double num : decimales) {
 *        System.out.println(num);
 *    }
 * 
 * 
 * ARRAY DE STRING:
 * 
 *    String[] nombres = {"Juan", "María", "Pedro"};
 *    
 *    for (String nombre : nombres) {
 *        System.out.println(nombre);
 *    }
 * 
 * 
 * ============================================================================
 * 8. ARRAYS MULTIDIMENSIONALES
 * ============================================================================
 * 
 * Un ARRAY BIDIMENSIONAL (matriz) es un array de arrays.
 * 
 * a) DECLARACIÓN BIDIMENSIONAL:
 * 
 *    int[][] matriz = new int[3][3];  // 3 filas, 3 columnas
 *    
 *    O inicializar con valores:
 *    
 *    int[][] matriz = {
 *        {1, 2, 3},
 *        {4, 5, 6},
 *        {7, 8, 9}
 *    };
 * 
 * 
 * b) ACCEDER A ELEMENTOS:
 * 
 *    matriz[0][0] = 1   (fila 0, columna 0)
 *    matriz[0][1] = 2   (fila 0, columna 1)
 *    matriz[1][0] = 4   (fila 1, columna 0)
 *    
 * 
 * c) RECORRER MATRIZ 2D:
 * 
 *    for (int i = 0; i < matriz.length; i++) {           // Filas
 *        for (int j = 0; j < matriz[i].length; j++) {    // Columnas
 *            System.out.println(matriz[i][j]);
 *        }
 *    }
 * 
 * 
 * d) RECORRER MATRIZ 2D CON FOR-EACH:
 * 
 *    for (int[] fila : matriz) {
 *        for (int valor : fila) {
 *            System.out.println(valor);
 *        }
 *    }
 * 
 * 
 * ============================================================================
 * 9. ARRAYS TRIDIMENSIONALES
 * ============================================================================
 * 
 * int[][][] cubo = new int[2][3][4];  // 2x3x4 = 24 elementos
 * 
 * Acceder:
 * cubo[0][1][2] = 42;
 * 
 * Recorrer:
 * for (int i = 0; i < cubo.length; i++) {
 *     for (int j = 0; j < cubo[i].length; j++) {
 *         for (int k = 0; k < cubo[i][j].length; k++) {
 *             System.out.println(cubo[i][j][k]);
 *         }
 *     }
 * }
 * 
 * 
 * ============================================================================
 * 10. VENTAJAS Y DESVENTAJAS
 * ============================================================================
 * 
 * VENTAJAS:
 * - Acceso rápido por índice (O(1))
 * - Uso eficiente de memoria
 * - Fácil de usar
 * - Buen rendimiento
 * 
 * DESVENTAJAS:
 * - Tamaño fijo (no puedes agregar más elementos)
 * - Si necesitas más espacio, hay que crear otro array
 * - Todas las posiciones ocupan memoria, aunque estén vacías
 * 
 * SOLUCIÓN: Usar ArrayList para tamaño dinámico
 * 
 * 
 * ============================================================================
 * 11. INICIALIZACIÓN POR DEFECTO
 * ============================================================================
 * 
 * Cuando creas un array sin valores, se inicializa por defecto:
 * 
 * int[] numeros = new int[5];
 * // Se inicializa automáticamente: {0, 0, 0, 0, 0}
 * 
 * boolean[] flags = new boolean[3];
 * // Se inicializa automáticamente: {false, false, false}
 * 
 * String[] nombres = new String[2];
 * // Se inicializa automáticamente: {null, null}
 * 
 * 
 * ============================================================================
 * 12. COMPARACIÓN DE ARRAYS
 * ============================================================================
 * 
 * NO USES == para comparar arrays:
 * 
 *    int[] a = {1, 2, 3};
 *    int[] b = {1, 2, 3};
 *    
 *    System.out.println(a == b);  // false (compara referencias, no contenido)
 * 
 * 
 * USA Arrays.equals():
 * 
 *    import java.util.Arrays;
 *    
 *    System.out.println(Arrays.equals(a, b));  // true (compara contenido)
 * 
 * 
 * ============================================================================
 */

public class EXPLICACION_ARRAYS {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("  CONCEPTOS DE ARRAYS EN JAVA");
        System.out.println("====================================================\n");
        
        System.out.println("1. ARRAY: Estructura que almacena múltiples valores");
        System.out.println("2. DECLARACIÓN: tipo[] nombre = new tipo[tamaño]");
        System.out.println("3. ÍNDICE: Comienza en 0");
        System.out.println("4. LENGTH: Propiedad que devuelve el tamaño");
        System.out.println("5. FOR-EACH: Ciclo mejorado para recorrer arrays\n");
        
        System.out.println("6. ARRAYS BIDIMENSIONALES: Arrays de arrays (matrices)");
        System.out.println("7. ARRAYS TRIDIMENSIONALES: Arrays de arrays de arrays");
        System.out.println("8. INICIALIZACIÓN: Por defecto (0, false, null)\n");
        
        System.out.println("Ejemplos en archivo:");
        System.out.println("- arrayEnteros.java: Arrays de int");
        System.out.println("- arrayDouble.java: Arrays de double");
        System.out.println("- arrayBoolean.java: Arrays de boolean");
        System.out.println("- arrayChar.java: Arrays de char");
        System.out.println("- arrayString.java: Arrays de String");
        System.out.println("- arrayMultidimensional.java: Matrices 2D y 3D");
    }
}
