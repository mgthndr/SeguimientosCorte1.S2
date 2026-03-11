// ============================================================================
// EJEMPLO 3: ARRAYS, VECTORES, STRUCTS Y OWNERSHIP
// ============================================================================

// Definir una estructura
struct Persona {
    nombre: String,
    edad: u32,
}

// Implementar métodos para la estructura
impl Persona {
    fn presentarse(&self) {
        println!("Hola, me llamo {} y tengo {} años", self.nombre, self.edad);
    }

    fn cumplir_años(&mut self) {
        self.edad += 1;
        println!("{} ahora tiene {} años", self.nombre, self.edad);
    }
}

fn imprimir_vector(numeros: &Vec<i32>) {
    println!("Vector: {:?}", numeros);
    println!("Longitud: {}\n", numeros.len());
}

fn sumar_elementos(numeros: &Vec<i32>) -> i32 {
    let mut suma = 0;
    for num in numeros {
        suma += num;
    }
    suma
}

fn main() {
    println!("=== EJEMPLO 3: ARRAYS, VECTORES, STRUCTS Y OWNERSHIP ===\n");
    
    // ============================================================
    // ARRAYS (Tamaño fijo)
    // ============================================================
    println!("--- ARRAYS ---");
    
    let numeros: [i32; 5] = [1, 2, 3, 4, 5];
    println!("Array: {:?}", numeros);
    println!("Primer elemento: {}", numeros[0]);
    println!("Último elemento: {}", numeros[4]);
    println!("Longitud: {}", numeros.len());
    println!();
    
    // ============================================================
    // RECORRER ARRAY
    // ============================================================
    println!("--- Recorrer Array ---");
    for (indice, valor) in numeros.iter().enumerate() {
        println!("  [{}] = {}", indice, valor);
    }
    println!();
    
    // ============================================================
    // VECTORES (Tamaño dinámico)
    // ============================================================
    println!("--- VECTORES ---");
    
    let mut números_din = vec![10, 20, 30];
    println!("Vector inicial: {:?}", números_din);
    
    números_din.push(40);
    println!("Después de push(40): {:?}", números_din);
    
    números_din.push(50);
    println!("Después de push(50): {:?}", números_din);
    println!();
    
    // ============================================================
    // POP - Remover último elemento
    // ============================================================
    println!("--- Remover elementos ---");
    
    if let Some(ultimo) = números_din.pop() {
        println!("Removido: {}", ultimo);
        println!("Vector ahora: {:?}\n", números_din);
    }
    
    // ============================================================
    // OPERACIONES CON VECTORES
    // ============================================================
    println!("--- Operaciones con Vectores ---");
    
    let valores = vec![5, 10, 15, 20, 25];
    imprimir_vector(&valores);
    
    let suma_total = sumar_elementos(&valores);
    println!("Suma de elementos: {}\n", suma_total);
    
    // ============================================================
    // STRUCTS (Estructuras)
    // ============================================================
    println!("--- STRUCTS ---");
    
    let p1 = Persona {
        nombre: String::from("Juan"),
        edad: 25,
    };
    
    let p2 = Persona {
        nombre: String::from("María"),
        edad: 30,
    };
    
    p1.presentarse();
    p2.presentarse();
    println!();
    
    // ============================================================
    // MÉTODOS QUE MODIFICAN (&mut self)
    // ============================================================
    println!("--- Métodos Mutables ---");
    
    let mut p3 = Persona {
        nombre: String::from("Pedro"),
        edad: 34,
    };
    
    p3.presentarse();
    p3.cumplir_años();
    p3.presentarse();
    println!();
    
    // ============================================================
    // OWNERSHIP
    // ============================================================
    println!("--- OWNERSHIP ---");
    
    let s1 = String::from("Hola");
    println!("s1 = {}", s1);
    
    let s2 = s1;  // s1 "se mueve" a s2
    println!("s2 = {}", s2);
    // println!("s1 = {}", s1);  // ERROR: s1 ya no es propietario
    println!();
    
    // ============================================================
    // BORROWING (Préstamo)
    // ============================================================
    println!("--- BORROWING ---");
    
    let mensaje = String::from("Rust es genial");
    println!("mensaje = {}", mensaje);
    
    // Préstamo inmutable
    let ref1 = &mensaje;
    let ref2 = &mensaje;
    println!("ref1 = {}", ref1);
    println!("ref2 = {}", ref2);
    println!("mensaje = {}\n", mensaje);  // Aún es propietario
    
    // ============================================================
    // PRÉSTAMO MUTABLE
    // ============================================================
    println!("--- Préstamo Mutable ---");
    
    let mut texto = String::from("Hola");
    println!("Texto original: {}", texto);
    
    modificar_string(&mut texto);
    println!("Después de modificar: {}\n", texto);
    
    // ============================================================
    // VECTOR DE STRUCTS
    // ============================================================
    println!("--- Vector de Structs ---");
    
    let mut personas = vec![
        Persona {
            nombre: String::from("Ana"),
            edad: 28,
        },
        Persona {
            nombre: String::from("Carlos"),
            edad: 32,
        },
    ];
    
    println!("Lista de personas:");
    for persona in &personas {
        persona.presentarse();
    }
    println!();
    
    // Modificar una persona en el vector
    personas[0].cumplir_años();
}

fn modificar_string(s: &mut String) {
    s.push_str(" Mundo");
}
