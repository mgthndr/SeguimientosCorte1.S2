/*
 * ============================================================================
 * GUÍA COMPLETA: HERENCIA, VISIBILIDAD, GETTERS, SETTERS, CONSTRUCTORES
 * ============================================================================
 * 
 * Este archivo explica paso a paso cada concepto utilizado en los ejemplos
 * de la carpeta herencia/
 * 
 * ============================================================================
 * 1. CONSTRUCTORES
 * ============================================================================
 * 
 * Un CONSTRUCTOR es un método especial que se ejecuta cuando se crea un objeto.
 * 
 * Características:
 * - Tiene el mismo nombre que la clase
 * - No tiene tipo de retorno (ni void)
 * - Se invoca automaticamente con la palabra "new"
 * - Se usa para inicializar atributos
 * 
 * Ejemplo:
 * 
 *    public class Animal {
 *        private String nombre;
 *        
 *        public Animal(String nombre) {  // <-- CONSTRUCTOR
 *            this.nombre = nombre;        // this = referencia al objeto actual
 *        }
 *    }
 *    
 *    // Al crear un objeto, se ejecuta el constructor:
 *    Animal perro = new Animal("Rex");  // Llama al constructor con "Rex"
 * 
 * 
 * ============================================================================
 * 2. VISIBILIDAD (Modificadores de Acceso)
 * ============================================================================
 * 
 * Controlamos quién puede acceder a los atributos y métodos usando:
 * 
 * a) PRIVATE (privado)
 *    - Solo se accede desde dentro de la misma clase
 *    - Oculta datos internos (encapsulación)
 *    
 *    Ejemplo:
 *    private String nombre;  // Nadie de afuera puede ver esto
 * 
 * 
 * b) PROTECTED (protegido)
 *    - Se accede desde clases que heredan (subclases)
 *    - Se accede desde la misma clase
 *    - También desde el mismo paquete
 *    
 *    Ejemplo:
 *    protected int edad;  // Las subclases pueden acceder directamente
 * 
 * 
 * c) PUBLIC (público)
 *    - Accesible desde cualquier lugar
 *    - Usado para métodos principales
 *    
 *    Ejemplo:
 *    public void mostrar() {}  // Cualquiera puede llamar esto
 * 
 * 
 * d) Sin modificador (package-private)
 *    - Accesible solo desde el mismo paquete
 * 
 * 
 * REGLA DE ENCAPSULACIÓN:
 * Atributos = PRIVATE
 * Acceso = A través de GETTERS y SETTERS
 * 
 * 
 * ============================================================================
 * 3. GETTERS (Métodos para OBTENER valores)
 * ============================================================================
 * 
 * Un GETTER es un método que devuelve el valor de un atributo privado.
 * 
 * Características:
 * - Empieza con "get" seguido del nombre del atributo
 * - Retorna el tipo del atributo
 * - No recibe parámetros
 * - Es PUBLIC
 * 
 * Ejemplo:
 * 
 *    private String nombre;
 *    
 *    public String getNombre() {           // <-- GETTER
 *        return nombre;
 *    }
 *    
 *    // Uso:
 *    String n = perro.getNombre();  // Obtiene el nombre del perro
 * 
 * 
 * ============================================================================
 * 4. SETTERS (Métodos para ESTABLECER valores)
 * ============================================================================
 * 
 * Un SETTER es un método que modifica el valor de un atributo privado.
 * 
 * Características:
 * - Empieza con "set" seguido del nombre del atributo
 * - Recibe como parámetro el valor nuevo
 * - No retorna nada (void)
 * - Es PUBLIC
 * 
 * Ejemplo:
 * 
 *    private String nombre;
 *    
 *    public void setNombre(String nombre) {  // <-- SETTER
 *        this.nombre = nombre;
 *    }
 *    
 *    // Uso:
 *    perro.setNombre("Fido");  // Cambia el nombre del perro
 * 
 * 
 * ============================================================================
 * 5. HERENCIA
 * ============================================================================
 * 
 * La HERENCIA permite que una clase (subclase/hija) herede atributos y 
 * métodos de otra clase (superclase/padre).
 * 
 * Palabra clave: "extends"
 * Objetivo: Reutilizar código y establecer relaciones "es un/a"
 * 
 * Ejemplo:
 * 
 *    public class Animal {              // CLASE PADRE (superclase)
 *        private String nombre;
 *        protected int edad;
 *        
 *        public Animal(String nombre, int edad) {
 *            this.nombre = nombre;
 *            this.edad = edad;
 *        }
 *    }
 *    
 *    public class Perro extends Animal {  // CLASE HIJA (subclase)
 *        private String raza;
 *        
 *        public Perro(String nombre, int edad, String raza) {
 *            super(nombre, edad);  // Llama al constructor del PADRE
 *            this.raza = raza;
 *        }
 *    }
 *    
 *    // Perro HEREDA de Animal:
 *    // - Hereda el atributo "nombre"
 *    // - Hereda el atributo "edad"
 *    // - Puede agregar sus propios atributos como "raza"
 * 
 * VENTAJAS:
 * - Reutiliza código del padre
 * - Las subclases acceden a atributos "protected"
 * - Se puede crear una jerarquía de clases
 * 
 * 
 * ============================================================================
 * 6. SUPER (referencia a la clase padre)
 * ============================================================================
 * 
 * La palabra "super" se usa para:
 * 
 * a) Llamar al constructor del padre:
 *    super(parámetros);
 *    
 *    Ejemplo:
 *    public Perro(String nombre, int edad, String raza) {
 *        super(nombre, edad);  // Inicializa los datos del PADRE
 *        this.raza = raza;
 *    }
 * 
 * 
 * b) Acceder a métodos del padre:
 *    super.metodo();
 *    
 *    Ejemplo:
 *    super.mostrar();  // Llama al método mostrar() del padre
 * 
 * 
 * ============================================================================
 * 7. THIS (referencia al objeto actual)
 * ============================================================================
 * 
 * "this" se refiere al objeto actual en el que se está ejecutando el código.
 * 
 * a) Diferenciar parámetro de atributo:
 *    this.nombre = nombre;  // this.nombre es el atributo, nombre es el parámetro
 * 
 * b) Acceder a métodos del mismo objeto:
 *    this.mostrar();
 * 
 * 
 * ============================================================================
 * 8. HERENCIA MULTINIVEL
 * ============================================================================
 * 
 * Se puede heredar de una clase que ya hereda de otra.
 * 
 * Ejemplo:
 *    Persona (clase padre)
 *      ↓ hereda
 *    Estudiante extends Persona
 *      ↓ hereda
 *    EstudianteAvanzado extends Estudiante
 * 
 * EstudianteAvanzado tiene:
 * - Métodos y atributos de Persona
 * - Métodos y atributos de Estudiante
 * - Sus propios métodos y atributos
 * 
 * 
 * ============================================================================
 * 9. MÉTODO MAIN
 * ============================================================================
 * 
 * El método main es el PUNTO DE ENTRADA de la aplicación.
 * 
 * Importante:
 * - Debe ser public static void
 * - Recibe String[] args (argumentos de línea de comandos)
 * - Se ejecuta automáticamente cuando se corre la clase
 * 
 * Sintaxis:
 * 
 *    public static void main(String[] args) {
 *        // Aquí se escribe el código que se ejecuta
 *    }
 * 
 * En nuestros ejemplos, main:
 * - Crea objetos (instancias)
 * - Utiliza constructores
 * - Llama a getters y setters
 * - Muestra resultados en consola
 * 
 * 
 * ============================================================================
 * 10. ENCAPSULACIÓN (Principio importante)
 * ============================================================================
 * 
 * Es una buena práctica proteger los datos:
 * 
 * MALO:
 * public int edad;  // Cualquiera puede cambiar esto sin control
 * 
 * BIEN:
 * private int edad;
 * public int getEdad() { return edad; }
 * public void setEdad(int edad) { 
 *     if (edad > 0) this.edad = edad;  // Validación
 * }
 * 
 * Beneficios:
 * - Control sobre cómo se modifican los datos
 * - Validación de valores
 * - Flexibilidad para cambiar la implementación interna
 * 
 * 
 * ============================================================================
 * RESUMEN VISUAL DE UN EJEMPLO COMPLETO
 * ============================================================================
 * 
 * public class Perro extends Animal {  // HERENCIA
 *     private String raza;             // ATRIBUTO PRIVADO
 * 
 *     public Perro(String nombre, int edad, String raza) {  // CONSTRUCTOR
 *         super(nombre, edad);         // Llama constructor del PADRE
 *         this.raza = raza;            // Inicializa atributo propio
 *     }
 * 
 *     public String getRaza() {        // GETTER
 *         return raza;
 *     }
 * 
 *     public void setRaza(String raza) {  // SETTER
 *         this.raza = raza;
 *     }
 * 
 *     public static void main(String[] args) {  // MÉTODO MAIN
 *         Perro p = new Perro("Rex", 5, "Labrador");  // CONSTRUYE OBJETO
 *         System.out.println(p.getRaza());            // OBTIENE CON GETTER
 *         p.setRaza("Pastor");                        // MODIFICA CON SETTER
 *     }
 * }
 * 
 * ============================================================================
 */

public class EXPLICACION {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("  CONCEPTOS DE HERENCIA EN JAVA");
        System.out.println("====================================================\n");
        
        System.out.println("1. CONSTRUCTOR: Inicializa objetos automáticamente");
        System.out.println("2. VISIBILIDAD: private, protected, public");
        System.out.println("3. GETTER: Obtiene valores de atributos privados");
        System.out.println("4. SETTER: Modifica valores de atributos privados");
        System.out.println("5. HERENCIA: Reutiliza código de clases padre");
        System.out.println("6. SUPER: Referencia a la clase padre");
        System.out.println("7. THIS: Referencia al objeto actual");
        System.out.println("8. ENCAPSULACIÓN: Protege datos internos\n");
        
        System.out.println("Revisa los ejemplos Ejemplo1.java, Ejemplo2.java");
        System.out.println("y Ejemplo3.java para ver estos conceptos en práctica.\n");
        
        System.out.println("Lee los comentarios en este archivo para más detalles.");
    }
}
