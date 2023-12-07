package avaliacao.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Falha {

  private static int proximoID = 1;
  private int id;
  private String matriculaImovel;
  private String descricao;
  private LocalDate previsaoConclusao;
  private LocalDate dataInicio;
  private LocalDate dataFim;

  public Falha(String matriculaImovel, String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    this.id = proximoID++;
    this.matriculaImovel = matriculaImovel;
    this.descricao = descricao;
    this.previsaoConclusao = previsaoConclusao;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
  }

  public int getId() {
    return this.id;
  }  

  public String getMatriculaImovel() {
    return this.matriculaImovel;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public LocalDate getPrevisaoConclusao() {
    return this.previsaoConclusao;
  }

  public LocalDate getDataInicio() {
    return this.dataInicio;
  }

  public LocalDate getDataFim() {
    return this.dataFim;
  }

  public void setMatriculaImovel(String matriculaImovel) {
    this.matriculaImovel = matriculaImovel;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setPrevisaoConclusao(LocalDate previsaoConclusao) {
    this.previsaoConclusao = previsaoConclusao;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((previsaoConclusao == null) ? 0 : previsaoConclusao.hashCode());
    result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
    result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
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
    Falha other = (Falha) obj;
    if (matriculaImovel == null) {
      if (other.matriculaImovel != null)
        return false;
    } else if (!matriculaImovel.equals(other.matriculaImovel))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (previsaoConclusao == null) {
      if (other.previsaoConclusao != null)
        return false;
    } else if (!previsaoConclusao.equals(other.previsaoConclusao))
      return false;
    if (dataInicio == null) {
      if (other.dataInicio != null)
        return false;
    } else if (!dataInicio.equals(other.dataInicio))
      return false;
    if (dataFim == null) {
      if (other.dataFim != null)
        return false;
    } else if (!dataFim.equals(other.dataFim))
      return false;
    return true;
  }

  @Override
  public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    StringBuilder sb = new StringBuilder();
    sb.append("Falha [");
    sb.append("id=").append(id).append(", ");

    if (matriculaImovel != null) {
        sb.append("matriculaImovel=").append(matriculaImovel).append(", ");
    } else {
        sb.append("matriculaImovel=não fornecida, ");
    }

    sb.append("descricao=").append(descricao)
      .append(", previsaoConclusao=").append(previsaoConclusao != null ? previsaoConclusao.format(dateFormatter) : "não especificada")
      .append(", dataInicio=").append(dataInicio.format(dateFormatter))
      .append(", dataFim=").append(dataFim != null ? dataFim.format(dateFormatter) : "ainda aberta")
      .append("]");

    return sb.toString();
  }

}