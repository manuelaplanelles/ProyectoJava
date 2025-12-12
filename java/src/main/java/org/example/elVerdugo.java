package org.example;

import java.util.Scanner;

/**
 * Versión interactiva del ahorcado para jugar y hacer pruebas
 *
 * @author Manuela Pianelles
 */
public class elVerdugo {

    // MÉTODOS (van ANTES del main)

    /**
     * Dibuja el estado del ahorcado según el número de fallos
     *
     * @param fallos Número de fallos acumulados (0-7)
     */
    public static void dibujarAhorcado(int fallos) {
        System.out.println("  ╔═══╗");
        System.out.println("  ║   " + (fallos >= 1 ? "😵" : " "));

        if (fallos >= 4) {
            System.out.println("  ║  /|\\");
        } else if (fallos >= 3) {
            System.out.println("  ║  /|");
        } else if (fallos >= 2) {
            System.out.println("  ║   |");
        } else {
            System.out.println("  ║    ");
        }

        if (fallos >= 6) {
            System.out.println("  ║  / \\");
        } else if (fallos >= 5) {
            System.out.println("  ║  /");
        } else {
            System.out.println("  ║    ");
        }

        System.out.println("  ║");
        System.out.println("══════════");

        if (fallos > 0 && fallos < 7) {
            System.out.println("⚠️  Fallos: " + fallos + "/7");
        }
    }

    /**
     * Muestra la palabra con letras adivinadas y guiones
     *
     * @param palabra La palabra secreta
     * @param letrasAcertadas String con las letras acertadas
     * @return String con la palabra parcialmente descubierta
     */
    public static String mostrarPalabraProgreso(String palabra, String letrasAcertadas) {
        String progreso = "";

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letrasAcertadas.indexOf(letra) >= 0) {
                progreso = progreso + letra + " ";
            } else {
                progreso = progreso + "_ ";
            }
        }

        return progreso;
    }

    /**
     * Cuenta letras únicas en una palabra
     *
     * @param palabra La palabra a analizar
     * @return Número de letras diferentes
     */
    public static int contarLetrasUnicas(String palabra) {
        String letrasContadas = "";

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letrasContadas.indexOf(letra) == -1) {
                letrasContadas = letrasContadas + letra;
            }
        }

        return letrasContadas.length();
    }

    /**
     * Cuenta cuántas letras únicas de la palabra han sido acertadas
     *
     * @param palabra La palabra secreta
     * @param letrasAcertadas String con letras acertadas
     * @return Número de letras únicas acertadas
     */
    public static int contarLetrasAcertadasUnicas(String palabra, String letrasAcertadas) {
        String letrasUnicasAcertadas = "";

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letrasAcertadas.indexOf(letra) >= 0 &&
                    letrasUnicasAcertadas.indexOf(letra) == -1) {
                letrasUnicasAcertadas = letrasUnicasAcertadas + letra;
            }
        }

        return letrasUnicasAcertadas.length();
    }

    // MAIN

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("═══════════════════════════════════");
        System.out.println("    🎮 JUEGO DEL AHORCADO 🎮");
        System.out.println("═══════════════════════════════════");

        System.out.print("Introduce la palabra secreta: ");
        String palabra = teclado.nextLine().toLowerCase();

        // "Limpiar" pantalla
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        String letrasAcertadas = "";
        String letrasFalladas = "";
        int fallos = 0;
        int totalLetras = contarLetrasUnicas(palabra);

        // Bucle del juego
        while (fallos < 7) {
            dibujarAhorcado(fallos);
            System.out.println("Palabra: " + mostrarPalabraProgreso(palabra, letrasAcertadas));

            if (letrasFalladas.length() > 0) {
                System.out.println("Letras incorrectas: " + letrasFalladas);
            }

            // Comprobar si ganó
            int letrasAcertadasCount = contarLetrasAcertadasUnicas(palabra, letrasAcertadas);

            if (letrasAcertadasCount == totalLetras) {
                System.out.println("🎉 ¡FELICIDADES! HAS GANADO 🎉");
                System.out.println("RESULTADO: SALVADO");
                break;
            }

            System.out.print("Introduce una letra: ");
            String entrada = teclado.nextLine().toLowerCase();

            if (entrada.length() != 1) {
                System.out.println("⚠️  Por favor, introduce solo una letra.");
                continue;
            }

            char intento = entrada.charAt(0);

            // Comprobar si ya fue usada
            if (letrasAcertadas.indexOf(intento) >= 0 ||
                    letrasFalladas.indexOf(intento) >= 0) {
                System.out.println("⚠️  Ya has probado esa letra.");
                continue;
            }

            // Comprobar si es acierto o fallo
            if (palabra.indexOf(intento) >= 0) {
                System.out.println("✅ ¡Correcto!");
                letrasAcertadas = letrasAcertadas + intento;
            } else {
                System.out.println("❌ ¡Fallo!");
                letrasFalladas = letrasFalladas + intento;
                fallos++;
            }

            // Sin pausa - directamente continúa
            System.out.println(); // Solo un salto de línea
        }

        if (fallos >= 7) {
            dibujarAhorcado(fallos);
            System.out.println("Palabra: " + palabra.toUpperCase());
            System.out.println("💀 ¡HAS PERDIDO! 💀");
            System.out.println("RESULTADO: AHORCADO");
        }
    }
}