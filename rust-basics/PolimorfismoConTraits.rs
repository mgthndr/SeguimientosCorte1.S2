// ============================================================================
// EJEMPLO 8: POLIMORFISMO CON TRAITS
// ============================================================================

pub trait Vehículo {
    fn acelerar(&self);
    fn frenar(&self);
    fn obtener_velocidad(&self) -> f64;
    fn obtener_nombre(&self) -> &str;

    // Método por defecto
    fn mostrar_info(&self) {
        println!(
            "{} viajando a {} km/h",
            self.obtener_nombre(),
            self.obtener_velocidad()
        );
    }
}

pub trait Terrestre: Vehículo {
    fn conducir(&self);
}

pub trait Acuatico: Vehículo {
    fn navegar(&self);
}

pub trait Aereo: Vehículo {
    fn volar(&self);
}

// ============================================================
// VEHÍCULOS TERRESTRES
// ============================================================

pub struct Auto {
    nombre: String,
    velocidad: f64,
}

impl Vehículo for Auto {
    fn acelerar(&self) {
        println!("🚗 {} acelerando", self.nombre);
    }

    fn frenar(&self) {
        println!("🚗 {} frenando", self.nombre);
    }

    fn obtener_velocidad(&self) -> f64 {
        self.velocidad
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

impl Terrestre for Auto {
    fn conducir(&self) {
        println!("Conduciendo {} en la carretera", self.nombre);
    }
}

pub struct Bicicleta {
    velocidad: f64,
}

impl Vehículo for Bicicleta {
    fn acelerar(&self) {
        println!("🚴 Pedalando más rápido");
    }

    fn frenar(&self) {
        println!("🚴 Frenando bicicleta");
    }

    fn obtener_velocidad(&self) -> f64 {
        self.velocidad
    }

    fn obtener_nombre(&self) -> &str {
        "Bicicleta"
    }
}

impl Terrestre for Bicicleta {
    fn conducir(&self) {
        println!("Andando en bicicleta");
    }
}

// ============================================================
// VEHÍCULOS ACUÁTICOS
// ============================================================

pub struct Barco {
    nombre: String,
    velocidad: f64,
}

impl Vehículo for Barco {
    fn acelerar(&self) {
        println!("⛵ {} aumentando velocidad", self.nombre);
    }

    fn frenar(&self) {
        println!("⛵ {} reduciendo velocidad", self.nombre);
    }

    fn obtener_velocidad(&self) -> f64 {
        self.velocidad
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

impl Acuatico for Barco {
    fn navegar(&self) {
        println!("Navegando {} en el mar", self.nombre);
    }
}

pub struct Submarino {
    velocidad: f64,
}

impl Vehículo for Submarino {
    fn acelerar(&self) {
        println!("🚩 Submarino acelerando");
    }

    fn frenar(&self) {
        println!("🚩 Submarino frenando");
    }

    fn obtener_velocidad(&self) -> f64 {
        self.velocidad
    }

    fn obtener_nombre(&self) -> &str {
        "Submarino"
    }
}

impl Acuatico for Submarino {
    fn navegar(&self) {
        println!("Navegando bajo el agua");
    }
}

// ============================================================
// VEHÍCULOS AÉREOS
// ============================================================

pub struct Avion {
    nombre: String,
    velocidad: f64,
}

impl Vehículo for Avion {
    fn acelerar(&self) {
        println!("✈️ {} acelerando en la pista", self.nombre);
    }

    fn frenar(&self) {
        println!("✈️ {} desplegando frenos", self.nombre);
    }

    fn obtener_velocidad(&self) -> f64 {
        self.velocidad
    }

    fn obtener_nombre(&self) -> &str {
        &self.nombre
    }
}

impl Aereo for Avion {
    fn volar(&self) {
        println!("Volando {} a gran altura", self.nombre);
    }
}

pub struct Helicoptero {
    velocidad: f64,
}

impl Vehículo for Helicoptero {
    fn acelerar(&self) {
        println!("🚁 Aumentando velocidad helicóptero");
    }

    fn frenar(&self) {
        println!("🚁 Reduciendo velocidad helicóptero");
    }

    fn obtener_velocidad(&self) -> f64 {
        self.velocidad
    }

    fn obtener_nombre(&self) -> &str {
        "Helicóptero"
    }
}

impl Aereo for Helicoptero {
    fn volar(&self) {
        println!("Volando verticamente");
    }
}

// ============================================================
// FUNCIONES POLIMÓRFICAS
// ============================================================

fn mostrar_vehiculo(v: &dyn Vehículo) {
    println!("\n=== Vehículo ===");
    v.mostrar_info();
    v.acelerar();
    v.frenar();
}

fn conducir_terrestre(v: &dyn Terrestre) {
    v.conducir();
    v.mostrar_info();
}

fn navegar_acuatico(v: &dyn Acuatico) {
    v.navegar();
    v.mostrar_info();
}

fn volar_aereo(v: &dyn Aereo) {
    v.volar();
    v.mostrar_info();
}

fn main() {
    println!("=== EJEMPLO 8: POLIMORFISMO CON TRAITS ===\n");

    // ============================================================
    // VEHÍCULOS TERRESTRES
    // ============================================================
    println!("--- Vehículos Terrestres ---");

    let auto = Auto {
        nombre: "Toyota Corolla".to_string(),
        velocidad: 200.0,
    };

    let bicicleta = Bicicleta { velocidad: 30.0 };

    conducir_terrestre(&auto);
    conducir_terrestre(&bicicleta);

    // ============================================================
    // VEHÍCULOS ACUÁTICOS
    // ============================================================
    println!("\n--- Vehículos Acuáticos ---");

    let barco = Barco {
        nombre: "Titanic".to_string(),
        velocidad: 45.0,
    };

    let submarino = Submarino { velocidad: 35.0 };

    navegar_acuatico(&barco);
    navegar_acuatico(&submarino);

    // ============================================================
    // VEHÍCULOS AÉREOS
    // ============================================================
    println!("\n--- Vehículos Aéreos ---");

    let avion = Avion {
        nombre: "Boeing 747".to_string(),
        velocidad: 900.0,
    };

    let helicoptero = Helicoptero { velocidad: 250.0 };

    volar_aereo(&avion);
    volar_aereo(&helicoptero);

    // ============================================================
    // POLIMORFISMO: TODOS COMO VEHÍCULOS
    // ============================================================
    println!("\n--- Todos como Vehículos (Polimorfismo) ---");

    let vehiculos: Vec<&dyn Vehículo> = vec![
        &auto,
        &bicicleta,
        &barco,
        &submarino,
        &avion,
        &helicoptero,
    ];

    for vehiculo in vehiculos {
        mostrar_vehiculo(vehiculo);
    }

    // ============================================================
    // BÚSQUEDA DE VELOCIDAD MÁS ALTA
    // ============================================================
    println!("\n--- Búsqueda de Velocidad Máxima ---");

    let velocidades = vec![
        &auto,
        &bicicleta,
        &barco,
        &submarino,
        &avion,
        &helicoptero,
    ];

    let mas_rapido = velocidades
        .iter()
        .max_by(|a, b| {
            a.obtener_velocidad()
                .partial_cmp(&b.obtener_velocidad())
                .unwrap()
        })
        .unwrap();

    println!(
        "Vehículo más rápido: {} - {} km/h",
        mas_rapido.obtener_nombre(),
        mas_rapido.obtener_velocidad()
    );

    // Más lento
    let mas_lento = velocidades
        .iter()
        .min_by(|a, b| {
            a.obtener_velocidad()
                .partial_cmp(&b.obtener_velocidad())
                .unwrap()
        })
        .unwrap();

    println!(
        "Vehículo más lento: {} - {} km/h",
        mas_lento.obtener_nombre(),
        mas_lento.obtener_velocidad()
    );
}
