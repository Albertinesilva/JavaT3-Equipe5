package avaliacao.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

import avaliacao.entities.Cliente;
import avaliacao.repository.ClienteRepository;
import avaliacao.utils.Utils;

public class ClienteService implements ClienteRepository {

  public static List<Cliente> clientes = new ArrayList<>();

  @Override
  public void adcionar(Cliente cliente) {
    clientes.add(cliente);
  }

  public static void cadastrar() {

    Utils.limparTela();
    System.out.println("\n\t===== CADASTRO DE CLIENTE =====");

    System.out.print("\n\tNome do Cliente: ");
    String nome = Utils.scan.nextLine();

    System.out.print("\n\tDigite o CPF: ");
    String cpf = Utils.scan.nextLine();

    clientes.add(new Cliente(nome, cpf));

    Utils.limparTela();
    System.out.println("\n\tCliente cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  public static void listar() {
    Utils.limparTela();
    System.out.print("\n\t===== LISTAGEM DE CLIENTES =====");

    if (clientes.size() > 0) {
      for (Cliente cliente : clientes) {
        System.out.println(cliente.toString()); // Chama explicitamente o método toString
        System.out.print("\t================================");
      }
    } else {
      System.out.println("\n\tNão há clientes cadastrados!");
    }

    Utils.pausar(Utils.scan);
  }

  public static void editar() {

    Utils.limparTela();
    System.out.println("\n\t===== EDIÇÃO DE CLIENTE =====");

    System.out.print("\n\tDigite o CPF do cliente: ");
    String cpf = Utils.scan.nextLine();

    for (Cliente cliente : clientes) {
      if (cliente.getCpf().equals(cpf)) {

        Utils.limparTela();
        System.out.print("\n\t===== DADOS DO CLIENTE =====");
        System.out.println(cliente.toString());

        while (true) {
          try {
            System.out.print("\n\tDeseja realmente editar este cliente? (S/N): ");
            String opcao = Utils.scan.nextLine();

            if (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n")) {
              throw new InputMismatchException("Opção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
            }

            if (opcao.equalsIgnoreCase("s")) {
              Utils.limparTela();
              System.out.print("\n\tDigite o novo nome do cliente: ");
              String nome = Utils.scan.nextLine();

              System.out.println("\n\tDigite o novo CPF: ");
              cpf = Utils.scan.nextLine();

              cliente.setNome(nome);
              cliente.setCpf(cpf);

              Utils.limparTela();
              System.out.print("\n\t===== CLIENTE EDITADO =====");
              System.out.println(cliente.toString());
              System.out.println("\n\tCliente editado com sucesso!");
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
      } else {
        System.out.println("\n\tOps, Cliente não encontrado!..");
        Utils.pausar(Utils.scan);
        return;

      }
    }
  }

  public static void excluir() {

    Utils.limparTela();
    System.out.println("\n\t===== EXCLUSÃO DE CLIENTE =====");

    System.out.print("\n\tDigite o CPF do cliente: ");
    String cpf = Utils.scan.nextLine();

    for (Cliente cliente : clientes) {
      if (cliente.getCpf().equals(cpf)) {

        Utils.limparTela();
        System.out.print("\n\t===== DADOS DO CLIENTE =====");
        System.out.println(cliente.toString());

        while (true) {
          try {
            System.out.print("\n\tDeseja realmente excluir este cliente? (S/N): ");
            String opcao = Utils.scan.nextLine();

            if (!opcao.equalsIgnoreCase("s") && !opcao.equalsIgnoreCase("n")) {
              throw new InputMismatchException("Opção inválida. Digite 'S' para confirmar ou 'N' para cancelar.");
            }

            if (opcao.equalsIgnoreCase("s")) {
              Utils.limparTela();
              clientes.remove(cliente);
              System.out.println("\n\tCliente removido com sucesso!");
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
      } else {
        System.out.println("\n\tOps, Cliente não encontrado!..");
        Utils.pausar(Utils.scan);
        return;

      }
    }
  }

  public static void pesquisar() {
    Utils.limparTela();
    System.out.println("\n\t===== PESQUISA DE CLIENTE =====");

    try {
      System.out.print("\n\tDigite o CPF do cliente: ");
      String cpf = Utils.scan.nextLine();

      Cliente clienteEncontrado = null;

      for (Cliente cliente : clientes) {
        if (cliente.getCpf().equals(cpf)) {
          clienteEncontrado = cliente;
          break;
        }
      }

      if (clienteEncontrado != null) {
        Utils.limparTela();
        System.out.print("\n\t===== DADOS DO CLIENTE =====");
        System.out.println(clienteEncontrado.toString());
        Utils.pausar(Utils.scan);
      } else {
        throw new NoSuchElementException("\n\tOps, Cliente não encontrado!..");
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      Utils.pausar(Utils.scan);
    } catch (Exception e) {
      System.out.println("\n\tOps, ocorreu um erro inesperado: " + e.getMessage());
      Utils.pausar(Utils.scan);
    }
  }

}