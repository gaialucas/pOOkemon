package pokemon;

public class Pokemon {
	private int hp, maxHP, numAtaques = 0;
	private String nome;
	private Ataque[] ataques = new Ataque[4];
	
	public Pokemon(int vida, String nomePokemon, Ataque[] ataquesPokemon, int numAtaquesPokemon){
		maxHP = vida;
		hp = vida;
		nome = nomePokemon;
		for (int i = 0; i < numAtaquesPokemon; i++){
			ataques[i] = ataquesPokemon[i];
		}
		numAtaques = numAtaquesPokemon;
	}
	
	public int getHP(){
		return hp;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getNumAtaques(){
		return numAtaques;
	}
	
	public Ataque getAtaque(int i){
		if (i >= 0 && i < numAtaques){
			return ataques[i];
		}else{
			return null;
		}
	}
	
	public void mudaHP(int alteracao){ //dano = alteracao negativa; cura = alteracao positiva
		if (hp + alteracao > maxHP){
			hp = maxHP;
		}else{
			if (hp + alteracao < 0){
				hp = 0;
			}else{
				hp+=alteracao;
			}
		}
	}
	
	public boolean vivo(){
		if (hp <= 0){
			return false;
		}else{
			return true;
		}
	}
	
}
