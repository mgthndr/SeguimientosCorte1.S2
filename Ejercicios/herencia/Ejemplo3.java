public class Ejemplo3 {
    public static class Vehiculo {
        private String marca;
        protected String modelo;
        public int año;
        
        public Vehiculo(String marca, String modelo, int año) {
            this.marca = marca;
            this.modelo = modelo;
            this.año = año;
        }
        
        public String getMarca() {
            return marca;
        }
        
        public void setMarca(String marca) {
            this.marca = marca;
        }
    }
    
    public static class Auto extends Vehiculo {
        private int puertas;
        
        public Auto(String marca, String modelo, int año, int puertas) {
            super(marca, modelo, año);
            this.puertas = puertas;
        }
        
        public int getPuertas() {
            return puertas;
        }
        
        public void setPuertas(int puertas) {
            this.puertas = puertas;
        }
        
        public void mostrarDetalles() {
            System.out.println("Auto: " + getMarca() + " " + modelo + " (" + año + "), Puertas: " + puertas);
        }
    }
    
    public static void main(String[] args) {
        Auto auto = new Auto("Toyota", "Corolla", 2023, 4);
        auto.mostrarDetalles();
        auto.setPuertas(2);
        System.out.println("Puertas actualizadas: " + auto.getPuertas());
    }
}
