package avaliacao.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import avaliacao.entities.FalhaDistribuicao;
import avaliacao.entities.FalhaGeracao;
import avaliacao.entities.Imovel;
import avaliacao.repositories.FalhaRepository;
import avaliacao.utils.Utils;

public class FalhaService implements FalhaRepository {
    public static List<FalhaDistribuicao> falhasDist = new ArrayList<>();
    public static List<FalhaGeracao> falhasGer = new ArrayList<>();

    public static void cadastrarFalhaDistribuicao() {

        Utils.limparTela();
        System.out.println("\n\t===== CADASTRO DE FALHA DE DISTRIBUIÇÃO=====");

        System.out.println("\n\tA falha foi reportada por algum cliente? (S/N)");
        String resposta = Utils.scan.nextLine();
        String matriculaImovel = null;
        if (resposta.equalsIgnoreCase("S")) {
            System.out.print("\n\tDigite a matrícula do imóvel: ");
            matriculaImovel = Utils.scan.nextLine();

            Imovel imovel = ImovelService.buscaImovel();

            if (imovel == null) {
                Utils.cxMsg("Imóvel não encontrado!");
                return;
            }
        } 
        
        System.out.print("\n\tDigite a descrição da falha: ");
        String descricao = Utils.scan.nextLine();

        System.out.print("\n\tDigite a previsão de conclusão: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate previsaoConclusao = LocalDate.parse(Utils.scan.nextLine(), formatter);

        System.out.print("\n\tDigite a data de início: ");
        LocalDate dataInicio = LocalDate.parse(Utils.scan.nextLine(), formatter);
        
        FalhaDistribuicao falhaDist = new FalhaDistribuicao(matriculaImovel, descricao, previsaoConclusao, dataInicio, null);
    
        falhasDist.add(falhaDist);
    }

    public static void cadastrarFalhaGeracao() {
        Utils.limparTela();
        System.out.println("\n\t===== CADASTRO DE FALHA DE GERAÇÃO =====");

        System.out.println("\n\tA falha foi reportada por algum cliente? (S/N)");
        String resposta = Utils.scan.nextLine();
        String matriculaImovel = null;
        if (resposta.equalsIgnoreCase("S")) {
            System.out.print("\n\tDigite a matrícula do imóvel: ");
            matriculaImovel = Utils.scan.nextLine();

            Imovel imovel = ImovelService.buscaImovel();

            if (imovel == null) {
                Utils.cxMsg("Imóvel não encontrado!");
                return;
            }
        } 

        System.out.print("\n\tDigite a descrição da falha: ");
        String descricao = Utils.scan.nextLine();

        System.out.print("\n\tDigite a previsão de conclusão: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate previsaoConclusao = LocalDate.parse(Utils.scan.nextLine(), formatter);

        System.out.print("\n\tDigite a data de início: ");
        LocalDate dataInicio = LocalDate.parse(Utils.scan.nextLine(), formatter);

        FalhaGeracao falhaGer = new FalhaGeracao(matriculaImovel, descricao, previsaoConclusao, dataInicio, null);

        falhasGer.add(falhaGer);
    }
}
