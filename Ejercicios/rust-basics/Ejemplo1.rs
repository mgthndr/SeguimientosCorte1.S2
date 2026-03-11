// ============================================================================
// EJEMPLO 1: VARIABLES, TIPOS Y FUNCIONES
// ============================================================================

// Función que suma dos números
fn sumar(a: i32, b: i32) -> i32 {
    a + b  // Sin ; = return implícito
}

// Función que saluda
fn saludar(nombre: &str) {
    println!("¡Hola, {}!", nombre);
}

// Función que calcula el área de un rectángulo
fn calcular_area(ancho: f64, alto: f64) -> f64 {
    ancho * alto
}

fn main() {
    println!("=== EJEMPLO 1: VARIABLES, TIPOS Y FUNCIONES ===\n");
    
    // ============================================================
    // VARIABLES INMUTABLES
    // ============================================================
    println!("--- Variables Inmutables ---");
    
    let x = 5;  // i32 inferido
    let y = 3.14;  // f64 inferido
    let nombre = "Rust";  // &str inferido
    let activo = true;  // bool inferido
    
    println!("x = {}", x);
    println!("y = {}", y);
    println!("nombre = {}", nombre);
    println!("activo = {}", activo);
    println!();
    
    // ============================================================
    // VARIABLES MUTABLES
    // ============================================================
    println!("--- Variables Mutables ---");
    
    let mut contador = 0;
    println!("Contador inicial: {}", contador);
    
    contador = 5;
    println!("Contador después: {}", contador);
    
    contador += 3;
    println!("Contador + 3: {}", contador);
    println!();
    
    // ============================================================
    // TIPOS EXPLÍCITOS
    // ============================================================
    println!("--- Tipos Explícitos ---");
    
    let entero: i32 = 42;
    let decimal: f64 = 3.14159;
    let texto: &str = "Hola Rust";
    let booleano: bool = false;
    
    println!("Entero (i32): {}", entero);
    println!("Decimal (f64): {}", decimal);
    println!("Texto (&str): {}", texto);
    println!("Booleano: {}", booleano);
    println!();
    
    // ============================================================
    // LLAMADAS A FUNCIONES
    // ============================================================
    println!("--- Funciones ---");
    
    let suma = sumar(10, 20);
    println!("10 + 20 = {}", suma);
    
    saludar("Juan");
    saludar("María");
    
    let area = calcular_area(5.0, 4.0);
    println!("Área del rectángulo: {}", area);
    println!();
    
    // ============================================================
    // CONSTANTES
    // ============================================================
    println!("--- Constantes ---");
    
    const PI: f64 = 3.14159;
    const VELOCIDAD_LUZ: u32 = 300000;
    
    println!("PI = {}", PI);
    println!("Velocidad de la luz = {} km/s", VELOCIDAD_LUZ);
    println!();
    
    // ============================================================
    // SOMBREADO (Shadowing)
    // ============================================================
    println!("--- Sombreado (Shadowing) ---");
    
    let valor = 5;
    println!("Valor original: {}", valor);
    
    let valor = valor + 1;
    println!("Valor después del sombreado: {}", valor);
    
    let valor = "ahora es texto";
    println!("Valor con tipo diferente: {}", valor);
}
