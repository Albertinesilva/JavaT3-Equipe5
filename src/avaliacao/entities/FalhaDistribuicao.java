package avaliacao.entities;

import java.time.LocalDate;

public class FalhaDistribuicao extends Falha {

  public FalhaDistribuicao(String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    super(descricao, previsaoConclusao, dataInicio, dataFim);
    
  }
  
}