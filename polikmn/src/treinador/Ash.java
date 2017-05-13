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
		super("Ash", new Pokemon[] {new Pikachu(), new Pidgeot(), new Rhydon()}, new Item[] {new SuperPotion(), new Potion()}, 0);
	}
	
	public Ash(int posicao) {
		super("Ash", new Pokemon[] {new Pikachu(), new Pidgeot(), new Rhydon()}, new Item[] {new SuperPotion(), new Potion()}, posicao);
	}
}
