package treinador;

import pokemon.Alakazam;
import pokemon.Blastoise;
import pokemon.Charizard;
import pokemon.Dragonite;
import pokemon.Gengar;
import pokemon.Jynx;
import pokemon.Machamp;
import pokemon.Metapod;
import pokemon.Pidgeot;
import pokemon.Pikachu;
import pokemon.Pinsir;
import pokemon.Pokemon;
import pokemon.Raichu;
import pokemon.Rhydon;
import pokemon.Scyther;
import pokemon.Venusaur;

public class PokemonUnico extends Treinador{

	public PokemonUnico(int i) {
		super(null, 1);
		switch (i){
		case 1:
			setNome("Alakazam");
			setPokemons(new Pokemon[] {new Alakazam()});
			break;
		case 2:
			setNome("Blastoise");
			setPokemons(new Pokemon[] {new Blastoise()});
			break;
		case 3:
			setNome("Charizard");
			setPokemons(new Pokemon[] {new Charizard()});
			break;
		case 4:
			setNome("Dragonite");
			setPokemons(new Pokemon[] {new Dragonite()});
			break;
		case 5:
			setNome("Gengar");
			setPokemons(new Pokemon[] {new Gengar()});
			break;
		case 6:
			setNome("Jynx");
			setPokemons(new Pokemon[] {new Jynx()});
			break;
		case 7:
			setNome("Machamp");
			setPokemons(new Pokemon[] {new Machamp()});
			break;
		case 8:
			setNome("Metapod");
			setPokemons(new Pokemon[] {new Metapod()});
			break;
		case 9:
			setNome("Pidgeot");
			setPokemons(new Pokemon[] {new Pidgeot()});
			break;
		case 10:
			setNome("Pikachu");
			setPokemons(new Pokemon[] {new Pikachu()});
			break;
		case 11:
			setNome("Pinsir");
			setPokemons(new Pokemon[] {new Pinsir()});
			break;
		case 12:
			setNome("Raichu");
			setPokemons(new Pokemon[] {new Raichu()});
			break;
		case 13:
			setNome("Rhydon");
			setPokemons(new Pokemon[] {new Rhydon()});
			break;
		case 14:
			setNome("Scyther");
			setPokemons(new Pokemon[] {new Scyther()});
			break;
		case 15:
			setNome("Venusaur"); 
			setPokemons(new Pokemon[] {new Venusaur()});
			break;
		}
	}
	
	public int estrategia() {
			return 1; //ataca
	}
	
	public int escolheItem(){
		return 0;
	}
}
