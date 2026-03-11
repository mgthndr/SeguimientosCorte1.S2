/*
 * EJEMPLO 1: INTERFACES BÁSICAS
 * 
 * Demuestra cómo definir e implementar interfaces simples.
 */

public class Ejemplo1 {
    
    // ============================================================
    // DEFINIR INTERFAZ
    // ============================================================
    public interface Animal {
        void hablar();
        String obtenerNombre();
    }
    
    // ============================================================
    // IMPLEMENTAR INTERFAZ
    // ============================================================
    public static class Perro implements Animal {
        private String nombre;
        private int edad;
        
        public Perro(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
        
        @Override
        public void hablar() {
            System.out.println("🐕 " + nombre + " dice: ¡Guau!");
        }
        
        @Override
        public String obtenerNombre() {
            return nombre;
        }
        
        public int obtenerEdad() {
            return edad;
        }
    }
    
    public static class Gato implements Animal {
        private String nombre;
        
        public Gato(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public void hablar() {
            System.out.println("🐱 " + nombre + " dice: ¡Miau!");
        }
        
        @Override
        public String obtenerNombre() {
            return nombre;
        }
    }
    
    public static class Pajaro implements Animal {
        private String nombre;
        private String especie;
        
        public Pajaro(String nombre, String especie) {
            this.nombre = nombre;
            this.especie = especie;
        }
        
        @Override
        public void hablar() {
            System.out.println("🐦 " + nombre + " (" + especie + ") dice: ¡Pío!");
        }
        
        @Override
        public String obtenerNombre() {
            return nombre;
        }
    }
    
    // ============================================================
    // INTERFAZ CON MÉTODOS POR DEFECTO (Java 8+)
    // ============================================================
    public interface Mascota {
        void jugar();
        
        // Método por defecto (tiene implementación)
        default void acariciar() {
            System.out.println("  Acariciando mascota... 😊");
        }
        
        // Método estático
        static void informacion() {
            System.out.println("Las mascotas son animales domesticados");
        }
    }
    
    public static class GatoMascota implements Mascota {
        private String nombre;
        
        public GatoMascota(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public void jugar() {
            System.out.println("🧶 " + nombre + " está jugando con un ovillo");
        }
    }
    
    public static class PerroMascota implements Mascota {
        private String nombre;
        
        public PerroMascota(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public void jugar() {
            System.out.println("🎾 " + nombre + " está jugando a traer la pelota");
        }
        
        // Sobrescribir el método por defecto
        @Override
        public void acariciar() {
            System.out.println("  " + nombre + " mete la cola feliz 🐕");
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 1: INTERFACES BÁSICAS ===\n");
        
        // ============================================================
        // IMPLEMENTAR INTERFAZ Animal
        // ============================================================
        System.out.println("--- Interfaz Animal ---\n");
        
        Perro perro = new Perro("Rex", 5);
        Gato gato = new Gato("Whiskers");
        Pajaro pajaro = new Pajaro("Tweety", "Canario");
        
        perro.hablar();
        gato.hablar();
        pajaro.hablar();
        System.out.println();
        
        // ============================================================
        // POLIMORFISMO CON INTERFAZ
        // ============================================================
        System.out.println("--- Polimorfismo (Animal) ---\n");
        
        // Referencia de tipo interfaz (polimorfismo)
        Animal[] animales = {perro, gato, pajaro};
        
        System.out.println("Todos hacen sonido:");
        for (Animal a : animales) {
            System.out.println("  - " + a.obtenerNombre() + ": ", null);
            a.hablar();
        }
        System.out.println();
        
        // ============================================================
        // INTERFAZ CON MÉTODOS POR DEFECTO
        // ============================================================
        System.out.println("--- Interfaz Mascota (métodos por defecto) ---\n");
        
        PerroMascota perroMascota = new PerroMascota("Max");
        GatoMascota gatoMascota = new GatoMascota("Michi");
        
        perroMascota.jugar();
        perroMascota.acariciar();
        System.out.println();
        
        gatoMascota.jugar();
        gatoMascota.acariciar();
        System.out.println();
        
        // ============================================================
        // MÉTODO ESTÁTICO DE LA INTERFAZ
        // ============================================================
        System.out.println("--- Método Estático ---\n");
        Mascota.informacion();
        System.out.println();
        
        // ============================================================
        // LISTA DE MASCOTAS
        // ============================================================
        System.out.println("--- Lista de Mascotas ---\n");
        
        java.util.ArrayList<Mascota> mascotas = new java.util.ArrayList<>();
        mascotas.add(perroMascota);
        mascotas.add(gatoMascota);
        
        for (Mascota m : mascotas) {
            m.jugar();
            m.acariciar();
            System.out.println();
        }
    }
}
