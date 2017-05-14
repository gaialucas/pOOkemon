package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Dragonite;
import pokemon.Charizard;
import pokemon.Gyarados;
import pokemon.Pokemon;

public class Lance extends Treinador{

	public Lance() {
		super("Lance", new Pokemon[] {new Gyarados(), new Dragonite(), new Charizard(), new Dragonite()}, new Item[] {new Potion(), new SuperPotion()}, 3);
	}

	public Lance(int posicao) {
		super("Lance", new Pokemon[] {new Gyarados(), new Dragonite(), new Charizard(), new Dragonite()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
}
