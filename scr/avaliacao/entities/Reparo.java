package avaliacao.entities;

import java.time.LocalDate;

  public class Reparo {
  private String descricao;
  private LocalDate previsaoConclusao;
  private LocalDate dataInicio;
  private LocalDate dataFim;
  private boolean concluido;
  private Reparo reparoAuxiliar;
  private Falha falha;

  public Reparo(String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim, boolean concluido, Reparo reparoAuxiliar, Falha falha) {
    this.descricao = descricao;
    this.previsaoConclusao = previsaoConclusao;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.concluido = concluido;
    this.reparoAuxiliar = reparoAuxiliar;
    this.falha = falha;
  }

    public Reparo(String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, Falha falha) {
    this.descricao = descricao;
    this.previsaoConclusao = previsaoConclusao;
    this.dataInicio = dataInicio;
    this.falha = falha;
    this.dataFim = null;
    this.concluido = false;

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

  public boolean getConcluido() {
    return this.concluido;
  }

  public Reparo getReparoAuxiliar(){
    return this.reparoAuxiliar;
  }

  public Falha getFalha(){
    return this.falha;
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

  public void setConcluido(boolean concluido) {
    this.concluido = concluido;
  }

  public void setReparoAuxiliar(Reparo reparoAuxiliar){
    this.reparoAuxiliar = reparoAuxiliar;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((previsaoConclusao == null) ? 0 : previsaoConclusao.hashCode());
    result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
    result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
    result = prime * result + (concluido ? 1231 : 1237);
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
    Reparo other = (Reparo) obj;
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
    if (concluido != other.concluido)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Reparo [descricao=" + descricao + ", previsaoConclusao=" + previsaoConclusao + ", dataInicio=" + dataInicio
        + ", dataFim=" + dataFim + ", concluido=" + concluido + ", falha=" + falha.toString() + "]";
      }
}