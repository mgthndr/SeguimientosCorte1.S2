// ============================================================================
// EJEMPLO 5: MUTACIÓN - MODIFICACIÓN DE DATOS
// ============================================================================

#[derive(Debug)]
struct Banco {
    titular: String,
    mut_saldo: f64,
}

impl Banco {
    fn depositar(&mut self, cantidad: f64) {
        if cantidad > 0.0 {
            self.mut_saldo += cantidad;
            println!("  ✓ Depositado: ${}", cantidad);
        }
    }

    fn retirar(&mut self, cantidad: f64) -> bool {
        if cantidad > 0.0 && cantidad <= self.mut_saldo {
            self.mut_saldo -= cantidad;
            println!("  ✓ Retirado: ${}", cantidad);
            true
        } else {
            println!("  ✗ No se puede retirar ${}", cantidad);
            false
        }
    }

    fn mostrar_saldo(&self) {
        println!("  Saldo actual: ${:.2}", self.mut_saldo);
    }
}

struct Contador {
    valor: i32,
}

impl Contador {
    fn nuevo() -> Contador {
        Contador { valor: 0 }
    }

    fn incrementar(&mut self) {
        self.valor += 1;
    }

    fn decrementar(&mut self) {
        self.valor -= 1;
    }

    fn obtener(&self) -> i32 {
        self.valor
    }
}

fn incrementar_por_referencia(numero: &mut i32) {
    *numero += 1;  // * desreferencia
}

fn cambiar_primer_elemento(vector: &mut Vec<i32>) {
    if !vector.is_empty() {
        vector[0] = 999;
    }
}

fn main() {
    println!("=== EJEMPLO 5: MUTACIÓN - MODIFICACIÓN DE DATOS ===\n");
    
    // ============================================================
    // VARIABLES MUTABLES BÁSICAS
    // ============================================================
    println!("--- Variables Mutables Básicas ---");
    
    let mut x = 10;
    println!("x inicial: {}", x);
    
    x = 20;
    println!("x después de cambio: {}", x);
    
    x += 5;
    println!("x después de +=: {}", x);
    
    x -= 3;
    println!("x después de -=: {}", x);
    println!();
    
    // ============================================================
    // MUTACIÓN DE STRINGS
    // ============================================================
    println!("--- Mutación de Strings ---");
    
    let mut mensaje = String::from("Hola");
    println!("Mensaje inicial: {}", mensaje);
    
    mensaje.push_str(" Mundo");
    println!("Después de push_str: {}", mensaje);
    
    mensaje = String::from("Nuevo mensaje");
    println!("Mensaje completamente nuevo: {}", mensaje);
    println!();
    
    // ============================================================
    // MUTACIÓN DE VECTORES
    // ============================================================
    println!("--- Mutación de Vectores ---");
    
    let mut numeros = vec![1, 2, 3];
    println!("Vector inicial: {:?}", numeros);
    
    numeros.push(4);
    println!("Después de push(4): {:?}", numeros);
    
    numeros.push(5);
    println!("Después de push(5): {:?}", numeros);
    
    if let Some(último) = numeros.pop() {
        println!("Pop removió: {}", último);
        println!("Vector ahora: {:?}", numeros);
    }
    
    numeros[0] = 100;
    println!("Después de cambiar numeros[0]: {:?}", numeros);
    println!();
    
    // ============================================================
    // REFENCIAS MUTABLES (&mut)
    // ============================================================
    println!("--- Referencias Mutables (&mut) ---");
    
    let mut valor = 42;
    println!("Valor antes: {}", valor);
    
    incrementar_por_referencia(&mut valor);
    println!("Valor después de incrementar: {}", valor);
    
    incrementar_por_referencia(&mut valor);
    println!("Valor después de incrementar de nuevo: {}", valor);
    println!();
    
    // ============================================================
    // MODIFICAR ARREGLOS POR REFERENCIA
    // ============================================================
    println!("--- Modificar Vector por Referencia ---");
    
    let mut arr = vec![1, 2, 3, 4, 5];
    println!("Array antes: {:?}", arr);
    
    cambiar_primer_elemento(&mut arr);
    println!("Array después (primer elemento cambió): {:?}", arr);
    println!();
    
    // ============================================================
    // STRUCTS MUTABLES
    // ============================================================
    println!("--- Structs Mutables ---");
    
    let mut contador = Contador::nuevo();
    println!("Contador inicial: {}", contador.obtener());
    
    contador.incrementar();
    println!("Después de incrementar: {}", contador.obtener());
    
    contador.incrementar();
    contador.incrementar();
    println!("Después de 2 incrementos más: {}", contador.obtener());
    
    contador.decrementar();
    println!("Después de decrementar: {}", contador.obtener());
    println!();
    
    // ============================================================
    // SIMULACIÓN DE CUENTA BANCARIA
    // ============================================================
    println!("--- Simulación de Cuenta Bancaria ---");
    
    let mut cuenta = Banco {
        titular: String::from("Juan Pérez"),
        mut_saldo: 1000.0,
    };
    
    println!("Cuenta bancaria de {}", cuenta.titular);
    cuenta.mostrar_saldo();
    
    println!("\nDepositando $500:");
    cuenta.depositar(500.0);
    cuenta.mostrar_saldo();
    
    println!("\nRetirando $300:");
    cuenta.retirar(300.0);
    cuenta.mostrar_saldo();
    
    println!("\nRetirando $2000 (sin fondos):");
    cuenta.retirar(2000.0);
    cuenta.mostrar_saldo();
    
    println!("\nRetirando $800:");
    cuenta.retirar(800.0);
    cuenta.mostrar_saldo();
    println!();
    
    // ============================================================
    // MUTACIÓN EN CICLOS
    // ============================================================
    println!("--- Mutación en Ciclos ---");
    
    let mut suma = 0;
    println!("Sumando números del 1 al 10:");
    for i in 1..=10 {
        suma += i;
        println!("  Suma actual: {}", suma);
    }
    println!("Suma final: {}\n", suma);
    
    // ============================================================
    // MUTACIÓN CON ITERADORES
    // ============================================================
    println!("--- Mutación con Iteradores ---");
    
    let mut datos = vec![1, 2, 3, 4, 5];
    println!("Vector inicial: {:?}", datos);
    
    // Multiplicar cada elemento por 2
    for elemento in &mut datos {
        *elemento *= 2;
    }
    println!("Vector después de ×2: {:?}", datos);
    
    // Sumar 10 a cada elemento
    for elemento in &mut datos {
        *elemento += 10;
    }
    println!("Vector después de +10: {:?}", datos);
    println!();
    
    // ============================================================
    // DESREFERENCIACIÓN
    // ============================================================
    println!("--- Desreferenciación (*) ---");
    
    let mut x = 5;
    let referencia = &mut x;
    
    println!("x original: {}", x);
    println!("A través de referencia: {}", *referencia);
    
    *referencia = 20;
    println!("Después de modificar con *referencia = 20: {}", x);
    println!();
    
    // ============================================================
    // MÚLTIPLES REFERENCIAS MUTABLES (No permitido)
    // ============================================================
    println!("--- Regla de Borrow Checker ---");
    println!("En Rust no puedes tener múltiples referencias mutables al mismo tiempo");
    
    let mut valor = 10;
    let ref1 = &mut valor;
    println!("Primera referencia mutable: {}", ref1);
    
    *ref1 = 15;  // Usar la primera referencia
    
    let ref2 = &mut valor;  // Ahora puedo crear otra
    println!("Segunda referencia mutable: {}", ref2);
    // println!("Primera referencia: {}", ref1);  // ERROR: ref1 ya no es válida
}
