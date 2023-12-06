package avaliacao.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

  }

  public static void excluir() {

  }

  public static void pesquisar() {

  }

  private static LocalDate obterDataValida(String prompt) {

    LocalDate data = null;
    boolean dataValida = false;

    do {

      try {
        System.out.print(prompt);
        String dataStr = Utils.scan.nextLine();
        data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dataValida = true; // Se chegou aqui, a data é válida

      } catch (Exception e) {
        Utils.limparTela();
        System.out.println("\n\tFormato de data inválido. Por favor, digite novamente.");
        Utils.pausar(Utils.scan);
      }
    } while (!dataValida);

    return data;
  }
}
