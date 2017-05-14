package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Metapod;
import pokemon.Pinsir;
import pokemon.Pokemon;

public class BugCatcherBili extends Treinador{

	public BugCatcherBili() {
		super("Bug Catcher Bili", new Pokemon[] {new Metapod(), new Metapod(), new Metapod(), new Metapod(), new Metapod(), new Pinsir()}, new Item[] {new Potion(), new SuperPotion()}, 3);
	}

	public BugCatcherBili(int posicao) {
		super("Bug Catcher Bili", new Pokemon[] {new Metapod(), new Metapod(), new Metapod(), new Metapod(), new Metapod(), new Pinsir()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
}
