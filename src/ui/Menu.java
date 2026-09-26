package ui;

import util.EntradaDados;

public class Menu {

    public static void exibir() {
        System.out.println("=== CALCULADORA FINANCEIRA ===");
        System.out.println("1. Porcentagem");
        System.out.println("2. Acréscimo percentual");
        System.out.println("3. Desconto percentual");
        System.out.println("4. Juros simples");
        System.out.println("5. Juros compostos");
        System.out.println("0. Sair");

        int opcao = EntradaDados.lerInteiro();

        System.out.println("Você escolheu: " + opcao);
    }
}