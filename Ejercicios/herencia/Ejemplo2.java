public class Ejemplo2 {
    public static class Persona {
        private String nombre;
        private int cedula;
        
        public Persona(String nombre, int cedula) {
            this.nombre = nombre;
            this.cedula = cedula;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
    
    public static class Estudiante extends Persona {
        private String carrera;
        protected double promedio;
        
        public Estudiante(String nombre, int cedula, String carrera, double promedio) {
            super(nombre, cedula);
            this.carrera = carrera;
            this.promedio = promedio;
        }
        
        public String getCarrera() {
            return carrera;
        }
        
        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
    }
    
    public static class EstudianteAvanzado extends Estudiante {
        private String proyecto;
        
        public EstudianteAvanzado(String nombre, int cedula, String carrera, double promedio, String proyecto) {
            super(nombre, cedula, carrera, promedio);
            this.proyecto = proyecto;
        }
        
        public String getProyecto() {
            return proyecto;
        }
        
        public void mostrarInfo() {
            System.out.println("Estudiante: " + getNombre() + ", Carrera: " + getCarrera() + 
                             ", Promedio: " + promedio + ", Proyecto: " + proyecto);
        }
    }
    
    public static void main(String[] args) {
        EstudianteAvanzado est = new EstudianteAvanzado("Juan", 1001, "Ingeniería", 4.5, "IA");
        est.mostrarInfo();
        est.setCarrera("Ingeniería de Sistemas");
        System.out.println("Nueva carrera: " + est.getCarrera());
    }
}
