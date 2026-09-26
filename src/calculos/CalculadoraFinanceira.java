package calculos;

public class CalculadoraFinanceira {

    public static double calcularPorcentagem(double valor, double percentual) {

        return valor * percentual / 100;
    }

    public static double calcularAcrescimo(double valor, double percentual) {

        double acrescimo = calcularPorcentagem(valor, percentual);

        return valor + acrescimo;
    }

    public static double calcularDesconto(double valor, double percentual) {

        double desconto = calcularPorcentagem(valor, percentual);

        return valor - desconto;
    }

    public static double calcularJurosSimples(
        double capital,
        double taxa,
        int meses
    ) {

        double taxaDecimal = taxa / 100;
        double juros = capital * taxaDecimal * meses;

        return juros;
    }
    public static double calcularJurosCompostos(
    double capital,
    double taxa,
    int meses 
    ) {
    double taxaDecimal = taxa / 100;
    double montante = capital * Math.pow(1 + taxaDecimal, meses);

    return montante - capital;
    }
}