/*
 * ============================================================================
 * GUÍA COMPLETA: INTERFACES EN JAVA
 * ============================================================================
 * 
 * Las INTERFACES son contratos que definen qué métodos debe implementar
 * una clase. Son similares a los TRAITS en Rust.
 * 
 * ============================================================================
 * 1. ¿QUÉ ES UNA INTERFAZ?
 * ============================================================================
 * 
 * Una INTERFAZ define un conjunto de métodos que una clase DEBE implementar.
 * 
 * DEFINICIÓN:
 * 
 *    public interface Animal {
 *        void hablar();
 *        String obtenerNombre();
 *    }
 * 
 * 
 * IMPLEMENTACIÓN:
 * 
 *    public class Perro implements Animal {
 *        private String nombre;
 *        
 *        @Override
 *        public void hablar() {
 *            System.out.println("Guau!");
 *        }
 *        
 *        @Override
 *        public String obtenerNombre() {
 *            return nombre;
 *        }
 *    }
 * 
 * 
 * ============================================================================
 * 2. CARACTERÍSTICAS DE LAS INTERFACES
 * ============================================================================
 * 
 * ANTES DE JAVA 8:
 * - Solo métodos abstractos (sin implementación)
 * - Todas las variables eran constantes (public static final)
 * 
 * JAVA 8+:
 * - Se pueden agregar métodos por defecto (default)
 * - Se pueden agregar métodos estáticos
 * 
 * JAVA 9+:
 * - Se pueden agregar métodos privados
 * 
 * 
 * ============================================================================
 * 3. MÉTODOS EN INTERFACES
 * ============================================================================
 * 
 * MÉTODO ABSTRACTO (sin implementación):
 * 
 *    public interface Animal {
 *        void hablar();  // Abstracto: debe ser implementado
 *    }
 * 
 * 
 * MÉTODO POR DEFECTO (default):
 * 
 *    public interface Animal {
 *        void hablar();
 *        
 *        default void describirse() {
 *            System.out.println("Soy un animal");
 *        }
 *    }
 * 
 * 
 * MÉTODO ESTÁTICO:
 * 
 *    public interface Animal {
 *        static void informacion() {
 *            System.out.println("Información de animales");
 *        }
 *    }
 *    
 *    // Se llama así:
 *    Animal.informacion();
 * 
 * 
 * ============================================================================
 * 4. MÚLTIPLES INTERFACES
 * ============================================================================
 * 
 * Una clase puede implementar VARIAS interfaces:
 * 
 *    public interface Animal {
 *        void hablar();
 *    }
 *    
 *    public interface Corredor {
 *        void correr();
 *    }
 *    
 *    public class Perro implements Animal, Corredor {
 *        @Override
 *        public void hablar() {
 *            System.out.println("Guau!");
 *        }
 *        
 *        @Override
 *        public void correr() {
 *            System.out.println("Corriendo...");
 *        }
 *    }
 * 
 * 
 * ============================================================================
 * 5. INTERFAZ EXTENDS INTERFAZ
 * ============================================================================
 * 
 * Las interfaces pueden heredar de otras interfaces:
 * 
 *    public interface Animal {
 *        void hablar();
 *    }
 *    
 *    public interface MascotaInteligente extends Animal {
 *        void entrenar();
 *        void obedecer();
 *    }
 * 
 * Una clase que implemente MascotaInteligente debe implementar
 * todos los métodos de ambas interfaces.
 * 
 * 
 * ============================================================================
 * 6. VARIABLES EN INTERFACES
 * ============================================================================
 * 
 * Las variables en interfaces son siempre: public static final
 * 
 *    public interface Configuracion {
 *        int VELOCIDAD_MAXIMA = 200;
 *        String VERSION = "1.0";
 *    }
 *    
 *    // Acceder:
 *    int vel = Configuracion.VELOCIDAD_MAXIMA;
 * 
 * 
 * ============================================================================
 * 7. INTERFACES COMO TIPOS
 * ============================================================================
 * 
 * Puedes usar una interfaz como tipo:
 * 
 *    Animal animal = new Perro();  // Referencia de tipo Animal
 *    Animal animal = new Gato();   // Polimorfismo
 * 
 *    // En colecciones:
 *    List<Animal> animales = new ArrayList<>();
 *    animales.add(new Perro());
 *    animales.add(new Gato());
 *    
 *    for (Animal a : animales) {
 *        a.hablar();  // Polimorfismo
 *    }
 * 
 * 
 * ============================================================================
 * 8. DIFERENCIA CON CLASES ABSTRACTAS
 * ============================================================================
 * 
 *                 INTERFAZ              CLASE ABSTRACTA
 * ─────────────────────────────────────────────────────────────
 * Variables       Solo constantes       Pueden variar (private, public)
 * Métodos         Solo abstract/default Pueden tener cuerpo
 * Constructor     No tiene              Sí tiene
 * Herencia        implements            extends
 * Múltiples       Sí (varias)          No (solo una)
 * Propósito       Contrato              Base común
 * 
 * 
 * ============================================================================
 * 9. CUÁNDO USAR INTERFACES
 * ============================================================================
 * 
 * USA INTERFACES CUANDO:
 * - Necesitas definir un contrato que múltiples clases deben cumplir
 * - Quieres permitir múltiples "tipos" en una clase
 * - Necesitas polimorfismo sin relación de herencia
 * - Defines capacidades que pueden tener objetos diferentes
 * 
 * EJEMPLOS:
 * - Comparable: Objetos que se pueden comparar
 * - Serializable: Objetos que se pueden serializar
 * - Iterable: Objetos que se pueden iterar
 * - Cloneable: Objetos que se pueden clonar
 * 
 * 
 * ============================================================================
 * 10. VENTAJAS
 * ============================================================================
 * 
 * ✓ Contrato claro: Define qué debe hacer
 * ✓ Polimorfismo: Múltiples implementaciones
 * ✓ Flexibilidad: Cambiar implementación sin afectar código
 * ✓ Múltiples interfaces: Mayor flexibilidad que herencia
 * ✓ Testing: Fácil crear mocks para pruebas
 * 
 * 
 * ============================================================================
 */

public class EXPLICACION_INTERFACES {
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  INTERFACES EN JAVA");
        System.out.println("======================================================\n");
        
        System.out.println("DEFINICIÓN:");
        System.out.println("  - Contrato que define métodos que deben implementarse");
        System.out.println("  - 'public interface NombreInterfaz { ... }'\n");
        
        System.out.println("IMPLEMENTACIÓN:");
        System.out.println("  - 'public class Clase implements Interfaz { ... }'");
        System.out.println("  - @Override para cada método requerido\n");
        
        System.out.println("CARACTERÍSTICAS:");
        System.out.println("  - Una clase implementa VARIAS interfaces");
        System.out.println("  - Métodos abstract (sin cuerpo)");
        System.out.println("  - Métodos default (con cuerpo, desde Java 8)");
        System.out.println("  - Métodos static (desde Java 8)\n");
        
        System.out.println("VENTAJAS:");
        System.out.println("  - Polimorfismo");
        System.out.println("  - Contrato claro");
        System.out.println("  - Múltiples implementaciones\n");
        
        System.out.println("Ver ejemplos:");
        System.out.println("  - Ejemplo1.java: Interfaces básicas");
        System.out.println("  - Ejemplo2.java: Múltiples interfaces");
        System.out.println("  - Ejemplo3.java: Polimorfismo con interfaces");
    }
}
