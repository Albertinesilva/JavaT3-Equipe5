package avaliacao.services;
import java.util.*;
import avaliacao.utils.*;
import avaliacao.entities.*;

public class FaturaService {
    private static List<Fatura> listaFatura = new ArrayList<>();

    public static void registrarConsumo() {
		Imovel imovel = ImovelService.buscaImovel();

		if(imovel == null) {
			Utils.cxMsg("Imóvel não encontrado!");
			return;
		}

		while (true) {
			int valorLido;
			try {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				
				Utils.limparTela();
				System.out.print("Informe a leitura realizada: ");
				valorLido = scanner.nextInt();
				if(imovel.getUltimaLeitura() > valorLido){
					Utils.cxMsg("A leitura atual não pode ser menor que a leitura antiga!");
					continue;
				}
				imovel.setUltimaLeitura(valorLido);
				novaFatura(imovel);
				Utils.cxMsg("O consumo foi registrado e a fatura foi gerada!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}

    	
    }
    
    public static void novaFatura(Imovel imovel) {    	
    	Fatura nova = new Fatura(imovel.getMatricula(), imovel.getUltimaLeitura(), imovel.getPenultimaLeitura());
    	listaFatura.add(nova);
    }

    public static void todasAsFaturas() {
        Utils.limparTela();
        System.out.println("=============== TODAS AS FATURAS ===============");
        System.out.println("");
        
        for (Fatura f : listaFatura) {
			System.out.println(f.toString());
		}
		Scanner scanner = new Scanner(System.in);
        Utils.pausar(scanner);
    }

    public static void faturasEmAberto() {
    	Utils.limparTela();
        System.out.println("=============== FATURAS EM ABERTO ===============");
        System.out.println("");
        
        for (Fatura f : listaFatura) {
        	if(!f.isQuitado())
        		System.out.println(f.toString());
		}
        Utils.pausar(Utils.scan);
    }

    public static Fatura obterFaturaPorMesEmissao() {
        Imovel imovel = ImovelService.buscaImovel();
    	
		if(imovel == null) {
			Utils.cxMsg("Imóvel não encontrado!");
			return null;
		}
    	
    	int valorLido = 0;
    	int k = 0;
		while (valorLido > 12 || valorLido < 1) {
			try {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);

				Utils.limparTela();
				System.out.print("Informe o mês referente à fatura: ");
				valorLido = scanner.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			if (valorLido > 12 || valorLido < 1) {
				Utils.cxMsg("O mês informado é inválido!");
				k++;
			}
			if(k == 3) {
				Utils.cxMsg("Limite de tentativas excedidas! Tente novamente!");
			}
		}
		
		for (Fatura fatura : listaFatura) {
            if (fatura.getMatriculaImovel().equalsIgnoreCase(imovel.getMatricula()) && fatura.getDataEmissao().getMonthValue() == valorLido) {
                return fatura;
            }
        }
        return null;
    }
    
    public static void todosOsPagamentos() {
		Utils.limparTela();
    	System.out.println("=============== TODOS OS PAGAMENTOS ===============");
    	System.out.println("");
    	for (Fatura f : listaFatura) {
    		System.out.println("===== IMÓVEL DE MATRÍCULA: " + f.getMatriculaImovel() + " =====");
    		System.out.println("");
			for (Pagamento p : f.getPagamentos()) {
				System.out.println(p.toString());
			}
			System.out.println("");
		}
    	Scanner scanner = new Scanner(System.in);
        Utils.pausar(scanner);
    }

    public static void pagamentosPorFatura() {
		Fatura encontrada = obterFaturaPorMesEmissao();
		
		if(encontrada == null) {
			Utils.cxMsg("Não foi encontrado nenhuma fatura com as descrições informadas!");
			return;
		}
		
		Utils.limparTela();
    	System.out.println("=============== PAGAMENTOS RELACIONADOS À FATURA ===============");
    	System.out.println("");
    	for (Pagamento p : encontrada.getPagamentos()) {
    		System.out.println(p.toString());
		}
    	Scanner scanner = new Scanner(System.in);
        Utils.pausar(scanner);
    }

    public static void todosOsReembolsos() {
		Utils.limparTela();
    	System.out.println("=============== TODOS OS REEMBOLSOS ===============");
    	System.out.println("");
    	for (Fatura f : listaFatura) {
    		System.out.println("===== IMÓVEL DE MATRÍCULA: " + f.getMatriculaImovel() + " =====");
    		System.out.println("");
			System.out.println(f.getReembolso().toString());
			System.out.println("");
		}
    	Scanner scanner = new Scanner(System.in);
        Utils.pausar(scanner);
    }
    
    public static void reembolsosPorFatura() {
		Fatura encontrada = obterFaturaPorMesEmissao();
		
		if(encontrada == null) {
			Utils.cxMsg("Não foi encontrado nenhuma fatura com as descrições informadas!");
			return;
		}
		
		Utils.limparTela();
    	System.out.println("=============== REEMBOLSOS RELACIONADOS À FATURA ===============");
    	System.out.println("");
    	if(encontrada.getReembolso() != null)
    		System.out.println(encontrada.getReembolso().toString());
    	else
    		System.out.println("Não há reembolsos para essa fatura!");
    	Scanner scanner = new Scanner(System.in);
        Utils.pausar(scanner);
    }

}