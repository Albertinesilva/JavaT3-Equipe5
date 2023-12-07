package avaliacao.entities;

import java.time.LocalDate;

public class FalhaGeracao extends Falha {

  public FalhaGeracao(String matriculaImovel, String descricao, LocalDate previsaoConclusao, LocalDate dataInicio, LocalDate dataFim) {
    super(matriculaImovel, descricao, previsaoConclusao, dataInicio, dataFim);

  }
}