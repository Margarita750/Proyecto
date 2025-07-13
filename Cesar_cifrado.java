import java.util.Scanner;

public class Cesar_cifrado {

// Esto es una edicion al codigo original. Este cambio es un comentario. 
    
    public static String cifrar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        for (char letra : texto.toCharArray()) {
            if (Character.isLowerCase(letra)) {
                
                char nuevaLetra = (char) ((letra - 'a' + desplazamiento) % 26 + 'a');
                resultado.append(nuevaLetra);
            } else if (Character.isUpperCase(letra)) {
                
                char nuevaLetra = (char) ((letra - 'A' + desplazamiento) % 26 + 'A');
                resultado.append(nuevaLetra);
            } else {
                
                resultado.append(letra);
            }
        }
        return resultado.toString();
    }

    
    public static String descifrar(String texto, int desplazamiento) {
        return cifrar(texto, 26 - (desplazamiento % 26)); // Inverso del desplazamiento
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el desplazamiento para el cifrado o descifrado:");
        int desplazamiento = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("¿Qué desea hacer? (1 para cifrar, 2 para descifrar):");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (opcion == 1) {
            System.out.println("Ingrese el texto para cifrar:");
            String texto = scanner.nextLine();
            String textoCifrado = cifrar(texto, desplazamiento);
            System.out.println("Texto cifrado: " + textoCifrado);
        } else if (opcion == 2) {
            System.out.println("Ingrese el texto para descifrar:");
            String texto = scanner.nextLine();
            String textoDescifrado = descifrar(texto, desplazamiento);
            System.out.println("Texto descifrado: " + textoDescifrado);
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
