// ============================================================================
// EJEMPLO 6: TRAITS BÁSICOS EN RUST
// ============================================================================

// Definir un trait (interfaz)
pub trait Animal {
    fn hablar(&self);
    fn obtener_nombre(&self) -> &str;
}

// Definir otro trait
pub trait Corredor {
    fn correr(&self);
    fn obtener_velocidad(&self) -> f64;
}

// Struct Perro
pub struct Perro {
    nombre: String,
    edad: u32,
}

// Implementar Animal para Perro
impl Animal for Perro {
    fn hablar(&self) {
        println!("🐕 {} dice: ¡Guau! (edad: {})", self.nombre, self.edad);
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

// Implementar Corredor para Perro
impl Corredor for Perro {
    fn correr(&self) {
        println!("{} está corriendo rápidamente!", self.nombre);
    }

    fn obtener_velocidad(&self) -> f64 {
        40.0  // km/h
    }
}

// Struct Gato
pub struct Gato {
    nombre: String,
}

// Implementar Animal para Gato
impl Animal for Gato {
    fn hablar(&self) {
        println!("🐱 {} dice: ¡Miau!", self.nombre);
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

// No implementamos Corredor para Gato

// Struct Pajaro
pub struct Pajaro {
    nombre: String,
    especie: String,
}

// Implementar Animal para Pajaro
impl Animal for Pajaro {
    fn hablar(&self) {
        println!("🐦 {} ({}) dice: ¡Pío pío!", self.nombre, self.especie);
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

// Struct Cheetah (corre rápido)
pub struct Cheetah {
    nombre: String,
}

impl Animal for Cheetah {
    fn hablar(&self) {
        println!("🐆 {} rugre", self.nombre);
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

impl Corredor for Cheetah {
    fn correr(&self) {
        println!("{} está corriendo a velocidad de cazador!", self.nombre);
    }

    fn obtener_velocidad(&self) -> f64 {
        120.0  // km/h - uno de los más rápidos
    }
}

fn main() {
    println!("=== EJEMPLO 6: TRAITS BÁSICOS ===\n");

    // ============================================================
    // CREAR INSTANCIAS
    // ============================================================
    println!("--- Crear Animales ---\n");

    let perro = Perro {
        nombre: "Rex".to_string(),
        edad: 5,
    };

    let gato = Gato {
        nombre: "Whiskers".to_string(),
    };

    let pajaro = Pajaro {
        nombre: "Tweety".to_string(),
        especie: "Canario".to_string(),
    };

    let cheetah = Cheetah {
        nombre: "Spot".to_string(),
    };

    // ============================================================
    // USAR EL TRAIT Animal
    // ============================================================
    println!("--- Haciendo Sonidos (Trait Animal) ---\n");

    perro.hablar();
    gato.hablar();
    pajaro.hablar();
    cheetah.hablar();
    println!();

    // ============================================================
    // USAR EL TRAIT Corredor
    // ============================================================
    println!("--- Correr (Trait Corredor) ---\n");

    perro.correr();
    println!("Velocidad: {} km/h\n", perro.obtener_velocidad());

    cheetah.correr();
    println!("Velocidad: {} km/h\n", cheetah.obtener_velocidad());

    // ============================================================
    // ACCEDER A NOMBRES
    // ============================================================
    println!("--- Nombres ---\n");

    println!("Perro: {}", perro.obtener_nombre());
    println!("Gato: {}", gato.obtener_nombre());
    println!("Pájaro: {}", pajaro.obtener_nombre());
    println!("Cheetah: {}\n", cheetah.obtener_nombre());

    // ============================================================
    // VECTOR DE REFERENCIAS A TRAIT
    // ============================================================
    println!("--- Vector de Animales (Trait Objects) ---\n");

    let animales: Vec<&dyn Animal> = vec![&perro, &gato, &pajaro, &cheetah];

    println!("Todos hacen sonido:");
    for animal in &animales {
        animal.hablar();
    }
    println!();

    // ============================================================
    // VECTOR DE CORREDORES
    // ============================================================
    println!("--- Corredores ---\n");

    let corredores: Vec<&dyn Corredor> = vec![&perro, &cheetah];

    println!("Velocidades de corredores:");
    for corredor in &corredores {
        corredor.correr();
    }
}
