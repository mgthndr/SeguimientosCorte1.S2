/*
 * EJEMPLO 2: MÚLTIPLES INTERFACES
 * 
 * Demuestra cómo una clase puede implementar varias interfaces.
 */

import java.util.ArrayList;
import java.util.List;

public class Ejemplo2 {
    
    // ============================================================
    // INTERFACES
    // ============================================================
    
    public interface Deportista {
        void entrenar();
        String obtenerDeporte();
    }
    
    public interface Corredor {
        void correr();
        double obtenerVelocidad();
    }
    
    public interface Saltador {
        void saltar();
        double obtenerAltura();
    }
    
    public interface Nadador {
        void nadar();
        double obtenerProfundidad();
    }
    
    // ============================================================
    // CLASES QUE IMPLEMENTAN MÚLTIPLES INTERFACES
    // ============================================================
    
    public static class Atleta implements Deportista, Corredor, Saltador {
        private String nombre;
        private String deporte;
        private double velocidad;
        private double altura;
        
        public Atleta(String nombre, String deporte) {
            this.nombre = nombre;
            this.deporte = deporte;
            this.velocidad = 25.0;  // km/h
            this.altura = 2.5;      // metros
        }
        
        @Override
        public void entrenar() {
            System.out.println("Atleta " + nombre + " entrenando intensamente");
        }
        
        @Override
        public String obtenerDeporte() {
            return deporte;
        }
        
        @Override
        public void correr() {
            System.out.println("🏃 " + nombre + " corriendo a " + velocidad + " km/h");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public void saltar() {
            System.out.println("⬆️  " + nombre + " saltando " + altura + " metros");
        }
        
        @Override
        public double obtenerAltura() {
            return altura;
        }
    }
    
    public static class Nadador implements Deportista, Nadador {
        private String nombre;
        private double profundidad;
        
        public Nadador(String nombre) {
            this.nombre = nombre;
            this.profundidad = 2.5;  // metros
        }
        
        @Override
        public void entrenar() {
            System.out.println("Nadador " + nombre + " entrenando en la piscina");
        }
        
        @Override
        public String obtenerDeporte() {
            return "Natación";
        }
        
        @Override
        public void nadar() {
            System.out.println("🏊 " + nombre + " nadando a " + profundidad + " metros de profundidad");
        }
        
        @Override
        public double obtenerProfundidad() {
            return profundidad;
        }
    }
    
    public static class AletaMultiple implements Corredor, Saltador, Nadador {
        private String nombre;
        
        public AletaMultiple(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public void correr() {
            System.out.println("🏃 " + nombre + " corriendo rápido");
        }
        
        @Override
        public double obtenerVelocidad() {
            return 30.0;
        }
        
        @Override
        public void saltar() {
            System.out.println("⬆️  " + nombre + " saltando alto");
        }
        
        @Override
        public double obtenerAltura() {
            return 3.0;
        }
        
        @Override
        public void nadar() {
            System.out.println("🏊 " + nombre + " nadando profundamente");
        }
        
        @Override
        public double obtenerProfundidad() {
            return 5.0;
        }
    }
    
    // ============================================================
    // FUNCIONES QUE USAN INTERFACES
    // ============================================================
    
    public static void hacerCorrer(Corredor c) {
        c.correr();
        System.out.println("  Velocidad: " + c.obtenerVelocidad() + " km/h");
    }
    
    public static void hacerSaltar(Saltador s) {
        s.saltar();
        System.out.println("  Altura: " + s.obtenerAltura() + " m");
    }
    
    public static void hacerNadar(Nadador n) {
        n.nadar();
        System.out.println("  Profundidad: " + n.obtenerProfundidad() + " m");
    }
    
    public static void hacerEntrenar(Deportista d) {
        d.entrenar();
        System.out.println("  Deporte: " + d.obtenerDeporte());
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 2: MÚLTIPLES INTERFACES ===\n");
        
        // ============================================================
        // CREAR INSTANCIAS
        // ============================================================
        System.out.println("--- Crear Deportistas ---\n");
        
        Atleta atleta = new Atleta("Usain", "Atletismo");
        Nadador nadador = new Nadador("Michael Phelps");
        AletaMultiple aleta = new AletaMultiple("Superman");
        
        // ============================================================
        // USAR COMO INTERFAZ DIFERENTE
        // ============================================================
        System.out.println("--- Atleta (implementa Deportista, Corredor, Saltador) ---\n");
        
        hacerEntrenar(atleta);
        System.out.println();
        
        hacerCorrer(atleta);
        System.out.println();
        
        hacerSaltar(atleta);
        System.out.println();
        
        // ============================================================
        // NADADOR
        // ============================================================
        System.out.println("--- Nadador (implementa Deportista, Nadador) ---\n");
        
        hacerEntrenar(nadador);
        System.out.println();
        
        hacerNadar(nadador);
        System.out.println();
        
        // ============================================================
        // ALETA MÚLTIPLE
        // ============================================================
        System.out.println("--- Aleta Múltiple (implementa Corredor, Saltador, Nadador) ---\n");
        
        hacerCorrer(aleta);
        System.out.println();
        
        hacerSaltar(aleta);
        System.out.println();
        
        hacerNadar(aleta);
        System.out.println();
        
        // ============================================================
        // LISTA DE DIFFERENT TIPOS
        // ============================================================
        System.out.println("--- Lista de Corredores ---\n");
        
        List<Corredor> corredores = new ArrayList<>();
        corredores.add(atleta);
        corredores.add(aleta);
        
        System.out.println("Todos los corredores:");
        for (Corredor c : corredores) {
            hacerCorrer(c);
            System.out.println();
        }
        
        // ============================================================
        // LISTA DE SALTADORES
        // ============================================================
        System.out.println("--- Lista de Saltadores ---\n");
        
        List<Saltador> saltadores = new ArrayList<>();
        saltadores.add(atleta);
        saltadores.add(aleta);
        
        System.out.println("Todos los saltadores:");
        for (Saltador s : saltadores) {
            hacerSaltar(s);
            System.out.println();
        }
        
        // ============================================================
        // LISTA DE NADADORES
        // ============================================================
        System.out.println("--- Lista de Nadadores ---\n");
        
        List<Nadador> nadadores = new ArrayList<>();
        nadadores.add(nadador);
        nadadores.add(aleta);
        
        System.out.println("Todos los nadadores:");
        for (Nadador n : nadadores) {
            hacerNadar(n);
            System.out.println();
        }
        
        // ============================================================
        // NOTA IMPORTANTE
        // ============================================================
        System.out.println("NOTA:");
        System.out.println("- Un Atleta es: Deportista, Corredor, Saltador");
        System.out.println("- Un Nadador es: Deportista, Nadador");
        System.out.println("- AletaMultiple es: Corredor, Saltador, Nadador (sin Deportista)");
        System.out.println("- Las clases pueden implementar MÚLTIPLES interfaces");
    }
}
