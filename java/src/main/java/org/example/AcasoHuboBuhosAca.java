import java.util.Scanner;

public class AcasoHuboBuhosAca {

    static java.util.Scanner in;

    public static String escribe () {
        Scanner teclado = new Scanner(System.in);
        String frase;
        System.out.println("Escribe tu frase: ");
        frase = teclado.nextLine();
        return frase;
    }
    public static boolean casoDePrueba() {
        boolean igual = true;
        String frase = escribe();

        if (frase.equalsIgnoreCase("XXX")){
            return false;
        }else {
            int j=frase.length()-1;
            igual=true;
            int i=0;
            while (i<j && igual){
                while (i < j && frase.charAt(i) == ' ') i++;
                while (i < j && frase.charAt(j) == ' ') j--;
                System.out.println(frase.charAt(i) + " " + frase.charAt(j));
                if (Character.toLowerCase(frase.charAt(i))==Character.toLowerCase(frase.charAt(j))){
                    j--;
                    i++;
                }else {
                    igual = false;
                }
            }

            if(igual){
                System.out.println("Son palindromos.");
            }else{
                System.out.println("No son palindromos.");
            }
        }

        return true;
    }
    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}