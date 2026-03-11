// ============================================================================
// EJEMPLO 2: CONTROL DE FLUJO Y CICLOS
// ============================================================================

fn obtener_categoria(edad: u32) -> &'static str {
    if edad < 13 {
        "Niño"
    } else if edad < 18 {
        "Adolescente"
    } else if edad < 65 {
        "Adulto"
    } else {
        "Adulto Mayor"
    }
}

fn es_par(numero: i32) -> bool {
    numero % 2 == 0
}

fn calificar(nota: u32) -> &'static str {
    match nota {
        90..=100 => "A - Excelente",
        80..=89 => "B - Muy Bueno",
        70..=79 => "C - Bueno",
        60..=69 => "D - Pasable",
        _ => "F - Reprobado",
    }
}

fn main() {
    println!("=== EJEMPLO 2: CONTROL DE FLUJO Y CICLOS ===\n");
    
    // ============================================================
    // IF / ELSE
    // ============================================================
    println!("--- IF / ELSE ---");
    
    let edad = 25;
    let categoria = obtener_categoria(edad);
    println!("Edad {}: {}\n", edad, categoria);
    
    let edad_menor = 12;
    let categoria_menor = obtener_categoria(edad_menor);
    println!("Edad {}: {}\n", edad_menor, categoria_menor);
    
    // ============================================================
    // IF COMO EXPRESIÓN
    // ============================================================
    println!("--- IF como Expresión ---");
    
    let numero = 10;
    let mensaje = if es_par(numero) {
        "es par"
    } else {
        "es impar"
    };
    println!("{} {}\n", numero, mensaje);
    
    // ============================================================
    // MATCH (Pattern Matching)
    // ============================================================
    println!("--- MATCH/Pattern Matching ---");
    
    let nota = 95;
    println!("Nota {}: {}\n", nota, calificar(nota));
    
    let nota_baja = 65;
    println!("Nota {}: {}\n", nota_baja, calificar(nota_baja));
    
    // ============================================================
    // FOR CON RANGO
    // ============================================================
    println!("--- FOR con Rango ---");
    
    println!("Números del 1 al 5:");
    for i in 1..=5 {
        println!("  {}", i);
    }
    println!();
    
    // ============================================================
    // FOR CON ARRAY
    // ============================================================
    println!("--- FOR con Array ---");
    
    let numeros = [10, 20, 30, 40, 50];
    println!("Array: {:?}", numeros);
    println!("Elementos:");
    for num in &numeros {
        println!("  {}", num);
    }
    println!();
    
    // ============================================================
    // FOR CON ENUMERACIÓN
    // ============================================================
    println!("--- FOR con Enumeración ---");
    
    let nombres = ["Juan", "María", "Pedro"];
    for (indice, nombre) in nombres.iter().enumerate() {
        println!("  [{}] {}", indice, nombre);
    }
    println!();
    
    // ============================================================
    // WHILE
    // ============================================================
    println!("--- WHILE ---");
    
    let mut contador = 1;
    println!("Conteo con WHILE:");
    while contador <= 5 {
        println!("  contador = {}", contador);
        contador += 1;
    }
    println!();
    
    // ============================================================
    // LOOP CON BREAK Y CONTINUE
    // ============================================================
    println!("--- LOOP con BREAK y CONTINUE ---");
    
    let mut num = 0;
    println!("Números pares entre 0 y 10:");
    loop {
        num += 1;
        
        if num > 10 {
            break;
        }
        
        if num % 2 != 0 {
            continue;  // Saltar si es impar
        }
        
        println!("  {}", num);
    }
    println!();
    
    // ============================================================
    // LOOP CON RETORNO DE VALOR
    // ============================================================
    println!("--- LOOP con Retorno ---");
    
    let mut x = 0;
    let resultado = loop {
        x += 1;
        
        if x * x >= 100 {
            break x * x;  // Romper y retornar valor
        }
    };
    println!("Primer cuadrado >= 100: {}\n", resultado);
    
    // ============================================================
    // ANIDACIÓN DE CICLOS
    // ============================================================
    println!("--- Tabla de Multiplicar ---");
    
    for i in 1..=3 {
        for j in 1..=3 {
            print!("{}x{} = {:2}  ", i, j, i * j);
        }
        println!();
    }
}
