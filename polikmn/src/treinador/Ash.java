package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;
import pokemon.Blastoise;
import pokemon.Charizard;
import pokemon.Pidgeot;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Rhydon;
import pokemon.Venusaur;

public class Ash extends Treinador{

	public Ash() {
		super("Ash", new Pokemon[] {new Pikachu(),new Charizard(), new Blastoise(), new Venusaur(), new Pidgeot(), new Rhydon()}, new Item[] {new SuperPotion(), new Potion()}, 0);
	}
	
	public Ash(int posicao) {
		super("Ash", new Pokemon[] {new Pikachu(),new Charizard(), new Blastoise(), new Venusaur(), new Pidgeot(), new Rhydon()}, new Item[] {new SuperPotion(), new Potion()}, posicao);
	}
}
