package ui;

import calculos.CalculadoraFinanceira;
import util.EntradaDados;

public class Menu {

    public static void exibir() {

        int opcao;

        do {
            System.out.println("=== CALCULADORA FINANCEIRA ===");
            System.out.println("1. Porcentagem");
            System.out.println("2. Acréscimo percentual");
            System.out.println("3. Desconto percentual");
            System.out.println("4. Juros simples");
            System.out.println("5. Juros compostos");
            System.out.println("0. Sair");

            opcao = EntradaDados.lerInteiro();

            switch (opcao) {
                case 1: {
                    System.out.println("Digite o valor:");
                    double valor = EntradaDados.lerDecimal();

                    System.out.println("Digite o percentual:");
                    double percentual = EntradaDados.lerDecimal();

                    double resultado = CalculadoraFinanceira.calcularPorcentagem(valor, percentual);

                    System.out.println("Resultado: " + resultado);
                    break;
                }

                case 2: {
                    System.out.println("Digite o valor:");
                    double valor = EntradaDados.lerDecimal();

                    System.out.println("Digite o percentual:");
                    double percentual = EntradaDados.lerDecimal();

                    double resultado = CalculadoraFinanceira.calcularAcrescimo(valor, percentual);

                    System.out.println("Resultado: " + resultado);
                    break;
                }

                case 3: {
                    System.out.println("Digite o valor:");
                    double valor = EntradaDados.lerDecimal();

                    System.out.println("Digite o percentual:");
                    double percentual = EntradaDados.lerDecimal();

                    double resultado = CalculadoraFinanceira.calcularDesconto(valor, percentual);

                    System.out.println("Resultado: " + resultado);
                    break;
                }

                case 4:{
                    System.out.println("Juros simples");
                    break;
                }

                case 5:{
                    System.out.println("Juros compostos");
                    break;
                }

                case 0:{
                    System.out.println("Encerrando...");
                    break;
                }

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}