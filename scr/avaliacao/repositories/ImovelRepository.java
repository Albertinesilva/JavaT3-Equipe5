package avaliacao.repositories;

import avaliacao.entities.Imovel;

public interface ImovelRepository {
  
  public void adcionar(Imovel imovel);

  public static void cadastrar(){}

  public static void listar(){}

  public static void editar(){}

  public static void excluir(){}

  public static void pesquisar(){}

  public static Imovel buscaImovel(){
    return null;
  }
}
