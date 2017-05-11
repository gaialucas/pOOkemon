package treinador;

import pokemon.Alakazam;
import pokemon.Pokemon;

public class PokemonUnico extends Treinador{

	public PokemonUnico() {
		super("Alakazam", new Pokemon[] {new Alakazam()}, null, 1);
	}
	
	public int estrategia() {
			return 1; //ataca
	}
	
	public int escolheAtaque(){
		return 1;
	}
	
	public int escolheItem(){
		return 0;
	}
}
