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
  }
