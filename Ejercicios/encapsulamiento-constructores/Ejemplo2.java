/*
 * EJEMPLO 2: CONSTRUCTORES SOBRECARGADOS
 * 
 * Demuestra cómo crear múltiples versiones del constructor.
 */

public class Ejemplo2 {
    
    // ============================================================
    // CLASE: Persona
    // ============================================================
    public static class Persona {
        private String nombre;
        private int edad;
        private String ciudad;
        private String profesion;
        
        // CONSTRUCTOR 1: Sin parámetros (por defecto)
        public Persona() {
            this("Desconocido", 0, "No especificada", "No especificada");
            System.out.println("Constructor 1: Sin parámetros");
        }
        
        // CONSTRUCTOR 2: Solo nombre
        public Persona(String nombre) {
            this(nombre, 0, "No especificada", "No especificada");
            System.out.println("Constructor 2: Solo nombre");
        }
        
        // CONSTRUCTOR 3: Nombre y edad
        public Persona(String nombre, int edad) {
            this(nombre, edad, "No especificada", "No especificada");
            System.out.println("Constructor 3: Nombre y edad");
        }
        
        // CONSTRUCTOR 4: Nombre, edad y ciudad
        public Persona(String nombre, int edad, String ciudad) {
            this(nombre, edad, ciudad, "No especificada");
            System.out.println("Constructor 4: Nombre, edad y ciudad");
        }
        
        // CONSTRUCTOR 5: Todos los parámetros
        public Persona(String nombre, int edad, String ciudad, String profesion) {
            this.nombre = nombre;
            this.edad = edad;
            this.ciudad = ciudad;
            this.profesion = profesion;
            System.out.println("Constructor 5: Todos los parámetros");
        }
        
        // GETTERS
        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }
        public String getCiudad() { return ciudad; }
        public String getProfesion() { return profesion; }
        
        // SETTERS
        public void setNombre(String nombre) {
            if (nombre != null && !nombre.isEmpty()) {
                this.nombre = nombre;
            }
        }
        
        public void setEdad(int edad) {
            if (edad > 0 && edad < 150) {
                this.edad = edad;
            }
        }
        
        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }
        
        public void setProfesion(String profesion) {
            this.profesion = profesion;
        }
        
        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", ciudad='" + ciudad + '\'' +
                    ", profesion='" + profesion + '\'' +
                    '}';
        }
    }
    
    
    // ============================================================
    // CLASE: Estudiante
    // ============================================================
    public static class Estudiante {
        private String nombre;
        private int matricula;
        private String carrera;
        private double promedio;
        
        // CONSTRUCTOR 1: Valores por defecto
        public Estudiante() {
            this("", 0, "", 0.0);
        }
        
        // CONSTRUCTOR 2: Información básica
        public Estudiante(String nombre, int matricula) {
            this(nombre, matricula, "", 0.0);
        }
        
        // CONSTRUCTOR 3: Con carrera
        public Estudiante(String nombre, int matricula, String carrera) {
            this(nombre, matricula, carrera, 0.0);
        }
        
        // CONSTRUCTOR 4: Completo
        public Estudiante(String nombre, int matricula, String carrera, double promedio) {
            this.nombre = nombre;
            this.matricula = matricula;
            this.carrera = carrera;
            this.promedio = promedio;
        }
        
        // GETTERS
        public String getNombre() { return nombre; }
        public int getMatricula() { return matricula; }
        public String getCarrera() { return carrera; }
        public double getPromedio() { return promedio; }
        
        // SETTERS
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
        
        public void setPromedio(double promedio) {
            if (promedio >= 0 && promedio <= 5.0) {
                this.promedio = promedio;
            }
        }
        
        public String obtenerEstado() {
            if (promedio >= 4.0) {
                return "Excelente";
            } else if (promedio >= 3.0) {
                return "Bueno";
            } else if (promedio >= 2.0) {
                return "Aceptable";
            } else {
                return "Reprobado";
            }
        }
        
        @Override
        public String toString() {
            return "Estudiante{" +
                    "nombre='" + nombre + '\'' +
                    ", matricula=" + matricula +
                    ", carrera='" + carrera + '\'' +
                    ", promedio=" + String.format("%.2f", promedio) +
                    ", estado='" + obtenerEstado() + '\'' +
                    '}';
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 2: CONSTRUCTORES SOBRECARGADOS ===\n");
        
        // ============================================================
        // EJEMPLO 1: Personas con diferentes constructores
        // ============================================================
        System.out.println("--- Creando Personas ---\n");
        
        System.out.println("1. Persona sin parámetros:");
        Persona p1 = new Persona();
        System.out.println(p1);
        System.out.println();
        
        System.out.println("2. Persona con solo nombre:");
        Persona p2 = new Persona("María");
        System.out.println(p2);
        System.out.println();
        
        System.out.println("3. Persona con nombre y edad:");
        Persona p3 = new Persona("Juan", 30);
        System.out.println(p3);
        System.out.println();
        
        System.out.println("4. Persona con nombre, edad y ciudad:");
        Persona p4 = new Persona("Carlos", 25, "Madrid");
        System.out.println(p4);
        System.out.println();
        
        System.out.println("5. Persona con todos los datos:");
        Persona p5 = new Persona("Ana", 28, "Barcelona", "Ingeniera");
        System.out.println(p5);
        System.out.println();
        
        // ============================================================
        // EJEMPLO 2: Modificar datos con setters
        // ============================================================
        System.out.println("--- Modificar Persona p1 ---");
        System.out.println("Antes: " + p1);
        
        p1.setNombre("Pedro");
        p1.setEdad(35);
        p1.setCiudad("Valencia");
        p1.setProfesion("Profesor");
        
        System.out.println("Después: " + p1);
        System.out.println();
        
        // ============================================================
        // EJEMPLO 3: Estudiantes con diferentes constructores
        // ============================================================
        System.out.println("--- Creando Estudiantes ---\n");
        
        System.out.println("1. Estudiante sin parámetros:");
        Estudiante e1 = new Estudiante();
        System.out.println(e1);
        System.out.println();
        
        System.out.println("2. Estudiante con nombre y matrícula:");
        Estudiante e2 = new Estudiante("Jorge", 2001);
        System.out.println(e2);
        System.out.println();
        
        System.out.println("3. Estudiante con carrera:");
        Estudiante e3 = new Estudiante("Sandra", 2002, "Ingeniería en Sistemas");
        System.out.println(e3);
        System.out.println();
        
        System.out.println("4. Estudiante completo:");
        Estudiante e4 = new Estudiante("Roberto", 2003, "Administración", 4.5);
        System.out.println(e4);
        System.out.println();
        
        // ============================================================
        // EJEMPLO 4: Actualizar promedio y ver cambios de estado
        // ============================================================
        System.out.println("--- Actualizar Promedio ---");
        
        Estudiante e5 = new Estudiante("Laura", 2004, "Diseño Gráfico", 2.8);
        System.out.println("Estado inicial: " + e5.obtenerEstado() + " (promedio: " + e5.getPromedio() + ")");
        
        e5.setPromedio(3.5);
        System.out.println("Después de 3.5: " + e5.obtenerEstado());
        
        e5.setPromedio(4.2);
        System.out.println("Después de 4.2: " + e5.obtenerEstado());
        System.out.println();
        
        // ============================================================
        // EJEMPLO 5: Array de Estudiantes
        // ============================================================
        System.out.println("--- Clase de 5 Estudiantes ---");
        
        Estudiante[] clase = {
            new Estudiante("Luis", 3001, "Informática", 4.0),
            new Estudiante("Paula", 3002, "Informática", 3.8),
            new Estudiante("Marcos", 3003, "Informática", 3.2),
            new Estudiante("Diana", 3004, "Informática", 4.5),
            new Estudiante("Rodrigo", 3005, "Informática", 2.9)
        };
        
        double promedioPrueba = 0;
        for (Estudiante e : clase) {
            System.out.println(e);
            promedioPrueba += e.getPromedio();
        }
        
        System.out.println("Promedio de la clase: " + 
                         String.format("%.2f", promedioPrueba / clase.length));
    }
}
