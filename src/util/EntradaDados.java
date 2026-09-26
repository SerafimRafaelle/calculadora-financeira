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

    public static int lerInteiroPositivo() {

        int valor;

        do {
            valor = lerInteiro();

            if (valor <= 0) {
                System.out.println("Digite um número maior que zero.");
            }

        } while (valor <= 0);

        return valor;
    }

    public static double lerDecimal() {

        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um número.");
            scanner.next();
        }

        return scanner.nextDouble();
    }
    
    public static double lerDecimalNaoNegativo() {

    double valor;

    do {
        valor = lerDecimal();

        if (valor < 0) {
            System.out.println("Digite um número maior ou igual a zero.");
        }

    } while (valor < 0);

    return valor;
    }
}