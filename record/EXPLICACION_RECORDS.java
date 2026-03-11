/*
 * ============================================================================
 * GUÍA COMPLETA: RECORDS EN JAVA
 * ============================================================================
 * 
 * Este archivo explica qué son los RECORDS y cómo se utilizan.
 * 
 * ============================================================================
 * 1. ¿QUÉ ES UN RECORD?
 * ============================================================================
 * 
 * Un RECORD es una clase especial (a partir de Java 14) diseñada para
 * almacenar datos SIN mucha lógica adicional.
 * 
 * Características principales:
 * - Genera automáticamente getters
 * - Genera automáticamente constructor
 * - Genera automáticamente equals() y hashCode()
 * - Genera automáticamente toString()
 * - Es INMUTABLE (no se puede modificar después de crear)
 * 
 * 
 * ============================================================================
 * 2. RECORD vs CLASE NORMAL
 * ============================================================================
 * 
 * CLASE NORMAL:
 * 
 *    public class Punto2D {
 *        private int x;
 *        private int y;
 *        
 *        public Punto2D(int x, int y) {
 *            this.x = x;
 *            this.y = y;
 *        }
 *        
 *        public int getX() { return x; }
 *        public int getY() { return y; }
 *        
 *        @Override
 *        public String toString() {
 *            return "Punto2D(" + x + ", " + y + ")";
 *        }
 *    }
 * 
 * RECORD (Más simple):
 * 
 *    public record Punto2D(int x, int y) {}
 * 
 * ¡El Record genera automáticamente todo!
 * 
 * 
 * ============================================================================
 * 3. SYNTAX DE RECORD
 * ============================================================================
 * 
 * public record NombreRecord(tipo1 campo1, tipo2 campo2, ...) {}
 * 
 * Componentes:
 * - "record": palabra clave
 * - "NombreRecord": nombre de la clase
 * - "(tipo1 campo1, tipo2 campo2, ...)": componentes (se convierten en atributos)
 * - "{}": cuerpo (vacío o con métodos personalizados)
 * 
 * Ejemplo:
 * 
 *    public record Producto(String nombre, double precio, int cantidad) {}
 * 
 * Genera automáticamente:
 * - Constructor: new Producto(nombre, precio, cantidad)
 * - Getters:    producto.nombre(), producto.precio(), producto.cantidad()
 * - toString()
 * - equals() y hashCode()
 * 
 * 
 * ============================================================================
 * 4. USO DE RECORDS
 * ============================================================================
 * 
 * a) CREAR UN RECORD:
 * 
 *    public record Persona(String nombre, int edad) {}
 * 
 * 
 * b) CREAR INSTANCIAS:
 * 
 *    Persona p = new Persona("Juan", 25);
 * 
 * 
 * c) ACCEDER A LOS DATOS:
 * 
 *    String n = p.nombre();  // nombre() es el getter automático
 *    int e = p.edad();       // edad() es el getter automático
 * 
 * 
 * d) USAR toString():
 * 
 *    System.out.println(p);  // Persona[nombre=Juan, edad=25]
 * 
 * 
 * ============================================================================
 * 5. VENTAJAS DE LOS RECORDS
 * ============================================================================
 * 
 * 1. Código MÁS LIMPIO: Una línea en lugar de muchas líneas
 * 2. Menos ERRORES: El compilador genera automáticamente
 * 3. INMUTABILIDAD: Los datos no cambian después de crear
 * 4. toString() AUTOMÁTICO: Muestra datos de manera legible
 * 5. equals() y hashCode(): Funcionan correctamente automáticamente
 * 
 * 
 * ============================================================================
 * 6. LIMITACIONES
 * ============================================================================
 * 
 * - NO pueden usar HERENCIA (no pueden extends otra clase)
 * - Los atributos son FINALES (no se pueden modificar)
 * - No pueden ser abstractos
 * - Cada componente genera automáticamente un getter
 * 
 * 
 * ============================================================================
 * 7. RECORDS EN EL PROYECTO
 * ============================================================================
 * 
 * En la carpeta record/ encontrarás:
 * 
 * - Punto2D.java: Record para representar un punto (x, y)
 * - Producto.java: Record para representar un producto
 * - ResultadoOperacion.java: Record para resultado de operaciones
 * 
 * Ejemplos de uso:
 * 
 *    Punto2D p = new Punto2D(3, 4);
 *    System.out.println(p);  // Punto2D[x=3, y=4]
 * 
 *    Producto prod = new Producto("Laptop", 999.99, 5);
 *    System.out.println(prod.nombre());  // Laptop
 * 
 *    ResultadoOperacion res = new ResultadoOperacion("éxito", 42);
 *    System.out.println(res);  // ResultadoOperacion[estado=éxito, valor=42]
 * 
 * 
 * ============================================================================
 * 8. CUÁNDO USAR RECORDS
 * ============================================================================
 * 
 * USO RECORDS CUANDO:
 * - Solo necesitas almacenar datos
 * - Los datos no cambian (inmutabilidad)
 * - Necesitas toString(), equals() y hashCode() automáticamente
 * - Quieres código limpio y legible
 * 
 * Ejemplos: Punto, Persona, Producto, Resultado, Configuración, etc.
 * 
 * 
 * NO USES RECORDS CUANDO:
 * - Necesitas lógica compleja con métodos
 * - Necesitas herencia
 * - Necesitas que los atributos sean modificables
 * 
 * 
 * ============================================================================
 * 9. EJEMPLO COMPARATIVO
 * ============================================================================
 * 
 * CLASE TRADICIONAL (muchas líneas):
 * 
 *    public class Resultado {
 *        private boolean exito;
 *        private String mensaje;
 *        
 *        public Resultado(boolean exito, String mensaje) {
 *            this.exito = exito;
 *            this.mensaje = mensaje;
 *        }
 *        
 *        public boolean isExito() { return exito; }
 *        public String getMensaje() { return mensaje; }
 *        
 *        @Override
 *        public String toString() {
 *            return "Resultado{" + "exito=" + exito + ", mensaje='" + mensaje + '\'' + '}';
 *        }
 *        
 *        @Override
 *        public equals(Object o) { ... }
 *        
 *        @Override
 *        public int hashCode() { ... }
 *    }
 * 
 * 
 * RECORD (una línea):
 * 
 *    public record Resultado(boolean exito, String mensaje) {}
 * 
 * ¡Eso es todo! El Record genera automáticamente todo lo anterior.
 * 
 * 
 * ============================================================================
 * 10. MÉTODO EQUALS EN RECORDS
 * ============================================================================
 * 
 * Los records generan equals() automáticamente:
 * 
 *    Persona p1 = new Persona("Juan", 25);
 *    Persona p2 = new Persona("Juan", 25);
 *    
 *    System.out.println(p1.equals(p2));  // true (compara todos los campos)
 *    System.out.println(p1 == p2);       // false (son objetos diferentes)
 * 
 * 
 * ============================================================================
 */

public class EXPLICACION_RECORDS {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("  CONCEPTOS DE RECORDS EN JAVA");
        System.out.println("====================================================\n");
        
        System.out.println("1. RECORD: Clase para almacenar datos");
        System.out.println("2. COMPONENTES: Atributos que se generan automáticamente");
        System.out.println("3. GETTERS: Se generan como método1(), método2()");
        System.out.println("4. INMUTABILIDAD: Los datos no cambian después de crear");
        System.out.println("5. toString(): Se genera automáticamente\n");
        
        System.out.println("6. equals() y hashCode(): Se generan automáticamente");
        System.out.println("7. CONSTRUCTOR: Se genera automáticamente\n");
        
        System.out.println("Revisa los archivos en la carpeta record/");
        System.out.println("para ver ejemplos de uso de Records.\n");
        
        System.out.println("Ejemplo rápido:");
        System.out.println("  public record Persona(String nombre, int edad) {}");
        System.out.println("  Persona p = new Persona(\"Juan\", 25);");
        System.out.println("  p.nombre();  // \"Juan\"");
        System.out.println("  p.edad();    // 25");
    }
}
