/*
 * ============================================================================
 * GUÍA COMPLETA: ENCAPSULAMIENTO, CONSTRUCTORES Y MUTACIONES EN JAVA
 * ============================================================================
 * 
 * Este archivo explica los conceptos fundamentales de OOP en Java.
 * 
 * ============================================================================
 * 1. ENCAPSULAMIENTO
 * ============================================================================
 * 
 * El ENCAPSULAMIENTO es un principio de OOP que consiste en:
 * - Ocultar los detalles internos de una clase (datos privados)
 * - Proporcionar métodos públicos para acceder a esos datos (getters/setters)
 * - Proteger la integridad de los datos
 * 
 * OBJETIVO:
 * - Control: Validar cambios antes de aplicarlos
 * - Flexibilidad: Cambiar la implementación interna sin afectar el código externo
 * - Seguridad: Evitar cambios inapropiados
 * 
 * EJEMPLO SIN ENCAPSULAMIENTO (malo):
 * 
 *    public class Persona {
 *        public int edad;  // Público: cualquiera puede cambiar
 *    }
 *    
 *    Persona p = new Persona();
 *    p.edad = -5;  // ERROR lógico, pero permitido
 * 
 * 
 * EJEMPLO CON ENCAPSULAMIENTO (bien):
 * 
 *    public class Persona {
 *        private int edad;  // Privado: protegido
 *        
 *        public void setEdad(int edad) {
 *            if (edad > 0 && edad < 150) {
 *                this.edad = edad;
 *            }
 *        }
 *        
 *        public int getEdad() {
 *            return edad;
 *        }
 *    }
 * 
 * 
 * ============================================================================
 * 2. CONSTRUCTORES
 * ============================================================================
 * 
 * Un CONSTRUCTOR es un método especial que se ejecuta automáticamente
 * cuando se crea un objeto (instancia).
 * 
 * CARACTERÍSTICAS:
 * - Mismo nombre que la clase
 * - Sin tipo de retorno
 * - Se invoca con "new"
 * - Puede estar sobrecargado (múltiples versiones)
 * 
 * CONSTRUCTOR POR DEFECTO:
 * 
 *    public class Persona {
 *        public Persona() {  // Constructor sin parámetros
 *            System.out.println("Objeto creado");
 *        }
 *    }
 * 
 * 
 * CONSTRUCTOR CON PARÁMETROS:
 * 
 *    public class Persona {
 *        private String nombre;
 *        private int edad;
 *        
 *        public Persona(String nombre, int edad) {
 *            this.nombre = nombre;
 *            this.edad = edad;
 *        }
 *    }
 *    
 *    Persona p = new Persona("Juan", 25);
 * 
 * 
 * SOBRECARGA DE CONSTRUCTORES:
 * 
 *    public class Persona {
 *        private String nombre;
 *        private int edad;
 *        
 *        // Constructor 1: Sin parámetros
 *        public Persona() {
 *            this("Desconocido", 0);
 *        }
 *        
 *        // Constructor 2: Solo nombre
 *        public Persona(String nombre) {
 *            this(nombre, 0);
 *        }
 *        
 *        // Constructor 3: Con ambos parámetros
 *        public Persona(String nombre, int edad) {
 *            this.nombre = nombre;
 *            this.edad = edad;
 *        }
 *    }
 * 
 * 
 * PALABRA CLAVE THIS:
 * - this.atributo = diferencia el atributo del parámetro
 * - this(...) = llama otro constructor
 * 
 * 
 * ============================================================================
 * 3. MUTACIÓN
 * ============================================================================
 * 
 * La MUTACIÓN es el cambio de estado de un objeto (cambio de valores).
 * 
 * EN JAVA:
 * - Los objetos son mutables por defecto
 * - Se pueden cambiar sus atributos después de crear
 * - Los datos primitivos dentro de un objeto también son mutables
 * 
 * MUTACIÓN DIRECTA (sin getters/setters):
 * 
 *    public class Banco {
 *        public double saldo;  // Público (malo)
 *    }
 *    
 *    Banco b = new Banco();
 *    b.saldo = 1000;
 *    b.saldo = -500;  // Error lógico permitido
 * 
 * 
 * MUTACIÓN CONTROLADA (con setters):
 * 
 *    public class Banco {
 *        private double saldo;
 *        
 *        public void setSaldo(double saldo) {
 *            if (saldo >= 0) {
 *                this.saldo = saldo;
 *            }
 *        }
 *    }
 * 
 * 
 * MUTACIÓN DE STRINGS (objetos):
 * 
 *    String s1 = "Hola";
 *    String s2 = s1;
 *    s1 = "Adiós";  // Crea un nuevo objeto
 *    // s2 sigue siendo "Hola" (strings son inmutables)
 * 
 *    StringBuilder sb = new StringBuilder("Hola");
 *    sb.append(" Mundo");  // Muta el objeto (mutable)
 * 
 * 
 * ============================================================================
 * 4. RELACIÓN ENTRE CONCEPTOS
 * ============================================================================
 * 
 * CONSTRUCTORES inicializan el estado inicial del objeto
 * ENCAPSULAMIENTO protege ese estado
 * MUTACIÓN (setters) cambia el estado de manera controlada
 * 
 * EJEMPLO INTEGRADO:
 * 
 *    public class Cuenta {
 *        private String titular;
 *        private double saldo;
 *        
 *        // CONSTRUCTOR: inicializa estado
 *        public Cuenta(String titular, double saldoInicial) {
 *            this.titular = titular;
 *            this.saldo = saldoInicial;
 *        }
 *        
 *        // GETTERS: acceso de lectura (encapsulamiento)
 *        public String getTitular() {
 *            return titular;
 *        }
 *        
 *        public double getSaldo() {
 *            return saldo;
 *        }
 *        
 *        // SETTERS: mutación controlada (encapsulamiento)
 *        public void depositar(double cantidad) {
 *            if (cantidad > 0) {
 *                this.saldo += cantidad;
 *            }
 *        }
 *        
 *        public boolean retirar(double cantidad) {
 *            if (cantidad > 0 && cantidad <= this.saldo) {
 *                this.saldo -= cantidad;
 *                return true;
 *            }
 *            return false;
 *        }
 *    }
 * 
 * 
 * ============================================================================
 * 5. BUENAS PRÁCTICAS
 * ============================================================================
 * 
 * 1. ATRIBUTOS PRIVADOS:
 *    private int edad;
 *    private String nombre;
 * 
 * 2. GETTERS Y SETTERS PÚBLICOS:
 *    public int getEdad() { return edad; }
 *    public void setEdad(int edad) { this.edad = edad; }
 * 
 * 3. VALIDACIÓN EN SETTERS:
 *    public void setEdad(int edad) {
 *        if (edad > 0 && edad < 150) {
 *            this.edad = edad;
 *        }
 *    }
 * 
 * 4. CONSTRUCTORES ÚTILES:
 *    - Constructor sin parámetros (por defecto)
 *    - Constructor con parámetros principales
 *    - Constructor con todos los parámetros (copy)
 * 
 * 5. MÉTODOS TOSTRING:
 *    @Override
 *    public String toString() {
 *        return nombre + " (" + edad + ")";
 *    }
 * 
 *    System.out.println(objeto);  // Automáticamente llama toString()
 * 
 * 
 * ============================================================================
 * 6. ARRAYS Y COLECCIONES MUTABLES
 * ============================================================================
 * 
 * Arrays en Java son mutables:
 * 
 *    int[] numeros = {1, 2, 3};
 *    numeros[0] = 10;  // Cambiar valor
 * 
 * 
 * ArrayList es mutable:
 * 
 *    ArrayList<Integer> lista = new ArrayList<>();
 *    lista.add(1);      // Agregar
 *    lista.remove(0);   // Remover
 *    lista.set(0, 10);  // Cambiar
 * 
 * 
 * ============================================================================
 */

public class EXPLICACION_ENCAPSULAMIENTO {
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  ENCAPSULAMIENTO, CONSTRUCTORES Y MUTACIONES");
        System.out.println("======================================================\n");
        
        System.out.println("ENCAPSULAMIENTO:");
        System.out.println("  - Atributos privados");
        System.out.println("  - Métodos getters y setters");
        System.out.println("  - Validación de datos");
        System.out.println("  - Control de acceso\n");
        
        System.out.println("CONSTRUCTORES:");
        System.out.println("  - Inicialización de objetos");
        System.out.println("  - Nombre igual a la clase");
        System.out.println("  - Sin tipo de retorno");
        System.out.println("  - Pueden estar sobrecargados\n");
        
        System.out.println("MUTACIÓN:");
        System.out.println("  - Cambio de estado del objeto");
        System.out.println("  - Objetos son mutables por defecto");
        System.out.println("  - Strings son inmutables");
        System.out.println("  - Setters controlan la mutación\n");
        
        System.out.println("Ver ejemplos:");
        System.out.println("  - Ejemplo1.java: Encapsulamiento básico");
        System.out.println("  - Ejemplo2.java: Constructores sobrecargados");
        System.out.println("  - Ejemplo3.java: Mutación controlada");
    }
}
