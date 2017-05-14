package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Gengar;
import pokemon.Machamp;
import pokemon.Pokemon;
import pokemon.Raichu;

public class Red extends Treinador{

	public Red() {
		super("Red", new Pokemon[] {new Raichu(), new Machamp(), new Gengar()}, new Item[] {new Potion(), new SuperPotion()}, 3);
	}
	
	public Red(int posicao) {
		super("Red", new Pokemon[] {new Raichu(), new Machamp(), new Gengar()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
}
