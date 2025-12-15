package org.example;

import java.util.Scanner;

public class elVerdugo2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Palabra secreta: ");
        String palabra = teclado.nextLine().toLowerCase();

        String usadas = "";
        String acertadas = "";
        int fallos = 0;

        // Contar letras únicas
        String letrasPalabra = "";
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letrasPalabra.indexOf(letra) == -1) {
                letrasPalabra = letrasPalabra + letra;
            }
        }

        // Bucle del juego
        while (fallos < 7) {

            // Mostrar palabra
            System.out.print("Palabra: ");
            for (int i = 0; i < palabra.length(); i++) {
                char letra = palabra.charAt(i);
                if (acertadas.indexOf(letra) >= 0) {
                    System.out.print(letra + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println("  (Fallos: " + fallos + "/7)");

            // Comprobar si ganó
            boolean gano = true;
            for (int i = 0; i < letrasPalabra.length(); i++) {
                if (acertadas.indexOf(letrasPalabra.charAt(i)) == -1) {
                    gano = false;
                    break;
                }
            }

            if (gano) {
                System.out.println("\nSALVADO\n");
                break;
            }

            // Pedir letra
            System.out.print("Letra: ");
            String entrada = teclado.nextLine().toLowerCase();

            if (entrada.length() != 1) {
                System.out.println("Solo una letra.\n");
                continue;
            }

            char letra = entrada.charAt(0);

            // Ya usada
            if (usadas.indexOf(letra) >= 0) {
                System.out.println("Ya probaste esa letra.\n");
                continue;
            }

            usadas = usadas + letra;

            // Verificar
            if (palabra.indexOf(letra) >= 0) {
                System.out.println("Correcto!\n");
                acertadas = acertadas + letra;
            } else {
                System.out.println("Fallo!\n");
                fallos++;
            }
        }

        // Perdió
        if (fallos >= 7) {
            System.out.println("Palabra: " + palabra);
            System.out.println("\nAHORCADO\n");
        }

        teclado.close();
    }
}
