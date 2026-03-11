/*
 * EJEMPLO 3: MUTACIÓN CONTROLADA
 * 
 * Demuestra cómo los setters controlan la mutación de objetos.
 */

import java.util.ArrayList;

public class Ejemplo3 {
    
    // ============================================================
    // CLASE: Carrito de Compras
    // ============================================================
    public static class Carrito {
        private ArrayList<Articulo> articulos;
        private double descuento;
        
        // Clase interna: Articulo
        public static class Articulo {
            private String nombre;
            private double precio;
            private int cantidad;
            
            public Articulo(String nombre, double precio, int cantidad) {
                this.nombre = nombre;
                this.precio = precio;
                this.cantidad = cantidad;
            }
            
            public double obtenerSubtotal() {
                return precio * cantidad;
            }
            
            @Override
            public String toString() {
                return nombre + " - $" + String.format("%.2f", precio) + 
                       " x" + cantidad + " = $" + String.format("%.2f", obtenerSubtotal());
            }
        }
        
        // CONSTRUCTOR
        public Carrito() {
            this.articulos = new ArrayList<>();
            this.descuento = 0;
        }
        
        // GETTERS
        public int getCantidadArticulos() {
            return articulos.size();
        }
        
        public double getDescuento() {
            return descuento;
        }
        
        // SETTER CON VALIDACIÓN
        public void setDescuento(double descuento) {
            if (descuento >= 0 && descuento <= 100) {
                this.descuento = descuento;
                System.out.println("Descuento actualizado a: " + descuento + "%");
            } else {
                System.out.println("Error: Descuento debe estar entre 0 y 100");
            }
        }
        
        // MUTADORES (métodos que cambian el estado)
        public void agregarArticulo(String nombre, double precio, int cantidad) {
            if (precio > 0 && cantidad > 0) {
                articulos.add(new Articulo(nombre, precio, cantidad));
                System.out.println("✓ Agregado: " + nombre);
            }
        }
        
        public void modificarCantidad(int indice, int nuevaCantidad) {
            if (indice >= 0 && indice < articulos.size()) {
                if (nuevaCantidad > 0) {
                    articulos.get(indice).cantidad = nuevaCantidad;
                    System.out.println("✓ Cantidad actualizada");
                } else if (nuevaCantidad == 0) {
                    articulos.remove(indice);
                    System.out.println("✓ Artículo removido");
                }
            }
        }
        
        public void vaciarCarrito() {
            articulos.clear();
            descuento = 0;
            System.out.println("✓ Carrito vaciado");
        }
        
        // CALCULADORES
        public double obtenerSubtotal() {
            double suma = 0;
            for (Articulo a : articulos) {
                suma += a.obtenerSubtotal();
            }
            return suma;
        }
        
        public double obtenerTotal() {
            double subtotal = obtenerSubtotal();
            double descuentoAplicado = subtotal * (descuento / 100);
            return subtotal - descuentoAplicado;
        }
        
        public void mostrar() {
            System.out.println("===== CARRITO =====");
            if (articulos.isEmpty()) {
                System.out.println("(carrito vacío)");
            } else {
                for (int i = 0; i < articulos.size(); i++) {
                    System.out.println(i + ". " + articulos.get(i));
                }
            }
            System.out.println("Subtotal: $" + String.format("%.2f", obtenerSubtotal()));
            System.out.println("Descuento: " + descuento + "%");
            System.out.println("Total: $" + String.format("%.2f", obtenerTotal()));
            System.out.println();
        }
    }
    
    
    // ============================================================
    // CLASE: Videojuego
    // ============================================================
    public static class Videojuego {
        private String titulo;
        private int anioLanzamiento;
        private int puntuacion;
        private ArrayList<String> comentarios;
        private boolean completado;
        
        public Videojuego(String titulo, int anio) {
            this.titulo = titulo;
            this.anioLanzamiento = anio;
            this.puntuacion = 0;
            this.comentarios = new ArrayList<>();
            this.completado = false;
        }
        
        // GETTERS
        public String getTitulo() { return titulo; }
        public int getAnioLanzamiento() { return anioLanzamiento; }
        public int getPuntuacion() { return puntuacion; }
        public boolean estaCompletado() { return completado; }
        
        // SETTERS CON VALIDACIÓN
        public void setPuntuacion(int puntuacion) {
            if (puntuacion >= 1 && puntuacion <= 10) {
                this.puntuacion = puntuacion;
                System.out.println("✓ Puntuación actualizada a: " + puntuacion + "/10");
            }
        }
        
        public void setCompletado(boolean completado) {
            this.completado = completado;
            if (completado) {
                System.out.println("✓ " + titulo + " marcado como completado");
            }
        }
        
        // MUTADORES
        public void agregarComentario(String comentario) {
            comentarios.add(comentario);
            System.out.println("✓ Comentario agregado");
        }
        
        public void mostrarDetalles() {
            System.out.println("----- " + titulo + " -----");
            System.out.println("Año: " + anioLanzamiento);
            System.out.println("Puntuación: " + puntuacion + "/10");
            System.out.println("Estado: " + (completado ? "Completado" : "En progreso"));
            if (!comentarios.isEmpty()) {
                System.out.println("Comentarios:");
                for (String c : comentarios) {
                    System.out.println("  - " + c);
                }
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO 3: MUTACIÓN CONTROLADA ===\n");
        
        // ============================================================
        // EJEMPLO 1: Carrito de Compras
        // ============================================================
        System.out.println("--- Carrito de Compras ---\n");
        
        Carrito carrito = new Carrito();
        
        System.out.println("1. Agregar artículos:");
        carrito.agregarArticulo("Laptop", 800, 1);
        carrito.agregarArticulo("Mouse", 25, 2);
        carrito.agregarArticulo("Teclado", 75, 1);
        System.out.println();
        
        carrito.mostrar();
        
        System.out.println("2. Aplicar descuento:");
        carrito.setDescuento(10);
        System.out.println();
        carrito.mostrar();
        
        System.out.println("3. Modificar cantidad de Mouse:");
        carrito.modificarCantidad(1, 5);
        System.out.println();
        carrito.mostrar();
        
        System.out.println("4. Intentar descuento inválido:");
        carrito.setDescuento(150);  // Rechazado
        System.out.println();
        
        System.out.println("5. Aplicar descuento válido del 20%:");
        carrito.setDescuento(20);
        System.out.println();
        carrito.mostrar();
        
        System.out.println("6. Remover un artículo:");
        carrito.modificarCantidad(0, 0);  // Remover con cantidad 0
        System.out.println();
        carrito.mostrar();
        
        // ============================================================
        // EJEMPLO 2: Videojuegos
        // ============================================================
        System.out.println("--- Biblioteca de Videojuegos ---\n");
        
        Videojuego juego1 = new Videojuego("The Legend of Zelda", 2023);
        Videojuego juego2 = new Videojuego("Elden Ring", 2022);
        Videojuego juego3 = new Videojuego("Super Mario Bros", 2023);
        
        System.out.println("Adquirir juegos:\n");
        
        System.out.println("Jugando: The Legend of Zelda");
        juego1.setPuntuacion(9);
        juego1.agregarComentario("Increíble juego, muy largo");
        juego1.agregarComentario("Los puzzles son desafiantes pero divertidos");
        juego1.setCompletado(true);
        System.out.println();
        juego1.mostrarDetalles();
        
        System.out.println("Jugando: Elden Ring");
        juego2.setPuntuacion(8);
        juego2.agregarComentario("Muy difícil pero adictivo");
        System.out.println();
        juego2.mostrarDetalles();
        
        System.out.println("Jugando: Super Mario Bros");
        juego3.setPuntuacion(10);
        juego3.agregarComentario("Clásico del género");
        juego3.agregarComentario("Perfecto para jugar en cualquier momento");
        juego3.setCompletado(true);
        System.out.println();
        juego3.mostrarDetalles();
        
        // ============================================================
        // EJEMPLO 3: Validación de cambios
        // ============================================================
        System.out.println("--- Intentar cambios inválidos ---\n");
        
        Videojuego juego4 = new Videojuego("Test Game", 2023);
        
        System.out.println("Intentar puntuación 15 (rango: 1-10):");
        juego4.setPuntuacion(15);  // No se cambia
        System.out.println("Puntuación actual: " + juego4.getPuntuacion() + "\n");
        
        System.out.println("Intentar puntuación 0 (rango: 1-10):");
        juego4.setPuntuacion(0);  // No se cambia
        System.out.println("Puntuación actual: " + juego4.getPuntuacion() + "\n");
        
        System.out.println("Asignar puntuación 7 (válida):");
        juego4.setPuntuacion(7);  // Se cambia
        System.out.println("Puntuación actual: " + juego4.getPuntuacion());
    }
}
