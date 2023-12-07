package avaliacao.entities;

import java.time.LocalDate;

public class FalhaDistribuicao extends Falha {

  public FalhaDistribuicao(String matriculaImovel, String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    super(matriculaImovel, descricao, previsaoConclusao, dataInicio, dataFim);
    
  }
  
}