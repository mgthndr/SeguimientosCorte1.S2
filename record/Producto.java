package record;

public record Producto(String nombre, double precio, int stock) {

    // Constructor compacto con validaciones
    public Producto {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
        // Normalizamos el nombre (opcional)
        nombre = nombre.trim();
    }

    // Método de conveniencia
    public boolean estaDisponible() {
        return stock > 0;
    }

    public double valorEnInventario() {
        return precio * stock;
    }

    public static void main(String[] args) {
        try {
            Producto laptop = new Producto("MacBook Pro", 1450.99, 12);
            System.out.println(laptop);
            System.out.println("Disponible? " + laptop.estaDisponible());
            System.out.println("Valor total: $" + laptop.valorEnInventario());

            // Esto lanzará excepción
            // Producto invalido = new Producto("  ", 0, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}