package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Blastoise;
import pokemon.Gengar;
import pokemon.Pokemon;
import pokemon.Raichu;

public class Red extends Treinador{

	public Red() {
		super("Red", new Pokemon[] {new Blastoise(), new Raichu(), new Gengar()}, new Item[] {new Potion(), new SuperPotion()});
	}
	
	public int estrategia() {
		if (getPokemon(getPokemonAtual()).getHP() <= 30){ //usa item neste caso
			return 2;
		}else{
			return 1; //ataca
		}
	}
	
	public int escolheAtaque(){
		return 1;
	}
	
	public int escolheItem(){
		return 0;
	}
}
