import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Transposicion_cifrado {

    
    public static String cifrar(String texto, String clave) {
        if (clave.length() != 3) {
            throw new IllegalArgumentException("La clave debe tener exactamente 3 dígitos.");
        }

        
        ArrayList<Integer> orden = new ArrayList<>();
        for (char c : clave.toCharArray()) {
            orden.add(Character.getNumericValue(c) - 1);
        }

        
        ArrayList<String> bloques = new ArrayList<>();
        for (int i = 0; i < texto.length(); i += 3) {
            String bloque = texto.substring(i, Math.min(i + 3, texto.length()));
            while (bloque.length() < 3) {
                bloque += " "; 
            }
            bloques.add(bloque);
        }

        
        StringBuilder resultado = new StringBuilder();
        for (String bloque : bloques) {
            for (int indice : orden) {
                resultado.append(bloque.charAt(indice));
            }
        }

        return resultado.toString();
    }

    
    public static String descifrar(String texto, String clave) {
        if (clave.length() != 3) {
            throw new IllegalArgumentException("La clave debe tener exactamente 3 dígitos.");
        }

        
        ArrayList<Integer> orden = new ArrayList<>();
        for (char c : clave.toCharArray()) {
            orden.add(Character.getNumericValue(c) - 1);
        }

        
        ArrayList<Integer> inverso = new ArrayList<>(Collections.nCopies(3, 0));
        for (int i = 0; i < 3; i++) {
            inverso.set(orden.get(i), i);
        }

        
        ArrayList<String> bloques = new ArrayList<>();
        for (int i = 0; i < texto.length(); i += 3) {
            bloques.add(texto.substring(i, Math.min(i + 3, texto.length())));
        }

        
        StringBuilder resultado = new StringBuilder();
        for (String bloque : bloques) {
            char[] original = new char[3];
            for (int i = 0; i < 3; i++) {
                if (i < bloque.length()) {
                    original[inverso.get(i)] = bloque.charAt(i);
                } else {
                    original[inverso.get(i)] = ' ';
                }
            }
            resultado.append(new String(original));
        }

        
        return resultado.toString().replaceAll("\\s+$", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBienvenido");
        while (true) {
            System.out.print("\nElige una opción (1 para cifrar, 2 para descifrar): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            try {
                if (opcion == 1) {
                    System.out.print("Texto a cifrar: ");
                    String texto = scanner.nextLine();
                    System.out.print("Escribe la clave de 3 dígitos: ");
                    String claveCifrar = scanner.nextLine();

                    String textoCifrado = cifrar(texto, claveCifrar);
                    System.out.println("Texto cifrado: " + textoCifrado);

                } else if (opcion == 2) {
                    System.out.print("Texto cifrado: ");
                    String textoCifradoInput = scanner.nextLine();
                    System.out.print("Clave de 3 dígitos: ");
                    String claveDescifrar = scanner.nextLine();

                    String textoDescifrado = descifrar(textoCifradoInput, claveDescifrar);
                    System.out.println("Texto descifrado: " + textoDescifrado);

                } else {
                    System.out.println("Elige 1 o 2.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
