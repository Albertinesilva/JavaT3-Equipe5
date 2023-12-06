package avaliacao.entities;

public class Imovel {

  private String matricula;
  private String endereco;
  private int UltimaLeitura;
  private int penultimaLeitura;

  public Imovel(String matricula, String endereco, int ultimaLeitura, int penultimaLeitura) {
    this.matricula = matricula;
    this.endereco = endereco;
    UltimaLeitura = ultimaLeitura;
    this.penultimaLeitura = penultimaLeitura;
  }

  public String getMatricula() {
    return this.matricula;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public int getUltimaLeitura() {
    return this.UltimaLeitura;
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

  public void setUltimaLeitura(int ultimaLeitura) {
    UltimaLeitura = ultimaLeitura;
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
    result = prime * result + UltimaLeitura;
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
    if (UltimaLeitura != other.UltimaLeitura)
      return false;
    if (penultimaLeitura != other.penultimaLeitura)
      return false;
    return true;
  }

  @Override
  public String toString() {

    return "\n\tMatricula: " + matricula + "\n\tEndereco: " + endereco + "\n\tPenultimaLeitura: "
        + penultimaLeitura + "\n\tUltimaLeitura: " + UltimaLeitura;
  }
}