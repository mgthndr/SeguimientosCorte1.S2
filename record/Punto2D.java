package record;

public record Punto2D(double x, double y) {

    // Método personalizado
    public double distanciaAlOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    // Método con lógica adicional
    public Punto2D escalar(double factor) {
        return new Punto2D(x * factor, y * factor);
    }

    // Podemos sobrescribir toString si queremos un formato especial
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    public static void main(String[] args) {
        Punto2D p1 = new Punto2D(3, 4);
        Punto2D p2 = new Punto2D(-1.5, 2.5);

        System.out.println("p1 = " + p1);
        System.out.println("Distancia al origen: " + p1.distanciaAlOrigen()); // 5.0
        System.out.println("p2 escalado ×2 = " + p2.escalar(2));
        
        // Equals y hashCode ya funcionan correctamente
        System.out.println(p1.equals(new Punto2D(3, 4)));     // true
        System.out.println(p1.equals(new Punto2D(3, 4.0001))); // false
    }
}