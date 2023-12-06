package avaliacao.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

  private String nome;
  private String cpf;
  private List<Imovel> imoveis;

  public Cliente(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    this.imoveis = new ArrayList<>();
  }

  //Não implementei o setImoveis estou na duvida se é necessario.
  public List<Imovel> getImoveis() {
    return this.imoveis;
  }

  public void adicionarImovel(Imovel imovel) {
    this.imoveis.add(imovel);
  }

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (cpf == null) {
      if (other.cpf != null)
        return false;
    } else if (!cpf.equals(other.cpf))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "\n\tNome: " + nome + "\n\tCPF : " + cpf;
  }

}