import java.util.Scanner;

public class palindromosJuez {

        static java.util.Scanner in;

        public static boolean casoDePrueba() {
            Scanner teclado = new Scanner(System.in);
           String frase;
            boolean igual = true;

                System.out.println("Escribe tu frase: ");
                frase = teclado.nextLine();
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