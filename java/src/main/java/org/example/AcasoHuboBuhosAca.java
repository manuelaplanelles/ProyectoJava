import java.util.Scanner;

public class AcasoHuboBuhosAca {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- DETECTOR DE PALÍNDROMOS ---");
        System.out.println("Escribe XXX para terminar");

        while (true) {
            System.out.println("Introduce tu frase: ");
            String frase = teclado.nextLine();

            if (frase.equalsIgnoreCase("XXX")) {
                break;
            }

            String limpia = ValidarYLimpiar(frase); //metdo1

            if (limpia == null) {
                continue;
            }

            boolean palindromo = RecorrerPalindromo(limpia); //metodo2

            if (palindromo) {
                System.out.println("Si es un palindromo.");
            } else {
                System.out.println("No es palindromo.");
            }
        }
    }

    static String ValidarYLimpiar(String frase) {
        int longitud = frase.length();

        if (longitud == 0 || longitud > 100) {
            System.out.println("Error: La frase debe tener entre 1 y 100 caracteres.");
            return null;
        }

        if (frase.charAt(0) == ' ' || frase.charAt(longitud - 1) == ' ') {
            System.out.println("Error: La frase no puede empezar ni terminar con espacios.");
            return null;
        }

        boolean cartInv = false;
        for (int i = 0; i < longitud; i++) {
            char cart = frase.charAt(i);
            if (!((cart >= 'a' && cart <= 'z') || (cart >= 'A' && cart <= 'Z') || cart == ' ')) {
                System.out.println("Error: Solo letras inglesas y espacios.");
                cartInv = true;
                break;
            }
        }

        if (cartInv) {
            return null;
        }

        String limpia = "";
        for (int i = 0; i < frase.length(); i++) {
            char cart = frase.charAt(i);
            if (cart != ' ') {
                limpia = limpia + cart;
            }
        }

        limpia = limpia.toLowerCase();
        return limpia;
    }

    static boolean RecorrerPalindromo(String limpia) {
        int i = 0;
        int j = limpia.length() - 1;
        boolean palindromo = true;

        while (i < j) {
            if (limpia.charAt(i) != limpia.charAt(j)) {
                palindromo = false;
                break;
            }
            i++;
            j--;
        }

        return palindromo;
    }
}