// ============================================================================
// EJEMPLO 7: TRAITS AVANZADOS
// ============================================================================

use std::fmt;

// ============================================================
// TRAIT CON MÉTODOS POR DEFECTO
// ============================================================

pub trait Jugador {
    fn jugar(&self);
    fn obtener_equipo(&self) -> &str;

    // Método con implementación por defecto
    fn describirse(&self) {
        println!("Soy un jugador del equipo: {}", self.obtener_equipo());
    }

    // Otro método por defecto
    fn celebrar(&self) {
        println!("¡Celebrando victoria! 🎉");
    }
}

// ============================================================
// STRUCT Y IMPLEMENTATIONS
// ============================================================

pub struct Futbolista {
    nombre: String,
    equipo: String,
    numero: u32,
}

impl Jugador for Futbolista {
    fn jugar(&self) {
        println!(
            "⚽ {} (#{}) juega para {}",
            self.nombre, self.numero, self.equipo
        );
    }

    fn obtener_equipo(&self) -> &str {
        &self.equipo
    }

    // Sobrescribir el método por defecto
    fn describirse(&self) {
        println!(
            "{} es futbolista del equipo {}",
            self.nombre, self.equipo
        );
    }
}

pub struct Basquetbolista {
    nombre: String,
    equipo: String,
}

impl Jugador for Basquetbolista {
    fn jugar(&self) {
        println!("🏀 {} juega baloncesto para {}", self.nombre, self.equipo);
    }

    fn obtener_equipo(&self) -> &str {
        &self.equipo
    }
}

// ============================================================
// MÚLTIPLES TRAITS
// ============================================================

pub trait Deportista {
    fn entrenar(&self);
}

pub trait Internacional {
    fn representar_pais(&self) -> &str;
}

pub struct TenistaMundial {
    nombre: String,
    pais: String,
}

impl Jugador for TenistaMundial {
    fn jugar(&self) {
        println!("🎾 {} juega tenis", self.nombre);
    }

    fn obtener_equipo(&self) -> &str {
        "(Sin equipo - Individual)"
    }
}

impl Deportista for TenistaMundial {
    fn entrenar(&self) {
        println!("{} está entrenando en la cancha", self.nombre);
    }
}

impl Internacional for TenistaMundial {
    fn representar_pais(&self) -> &str {
        &self.pais
    }
}

// ============================================================
// TRAIT BOUND EN FUNCIÓN
// ============================================================

fn hacer_jugar<T: Jugador>(jugador: &T) {
    jugador.jugar();
    jugador.describirse();
    jugador.celebrar();
}

fn entrenar_si_es_deportista<T: Deportista>(d: &T) {
    d.entrenar();
}

// ============================================================
// RETORNAR impl TRAIT
// ============================================================

fn crear_futbolista(nombre: &str) -> impl Jugador {
    Futbolista {
        nombre: nombre.to_string(),
        equipo: "FC Ejemplo".to_string(),
        numero: 10,
    }
}

// ============================================================
// USANDO BOX PARA RETORNAR DIFERENTES TIPOS
// ============================================================

fn crear_jugador_aleatorio(tipo: &str) -> Box<dyn Jugador> {
    match tipo {
        "futbol" => Box::new(Futbolista {
            nombre: "Messi".to_string(),
            equipo: "Barcelona".to_string(),
            numero: 10,
        }),
        "basquet" => Box::new(Basquetbolista {
            nombre: "LeBron".to_string(),
            equipo: "Lakers".to_string(),
        }),
        _ => Box::new(Futbolista {
            nombre: "Jugador Genérico".to_string(),
            equipo: "Equipo Genérico".to_string(),
            numero: 1,
        }),
    }
}

// ============================================================
// TRAIT CON TIPOS ASOCIADOS
// ============================================================

pub trait Juego {
    type Posicion;

    fn obtener_posicion(&self) -> Self::Posicion;
}

#[derive(Clone, Copy)]
pub struct Coordenada {
    x: f64,
    y: f64,
}

impl Juego for Futbolista {
    type Posicion = Coordenada;

    fn obtener_posicion(&self) -> Coordenada {
        Coordenada { x: 10.5, y: 20.5 }
    }
}

// ============================================================
// TRAIT BOUND CON MÚLTIPLES TRAITS
// ============================================================

fn mostrar_jugador_internacional<T: Jugador + Internacional>(j: &T) {
    println!("\n=== Jugador Internacional ===");
    j.jugar();
    println!("Representa a: {}", j.representar_pais());
}

fn main() {
    println!("=== EJEMPLO 7: TRAITS AVANZADOS ===\n");

    // ============================================================
    // MÉTODOS POR DEFECTO
    // ============================================================
    println!("--- Métodos por Defecto ---\n");

    let futbolista = Futbolista {
        nombre: "Ronaldo".to_string(),
        equipo: "Manchester".to_string(),
        numero: 7,
    };

    futbolista.jugar();
    futbolista.describirse();  // Personalizado
    futbolista.celebrar();     // Por defecto
    println!();

    let basquetbolista = Basquetbolista {
        nombre: "Michael Jordan".to_string(),
        equipo: "Bulls".to_string(),
    };

    basquetbolista.jugar();
    basquetbolista.describirse();  // Usa el default
    basquetbolista.celebrar();     // Por defecto
    println!();

    // ============================================================
    // TRAIT BOUND EN FUNCIÓN
    // ============================================================
    println!("--- Trait Bound ---\n");

    println!("Con futbolista:");
    hacer_jugar(&futbolista);
    println!();

    println!("Con basquetbolista:");
    hacer_jugar(&basquetbolista);
    println!();

    // ============================================================
    // MÚLTIPLES TRAITS
    // ============================================================
    println!("--- Múltiples Traits ---\n");

    let tenista = TenistaMundial {
        nombre: "Novak Djokovic".to_string(),
        pais: "Serbia".to_string(),
    };

    tenista.jugar();
    entrenar_si_es_deportista(&tenista);
    println!();

    mostrar_jugador_internacional(&tenista);
    println!();

    // ============================================================
    // impl TRAIT
    // ============================================================
    println!("--- Retornar impl Trait ---\n");

    let j = crear_futbolista("Pelé");
    j.jugar();
    println!();

    // ============================================================
    // BOX<dyn TRAIT>
    // ============================================================
    println!("--- Box<dyn Trait> ---\n");

    let futbolista_box = crear_jugador_aleatorio("futbol");
    futbolista_box.jugar();

    let basquetbolista_box = crear_jugador_aleatorio("basquet");
    basquetbolista_box.jugar();
    println!();

    // ============================================================
    // VECTOR DE TRAITS
    // ============================================================
    println!("--- Vector de Diferentes Tipos ---\n");

    let jugadores: Vec<Box<dyn Jugador>> = vec![
        Box::new(Futbolista {
            nombre: "Neymar".to_string(),
            equipo: "PSG".to_string(),
            numero: 10,
        }),
        Box::new(Basquetbolista {
            nombre: "Kobe Bryant".to_string(),
            equipo: "Lakers".to_string(),
        }),
        crear_jugador_aleatorio("futbol"),
    ];

    for (i, jugador) in jugadores.iter().enumerate() {
        println!("Jugador {}:", i + 1);
        jugador.jugar();
        jugador.describirse();
        println!();
    }

    // ============================================================
    // TRAIT CON TIPOS ASOCIADOS
    // ============================================================
    println!("--- Tipos Asociados ---\n");

    let pos = futbolista.obtener_posicion();
    println!("Posición del futbolista: ({}, {})\n", pos.x, pos.y);
}
