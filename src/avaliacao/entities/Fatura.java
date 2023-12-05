package avaliacao.entities;

import java.time.LocalDate;

public class Fatura {
  
  private LocalDate dataVencimento;
  private LocalDate ultimaLeitura;
  private LocalDate penultimaLeitura;
  private double valor;
  private boolean quitado;

  public Fatura(LocalDate dataVencimento, LocalDate ultimaLeitura, LocalDate penultimaLeitura, double valor) {
    this.dataVencimento = dataVencimento;
    this.ultimaLeitura = ultimaLeitura;
    this.penultimaLeitura = penultimaLeitura;
    this.valor = valor;
    this.quitado = false;
  }

  public LocalDate getDataVencimento() {
    return this.dataVencimento;
  }

  public LocalDate getUltimaLeitura() {
    return this.ultimaLeitura;
  }

  public LocalDate getPenultimaLeitura() {
    return this.penultimaLeitura;
  }

  public double getValor() {
    return this.valor;
  }

  public boolean isQuitado() {
    return this.quitado;
  }

  public void setDataVencimento(LocalDate dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public void setUltimaLeitura(LocalDate ultimaLeitura) {
    this.ultimaLeitura = ultimaLeitura;
  }

  public void setPenultimaLeitura(LocalDate penultimaLeitura) {
    this.penultimaLeitura = penultimaLeitura;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void setQuitado(boolean quitado) {
    this.quitado = quitado;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
    result = prime * result + ((ultimaLeitura == null) ? 0 : ultimaLeitura.hashCode());
    result = prime * result + ((penultimaLeitura == null) ? 0 : penultimaLeitura.hashCode());
    long temp;
    temp = Double.doubleToLongBits(valor);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + (quitado ? 1231 : 1237);
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
    Fatura other = (Fatura) obj;
    if (dataVencimento == null) {
      if (other.dataVencimento != null)
        return false;
    } else if (!dataVencimento.equals(other.dataVencimento))
      return false;
    if (ultimaLeitura == null) {
      if (other.ultimaLeitura != null)
        return false;
    } else if (!ultimaLeitura.equals(other.ultimaLeitura))
      return false;
    if (penultimaLeitura == null) {
      if (other.penultimaLeitura != null)
        return false;
    } else if (!penultimaLeitura.equals(other.penultimaLeitura))
      return false;
    if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
      return false;
    if (quitado != other.quitado)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Fatura [dataVencimento=" + dataVencimento + ", ultimaLeitura=" + ultimaLeitura + ", penultimaLeitura="
        + penultimaLeitura + ", valor=" + valor + ", quitado=" + quitado + "]";
  }
 
  
}