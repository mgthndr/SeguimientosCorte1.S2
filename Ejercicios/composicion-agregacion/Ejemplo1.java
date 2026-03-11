/*
 * EJEMPLO 1: COMPOSICIÓN
 * 
 * Demuestra relaciones fuertes donde el objeto contenido depende del contenedor.
 */

public class Ejemplo1 {
    
    // ============================================================
    // COMPOSICIÓN: Computadora - CPU, RAM, Disco
    // ============================================================
    
    public static class CPU {
        private String modelo;
        private int nucleos;
        private double velocidad;  // GHz
        
        public CPU(String modelo, int nucleos, double velocidad) {
            this.modelo = modelo;
            this.nucleos = nucleos;
            this.velocidad = velocidad;
        }
        
        @Override
        public String toString() {
            return modelo + " (" + nucleos + " núcleos, " + velocidad + " GHz)";
        }
    }
    
    public static class RAM {
        private int capacidad;  // GB
        private String tipo;
        
        public RAM(int capacidad, String tipo) {
            this.capacidad = capacidad;
            this.tipo = tipo;
        }
        
        @Override
        public String toString() {
            return capacidad + "GB " + tipo;
        }
    }
    
    public static class DiscoDuro {
        private int capacidad;  // GB
        private String tipo;
        
        public DiscoDuro(int capacidad, String tipo) {
            this.capacidad = capacidad;
            this.tipo = tipo;
        }
        
        @Override
        public String toString() {
            return capacidad + "GB " + tipo;
        }
    }
    
    public static class Computadora {
        private String marca;
        private CPU cpu;           // COMPOSICIÓN
        private RAM ram;           // COMPOSICIÓN
        private DiscoDuro disco;   // COMPOSICIÓN
        
        // CONSTRUCTOR: Crea todos los componentes internamente
        public Computadora(String marca, String modeloCPU, int nucleos, 
                          double velocidadCPU, int ramGB, int discoGB) {
            this.marca = marca;
            this.cpu = new CPU(modeloCPU, nucleos, velocidadCPU);
            this.ram = new RAM(ramGB, "DDR4");
            this.disco = new DiscoDuro(discoGB, "SSD");
        }
        
        public void mostrarEspecificaciones() {
            System.out.println("Computadora: " + marca);
            System.out.println("  CPU: " + cpu);
            System.out.println("  RAM: " + ram);
            System.out.println("  Disco: " + disco);
        }
    }
    
    
    // ============================================================
    // COMPOSICIÓN: Casa - Habitaciones, Cocina, Baño
    // ============================================================
    
    public static class Habitacion {
        private String nombre;
        private double area;
        
        public Habitacion(String nombre, double area) {
            this.nombre = nombre;
            this.area = area;
        }
        
        @Override
        public String toString() {
            return nombre + " (" + area + " m²)";
        }
    }
    
    public static class Casa {
        private String direccion;
        private Habitacion dormitorio;      // COMPOSICIÓN
        private Habitacion cocina;          // COMPOSICIÓN
        private Habitacion sala;            // COMPOSICIÓN
        private Habitacion bano;            // COMPOSICIÓN
        
        // CONSTRUCTOR: Crea todas las habitaciones
        public Casa(String direccion) {
            this.direccion = direccion;
            this.dormitorio = new Habitacion("Dormitorio", 20.0);
            this.cocina = new Habitacion("Cocina", 15.0);
            this.sala = new Habitacion("Sala", 30.0);
            this.bano = new Habitacion("Baño", 8.0);
        }
        
        public void mostrarDetalles() {
            System.out.println("Casa en: " + direccion);
            System.out.println("  - " + dormitorio);
            System.out.println("  - " + cocina);
            System.out.println("  - " + sala);
            System.out.println("  - " + bano);
            double areaTotal = 20 + 15 + 30 + 8;
            System.out.println("  Area total: " + areaTotal + " m²");
        }
    }
    
    
    // ============================================================
    // COMPOSICIÓN: Persona - Cabeza, Cuerpo, Extremidades
    // ============================================================
    
    public static class Corazon {
        private int latidosPorMinuto;
        
        public Corazon() {
            this.latidosPorMinuto = 70;
        }
        
        public void latir() {
            System.out.println("  ❤️ Latido: " + latidosPorMinuto + " bpm");
        }
    }
    
    public static class Cerebro {
        private String actividadActual;
        
        public Cerebro() {
            this.actividadActual = "En reposo";
        }
        
        public void pensar(String pensamiento) {
            System.out.println("  🧠 Pensando: " + pensamiento);
        }
    }
    
    public static class Persona {
        private String nombre;
        private Corazon corazon;    // COMPOSICIÓN
        private Cerebro cerebro;    // COMPOSICIÓN
        
        // CONSTRUCTOR: Crea los órganos internamente
        public Persona(String nombre) {
            this.nombre = nombre;
            this.corazon = new Corazon();
            this.cerebro = new Cerebro();
        }
        
        public void vivir() {
            System.out.println(nombre + " está vivo:");
            corazon.latir();
            cerebro.pensar("Estoy vivo");
        }
        
        public String getNombre() {
            return nombre;
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 1: COMPOSICIÓN ===\n");
        
        // ============================================================
        // EJEMPLO 1: Computadora
        // ============================================================
        System.out.println("--- Computadora (Composición) ---\n");
        
        Computadora pc1 = new Computadora("Dell", "Intel i7", 8, 3.9, 16, 512);
        pc1.mostrarEspecificaciones();
        System.out.println();
        
        Computadora pc2 = new Computadora("ASUS", "AMD Ryzen 5", 6, 3.6, 8, 256);
        pc2.mostrarEspecificaciones();
        System.out.println();
        
        System.out.println("Nota: Los componentes (CPU, RAM, Disco) se crearon");
        System.out.println("      automáticamente cuando se creó la Computadora.");
        System.out.println("      Sin la Computadora, no existen esos componentes.\n");
        
        // ============================================================
        // EJEMPLO 2: Casa
        // ============================================================
        System.out.println("--- Casa (Composición) ---\n");
        
        Casa casa1 = new Casa("Calle Principal 123");
        casa1.mostrarDetalles();
        System.out.println();
        
        Casa casa2 = new Casa("Avenida Secundaria 456");
        casa2.mostrarDetalles();
        System.out.println();
        
        System.out.println("Nota: Las habitaciones se crearon automáticamente");
        System.out.println("      cuando se creó la Casa.\n");
        
        // ============================================================
        // EJEMPLO 3: Persona
        // ============================================================
        System.out.println("--- Persona (Composición) ---\n");
        
        Persona persona1 = new Persona("Juan");
        persona1.vivir();
        System.out.println();
        
        Persona persona2 = new Persona("María");
        persona2.vivir();
        System.out.println();
        
        System.out.println("Nota: Los órganos (Corazón, Cerebro) se crearon");
        System.out.println("      automáticamente cuando se creó la Persona.");
        System.out.println("      Sin la Persona, los órganos no existen.");
        System.out.println("      Esto es composición: relación fuerte.");
    }
}
