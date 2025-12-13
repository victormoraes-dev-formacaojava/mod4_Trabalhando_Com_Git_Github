package formacaojava.victormoraes.dev;

import java.util.Scanner;

public class GerenciadorNotas {
    private static final int MAX_ALUNOS = 50;
    private static final int MIN_ALUNOS = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeAlunos = lerQuantidadeAlunos(scanner);
        // Aqui virão as próximas etapas
        scanner.close();
    }

    // Método para ler e validar quantidade de alunos
    private static int lerQuantidadeAlunos(Scanner scanner) {
        int qtd;
        do {
            System.out.print("Digite a quantidade de alunos (1 a " + MAX_ALUNOS + "): ");
            while (!scanner.hasNextInt()) { // Valida se é inteiro
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next(); // Limpa input inválido
                System.out.print("Digite a quantidade de alunos (1 a " + MAX_ALUNOS + "): ");
            }
            qtd = scanner.nextInt();
            if (qtd < MIN_ALUNOS || qtd > MAX_ALUNOS) {
                System.out
                        .println("Quantidade deve ser entre " + MIN_ALUNOS + " e " + MAX_ALUNOS + ". Tente novamente.");
            }
        } while (qtd < MIN_ALUNOS || qtd > MAX_ALUNOS);
        return qtd;
    }

    private static double[] lerNotasAlunos(Scanner scanner, int quantidadeAlunos) {
        double[] todasNotas = new double[quantidadeAlunos * 2]; // Duas notas por aluno
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Aluno " + (i + 1) + ":");
            // Nota 1: prova
            todasNotas[i * 2] = lerNotaComValidacao(scanner, "prova");
            // Nota 2: trabalho
            todasNotas[i * 2 + 1] = lerNotaComValidacao(scanner, "trabalho");
        }
        return todasNotas;
    }

    // Método auxiliar para uma nota só
    private static double lerNotaComValidacao(Scanner scanner, String tipo) {
        double nota;
        do {
            System.out.print("Digite a nota da " + tipo + " (0 a 10): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, digite um número decimal válido.");
                scanner.next();
                System.out.print("Digite a nota da " + tipo + " (0 a 10): ");
            }
            nota = scanner.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("Nota deve ser entre 0 e 10. Tente novamente.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }
}
