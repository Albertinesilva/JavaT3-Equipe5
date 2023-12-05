package avaliacao.entities;

import java.time.LocalDate;

public class FalhaGeracao extends Falha {

  public FalhaGeracao(String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    super(descricao, previsaoConclusao, dataInicio, dataFim);

  }
}