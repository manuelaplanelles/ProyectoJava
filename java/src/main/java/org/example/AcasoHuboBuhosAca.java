import java.util.Scanner;

public class AcasoHuboBuhosAca {
    public static void main(String[]args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- DETECTOR DE PALINDROMOS ---");
        System.out.println("Escribe XXX para terminar");

        while (true){
            System.out.println("Introduce tu frase: ");
            String frase = teclado.nextLine();

            if (frase.equalsIgnoreCase("XXX")){
                break;
            }
            int longitud = frase.length();

            if (longitud == 0 || longitud > 100) {
                System.out.println("Error: La frase debe tener entre 1 y 100 caracteres.");
                continue;
            }

            if (frase.charAt(0) == ' ' || frase.charAt(longitud - 1) == ' ') {
                System.out.println("Error: La frase no puede empezar ni terminar con espacios.");
                continue;
            }
            boolean cartInv = false;

            for (int i = 0; i<longitud; i++){
                char cart = frase.charAt(i);
                if (!((cart >= 'a' && cart <= 'z') || (cart >= 'A' && cart <= 'Z') || cart == ' ')) {
                    System.out.println("Error: Solo letras inglesas y espacios.");
                    cartInv = true;
                    break;
                }
            }
        }
    }
}
