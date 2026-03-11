// ============================================================================
// CONCEPTOS BÁSICOS DE RUST
// ============================================================================
// 
// Este archivo explica los conceptos fundamentales de Rust.
//
// ============================================================================
// 1. VARIABLES Y MUTABILIDAD
// ============================================================================
//
// En Rust, las variables son INMUTABLES por defecto.
//
// INMUTABLE (por defecto):
//    let x = 5;
//    x = 10;  // ERROR: no puedes cambiar x
//
// MUTABLE (con mut):
//    let mut x = 5;
//    x = 10;  // OK
//
// CONSTANTES (nunca cambian):
//    const PI: f64 = 3.14159;
//
//
// ============================================================================
// 2. TIPOS DE DATOS
// ============================================================================
//
// ENTEROS:
//    i32  = entero de 32 bits (con signo)
//    u32  = entero de 32 bits (sin signo)
//    i64  = entero de 64 bits
//
// DECIMALES:
//    f32  = número flotante de 32 bits
//    f64  = número flotante de 64 bits
//
// BOOLEANOS:
//    true o false
//
// CARACTERES:
//    'a', 'Z', '1'  (comillas simples)
//
// STRINGS:
//    "Hola"         (comillas dobles, inmutable)
//    String::from("Hola")  (mutable)
//
//
// ============================================================================
// 3. INFERENCIA DE TIPOS
// ============================================================================
//
// Rust intenta inferir el tipo automáticamente:
//
//    let x = 5;              // Rust infiere: i32
//    let y = 5.0;            // Rust infiere: f64
//    let z = "Hola";         // Rust infiere: &str
//
// Pero puedes especificar el tipo explícitamente:
//
//    let x: u32 = 5;
//    let y: f32 = 5.0;
//
//
// ============================================================================
// 4. FUNCIONES
// ============================================================================
//
// Sintaxis básica:
//
//    fn nombre_funcion(parámetro1: tipo1, parámetro2: tipo2) -> tipo_retorno {
//        // código
//        valor_retorno  // sin punto y coma = return implícito
//    }
//
// Ejemplos:
//
//    fn sumar(a: i32, b: i32) -> i32 {
//        a + b  // Sin ; devuelve el valor
//    }
//
//    fn saludar(nombre: &str) {  // &str = referencia a string
//        println!("Hola, {}", nombre);
//    }
//
//
// ============================================================================
// 5. CONTROL DE FLUJO
// ============================================================================
//
// IF / ELSE:
//
//    if edad >= 18 {
//        println!("Eres adulto");
//    } else {
//        println!("Eres menor");
//    }
//
// IF COMO EXPRESIÓN:
//
//    let mensaje = if edad >= 18 {
//        "Adulto"
//    } else {
//        "Menor"
//    };
//
//
// ============================================================================
// 6. CICLOS
// ============================================================================
//
// LOOP infinito:
//
//    loop {
//        println!("Infinito");
//        break;  // Salir del ciclo
//    }
//
// WHILE:
//
//    let mut contador = 0;
//    while contador < 5 {
//        println!("{}", contador);
//        contador += 1;
//    }
//
// FOR (rango):
//
//    for i in 0..5 {  // 0, 1, 2, 3, 4 (5 NO se incluye)
//        println!("{}", i);
//    }
//
//    for i in 0..=5 {  // 0, 1, 2, 3, 4, 5 (5 SÍ se incluye)
//        println!("{}", i);
//    }
//
//
// ============================================================================
// 7. ARRAYS Y VECTORES
// ============================================================================
//
// ARRAY (tamaño fijo, en stack):
//
//    let numeros: [i32; 5] = [1, 2, 3, 4, 5];
//    //           [tipo; tamaño]
//
//    println!("{}", numeros[0]);  // 1
//
// VECTOR (tamaño dinámico, en heap):
//
//    let mut numeros = vec![1, 2, 3, 4, 5];
//    numeros.push(6);      // Agregar elemento
//    numeros.pop();        // Remover último
//    println!("{}", numeros.len());  // Longitud
//
//
// ============================================================================
// 8. OWNERSHIP (Propiedad)
// ============================================================================
//
// Rust tiene 3 reglas de memoria:
//
// 1. Cada valor tiene un PROPIETARIO
// 2. Solo puede haber un PROPIETARIO a la vez
// 3. Cuando el propietario sale del scope, el valor se libera
//
// Ejemplo:
//
//    let s1 = String::from("Hola");
//    let s2 = s1;  // s1 "se mueve" a s2
//    
//    println!("{}", s1);  // ERROR: s1 ya no es propietario
//    println!("{}", s2);  // OK: s2 es ahora el propietario
//
//
// ============================================================================
// 9. BORROWING (Préstamo)
// ============================================================================
//
// En lugar de mover, puedes "pedir prestado" con &:
//
// REFERENCIA INMUTABLE (&):
//
//    let s1 = String::from("Hola");
//    let s2 = &s1;  // Pedir prestado (inmutable)
//    
//    println!("{}", s1);  // OK
//    println!("{}", s2);  // OK
//
// REFERENCIA MUTABLE (&mut):
//
//    let mut s1 = String::from("Hola");
//    let s2 = &mut s1;  // Pedir prestado (mutable)
//    s2.push_str(" Mundo");
//    
//    println!("{}", s1);  // "Hola Mundo"
//
//
// ============================================================================
// 10. ESTRUCTURAS (STRUCTS)
// ============================================================================
//
// Agrupar datos relacionados:
//
//    struct Persona {
//        nombre: String,
//        edad: u32,
//    }
//
// Crear instancia:
//
//    let p = Persona {
//        nombre: String::from("Juan"),
//        edad: 25,
//    };
//
// Acceder a campos:
//
//    println!("{}", p.nombre);
//    println!("{}", p.edad);
//
//
// ============================================================================
// 11. PATTERN MATCHING (match)
// ============================================================================
//
// Similar a switch en otros lenguajes:
//
//    let numero = 2;
//    
//    match numero {
//        1 => println!("Uno"),
//        2 => println!("Dos"),
//        3 => println!("Tres"),
//        _ => println!("Otro"),  // _ es el caso default
//    }
//
//
// ============================================================================
// 12. ENUMS
// ============================================================================
//
// Tipo que puede ser uno de varios valores:
//
//    enum Resultado {
//        Éxito,
//        Error,
//    }
//
//    let res = Resultado::Éxito;
//
// Con datos asociados:
//
//    enum ResultadoConDatos {
//        Éxito(String),
//        Error(String),
//    }
//
//    let res = ResultadoConDatos::Éxito("OK".to_string());
//
//
// ============================================================================

fn main() {
    println!("============================================================");
    println!("  CONCEPTOS BÁSICOS DE RUST");
    println!("============================================================\n");
    
    println!("1. VARIABLES: let, mut, const");
    println!("2. TIPOS: i32, u32, f64, bool, char, String");
    println!("3. FUNCIONES: fn nombre(param: tipo) -> tipo");
    println!("4. CONTROL: if/else, match");
    println!("5. CICLOS: loop, while, for\n");
    
    println!("6. ARRAYS: Tamaño fijo");
    println!("7. VECTORES: Tamaño dinámico");
    println!("8. OWNERSHIP: Propiedad de datos");
    println!("9. BORROWING: Préstamo con &\n");
    
    println!("10. STRUCTS: Agrupar datos");
    println!("11. ENUMS: Valores alternativos");
    println!("12. PATTERN MATCHING: match expresión");
    println!("\nRevisa los ejemplos Ejemplo1.rs, Ejemplo2.rs y Ejemplo3.rs");
}
