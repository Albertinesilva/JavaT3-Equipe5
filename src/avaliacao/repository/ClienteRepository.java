package avaliacao.repository;

import java.util.ArrayList;
import java.util.List;

import avaliacao.entities.Cliente;

public interface ClienteRepository{
  
  public void adcionar(Cliente cliente);

  public void cadastrar(Cliente cliente);

  public void listar();

  public void excluir();

  public void buscar();
}