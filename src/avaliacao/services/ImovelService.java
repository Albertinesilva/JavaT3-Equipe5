package avaliacao.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import avaliacao.entities.Imovel;
import avaliacao.repositories.ImovelRepository;
import avaliacao.utils.Utils;

public class ImovelService implements ImovelRepository {

  public static List<Imovel> imoveis = new ArrayList<Imovel>();

  public void adcionar(Imovel imovel) {
    imoveis.add(imovel);
  }

  public static void cadastrar() {
    Utils.limparTela();
    System.out.println("\n\t===== CADASTRO DE IMÓVEL =====");

    System.out.print("\n\tMatrícula do Imóvel: ");
    String matricula = Utils.scan.nextLine();

    System.out.print("\n\tEndereço do Imóvel: ");
    String endereco = Utils.scan.nextLine();

    int ultimaLeitura = obterInteiroValido("\n\tLeitura atual (em kWh): ");

    imoveis.add(new Imovel(matricula, endereco, ultimaLeitura));

    Utils.limparTela();
    System.out.println("\n\tImóvel cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public static void listar() {

    Utils.limparTela();
    System.out.print("\n\t===== LISTAGEM DE IMÓVEIS =====");

    if (imoveis.size() > 0) {
      for (Imovel imovel : imoveis) {
        System.out.println(imovel.toString()); // Chama explicitamente o método toString
        System.out.print("\t================================");
      }
    } else {
      System.out.println("\n\tNão há imóveis cadastrados!");
    }

    Utils.pausar(Utils.scan);
  }

  public static void editar() {

    Utils.limparTela();
    System.out.println("\n\t===== EDIÇÃO DE IMOVEL =====");

    if (imoveis.size() > 0) {
      System.out.print("\n\tDigite a matrícula do imóvel: ");
      String matricula = Utils.scan.nextLine();

      for (Imovel imovel : imoveis) {
        if (imovel.getMatricula().equals(matricula)) {
          Utils.limparTela();
          System.out.print("\n\t===== DADOS DO IMOVEL =====");
          System.out.println(imovel.toString());
          System.out.println("\t===========================");

          while (true) {
            try {
              System.out.print("\n\tDeseja realmente editar este imóvel? (S/N): ");
              String opcao = Utils.scan.nextLine();

              if (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n")) {
                throw new InputMismatchException("Opção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
              }

              if (opcao.equalsIgnoreCase("s")) {
                Utils.limparTela();
                System.out.print("\n\tDigite o novo endereço do imóvel: ");
                String endereco = Utils.scan.nextLine();

                int penultimaLeitura = obterInteiroValido(
                    "\n\tDigite a nova leitura da penúltima leitura (em kWh): ");
                int ultimaLeitura = obterInteiroValido("\n\tDigite a nova leitura da última leitura (em kWh): ");

                imovel.setEndereco(endereco);
                imovel.setUltimaLeitura(ultimaLeitura);
                imovel.setPenultimaLeitura(penultimaLeitura);

                Utils.limparTela();
                System.out.print("\n\t===== IMOVEL EDITADO =====");
                System.out.println(imovel.toString());
                System.out.print("\t==========================");
                System.out.println("\n\tImóvel editado com sucesso!");
                Utils.pausar(Utils.scan);
                return;
              } else {
                System.out.println("\n\tOperação cancelada!");
                Utils.pausar(Utils.scan);
                return;
              }
            } catch (InputMismatchException e) {
              System.out.println("\n\t" + e.getMessage());
              // Limpar o buffer do scanner antes de continuar o loop
              Utils.scan.nextLine();
            }
          }
        }
      }

      Utils.limparTela();
      System.out.println("\n\tImóvel não encontrado!");
    } else {
      Utils.limparTela();
      System.out.println("\n\tNão há imóveis cadastrados!");
    }
    Utils.pausar(Utils.scan);
  }

  public static void excluir() {

    Utils.limparTela();
    System.out.println("\n\t===== EXCLUSÃO DE IMOVEL =====");

    if (imoveis.size() > 0) {
      System.out.print("\n\tDigite a matrícula do imóvel: ");
      String matricula = Utils.scan.nextLine();

      // boolean imovelEncontrado = false;

      for (Imovel imovel : imoveis) {
        if (imovel.getMatricula().equals(matricula)) {
          Utils.limparTela();
          System.out.print("\n\t===== DADOS DO IMOVEL =====");
          System.out.println(imovel.toString());
          System.out.print("\t===========================");

          while (true) {
            try {
              System.out.print("\n\tDeseja realmente excluir este imóvel? (S/N): ");
              String opcao = Utils.scan.nextLine();

              if (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n")) {
                throw new InputMismatchException("Opção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
              }

              if (opcao.equalsIgnoreCase("s")) {
                Utils.limparTela();
                imoveis.remove(imovel);
                System.out.println("\n\tImóvel excluído com sucesso!");
                Utils.pausar(Utils.scan);
                return;

              } else {
                System.out.println("\n\tOperação cancelada!");
                Utils.pausar(Utils.scan);
                return;
              }
            } catch (InputMismatchException e) {
              System.out.println("\n\t" + e.getMessage());
              // Limpar o buffer do scanner antes de continuar o loop
              Utils.scan.nextLine();
            }
          }
        }
      }

      Utils.limparTela();
      System.out.println("\n\tImóvel não encontrado!");
    } else {
      Utils.limparTela();
      System.out.println("\n\tNão há imóveis cadastrados!");
    }
    Utils.pausar(Utils.scan);
  }

  public static void pesquisar() {

    Utils.limparTela();
    System.out.print("\n\t===== PESQUISA DE IMÓVEL =====\n");

    if (imoveis.size() > 0) {
      System.out.print("\n\tDigite a matrícula do imóvel: ");
      String matricula = Utils.scan.nextLine();

      boolean imovelEncontrado = false;

      for (Imovel imovel : imoveis) {
        if (imovel.getMatricula().equals(matricula)) {
          Utils.limparTela();
          System.out.print("\n\t===== DADOS DO IMOVEL =====");
          System.out.println(imovel.toString());
          System.out.println("\t===========================");
          imovelEncontrado = true;
          break;
        }
      }

      if (!imovelEncontrado) {
        Utils.limparTela();
        System.out.println("\n\tImóvel não encontrado!");
      }

    } else {
      Utils.limparTela();
      System.out.println("\n\tNão há imóveis cadastrados!");
    }
    Utils.pausar(Utils.scan);
  }

  private static int obterInteiroValido(String prompt) {

    int valor = 0;
    boolean valorValido = false;

    do {
      try {
        System.out.print(prompt);
        valor = Integer.parseInt(Utils.scan.nextLine());
        valorValido = true; // Se chegou aqui, o valor é válido

      } catch (NumberFormatException e) {
        Utils.limparTela();
        System.out.println("\n\tPor favor, digite um valor inteiro válido.");
        Utils.pausar(Utils.scan);
      }
    } while (!valorValido);

    return valor;
  }

  public static Imovel buscaImovel() {

    Utils.limparTela();
    System.out.print("\n\t===== PESQUISA DE IMÓVEL POR MATRÍCULA =====");

    if (imoveis.size() > 0) {

      while (true) {

        System.out.print("\n\tDigite a matrícula do imóvel: ");
        String matricula = Utils.scan.nextLine();
        Utils.limparTela();

        boolean imovelEncontrado = false;

        for (Imovel imovel : imoveis) {

          if (imovel.getMatricula().equals(matricula)) {
            Utils.limparTela();
            System.out.print("\n\t===== DADOS DO IMOVEL =====");
            System.out.println(imovel.toString());
            System.out.println("\t===========================");

            // Pergunta se é o Imovel correto
            while (true) {
              System.out.print("\n\tEsse é o Imovel correto? (S/N): ");
              String resposta = Utils.scan.nextLine();

              if (resposta.equalsIgnoreCase("S")) {
                Utils.pausar(Utils.scan);
                return imovel;
              } else

              if (resposta.equalsIgnoreCase("N")) {
                imovelEncontrado = true;
                break; // Retorna ao loop anterior para pedir uma nova matrícula

              } else {
                Utils.limparTela();
                System.out.println("\n\tOpção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
              }
            }
          }
        }
        if (!imovelEncontrado) {
          Utils.limparTela();
          System.out.println("\n\tImóvel não encontrado!");
        }
      }
    } else {
      Utils.limparTela();
      System.out.println("\n\tNão há imóveis cadastrados!");
    }

    Utils.pausar(Utils.scan);
    return null; // Se não encontrou, retorna null
  }

}