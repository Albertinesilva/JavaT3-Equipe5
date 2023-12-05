package avaliacao.entities;

import java.time.LocalDate;

public class Reembolso {
  
  private LocalDate data;
  private double valor;

  public Reembolso(LocalDate data, double valor) {
    this.data = data;
    this.valor = valor;
  }

  public LocalDate getData() {
    return this.data;
  }

  public double getValor() {
    return this.valor;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    long temp;
    temp = Double.doubleToLongBits(valor);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Reembolso other = (Reembolso) obj;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Reembolso [data=" + data + ", valor=" + valor + "]";
  }

  
}