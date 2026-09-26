package util;

import java.util.Scanner;

public class EntradaDados {

    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro() {
        return scanner.nextInt();
    }
}