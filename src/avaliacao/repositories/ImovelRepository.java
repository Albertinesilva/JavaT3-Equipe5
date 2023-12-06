package avaliacao.repositories;

import java.time.LocalDate;

import avaliacao.entities.Imovel;

public interface ImovelRepository {
  
  public void adcionar(Imovel imovel);

  public static void cadastrar(){}

  public static void listar(){}

  public static void editar(){}

  public static void excluir(){}

  public static void pesquisar(){}

  private static LocalDate obterDataValida(String prompt){
    return null;
  }
}
