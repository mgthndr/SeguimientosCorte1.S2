/*
 * EJEMPLO 2: AGREGACIÓN
 * 
 * Demuestra relaciones débiles donde el objeto contenido es independiente.
 */

import java.util.ArrayList;

public class Ejemplo2 {
    
    // ============================================================
    // AGREGACIÓN: Equipo de Fútbol - Jugadores
    // ============================================================
    
    public static class Jugador {
        private String nombre;
        private int numero;
        private String posicion;
        
        public Jugador(String nombre, int numero, String posicion) {
            this.nombre = nombre;
            this.numero = numero;
            this.posicion = posicion;
        }
        
        public String getNombre() { return nombre; }
        public int getNumero() { return numero; }
        public String getPosicion() { return posicion; }
        
        @Override
        public String toString() {
            return "#" + numero + " " + nombre + " (" + posicion + ")";
        }
    }
    
    public static class EquipoDeFutbol {
        private String nombre;
        private ArrayList<Jugador> jugadores;  // AGREGACIÓN (referencia externa)
        
        public EquipoDeFutbol(String nombre) {
            this.nombre = nombre;
            this.jugadores = new ArrayList<>();
        }
        
        // Agregar jugador que YA EXISTE
        public void agregarJugador(Jugador j) {
            jugadores.add(j);
            System.out.println("✓ " + j.getNombre() + " se unió a " + nombre);
        }
        
        // Remover jugador
        public void removerJugador(Jugador j) {
            jugadores.remove(j);
            System.out.println("✗ " + j.getNombre() + " salió de " + nombre);
        }
        
        public void mostrarAlineacion() {
            System.out.println("\n=== Alineación " + nombre + " ===");
            for (Jugador j : jugadores) {
                System.out.println("  " + j);
            }
        }
    }
    
    
    // ============================================================
    // AGREGACIÓN: Biblioteca - Libros
    // ============================================================
    
    public static class Libro {
        private String titulo;
        private String autor;
        private int anio;
        
        public Libro(String titulo, String autor, int anio) {
            this.titulo = titulo;
            this.autor = autor;
            this.anio = anio;
        }
        
        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        
        @Override
        public String toString() {
            return "\"" + titulo + "\" por " + autor + " (" + anio + ")";
        }
    }
    
    public static class Biblioteca {
        private String nombre;
        private ArrayList<Libro> libros;  // AGREGACIÓN
        
        public Biblioteca(String nombre) {
            this.nombre = nombre;
            this.libros = new ArrayList<>();
        }
        
        public void adquirirLibro(Libro libro) {
            libros.add(libro);
            System.out.println("✓ Libro adquirido: " + libro.getTitulo());
        }
        
        public void mostrarCatalogo() {
            System.out.println("\n=== Biblioteca: " + nombre + " ===");
            for (int i = 0; i < libros.size(); i++) {
                System.out.println((i + 1) + ". " + libros.get(i));
            }
        }
        
        public int getCantidadLibros() {
            return libros.size();
        }
    }
    
    
    // ============================================================
    // AGREGACIÓN: Clase - Estudiantes
    // ============================================================
    
    public static class Estudiante {
        private String nombre;
        private int carnet;
        
        public Estudiante(String nombre, int carnet) {
            this.nombre = nombre;
            this.carnet = carnet;
        }
        
        public String getNombre() { return nombre; }
        
        @Override
        public String toString() {
            return nombre + " (Carnet: " + carnet + ")";
        }
    }
    
    public static class Clase {
        private String nombre;
        private ArrayList<Estudiante> estudiantes;  // AGREGACIÓN
        private int capacidadMaxima;
        
        public Clase(String nombre, int capacidad) {
            this.nombre = nombre;
            this.estudiantes = new ArrayList<>();
            this.capacidadMaxima = capacidad;
        }
        
        public boolean matricularEstudiante(Estudiante e) {
            if (estudiantes.size() < capacidadMaxima) {
                estudiantes.add(e);
                System.out.println("✓ " + e.getNombre() + " matriculado en " + nombre);
                return true;
            } else {
                System.out.println("✗ Clase llena. No se puede matricular " + e.getNombre());
                return false;
            }
        }
        
        public void mostrarListado() {
            System.out.println("\n=== Clase: " + nombre + " ===");
            System.out.println("Estudiantes: " + estudiantes.size() + "/" + capacidadMaxima);
            for (Estudiante e : estudiantes) {
                System.out.println("  - " + e);
            }
        }
    }
    
    
    // ============================================================
    // AGREGACIÓN: Empresa - Empleados
    // ============================================================
    
    public static class Empleado {
        private String nombre;
        private String puesto;
        private double salario;
        
        public Empleado(String nombre, String puesto, double salario) {
            this.nombre = nombre;
            this.puesto = puesto;
            this.salario = salario;
        }
        
        public String getNombre() { return nombre; }
        
        @Override
        public String toString() {
            return nombre + " (" + puesto + ") - $" + String.format("%.2f", salario);
        }
    }
    
    public static class Empresa {
        private String nombre;
        private ArrayList<Empleado> empleados;  // AGREGACIÓN
        
        public Empresa(String nombre) {
            this.nombre = nombre;
            this.empleados = new ArrayList<>();
        }
        
        public void contrarEmpleado(Empleado e) {
            empleados.add(e);
            System.out.println("✓ " + e.getNombre() + " contratado en " + nombre);
        }
        
        public void despedirEmpleado(Empleado e) {
            empleados.remove(e);
            System.out.println("✗ " + e.getNombre() + " despedido de " + nombre);
        }
        
        public void mostrarEmpleados() {
            System.out.println("\n=== Empresa: " + nombre + " ===");
            double sumaSalarios = 0;
            for (Empleado e : empleados) {
                System.out.println("  - " + e);
                sumaSalarios += e.salario;
            }
            System.out.println("Total empleados: " + empleados.size());
            System.out.println("Nómina total: $" + String.format("%.2f", sumaSalarios));
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 2: AGREGACIÓN ===\n");
        
        // ============================================================
        // EJEMPLO 1: Equipo de Fútbol
        // ============================================================
        System.out.println("--- Equipo de Fútbol (Agregación) ---");
        
        // Los jugadores EXISTEN ANTES de crear el equipo
        Jugador j1 = new Jugador("Messi", 10, "Delantero");
        Jugador j2 = new Jugador("Puyol", 5, "Defensa");
        Jugador j3 = new Jugador("Busquets", 16, "Centrocampista");
        
        // El equipo AGREGA los jugadores que ya existen
        EquipoDeFutbol barcelona = new EquipoDeFutbol("Barcelona");
        barcelona.agregarJugador(j1);
        barcelona.agregarJugador(j2);
        barcelona.agregarJugador(j3);
        barcelona.mostrarAlineacion();
        
        // Si removemos del equipo, el jugador sigue existiendo
        barcelona.removerJugador(j2);
        barcelona.mostrarAlineacion();
        System.out.println();
        
        // ============================================================
        // EJEMPLO 2: Biblioteca
        // ============================================================
        System.out.println("--- Biblioteca (Agregación) ---");
        
        // Los libros EXISTEN ANTES de entrar a la biblioteca
        Libro libro1 = new Libro("1984", "George Orwell", 1949);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Libro libro3 = new Libro("El quijote", "Miguel de Cervantes", 1605);
        
        // La biblioteca AGREGA los libros que ya existen
        Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");
        biblioteca.adquirirLibro(libro1);
        biblioteca.adquirirLibro(libro2);
        biblioteca.adquirirLibro(libro3);
        biblioteca.mostrarCatalogo();
        System.out.println("Total de libros: " + biblioteca.getCantidadLibros());
        System.out.println();
        
        // ============================================================
        // EJEMPLO 3: Clase
        // ============================================================
        System.out.println("--- Clase (Agregación) ---");
        
        // Los estudiantes EXISTEN ANTES de matricularse
        Estudiante e1 = new Estudiante("Juan", 1001);
        Estudiante e2 = new Estudiante("María", 1002);
        Estudiante e3 = new Estudiante("Pedro", 1003);
        Estudiante e4 = new Estudiante("Ana", 1004);
        
        // La clase AGREGA estudiantes (con capacidad limitada)
        Clase matematica = new Clase("Matemáticas", 3);
        matematica.matricularEstudiante(e1);
        matematica.matricularEstudiante(e2);
        matematica.matricularEstudiante(e3);
        matematica.matricularEstudiante(e4);  // No cabe
        matematica.mostrarListado();
        System.out.println();
        
        // ============================================================
        // EJEMPLO 4: Empresa
        // ============================================================
        System.out.println("--- Empresa (Agregación) ---");
        
        // Los empleados EXISTEN ANTES de ser contratados
        Empleado emp1 = new Empleado("Carlos", "Gerente", 5000);
        Empleado emp2 = new Empleado("Laura", "Programadora", 3500);
        Empleado emp3 = new Empleado("Diego", "Diseñador", 3000);
        
        // La empresa AGREGA los empleados que ya existen
        Empresa techCorp = new Empresa("TechCorp");
        techCorp.contrarEmpleado(emp1);
        techCorp.contrarEmpleado(emp2);
        techCorp.contrarEmpleado(emp3);
        techCorp.mostrarEmpleados();
        
        // Si despedimos, el empleado sigue existiendo (puede trabajar en otro lado)
        System.out.println("\nDespidiendo a Diego...");
        techCorp.despedirEmpleado(emp3);
        techCorp.mostrarEmpleados();
        System.out.println();
        
        System.out.println("NOTA: En Agregación, los objetos contenidos (Jugadores,");
        System.out.println("Libros, Estudiantes, Empleados) pueden vivir SIN el");
        System.out.println("contenedor (Equipo, Biblioteca, Clase, Empresa).");
    }
}
