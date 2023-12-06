package avaliacao.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import avaliacao.services.ClienteService;

public class Utils {

  LocalDateTime agora = LocalDateTime.now();
  public static Scanner scan = new Scanner(System.in);

  public static void MainEnergiaCoelho() {

    int opcao = -1;

    do {

      opcao = dispMain();

      switch (opcao) {
        case 1:
          menuCliente();
          break;
        case 2:
          // menuImoveis();
          break;
        case 3:
          // menuContas();
          break;
        case 4:
          // menuPagamentos();
          break;
        case 5:
          // menuRelatorios();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar a nossa Energia Coelho, Saindo!...");
          System.exit(0);
          break;
      }

    } while (opcao != 0);

  }

  public static int dispMain() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== ENERGIA COELHO =====");
      System.out.print("\n\t[1] - GESTÃO CLIENTES");
      System.out.print("\n\t[2] - GESTÃO IMÓVEIS");
      System.out.print("\n\t[3] - GESTÃO CONTAS");
      System.out.print("\n\t[4] - GESTÃO PAGAMENTOS");
      System.out.print("\n\t[5] - GESTÃO RELATÓRIOS");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 5) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 5.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 5);

    return opcao;
  }

  private static int dispMenuClientes() {

    int opcao = -1;

    do {
      limparTela();
      imprimirFormatado(LocalDateTime.now());
      calcularDiasRestantes(LocalDateTime.now());
      System.out.print("\n\t===== GESTÃO CLIENTE =====");
      System.out.print("\n\t[1] - CADASTRAR");
      System.out.print("\n\t[2] - LISTAR");
      System.out.print("\n\t[3] - EDITAR");
      System.out.print("\n\t[4] - EXCLUIR");
      System.out.print("\n\t[5] - PESQUISAR");
      System.out.print("\n\t[6] - MENU PRINCIPAL");
      System.out.print("\n\t[0] - SAIR");
      System.out.print("\n\tENTRADA -> ");

      try {
        opcao = scan.nextInt();
        scan.nextLine();

        if (opcao < 0 || opcao > 6) {
          System.out.println("\n\tOps, opção inválida. Digite um número entre 0 e 6.");
          pausar(scan);
          limparTela();
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\tOps, entrada inválida. Digite um número inteiro.");
        scan.next(); // Limpa o buffer do scanner
        pausar(scan);
        limparTela();
      }

    } while (opcao < 0 || opcao > 6);

    return opcao;
  }

  public static void menuCliente() {

    int opcao = -1;

    do {

      opcao = dispMenuClientes();

      switch (opcao) {
        case 1:
          ClienteService.cadastrar();
          break;
        case 2:
          ClienteService.listar();
          break;
        case 3:
          ClienteService.editar();
          break;
        case 4:
          ClienteService.excluir();
          break;
        case 5:
          ClienteService.pesquisar();
          break;
        case 6:
          System.out.println("\n\tRetornando ao menu principal...");
          pausar(scan);
          MainEnergiaCoelho();
          break;
        case 0:
          System.err.println("\n\tObrigado por utilizar o Energia Coelho, Saindo!...");
          System.exit(0);
          break;
        default:
          System.out.println("\n\tOpção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  public static void imprimirFormatado(LocalDateTime dataHora) {
    System.out.println("\n\tHoje é " + dataHora.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));
  }

  public static void calcularDiasRestantes(LocalDateTime dataHora) {

    LocalDate hoje = dataHora.toLocalDate();
    LocalDate ultimoDiaDoAno = LocalDate.of(hoje.getYear(), 12, 31);
    long diasRestantes = (ChronoUnit.DAYS.between(hoje, ultimoDiaDoAno)) + 1;
    System.out.println("\tJá se passaram " + ((dataHora.getDayOfYear()) - 1) + " dias, resta " + (diasRestantes)
        + " dias para o final do ano.");

  }

  public static void limparTela() {
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (final Exception e) {
      // Trata exceções (pode ser uma exceção de interrupção)
      e.printStackTrace();
    }
  }

  public static void pausar(Scanner scan) {
    System.out.print("\n\tPressione ENTER para continuar...");
    scan.nextLine();
  }
}