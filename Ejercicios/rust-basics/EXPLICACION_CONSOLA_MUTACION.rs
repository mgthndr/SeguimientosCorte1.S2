// ============================================================================
// EXPLICACIÓN: CONSOLA Y MUTACIÓN EN RUST
// ============================================================================
//
// Este archivo explica los conceptos de entrada/salida y mutación.
//
// ============================================================================
// 1. SALIDA A CONSOLA
// ============================================================================
//
// PRINTLN! (con salto de línea):
//    println!("Hola mundo");
//    println!("El valor es: {}", x);
//
// PRINT! (sin salto de línea):
//    print!("Hola ");
//    print!("mundo");  // Imprime en la misma línea
//
// EPRINTLN! (error output):
//    eprintln!("Error: algo salió mal");
//
//
// ============================================================================
// 2. FORMATEO DE SALIDA
// ============================================================================
//
// BÁSICO:
//    println!("#{}(valor);           // {} = display
//    println!("{:?}", valor);        // {:?} = debug (útil para colecciones)
//    println!("{:#?}", valor);       // {:#?} = pretty debug
//
// ALINEACIÓN:
//    println!("{:>10}", "derecha");   // Alineado a derecha
//    println!("{:<10}", "izquierda"); // Alineado a izquierda
//    println!("{:^10}", "centrado");  // Centrado
//
// DECIMALES:
//    let pi = 3.14159;
//    println!("{:.2}", pi);           // 3.14 (2 decimales)
//    println!("{:.5}", pi);           // 3.14159 (5 decimales)
//
// RELLENO CON CEROS:
//    println!("{:05}", 42);           // 00042
//
// MÚLTIPLES PARÁMETROS:
//    println!("{} {} {}", a, b, c);
//    println!("a={}, b={}, c={}", a, b, c);
//
//
// ============================================================================
// 3. ENTRADA DESDE CONSOLA
// ============================================================================
//
// MÓDULO NECESARIO:
//    use std::io;
//    use std::io::Read;
//
// LEER LÍNEA:
//    let mut input = String::new();
//    io::stdin().read_line(&mut input)
//        .expect("Error leyendo línea");
//    
//    let valor_limpio = input.trim();  // Quita espacios y \n
//
// PARSING (Convertir a número):
//    match input.trim().parse::<i32>() {
//        Ok(numero) => println!("Número: {}", numero),
//        Err(_) => println!("Error al parsear"),
//    }
//
// FUNCIÓN AUXILIAR:
//    fn leer_numero() -> i32 {
//        loop {
//            let mut input = String::new();
//            io::stdin().read_line(&mut input).unwrap();
//            
//            match input.trim().parse::<i32>() {
//                Ok(n) => return n,
//                Err(_) => println!("Intenta de nuevo"),
//            }
//        }
//    }
//
//
// ============================================================================
// 4. MUTABILIDAD EN RUST
// ============================================================================
//
// INMUTABLE (por defecto):
//    let x = 5;
//    x = 10;  // ERROR
//
// MUTABLE (con mut):
//    let mut x = 5;
//    x = 10;  // OK
//    x += 5;  // OK
//
// VENTAJAS DE LA INMUTABILIDAD:
// - Seguridad: No cambia sin intención
// - Concurrencia: Múltiples threads pueden leerlo
// - Claridad: El código es más predecible
//
// VENTAJAS DE LA MUTABILIDAD:
// - Flexibilidad: Cambiar valores cuando necesites
// - Eficiencia: No crear nuevos objetos cada vez
//
//
// ============================================================================
// 5. MUTACIÓN DE TIPOS
// ============================================================================
//
// NÚMEROS:
//    let mut x = 5;
//    x += 1;  // x = 6
//    x *= 2;  // x = 12
//
// STRINGS:
//    let mut s = String::from("Hola");
//    s.push_str(" Mundo");     // Agrega al final
//    s.push('!');              // Agrega un carácter
//    s = String::from("Nuevo"); // Reemplazar completamente
//
// VECTORES:
//    let mut v = vec![1, 2, 3];
//    v.push(4);                 // Agregar al final
//    v.pop();                   // Remover último
//    v[0] = 10;                 // Cambiar elemento
//    v.clear();                 // Limpiar todo
//
// COLECCIONES (HashMap):
//    let mut mapa = HashMap::new();
//    mapa.insert("Juan", 25);   // Insertar
//    mapa.remove("Juan");       // Remover
//
//
// ============================================================================
// 6. REFERENCIAS MUTABLES (&mut)
// ============================================================================
//
// Permitir cambios a través de una referencia:
//
//    fn incrementar(x: &mut i32) {
//        *x += 1;  // * = desreferenciar
//    }
//
//    let mut valor = 10;
//    incrementar(&mut valor);  // Pasar referencia mutable
//
// REGLA IMPORTANTE:
// - NO puedes tener múltiples referencias mutables al mismo tiempo
// - SÍ puedes tener múltiples referencias inmutables
// - NO puedes mezclar mutable e inmutable al mismo tiempo
//
//    let mut x = 5;
//    let r1 = &mut x;  // OK
//    let r2 = &mut x;  // ERROR: x ya está prestada (mutablemente)
//
//    let mut y = 10;
//    let r1 = &y;      // OK
//    let r2 = &y;      // OK (múltiples inmutables)
//    let r3 = &mut y;  // ERROR: y está prestada (inmutablemente)
//
//
// ============================================================================
// 7. MUTACIÓN EN ESTRUCTURAS
// ============================================================================
//
// Si quieres mutar un struct, todo el struct debe ser mut:
//
//    struct Persona {
//        nombre: String,
//        edad: u32,
//    }
//
//    let mut p = Persona {
//        nombre: String::from("Juan"),
//        edad: 25,
//    };
//
//    p.edad = 26;  // OK (Persona es mut)
//
// MÉTODOS MUTABLES:
//
//    impl Persona {
//        fn cumplir_años(&mut self) {  // &mut self
//            self.edad += 1;
//        }
//    }
//
//    let mut p = Persona { ... };
//    p.cumplir_años();  // p debe ser mut
//
//
// ============================================================================
// 8. ITERADORES MUTABLES
// ============================================================================
//
// Modificar elementos mientras iteras:
//
//    let mut numeros = vec![1, 2, 3];
//
//    for n in &mut numeros {  // &mut para referencia mutable
//        *n *= 2;             // * desreferencia
//    }
//
//    println!("{:?}", numeros);  // [2, 4, 6]
//
//
// ============================================================================
// 9. DESREFERENCIACIÓN
// ============================================================================
//
// El operador * obtiene el valor de una referencia:
//
//    let x = 5;
//    let r = &x;          // r es una referencia a x
//    println!("{}", *r);  // Imprime 5 (desreferencia)
//
// Con referencias mutables:
//
//    let mut x = 5;
//    let r = &mut x;
//    *r = 10;  // Cambiar el valor original
//    println!("{}", x);  // 10
//
//
// ============================================================================
// 10. PATRÓN COMÚN: MODIFICAR POR REFERENCIA
// ============================================================================
//
// Pasar una referencia mutable a una función:
//
//    fn cambiar_valores(v: &mut Vec<i32>) {
//        for elemento in v {
//            *elemento *= 2;
//        }
//    }
//
//    let mut numeros = vec![1, 2, 3];
//    cambiar_valores(&mut numeros);
//    println!("{:?}", numeros);  // [2, 4, 6]
//
// VENTAJAS:
// - No necesitas retornar el valor
// - Eficiente: No copias datos
// - Claro: La función puede modificar datos
//
//
// ============================================================================

fn main() {
    println!("======================================================");
    println!("  CONSOLA Y MUTACIÓN EN RUST");
    println!("======================================================\n");
    
    println!("SALIDA A CONSOLA:");
    println!("  - println!() = con salto");
    println!("  - print!() = sin salto");
    println!("  - Formateo: {{}}, {{:?}}, {{:.2}}, etc.\n");
    
    println!("ENTRADA DE CONSOLA:");
    println!("  - use std::io;");
    println!("  - io::stdin().read_line(&mut input)");
    println!("  - input.trim().parse::<tipo>()\n");
    
    println!("MUTABILIDAD:");
    println!("  - let x = 5;       (inmutable)");
    println!("  - let mut x = 5;   (mutable)");
    println!("  - &mut referencia (mutable)\n");
    
    println!("REFERENCIAS MUTABLES:");
    println!("  - &mut T (referencia mutable)");
    println!("  - *referencia (desreferenciar)\n");
    
    println!("MUTACIÓN DE TIPOS:");
    println!("  - String: push_str(), push()");
    println!("  - Vec: push(), pop(), [índice]");
    println!("  - Struct: campo mutable\n");
    
    println!("Ver Ejemplo4.rs para entrada/salida");
    println!("Ver Ejemplo5.rs para mutación");
}
