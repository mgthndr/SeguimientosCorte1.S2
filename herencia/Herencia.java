public class Ejemplo1 {
    // Clase base
    public static class Animal {
        private String nombre;
        protected int edad;
        
        public Animal(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public int getEdad() {
            return edad;
        }
        
        public void setEdad(int edad) {
            this.edad = edad;
        }
    }
    
    // Clase que hereda de Animal
    public static class Perro extends Animal {
        private String raza;
        
        public Perro(String nombre, int edad, String raza) {
            super(nombre, edad);
            this.raza = raza;
        }
        
        public String getRaza() {
            return raza;
        }
        
        public void setRaza(String raza) {
            this.raza = raza;
        }
        
        public void mostrar() {
            System.out.println("Perro: " + getNombre() + ", Edad: " + edad + ", Raza: " + raza);
        }
    }
    
    public static void main(String[] args) {
        Perro perro = new Perro("Rex", 5, "Labrador");
        perro.mostrar();
        perro.setEdad(6);
        System.out.println("Nueva edad: " + perro.getEdad());
    }
}
