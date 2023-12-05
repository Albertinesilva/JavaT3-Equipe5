package avaliacao.service;

import java.util.ArrayList;
import java.util.List;

import avaliacao.entities.Cliente;
import avaliacao.repository.ClienteRepository;
import avaliacao.utils.Utils;

public class ClienteService implements ClienteRepository {

  List<Cliente> clientes = new ArrayList<>();

  @Override
  public void cadastrar(Cliente cliente) {
    
    Utils.limparTela();
    System.out.println("\n\t===== CADASTRO DE CLIENTE =====\n");

    System.out.print("Nome: ");
    String nome = Utils.scan.nextLine();

    System.out.print("CPF: ");
    String cpf = Utils.scan.nextLine();

    Cliente novoCliente = new Cliente(nome, cpf);
    clientes.add(novoCliente);

    System.out.println("\n\tCliente cadastrado com sucesso!");
    Utils.pausar(Utils.scan);
  }

  @Override
  public void adcionar(Cliente cliente) {
    clientes.add(cliente);
  }

  @Override
  public void listar() {
   
  }

  @Override
  public void excluir() {
   
    throw new UnsupportedOperationException("Unimplemented method 'excluir'");
  }

  @Override
  public void buscar() {
    
    throw new UnsupportedOperationException("Unimplemented method 'buscar'");
  }
  
}
