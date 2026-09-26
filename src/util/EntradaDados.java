package util;

import java.util.Scanner;

public class EntradaDados {

    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro() {

        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.next();
        }

        return scanner.nextInt();
    }
}