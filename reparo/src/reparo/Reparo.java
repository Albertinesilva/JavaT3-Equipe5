package reparo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import falha .FalhaDistribuicao;

public class Reparo {
	
	static public ArrayList<Reparo> listaReparos = new ArrayList<>();;
	private String descricao;
	private String previsao;
	private LocalDate inicio;
	private LocalDate fim;
	private boolean resolvido;
	private FalhaDistribuicao falha;
	private Reparo novoReparo;	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPrevisao() {
		return previsao;
	}
	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public boolean isResolvido() {
		return resolvido;
	}
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	public FalhaDistribuicao getFalha() {
		return falha;
	}
	public void setFalha(FalhaDistribuicao falha) {
		this.falha = falha;
	}
	
	
	public void imprimeReparo() {
		System.out.println("Descricao: "+this.descricao+", Previsao: "+this.previsao+", finaliza: "+this.resolvido);
	}
	
	public void encerraReparo() {
		Scanner s = new Scanner(System.in);
		int resposta;
		this.fim = LocalDate.now();
		
		System.out.println("O reparo ralizado resolveu a falha? (1 - sim/2 - não)");
		resposta = s.nextInt();
		
		if(resposta == 2) {
			System.out.println("Criando reparo auxiliar");
			this.novoReparo = Reparo.criaReparo(this.falha);
			Reparo.listaReparos.add(this.novoReparo);
		}
		else 
			this.resolvido = true;
	}
	
	static public Reparo criaReparo(FalhaDistribuicao falha) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite a descrição do reparo");
		String descricao = s.nextLine();
		System.out.println("Digite a previsao do reparo");
		String previsao = s.nextLine();
		
		Reparo novoReparo = new Reparo();
		novoReparo.setDescricao(descricao);
		novoReparo.setPrevisao(previsao);
		novoReparo.setInicio(LocalDate.now());
		novoReparo.setResolvido(false);
		novoReparo.setFalha(falha);
		
		
		Reparo.listaReparos.add(novoReparo);
		return novoReparo;
	}
	
	
	static public void imprimeReparosAbertos() {
		for(Reparo reparo: Reparo.listaReparos) {
			if(!reparo.resolvido)
				reparo.imprimeReparo();
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			Reparo reparo = new Reparo();
			reparo = Reparo.criaReparo(new FalhaDistribuicao());
			reparo.encerraReparo();
		}
		for(Reparo reparo: Reparo.listaReparos) {
			reparo.imprimeReparo();
		}
		System.out.println("-------------------");
		Reparo.imprimeReparosAbertos();
	}
}
