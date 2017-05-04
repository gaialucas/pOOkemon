package pokemon;

public class Ataque {
	private String nome;
	private int dano, prioridade;
	
	public Ataque(String nomeAtaque, int danoAtaque, int prioridadeAtaque){
		nome = nomeAtaque;
		dano = danoAtaque;
		prioridade = prioridadeAtaque;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getDano(){
		return dano;
	}
	
	public int getPrioridadeAtaque(){
		return prioridade;
	}
}
