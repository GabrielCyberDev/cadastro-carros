import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // preço com ponto: 35000.50

        final int LIMITE = 50;
        Carro[] carros = new Carro[LIMITE]; // vetor com 50 posições

        int quantidade;
        do {
            System.out.print("Quantos carros deseja cadastrar (máximo 50)? ");
            quantidade = scanner.nextInt();
            if (quantidade < 1 || quantidade > LIMITE) {
                System.out.println("Quantidade inválida! Informe um valor entre 1 e " + LIMITE + ".");
            }
        } while (quantidade < 1 || quantidade > LIMITE);
        scanner.nextLine(); // limpa o buffer

        for (int i = 0; i < quantidade; i++) {
            System.out.println("--- Carro " + (i + 1) + " ---");
            System.out.print("Nome do modelo: ");
            String nome = scanner.nextLine();
            System.out.print("Preço (use ponto, ex.: 35000.50): ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // limpa o buffer

            carros[i] = new Carro(nome, preco);
        }

        System.out.println();
        System.out.println("===== RESUMO =====");
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + " - " + carros[i].getNome());
            soma += carros[i].getPreco();
        }

        System.out.println("Quantidade total de carros criados: " + quantidade);
        System.out.printf("Soma do preço de todos os carros: R$ %.2f%n", soma);

        scanner.close();
    }
}