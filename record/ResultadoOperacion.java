package record;

public sealed interface ResultadoOperacion {

    // Subtipos (records anidados)
    record Exito<T>(T valor) implements ResultadoOperacion {}
    
    record Error(String mensaje, int codigo) implements ResultadoOperacion {}

    // Método estático de fábrica conveniente
    static <T> ResultadoOperacion exitoso(T valor) {
        return new Exito<>(valor);
    }

    static ResultadoOperacion fallido(String mensaje, int codigo) {
        return new Error(mensaje, codigo);
    }

    // Métodos auxiliares
    static ResultadoOperacion dividir(int a, int b) {
        if (b == 0) {
            return fallido("División por cero", 400);
        }
        return exitoso(a / (double) b);
    }

    static void mostrarResultado(ResultadoOperacion resultado) {
        switch (resultado) {
            case Exito(var valor) -> System.out.println("Éxito: " + valor);
            case Error(var msg, var code) -> System.out.println("Error " + code + ": " + msg);
            default -> System.out.println("Estado desconocido");
        }
    }

    // Ejemplo con record patterns (Java 21+)
    static void procesarResultado(ResultadoOperacion r) {
        if (r instanceof Exito(Double valor)) {
            System.out.println("Resultado numérico: " + (valor * 100));
        } else if (r instanceof Error e) {
            System.out.println("Falló → " + e.mensaje() + " (código: " + e.codigo() + ")");
        }
    }

    static void main(String[] args) {
        // Ejemplo 1
        ResultadoOperacion r1 = dividir(10, 2);
        mostrarResultado(r1);

        // Ejemplo 2
        ResultadoOperacion r2 = dividir(10, 0);
        mostrarResultado(r2);

        // Ejemplo 3 - con record pattern (Java 21+)
        procesarResultado(dividir(25, 5));
    }
}