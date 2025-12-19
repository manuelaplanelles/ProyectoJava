package proyecto;

public class palindromosJuez {
    static java.util.Scanner in;
    public static boolean casoDePrueba() {
        boolean igual = true;
        //System.out.println("Escribe tu frase: ");
        String frase = in.nextLine();
        if (frase.equals("XXX")){
            return false;
        }else {
            int i = 0;
            int j = frase.length() - 1;
            while (i < j && igual) {
                while (i < j && frase.charAt(i) == ' ') i++;
                while (i < j && frase.charAt(j) == ' ') j--;
                //System.out.println(frase.charAt(i) + " " + frase.charAt(j));
                if (Character.toLowerCase(frase.charAt(i)) == Character.toLowerCase(frase.charAt(j))) {
                    j--;
                    i++;
                } else {
                    igual = false;
                }
            }
            if (igual) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
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