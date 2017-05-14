package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Venusaur;
import pokemon.Rhydon;
import pokemon.Machamp;
import pokemon.Pokemon;

public class Hugo extends Treinador{

	public Hugo() {
		super("Hugo", new Pokemon[] {new Venusaur(), new Rhydon(), new Machamp()}, new Item[] {new Potion(), new SuperPotion()}, 3);
	}

	public Hugo(int posicao) {
		super("Hugo", new Pokemon[] {new Venusaur(), new Rhydon(), new Machamp()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
}
