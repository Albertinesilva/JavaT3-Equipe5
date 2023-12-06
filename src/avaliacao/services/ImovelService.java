package avaliacao.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    LocalDate penultimaLeitura = obterDataValida("\n\tData da penúltima leitura (dd/MM/yyyy): ");
    LocalDate ultimaLeitura;

    do {
      ultimaLeitura = obterDataValida("\n\tData da última leitura (dd/MM/yyyy): ");

      if (ultimaLeitura.isBefore(penultimaLeitura)) {
        Utils.limparTela();
        System.out.println("\n\tA data da última leitura deve ser posterior à data da penúltima leitura.");
        Utils.pausar(Utils.scan);
      }

    } while (ultimaLeitura.isBefore(penultimaLeitura));

    imoveis.add(new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura));

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

                LocalDate penultimaLeitura = obterDataValida(
                    "\n\tDigite a nova data da penúltima leitura (dd/MM/yyyy): ");
                LocalDate ultimaLeitura = obterDataValida("\n\tDigite a nova data da última leitura (dd/MM/yyyy): ");

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

      boolean imovelEncontrado = false;

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
    System.out.print("\n\t===== PESQUISA DE IMÓVEL =====");

    if (imoveis.size() > 0) {

      System.out.print("\n\tDigite a matrícula do imóvel: ");
      String matricula = Utils.scan.nextLine();

      boolean imovelEncontrado = false;

      for (Imovel imovel : imoveis) {

        if (imovel.getMatricula().equals(matricula)) {

          Utils.limparTela();
          System.out.print("\n\t===== DADOS DO IMOVEL =====");
          System.out.println(imovel.toString());
          Utils.pausar(Utils.scan);
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

  private static LocalDate obterDataValida(String prompt) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = null;
    boolean dataValida = false;

    do {
      try {
        System.out.print(prompt);
        String dataStr = Utils.scan.nextLine();
        data = LocalDate.parse(dataStr, formatter);
        dataValida = true; // Se chegou aqui, a data é válida
      } catch (Exception e) {
        Utils.limparTela();
        System.out.println("\n\tFormato de data inválido. Por favor, digite novamente no formato dd/MM/yyyy.");
        Utils.pausar(Utils.scan);
      }
    } while (!dataValida);

    return data;
  }
}