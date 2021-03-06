package pokemon;

import ataques.Ataque;

abstract public class Pokemon {
	private int hp, maxHP, numAtaques;
	private String nome;
	private Ataque[] ataques;

	public Pokemon(String nomePokemon, int vida, Ataque[] ataquesPokemon){
		maxHP = vida;
		hp = vida;
		nome = nomePokemon;
		ataques = ataquesPokemon;
		numAtaques = ataquesPokemon.length;
	}

	public int getHP(){
		return hp;
	}
	
	public int getMaxHP(){
		return maxHP;
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
