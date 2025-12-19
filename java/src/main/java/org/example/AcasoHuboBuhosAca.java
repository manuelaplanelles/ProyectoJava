import java.util.Scanner;

public class AcasoHuboBuhosAca {

    static Scanner teclado = new Scanner(System.in);

    /**
     * Esta clase contiene los métodos necesarios para resolver el problema 252 Acaso Hubo Buho Aca - Palíndromos del Concurso ProgramaMe para el proyecto de la asignatura de programacion de 1ºDAW.
     * @author: Manuela Planelles
     * @version: 1.0 (19/12/2025)
     * @see <a href = "https://aceptaelreto.com/problem/statement.php?id=252"/> Acaso Hubo Buho Aca </a>
     */

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

    /**
     * Valída y limpia la frase proporcionada por el usuario.
     * Revisa si la frase tiene entre 1 y 100 caracteres, y si está bien formada (sin caracteres inválidos o espacios al principio o al final).
     * Elimina los espacios para facilitar la comprobación del palíndromo.
     * @param frase
     * @return La frase limpia y en minúsculas, o null si hay un error de validación.
     */

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

    /**
     * Verifica si la cadena de texto proporcionada es un palíndromo.
     * Compara los caracteres de la cadena desde ambos extremos hacia el centro.
     * @param limpia
     * @return true si la cadena es un palíndromo, false en caso contrario.
     */

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