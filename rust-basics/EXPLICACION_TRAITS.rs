// ============================================================================
// GUÍA COMPLETA: TRAITS (INTERFACES) EN RUST
// ============================================================================
//
// En Rust, los TRAITS son el equivalente a las interfaces.
// Son contratos que definen qué métodos debe implementar una struct.
//
// ============================================================================
// 1. ¿QUÉ ES UN TRAIT?
// ============================================================================
//
// Un TRAIT define un conjunto de métodos que un tipo DEBE implementar.
//
// DEFINICIÓN:
//
//    pub trait Dibujable {
//        fn dibujar(&self);
//        fn obtener_area(&self) -> f64;
//    }
//
// IMPLEMENTACIÓN:
//
//    struct Circulo {
//        radio: f64,
//    }
//
//    impl Dibujable for Circulo {
//        fn dibujar(&self) {
//            println!("Dibujando círculo");
//        }
//
//        fn obtener_area(&self) -> f64 {
//            3.14159 * self.radio * self.radio
//        }
//    }
//
//
// ============================================================================
// 2. VENTAJAS DE LOS TRAITS
// ============================================================================
//
// - Polimorfismo: Multiple tipos implementan el mismo trait
// - Reutilización: Código genérico que funciona con cualquier tipo
// - Flexibilidad: Agregar comportamiento sin modificar la struct
// - Seguridad: Compilador verifica que se implementen todos los métodos
//
//
// ============================================================================
// 3. MÉTODOS POR DEFECTO
// ============================================================================
//
// Los traits pueden tener IMPLEMENTACIONES POR DEFECTO:
//
//    pub trait Animal {
//        fn hablar(&self);
//        
//        fn describirse(&self) {  // Método por defecto
//            println!("Soy un animal");
//        }
//    }
//
//    struct Perro;
//    impl Animal for Perro {
//        fn hablar(&self) {
//            println!("Guau!");
//        }
//        // describirse() usa la implementación por defecto
//    }
//
//
// ============================================================================
// 4. TRAITS COMO PARÁMETROS
// ============================================================================
//
// Puedes pasar tipos que implementen un trait como parámetro:
//
//    fn hacer_sonido(animal: &impl Animal) {
//        animal.hablar();
//    }
//
//    O con trait bounds (más explícito):
//
//    fn hacer_sonido<T: Animal>(animal: &T) {
//        animal.hablar();
//    }
//
//
// ============================================================================
// 5. TRAIT OBJECTS (&dyn)
// ============================================================================
//
// Puedes usar &dyn Trait para trabajar con diferentes tipos en runtime:
//
//    let animales: Vec<&dyn Animal> = vec![&perro, &gato, &pajaro];
//    
//    for animal in animales {
//        animal.hablar();
//    }
//
//
// ============================================================================
// 6. RETORNAR TIPOS QUE IMPLEMENTAN UN TRAIT
// ============================================================================
//
// Usando impl Trait:
//
//    fn crear_circulo() -> impl Dibujable {
//        Circulo { radio: 5.0 }
//    }
//
// Usando trait objects:
//
//    fn crear_figura(tipo: &str) -> Box<dyn Dibujable> {
//        match tipo {
//            "circulo" => Box::new(Circulo { radio: 5.0 }),
//            "rectangulo" => Box::new(Rectangulo { ancho: 4.0, alto: 3.0 }),
//            _ => Box::new(Circulo { radio: 1.0 }),
//        }
//    }
//
//
// ============================================================================
// 7. MÚLTIPLES TRAITS
// ============================================================================
//
// Un tipo puede implementar VARIOS traits:
//
//    struct Perro;
//
//    impl Animal for Perro {
//        fn hablar(&self) { println!("Guau!"); }
//    }
//
//    impl Mascota for Perro {
//        fn jugar(&self) { println!("Jugando..."); }
//    }
//
//    // Perro ahora es Animal Y Mascota
//
//
// ============================================================================
// 8. TRAIT BOUNDS
// ============================================================================
//
// RESTRICCIONES en genéricos:
//
//    fn procesar<T: Display>(valor: T) {
//        println!("{}", valor);
//    }
//
//    MÚLTIPLES TRAITS:
//
//    fn procesar<T: Display + Clone>(valor: T) {
//        let copia = valor.clone();
//        println!("{}", copia);
//    }
//
//
// ============================================================================
// 9. TRAITS COMUNES EN RUST
// ============================================================================
//
// - Display: Mostrar como texto
// - Debug: Mostrar información de depuración ({:?})
// - Clone: Copiar un valor
// - Copy: Copiar automáticamente
// - Eq: Comparar igualdad
// - Ord: Ordenar valores
// - Iterator: Recorrer valores
// - Into: Convertir entre tipos
//
//
// ============================================================================

pub trait Dibujable {
    fn dibujar(&self);
    fn obtener_area(&self) -> f64;
    fn obtener_nombre(&self) -> &str;
}

pub trait Volador {
    fn volar(&self);
    fn obtener_altura(&self) -> f64;
}

fn main() {
    println!("======================================================");
    println!("  TRAITS (INTERFACES) EN RUST");
    println!("======================================================\n");
    
    println!("DEFINICIÓN:");
    println!("  - Trait: Contrato que define métodos");
    println!("  - Implementación: 'impl Trait for Struct'\n");
    
    println!("CARACTERÍSTICAS:");
    println!("  - Polimorfismo: Múltiples tipos implementan el trait");
    println!("  - Reutilización: Código genérico");
    println!("  - Seguridad: Verificación en tiempo de compilación\n");
    
    println!("PRÁCTICA:");
    println!("  - Ver Ejemplo6.rs: Traits básicos");
    println!("  - Ver Ejemplo7.rs: Traits avanzados");
    println!("  - Ver Ejemplo8.rs: Polimorfismo con traits");
}
