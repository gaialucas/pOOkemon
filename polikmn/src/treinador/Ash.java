package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Pidgeot;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Rhydon;

public class Ash extends Treinador{

	public Ash() {
		super("Ash", new Pokemon[] {new Pikachu(), new Pidgeot(), new Rhydon()}, new Item[] {new SuperPotion(), new Potion()});
	}

	public int estrategia() {
		if (getPokemonAtual().getHP() <= 30){ //usa item neste caso
			return 2;
		}else{
			return 1; //ataca
		}
	}
	
	public int escolheAtaque(){
		return 1;
	}
	
	public int escolheItem(){
		return 1;
	}
}
