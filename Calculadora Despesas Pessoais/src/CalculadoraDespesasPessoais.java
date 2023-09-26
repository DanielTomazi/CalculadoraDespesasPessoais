import java.util.ArrayList;
import java.util.Scanner;

class Despesa {
    private String descricao;
    private double valor;

    public Despesa(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}

class CalculadoraDespesas {
    private ArrayList<Despesa> despesas;

    public CalculadoraDespesas() {
        despesas = new ArrayList<>();
    }

    public void adicionarDespesa(String descricao, double valor) {
        Despesa despesa = new Despesa(descricao, valor);
        despesas.add(despesa);
        System.out.println("Despesa adicionada com sucesso!");
    }

    public void listarDespesas() {
        if (despesas.isEmpty()) {
            System.out.println("Nenhuma despesa encontrada.");
        } else {
            System.out.println("Lista de Despesas:");
            for (int i = 0; i < despesas.size(); i++) {
                Despesa despesa = despesas.get(i);
                System.out.println((i + 1) + ". " + despesa.getDescricao() + ": R$" + despesa.getValor());
            }
        }
    }

    public double calcularTotalDespesas() {
        double total = 0;
        for (Despesa despesa : despesas) {
            total += despesa.getValor();
        }
        return total;
    }

    public double calcularSaldo(double rendaMensal) {
        return rendaMensal - calcularTotalDespesas();
    }
}

public class CalculadoraDespesasPessoais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDespesas calculadora = new CalculadoraDespesas();

        System.out.print("Informe sua renda mensal: R$");
        double rendaMensal = scanner.nextDouble();
        scanner.nextLine(); // Limpar a quebra de linha

        while (true) {
            System.out.println("\n==== Calculadora de Despesas Pessoais ====");
            System.out.println("1. Adicionar Despesa");
            System.out.println("2. Listar Despesas");
            System.out.println("3. Calcular Total de Despesas");
            System.out.println("4. Calcular Saldo Disponível");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da despesa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o valor da despesa: R$");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar a quebra de linha
                    calculadora.adicionarDespesa(descricao, valor);
                    break;
                case 2:
                    calculadora.listarDespesas();
                    break;
                case 3:
                    double totalDespesas = calculadora.calcularTotalDespesas();
                    System.out.println("Total de Despesas: R$" + totalDespesas);
                    break;
                case 4:
                    double saldo = calculadora.calcularSaldo(rendaMensal);
                    System.out.println("Saldo Disponível: R$" + saldo);
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}

