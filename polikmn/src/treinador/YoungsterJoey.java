package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Pokemon;
import pokemon.Rattata;


public class YoungsterJoey extends Treinador{

	public YoungsterJoey() {
		super("Youngster Joey", new Pokemon[] {new Rattata()}, new Item[] {new Potion(), new SuperPotion()}, 3);
	}

	public YoungsterJoey(int posicao) {
		super("Youngster Joey", new Pokemon[] {new Rattata()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
}
