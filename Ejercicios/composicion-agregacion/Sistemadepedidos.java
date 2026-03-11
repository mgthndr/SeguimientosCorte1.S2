/*
 * EJEMPLO 3: SISTEMA DE PEDIDOS COMPLETO
 * 
 * Demuestra tanto composición como agregación en un ejemplo real.
 * Composición: Pedido - Items
 * Agregación: Pedido - Cliente
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class Ejemplo3 {
    
    // ============================================================
    // Cliente (agregación)
    // ============================================================
    public static class Cliente {
        private int id;
        private String nombre;
        private String email;
        private String telefono;
        
        public Cliente(int id, String nombre, String email, String telefono) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
            this.telefono = telefono;
        }
        
        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public String getEmail() { return email; }
        
        @Override
        public String toString() {
            return nombre + " (" + email + ")";
        }
    }
    
    // ============================================================
    // Producto (agregación)
    // ============================================================
    public static class Producto {
        private int id;
        private String nombre;
        private double precio;
        private int stock;
        
        public Producto(int id, String nombre, double precio, int stock) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }
        
        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
        
        @Override
        public String toString() {
            return nombre + " - $" + String.format("%.2f", precio);
        }
    }
    
    // ============================================================
    // ItemPedido (composición - parte del pedido)
    // ============================================================
    public static class ItemPedido {
        private Producto producto;
        private int cantidad;
        
        public ItemPedido(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }
        
        public Producto getProducto() { return producto; }
        public int getCantidad() { return cantidad; }
        
        public double obtenerSubtotal() {
            return producto.getPrecio() * cantidad;
        }
        
        @Override
        public String toString() {
            return cantidad + "x " + producto.getNombre() + 
                   " = $" + String.format("%.2f", obtenerSubtotal());
        }
    }
    
    // ============================================================
    // Pedido (composición de items + agregación de cliente)
    // ============================================================
    public static class Pedido {
        private int id;
        private Cliente cliente;              // AGREGACIÓN
        private ArrayList<ItemPedido> items;  // COMPOSICIÓN
        private LocalDate fecha;
        private String estado;  // "Pendiente", "Procesando", "Enviado", "Entregado"
        private double impuesto;
        
        public Pedido(int id, Cliente cliente) {
            this.id = id;
            this.cliente = cliente;  // Referencia a cliente EXTERNO
            this.items = new ArrayList<>();  // Crea items INTERNAMENTE
            this.fecha = LocalDate.now();
            this.estado = "Pendiente";
            this.impuesto = 0.15;  // 15%
        }
        
        public int getId() { return id; }
        public Cliente getCliente() { return cliente; }
        public String getEstado() { return estado; }
        
        // COMPOSICIÓN: agregar item (se crea con el producto existente)
        public void agregarItem(Producto producto, int cantidad) {
            if (cantidad > 0 && producto.stock >= cantidad) {
                ItemPedido item = new ItemPedido(producto, cantidad);
                items.add(item);
                producto.stock -= cantidad;  // Disminuir stock
                System.out.println("✓ Agregado: " + cantidad + "x " + producto.getNombre());
            } else {
                System.out.println("✗ No hay suficiente stock");
            }
        }
        
        public void removerItem(int indice) {
            if (indice >= 0 && indice < items.size()) {
                ItemPedido item = items.remove(indice);
                item.getProducto().stock += item.getCantidad();
                System.out.println("✓ Item removido");
            }
        }
        
        public void cambiarEstado(String nuevoEstado) {
            this.estado = nuevoEstado;
            System.out.println("✓ Pedido #" + id + " ahora está: " + nuevoEstado);
        }
        
        public double obtenerSubtotal() {
            double suma = 0;
            for (ItemPedido item : items) {
                suma += item.obtenerSubtotal();
            }
            return suma;
        }
        
        public double obtenerImpuesto() {
            return obtenerSubtotal() * impuesto;
        }
        
        public double obtenerTotal() {
            return obtenerSubtotal() + obtenerImpuesto();
        }
        
        public void mostrarDetalles() {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("PEDIDO #" + id);
            System.out.println("=".repeat(50));
            System.out.println("Cliente: " + cliente);
            System.out.println("Fecha: " + fecha);
            System.out.println("Estado: " + estado);
            System.out.println("-".repeat(50));
            
            if (items.isEmpty()) {
                System.out.println("(Sin items)");
            } else {
                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + ". " + items.get(i));
                }
            }
            
            System.out.println("-".repeat(50));
            System.out.println("Subtotal:  $" + String.format("%8.2f", obtenerSubtotal()));
            System.out.println("Impuesto:  $" + String.format("%8.2f", obtenerImpuesto()));
            System.out.println("TOTAL:     $" + String.format("%8.2f", obtenerTotal()));
            System.out.println("=".repeat(50));
        }
    }
    
    // ============================================================
    // SistemaPedidos
    // ============================================================
    public static class SistemaPedidos {
        private ArrayList<Pedido> pedidos;
        private ArrayList<Cliente> clientes;
        private ArrayList<Producto> productos;
        
        public SistemaPedidos() {
            this.pedidos = new ArrayList<>();
            this.clientes = new ArrayList<>();
            this.productos = new ArrayList<>();
        }
        
        public void registrarCliente(Cliente cliente) {
            clientes.add(cliente);
            System.out.println("✓ Cliente registrado: " + cliente.getNombre());
        }
        
        public void agregarProducto(Producto producto) {
            productos.add(producto);
            System.out.println("✓ Producto registrado: " + producto.getNombre());
        }
        
        public Cliente obtenerCliente(int id) {
            for (Cliente c : clientes) {
                if (c.getId() == id) return c;
            }
            return null;
        }
        
        public Producto obtenerProducto(int id) {
            for (Producto p : productos) {
                if (p.getId() == id) return p;
            }
            return null;
        }
        
        public Pedido crearPedido(int idPedido, int idCliente) {
            Cliente cliente = obtenerCliente(idCliente);
            if (cliente != null) {
                Pedido pedido = new Pedido(idPedido, cliente);
                pedidos.add(pedido);
                System.out.println("✓ Pedido creado para " + cliente.getNombre());
                return pedido;
            }
            System.out.println("✗ Cliente no encontrado");
            return null;
        }
        
        public void mostrarResumenVentas() {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("RESUMEN DE VENTAS");
            System.out.println("=".repeat(50));
            System.out.println("Total de pedidos: " + pedidos.size());
            
            double ventaTotal = 0;
            for (Pedido p : pedidos) {
                ventaTotal += p.obtenerTotal();
            }
            
            System.out.println("Venta total: $" + String.format("%.2f", ventaTotal));
            System.out.println("=".repeat(50));
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 3: SISTEMA DE PEDIDOS ===\n");
        
        // Crear sistema
        SistemaPedidos sistema = new SistemaPedidos();
        
        // ============================================================
        // REGISTRAR CLIENTES (AGREGACIÓN)
        // ============================================================
        System.out.println("--- Registrando Clientes ---");
        Cliente c1 = new Cliente(1, "Juan Pérez", "juan@email.com", "555-1234");
        Cliente c2 = new Cliente(2, "María García", "maria@email.com", "555-5678");
        Cliente c3 = new Cliente(3, "Carlos López", "carlos@email.com", "555-9012");
        
        sistema.registrarCliente(c1);
        sistema.registrarCliente(c2);
        sistema.registrarCliente(c3);
        System.out.println();
        
        // ============================================================
        // REGISTRAR PRODUCTOS (REFERENCIAS EXTERNAS)
        // ============================================================
        System.out.println("--- Registrando Productos ---");
        Producto p1 = new Producto(1, "Laptop", 800, 10);
        Producto p2 = new Producto(2, "Mouse", 25, 50);
        Producto p3 = new Producto(3, "Teclado", 75, 30);
        Producto p4 = new Producto(4, "Monitor", 250, 15);
        
        sistema.agregarProducto(p1);
        sistema.agregarProducto(p2);
        sistema.agregarProducto(p3);
        sistema.agregarProducto(p4);
        System.out.println();
        
        // ============================================================
        // CREAR PEDIDO 1 (COMPOSICIÓN)
        // ============================================================
        System.out.println("--- Creando Pedido #1 ---");
        Pedido pedido1 = sistema.crearPedido(1, 1);
        pedido1.agregarItem(p1, 1);  // 1 Laptop
        pedido1.agregarItem(p2, 2);  // 2 Mouse
        pedido1.agregarItem(p3, 1);  // 1 Teclado
        pedido1.mostrarDetalles();
        
        // ============================================================
        // CREAR PEDIDO 2
        // ============================================================
        System.out.println("--- Creando Pedido #2 ---");
        Pedido pedido2 = sistema.crearPedido(2, 2);
        pedido2.agregarItem(p4, 2);  // 2 Monitor
        pedido2.agregarItem(p2, 5);  // 5 Mouse
        pedido2.mostrarDetalles();
        
        // ============================================================
        // CREAR PEDIDO 3
        // ============================================================
        System.out.println("--- Creando Pedido #3 ---");
        Pedido pedido3 = sistema.crearPedido(3, 3);
        pedido3.agregarItem(p1, 2);  // 2 Laptop
        pedido3.agregarItem(p4, 1);  // 1 Monitor
        pedido3.mostrarDetalles();
        
        // ============================================================
        // CAMBIAR ESTADO DE PEDIDOS
        // ============================================================
        System.out.println("--- Actualizando Estados de Pedidos ---");
        pedido1.cambiarEstado("Procesando");
        pedido1.cambiarEstado("Enviado");
        pedido1.cambiarEstado("Entregado");
        
        pedido2.cambiarEstado("Procesando");
        pedido2.cambiarEstado("Enviado");
        
        System.out.println();
        
        // ============================================================
        // MOSTRAR PEDIDO ACTUALIZADO
        // ============================================================
        System.out.println("--- Pedido #1 (Actualizado) ---");
        pedido1.mostrarDetalles();
        
        // ============================================================
        // RESUMEN DE VENTAS
        // ============================================================
        sistema.mostrarResumenVentas();
        
        // ============================================================
        // EXPLICACIÓN
        // ============================================================
        System.out.println("\nNOTA SOBRE EL SISTEMA:");
        System.out.println("AGREGACIÓN: Pedido contiene referencia a Cliente");
        System.out.println("  - El cliente puede existir sin el pedido");
        System.out.println("  - El pedido usa una referencia al cliente externo");
        System.out.println("\nCOMPOSICIÓN: Pedido contiene ItemPedido");
        System.out.println("  - Los items se crean dentro del pedido");
        System.out.println("  - Los items dependen del pedido");
        System.out.println("  - Si se elimina el pedido, se eliminan los items");
    }
}
