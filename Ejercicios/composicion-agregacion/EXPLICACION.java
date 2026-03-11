/*
 * ============================================================================
 * GUÍA COMPLETA: COMPOSICIÓN Y AGREGACIÓN EN JAVA
 * ============================================================================
 * 
 * Estos son conceptos sobre cómo las clases se relacionan entre sí.
 * 
 * ============================================================================
 * 1. AGREGACIÓN ("HAS-A" débil)
 * ============================================================================
 * 
 * DEFINICIÓN:
 * Una clase contiene referencias a objetos de otra clase, pero esos objetos
 * pueden existir independientemente.
 * 
 * CARACTERÍSTICAS:
 * - Relación débil
 * - El objeto contenido puede vivir sin el contenedor
 * - El contenedor no es responsable del ciclo de vida
 * - Ejemplo: Un Departamento tiene Empleados
 * 
 * EJEMPLO:
 * 
 *    public class Departamento {
 *        private ArrayList<Empleado> empleados;  // Agregación
 *    }
 *    
 *    public class Empleado {
 *        private String nombre;
 *    }
 *    
 *    // Un empleado puede existir sin un departamento
 *    Empleado emp = new Empleado("Juan");
 *    
 *    // Un departamento contiene empleados
 *    Departamento dept = new Departamento();
 *    dept.agregarEmpleado(emp);
 *    
 *    // Si se elimina el departamento, los empleados aún existen
 * 
 * 
 * ============================================================================
 * 2. COMPOSICIÓN ("HAS-A" fuerte)
 * ============================================================================
 * 
 * DEFINICIÓN:
 * Una clase contiene objetos de otra clase, y esos objetos NO pueden
 * existir sin el contenedor. El contenedor es responsable del ciclo de vida.
 * 
 * CARACTERÍSTICAS:
 * - Relación fuerte
 * - El objeto contenido depende del contenedor
 * - Si se elimina el contenedor, se eliminan los contenidos
 * - Ejemplo: Una Persona tiene un Corazón
 * 
 * EJEMPLO:
 * 
 *    public class Persona {
 *        private Corazon corazon;  // Composición
 *        
 *        public Persona() {
 *            this.corazon = new Corazon();  // Se crea con la persona
 *        }
 *    }
 *    
 *    public class Corazon {
 *        private int latidos;
 *    }
 *    
 *    // Una persona siempre tiene un corazón
 *    Persona p = new Persona();  // Corazón creado automáticamente
 *    
 *    // Si muere la persona, muere también el corazón
 * 
 * 
 * ============================================================================
 * 3. DIFERENCIAS PRINCIPALES
 * ============================================================================
 * 
 * AGREGACIÓN:
 * - El objeto contenido es INDEPENDIENTE
 * - Se pasa por referencia (puede venir de afuera)
 * - Relación débil
 * - Ejemplo: Equipo de Fútbol - Jugadores
 * 
 * COMPOSICIÓN:
 * - El objeto contenido es DEPENDIENTE
 * - Se crea DENTRO del contenedor
 * - Relación fuerte
 * - Ejemplo: Coche - Motor, Ruedas
 * 
 * ANALOGÍA:
 * 
 *    Agregación: Una clase es una colección de estudiantes
 *    - Los estudiantes existen antes de la clase
 *    - Pueden cambiar de clase
 *    - Si se elimina la clase, siguen existiendo
 * 
 *    Composición: Un coche está compuesto de un motor
 *    - El motor se crea para el coche
 *    - El motor pertenece SOLO a ese coche
 *    - Sin motor, no hay coche; sin coche, muere el motor
 * 
 * 
 * ============================================================================
 * 4. DIAGRAMA UML
 * ============================================================================
 * 
 * AGREGACIÓN (línea con diamante vacío):
 * 
 *    Departamento <>------------ Empleado
 *    (contenedor)               (contenido independiente)
 * 
 * 
 * COMPOSICIÓN (línea con diamante lleno):
 * 
 *    Persona <><------------- Corazon
 *    (contiene)              (depende del contenedor)
 * 
 * 
 * ============================================================================
 * 5. CÓDIGO TÍPICO
 * ============================================================================
 * 
 * AGREGACIÓN:
 * 
 *    public class Escuela {
 *        private ArrayList<Estudiante> estudiantes;  // Referencias externas
 *        
 *        public void agregarEstudiante(Estudiante e) {
 *            estudiantes.add(e);  // Agrega referencia
 *        }
 *    }
 * 
 * 
 * COMPOSICIÓN:
 * 
 *    public class Computadora {
 *        private CPU cpu;              // Creado internamente
 *        private RAM ram;              // Creado internamente
 *        
 *        public Computadora() {
 *            this.cpu = new CPU();     // Crea los componentes
 *            this.ram = new RAM();
 *        }
 *    }
 * 
 * 
 * ============================================================================
 * 6. CUÁNDO USAR CADA UNA
 * ============================================================================
 * 
 * USA AGREGACIÓN CUANDO:
 * - El objeto contenido puede existir sin el contenedor
 * - Necesitas reutilizar el objeto en otros contenedores
 * - El ciclo de vida es independiente
 * - Ejemplo: Biblioteca - Libros
 * 
 * USA COMPOSICIÓN CUANDO:
 * - El objeto contenido solo tiene sentido dentro del contenedor
 * - El contenedor "posee" completamente el contenido
 * - El contenido se crea y se destruye con el contenedor
 * - Ejemplo: Automóvil - Motor, Ruedas
 * 
 * 
 * ============================================================================
 * 7. VENTAJAS
 * ============================================================================
 * 
 * AGREGACIÓN:
 * ✓ Flexibilidad: Reutilizar objetos
 * ✓ Independencia: Objetos viven solos
 * ✓ Bajo acoplamiento: Menos dependencia
 * 
 * COMPOSICIÓN:
 * ✓ Encapsulación: Control total del contenido
 * ✓ Ciclo de vida automático: Crea y destruye
 * ✓ Responsabilidad clara: El contenedor maneja todo
 * 
 * 
 * ============================================================================
 */

public class EXPLICACION_COMPOSICION_AGREGACION {
    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  COMPOSICIÓN Y AGREGACIÓN EN JAVA");
        System.out.println("======================================================\n");
        
        System.out.println("AGREGACIÓN:");
        System.out.println("  - Relación débil (HAS-A)");
        System.out.println("  - Objeto contenido es INDEPENDIENTE");
        System.out.println("  - Puede existir sin el contenedor");
        System.out.println("  - Ejemplo: Equipo - Jugadores\n");
        
        System.out.println("COMPOSICIÓN:");
        System.out.println("  - Relación fuerte (HAS-A)");
        System.out.println("  - Objeto contenido es DEPENDIENTE");
        System.out.println("  - Se crea DENTRO del contenedor");
        System.out.println("  - Ejemplo: Coche - Motor\n");
        
        System.out.println("Ver ejemplos:");
        System.out.println("  - Ejemplo1.java: Composición");
        System.out.println("  - Ejemplo2.java: Agregación");
        System.out.println("  - Ejemplo3.java: Sistema de Pedidos (completo)");
    }
}
