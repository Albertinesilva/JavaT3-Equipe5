package avaliacao.entities;

public class Imovel {

  private String matricula;
  private String endereco;
  private int ultimaLeitura;
  private int penultimaLeitura;

  public Imovel(String matricula, String endereco, int ultimaLeitura) {
    this.matricula = matricula;
    this.endereco = endereco;
    this.ultimaLeitura = ultimaLeitura;
  }

  public String getMatricula() {
    return this.matricula;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public int getUltimaLeitura() {
    return this.ultimaLeitura;
  }

  public int getPenultimaLeitura() {
    return this.penultimaLeitura;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setUltimaLeitura(int novaLeitura) {
    this.penultimaLeitura = this.ultimaLeitura;
    this.ultimaLeitura = novaLeitura;
  }

  public void setPenultimaLeitura(int penultimaLeitura) {
    this.penultimaLeitura = penultimaLeitura;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
    result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
    result = prime * result + ultimaLeitura;
    result = prime * result + penultimaLeitura;
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
    Imovel other = (Imovel) obj;
    if (matricula == null) {
      if (other.matricula != null)
        return false;
    } else if (!matricula.equals(other.matricula))
      return false;
    if (endereco == null) {
      if (other.endereco != null)
        return false;
    } else if (!endereco.equals(other.endereco))
      return false;
    if (ultimaLeitura != other.ultimaLeitura)
      return false;
    if (penultimaLeitura != other.penultimaLeitura)
      return false;
    return true;
  }

  @Override
  public String toString() {

    return "\n\tMatricula: " + matricula + "\n\tEndereco: " + endereco + "\n\tPenultimaLeitura: "
        + penultimaLeitura + "\n\tUltimaLeitura: " + ultimaLeitura;
  }
}