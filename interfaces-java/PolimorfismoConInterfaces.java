/*
 * EJEMPLO 3: POLIMORFISMO CON INTERFACES
 * 
 * Demuestra polimorfismo real con interfaces y sistema de vehículos.
 */

import java.util.ArrayList;
import java.util.List;

public class Ejemplo3 {
    
    // ============================================================
    // INTERFACES
    // ============================================================
    
    public interface Vehiculo {
        void acelerar();
        void frenar();
        double obtenerVelocidad();
        String obtenerNombre();
        
        // Método por defecto
        default void mostrarInfo() {
            System.out.println(obtenerNombre() + " viajando a " + obtenerVelocidad() + " km/h");
        }
    }
    
    public interface Terrestre extends Vehiculo {
        void conducir();
    }
    
    public interface Acuatico extends Vehiculo {
        void navegar();
    }
    
    public interface Aereo extends Vehiculo {
        void volar();
    }
    
    // ============================================================
    // VEHÍCULOS TERRESTRES
    // ============================================================
    
    public static class Auto implements Terrestre {
        private String nombre;
        private double velocidad;
        
        public Auto(String nombre, double velocidad) {
            this.nombre = nombre;
            this.velocidad = velocidad;
        }
        
        @Override
        public void acelerar() {
            System.out.println("🚗 " + nombre + " acelerando");
        }
        
        @Override
        public void frenar() {
            System.out.println("🚗 " + nombre + " frenando");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public String obtenerNombre() {
            return nombre;
        }
        
        @Override
        public void conducir() {
            System.out.println("Conduciendo " + nombre + " en la carretera");
        }
    }
    
    public static class Bicicleta implements Terrestre {
        private double velocidad;
        
        public Bicicleta(double velocidad) {
            this.velocidad = velocidad;
        }
        
        @Override
        public void acelerar() {
            System.out.println("🚴 Pedalando más rápido");
        }
        
        @Override
        public void frenar() {
            System.out.println("🚴 Frenando bicicleta");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public String obtenerNombre() {
            return "Bicicleta";
        }
        
        @Override
        public void conducir() {
            System.out.println("Andando en bicicleta");
        }
    }
    
    // ============================================================
    // VEHÍCULOS ACUÁTICOS
    // ============================================================
    
    public static class Barco implements Acuatico {
        private String nombre;
        private double velocidad;
        
        public Barco(String nombre, double velocidad) {
            this.nombre = nombre;
            this.velocidad = velocidad;
        }
        
        @Override
        public void acelerar() {
            System.out.println("⛵ " + nombre + " aumentando velocidad");
        }
        
        @Override
        public void frenar() {
            System.out.println("⛵ " + nombre + " reduciendo velocidad");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public String obtenerNombre() {
            return nombre;
        }
        
        @Override
        public void navegar() {
            System.out.println("Navegando " + nombre + " en el mar");
        }
    }
    
    public static class Submarino implements Acuatico {
        private double velocidad;
        
        public Submarino(double velocidad) {
            this.velocidad = velocidad;
        }
        
        @Override
        public void acelerar() {
            System.out.println("🚩 Submarino acelerando");
        }
        
        @Override
        public void frenar() {
            System.out.println("🚩 Submarino frenando");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public String obtenerNombre() {
            return "Submarino";
        }
        
        @Override
        public void navegar() {
            System.out.println("Navegando bajo el agua");
        }
    }
    
    // ============================================================
    // VEHÍCULOS AÉREOS
    // ============================================================
    
    public static class Avion implements Aereo {
        private String nombre;
        private double velocidad;
        
        public Avion(String nombre, double velocidad) {
            this.nombre = nombre;
            this.velocidad = velocidad;
        }
        
        @Override
        public void acelerar() {
            System.out.println("✈️ " + nombre + " acelerando en la pista");
        }
        
        @Override
        public void frenar() {
            System.out.println("✈️ " + nombre + " desplegando frenos");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public String obtenerNombre() {
            return nombre;
        }
        
        @Override
        public void volar() {
            System.out.println("Volando " + nombre + " a gran altura");
        }
    }
    
    public static class Helicoptero implements Aereo {
        private double velocidad;
        
        public Helicoptero(double velocidad) {
            this.velocidad = velocidad;
        }
        
        @Override
        public void acelerar() {
            System.out.println("🚁 Aumentando velocidad helicóptero");
        }
        
        @Override
        public void frenar() {
            System.out.println("🚁 Reduciendo velocidad helicóptero");
        }
        
        @Override
        public double obtenerVelocidad() {
            return velocidad;
        }
        
        @Override
        public String obtenerNombre() {
            return "Helicóptero";
        }
        
        @Override
        public void volar() {
            System.out.println("Volando verticamente");
        }
    }
    
    // ============================================================
    // FUNCIONES POLIMÓRFICAS
    // ============================================================
    
    public static void mostrarVehiculo(Vehiculo v) {
        System.out.println("\n=== " + v.obtenerNombre() + " ===");
        v.mostrarInfo();
        v.acelerar();
        v.frenar();
    }
    
    public static void conducir(Terrestre t) {
        t.conducir();
        t.mostrarInfo();
    }
    
    public static void navegar(Acuatico a) {
        a.navegar();
        a.mostrarInfo();
    }
    
    public static void volar(Aereo a) {
        a.volar();
        a.mostrarInfo();
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 3: POLIMORFISMO CON INTERFACES ===\n");
        
        // ============================================================
        // CREAR VEHÍCULOS
        // ============================================================
        System.out.println("--- Crear Vehículos ---");
        
        Auto auto = new Auto("Toyota Corolla", 200);
        Bicicleta bicicleta = new Bicicleta(30);
        
        Barco barco = new Barco("Titanic", 45);
        Submarino submarino = new Submarino(35);
        
        Avion avion = new Avion("Boeing 747", 900);
        Helicoptero helicoptero = new Helicoptero(250);
        
        // ============================================================
        // VEHÍCULOS TERRESTRES
        // ============================================================
        System.out.println("\n--- Vehículos Terrestres ---");
        conducir(auto);
        conducir(bicicleta);
        
        // ============================================================
        // VEHÍCULOS ACUÁTICOS
        // ============================================================
        System.out.println("\n--- Vehículos Acuáticos ---");
        navegar(barco);
        navegar(submarino);
        
        // ============================================================
        // VEHÍCULOS AÉREOS
        // ============================================================
        System.out.println("\n--- Vehículos Aéreos ---");
        volar(avion);
        volar(helicoptero);
        
        // ============================================================
        // POLIMORFISMO: TODOS COMO VEHÍCULOS
        // ============================================================
        System.out.println("\n--- Todos como Vehículos (Polimorfismo) ---");
        
        Vehiculo[] vehiculos = {auto, bicicleta, barco, submarino, avion, helicoptero};
        
        for (Vehiculo v : vehiculos) {
            mostrarVehiculo(v);
        }
        
        // ============================================================
        // BÚSQUEDA DE VELOCIDAD MÁXIMA
        // ============================================================
        System.out.println("\n--- Análisis de Velocidades ---");
        
        double maxVelocidad = 0;
        String vehiculoMasRapido = "";
        
        for (Vehiculo v : vehiculos) {
            if (v.obtenerVelocidad() > maxVelocidad) {
                maxVelocidad = v.obtenerVelocidad();
                vehiculoMasRapido = v.obtenerNombre();
            }
        }
        
        System.out.println("Vehículo más rápido: " + vehiculoMasRapido + " - " + 
                         maxVelocidad + " km/h");
        
        // ============================================================
        // LISTAS MÁS RÁPIDOS
        // ============================================================
        System.out.println("\n--- Clasificación por Velocidad ---");
        
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            listaVehiculos.add(v);
        }
        
        // Ordenar por velocidad (simple)
        listaVehiculos.sort((v1, v2) -> Double.compare(v2.obtenerVelocidad(), v1.obtenerVelocidad()));
        
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo v = listaVehiculos.get(i);
            System.out.println((i + 1) + ". " + v.obtenerNombre() + " - " + v.obtenerVelocidad() + " km/h");
        }
        
        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Total de vehículos: " + vehiculos.length);
        System.out.println("- Terrestres: 2 (Auto, Bicicleta)");
        System.out.println("- Acuáticos: 2 (Barco, Submarino)");
        System.out.println("- Aéreos: 2 (Avión, Helicóptero)");
        System.out.println("\nPolimorfismo: Todos comparten la interfaz Vehiculo");
    }
}
