/*
 * EJEMPLO 1: ENCAPSULAMIENTO BÁSICO
 * 
 * Demuestra cómo proteger datos con private, getters y setters.
 */

public class Ejemplo1 {
    
    // ============================================================
    // CLASE: Producto
    // ============================================================
    public static class Producto {
        // ATRIBUTOS PRIVADOS (encapsulados)
        private String nombre;
        private double precio;
        private int cantidad;
        
        // CONSTRUCTOR
        public Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
        
        // GETTERS (lectura)
        public String getNombre() {
            return nombre;
        }
        
        public double getPrecio() {
            return precio;
        }
        
        public int getCantidad() {
            return cantidad;
        }
        
        // SETTERS (escritura con validación)
        public void setNombre(String nombre) {
            if (nombre != null && !nombre.isEmpty()) {
                this.nombre = nombre;
            }
        }
        
        public void setPrecio(double precio) {
            if (precio > 0) {  // Validación: precio debe ser positivo
                this.precio = precio;
            }
        }
        
        public void setCantidad(int cantidad) {
            if (cantidad >= 0) {  // Validación: cantidad no puede ser negativa
                this.cantidad = cantidad;
            }
        }
        
        // MÉTODO ADICIONAL
        public double obtenerValorTotal() {
            return precio * cantidad;
        }
        
        @Override
        public String toString() {
            return "Producto{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", cantidad=" + cantidad +
                    ", total=" + obtenerValorTotal() +
                    '}';
        }
    }
    
    
    // ============================================================
    // CLASE: CuentaBancaria
    // ============================================================
    public static class CuentaBancaria {
        private String titular;
        private double saldo;
        private String numeroCuenta;
        
        // CONSTRUCTOR
        public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
            this.titular = titular;
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldoInicial;
        }
        
        // GETTERS
        public String getTitular() {
            return titular;
        }
        
        public double getSaldo() {
            return saldo;
        }
        
        public String getNumeroCuenta() {
            return numeroCuenta;
        }
        
        // SETTER CON VALIDACIÓN
        public void setSaldo(double saldo) {
            if (saldo >= 0) {
                this.saldo = saldo;
            }
        }
        
        // MÉTODOS DE NEGOCIO
        public void depositar(double cantidad) {
            if (cantidad > 0) {
                this.saldo += cantidad;
                System.out.println("✓ Depósito de $" + cantidad + " realizado");
            } else {
                System.out.println("✗ Error: cantidad debe ser positiva");
            }
        }
        
        public boolean retirar(double cantidad) {
            if (cantidad > 0 && cantidad <= this.saldo) {
                this.saldo -= cantidad;
                System.out.println("✓ Retiro de $" + cantidad + " realizado");
                return true;
            } else {
                System.out.println("✗ Error: fondos insuficientes o cantidad inválida");
                return false;
            }
        }
        
        public void mostrarEstado() {
            System.out.println("Titular: " + titular);
            System.out.println("Cuenta: " + numeroCuenta);
            System.out.println("Saldo: $" + String.format("%.2f", saldo));
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 1: ENCAPSULAMIENTO BÁSICO ===\n");
        
        // ============================================================
        // EJEMPLO 1: Producto
        // ============================================================
        System.out.println("--- Producto (Encapsulamiento) ---");
        
        Producto p1 = new Producto("Laptop", 800.00, 5);
        System.out.println(p1);
        System.out.println();
        
        // Acceder mediante getters
        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Precio: $" + p1.getPrecio());
        System.out.println("Cantidad: " + p1.getCantidad());
        System.out.println("Valor Total: $" + p1.obtenerValorTotal());
        System.out.println();
        
        // Modificar mediante setters (con validación)
        System.out.println("--- Modificar valores ---");
        p1.setPrecio(750.00);
        System.out.println("Nuevo precio: $" + p1.getPrecio());
        
        p1.setCantidad(10);
        System.out.println("Nueva cantidad: " + p1.getCantidad());
        System.out.println("Nuevo total: $" + p1.obtenerValorTotal());
        System.out.println();
        
        // Intentar asignar valores inválidos (serán rechazados)
        System.out.println("--- Intentar valores inválidos ---");
        p1.setPrecio(-100);  // No se cambia (negativo)
        System.out.println("Precio después de intentar -100: $" + p1.getPrecio());
        
        p1.setCantidad(-5);  // No se cambia (negativo)
        System.out.println("Cantidad después de intentar -5: " + p1.getCantidad());
        System.out.println();
        
        // ============================================================
        // EJEMPLO 2: Cuenta Bancaria
        // ============================================================
        System.out.println("--- Cuenta Bancaria (Encapsulamiento) ---");
        
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", "123456", 1000.00);
        cuenta.mostrarEstado();
        System.out.println();
        
        // Operaciones permitidas
        System.out.println("--- Operaciones Exitosas ---");
        cuenta.depositar(500);
        cuenta.mostrarEstado();
        System.out.println();
        
        cuenta.retirar(300);
        cuenta.mostrarEstado();
        System.out.println();
        
        // Intentar operaciones inválidas
        System.out.println("--- Intentar Operaciones Inválidas ---");
        cuenta.depositar(-100);  // Rechazado
        System.out.println();
        
        cuenta.retirar(2000);  // Rechazado (fondos insuficientes)
        System.out.println();
        
        cuenta.mostrarEstado();
        System.out.println();
        
        // ============================================================
        // EJEMPLO 3: Múltiples Productos
        // ============================================================
        System.out.println("--- Inventario de Productos ---");
        
        Producto[] productos = {
            new Producto("Mouse", 25.00, 50),
            new Producto("Teclado", 75.00, 30),
            new Producto("Monitor", 250.00, 10)
        };
        
        double valorTotalInventario = 0;
        for (Producto p : productos) {
            System.out.println(p);
            valorTotalInventario += p.obtenerValorTotal();
        }
        
        System.out.println("Valor Total del Inventario: $" + String.format("%.2f", valorTotalInventario));
    }
}
