package avaliacao.entities;

import java.time.LocalDate;

public class Falha {

  private String descricao;
  private LocalDate previsaoConclusao;
  private LocalDate dataInicio;
  private LocalDate dataFim;

  public Falha(String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    this.descricao = descricao;
    this.previsaoConclusao = previsaoConclusao;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
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
    return "Falha [descricao=" + descricao + ", previsaoConclusao=" + previsaoConclusao + ", dataInicio=" + dataInicio
        + ", dataFim=" + dataFim + "]";
  }

}