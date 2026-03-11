// ============================================================================
// EJEMPLO 4: CONSOLA - ENTRADA Y SALIDA
// ============================================================================
//
// Para usar entrada de consola, necesitas agregar esta dependencia en Cargo.toml:
// [dependencies]
// std = { path = "" }  // std ya está en Rust
//
// La entrada desde consola se hace con std::io::stdin()
//

use std::io;

fn leer_string(mensaje: &str) -> String {
    println!("{}", mensaje);
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Error leyendo");
    input.trim().to_string()
}

fn leer_numero(mensaje: &str) -> i32 {
    loop {
        let input = leer_string(mensaje);
        match input.parse::<i32>() {
            Ok(numero) => return numero,
            Err(_) => println!("Error: Ingresa un número válido"),
        }
    }
}

fn main() {
    println!("=== EJEMPLO 4: CONSOLA - ENTRADA Y SALIDA ===\n");
    
    // ============================================================
    // PRINTLN! - SALIDA BÁSICA
    // ============================================================
    println!("--- Salida Básica con println! ---");
    print!("Sin salto de línea ");
    println!("con salto de línea");
    println!();
    
    // ============================================================
    // FORMATEO DE SALIDA
    // ============================================================
    println!("--- Formateo de Salida ---");
    
    let nombre = "Juan";
    let edad = 25;
    let altura = 1.75;
    
    println!("Nombre: {}", nombre);
    println!("Edad: {}", edad);
    println!("Altura: {}", altura);
    println!();
    
    // Múltiples parámetros
    println!("Mi nombre es {} y tengo {} años", nombre, edad);
    println!();
    
    // ============================================================
    // FORMATEO AVANZADO
    // ============================================================
    println!("--- Formateo Avanzado ---");
    
    // Alineación
    println!("Alineado a derecha:    {:>10}", "Texto");
    println!("Alineado a izquierda:  {:<10}", "Texto");
    println!("Centrado:              {:^10}", "Texto");
    println!();
    
    // Decimales
    let pi = 3.14159265;
    println!("Pi con 2 decimales: {:.2}", pi);
    println!("Pi con 5 decimales: {:.5}", pi);
    println!();
    
    // Pad con ceros
    let numero = 42;
    println!("Número con pad: {:05}", numero);
    println!();
    
    // Debug ({:?})
    let vector = vec![1, 2, 3, 4, 5];
    println!("Vector: {:?}", vector);
    println!();
    
    // Pretty print ({:#?})
    println!("Vector bonito:");
    println!("{:#?}", vector);
    println!();
    
    // ============================================================
    // ENTRADA DESDE CONSOLA
    // ============================================================
    println!("--- Entrada desde Consola ---");
    
    // Leer línea completa
    println!("Escribe tu nombre:");
    let mut nombre_ingresado = String::new();
    io::stdin()
        .read_line(&mut nombre_ingresado)
        .expect("Error leyendo línea");
    
    let nombre_limpio = nombre_ingresado.trim();
    println!("¡Hola, {}!\n", nombre_limpio);
    
    // ============================================================
    // LEER NÚMEROS
    // ============================================================
    println!("--- Leer Números ---");
    
    println!("Ingresa un número:");
    let mut entrada = String::new();
    io::stdin()
        .read_line(&mut entrada)
        .expect("Error leyendo");
    
    match entrada.trim().parse::<i32>() {
        Ok(numero) => {
            println!("Número ingresado: {}", numero);
            println!("El doble es: {}", numero * 2);
            println!();
        }
        Err(_) => println!("No es un número válido"),
    }
    
    // ============================================================
    // FUNCIONES AUXILIARES
    // ============================================================
    println!("--- Usando Funciones Auxiliares ---");
    
    let usuario = leer_string("¿Cuál es tu nombre?");
    let edad_usuario = leer_numero("¿Cuántos años tienes?");
    
    println!("\nDatos ingresados:");
    println!("  Nombre: {}", usuario);
    println!("  Edad: {}", edad_usuario);
    println!();
    
    // ============================================================
    // TABLA DE MULTIPLICAR INTERACTIVA
    // ============================================================
    println!("--- Tabla de Multiplicar Interactiva ---");
    
    let numero_tabla = leer_numero("¿De qué número deseas la tabla?");
    
    println!("\nTabla del {}:", numero_tabla);
    for i in 1..=10 {
        println!("  {} x {} = {}", numero_tabla, i, numero_tabla * i);
    }
    println!();
    
    // ============================================================
    // CALCULADORA SIMPLE
    // ============================================================
    println!("--- Mini Calculadora ---");
    
    let num1 = leer_numero("Ingresa el primer número:");
    let num2 = leer_numero("Ingresa el segundo número:");
    
    println!("\nResultados:");
    println!("  {} + {} = {}", num1, num2, num1 + num2);
    println!("  {} - {} = {}", num1, num2, num1 - num2);
    println!("  {} × {} = {}", num1, num2, num1 * num2);
    if num2 != 0 {
        println!("  {} ÷ {} = {}", num1, num2, num1 / num2);
    }
}
