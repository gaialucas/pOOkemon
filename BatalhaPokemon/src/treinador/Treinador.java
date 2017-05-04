package treinador;

import pokemon.Pokemon;

public class Treinador {
	private String nome;
	private Pokemon[] pokemons = new Pokemon[6];
	private int numPokemons, numPokemonsRestantes;
	
	public Treinador(String nomeTreinador, Pokemon[] pokemonsTreinador, int numPokemonsTreinador){
		nome = nomeTreinador;
		for (int i = 0; i < numPokemonsTreinador; i++)
			pokemons[i] = pokemonsTreinador[i];
		numPokemons = numPokemonsTreinador;
		numPokemonsRestantes = numPokemonsTreinador;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getNumPokemonsRestantes(){
		return numPokemonsRestantes;
	}
	
	public int getNumPokemons(){
		return numPokemons;
	}
	
	public void pokemonMorre(){
		numPokemonsRestantes--;
	}
	
	public void pokemonRevive(){
		numPokemonsRestantes++;
	}
	
	public boolean restaPokemons(){
		if (numPokemonsRestantes <= 0){
			return false;
		}else{
			return true;
		}
	}
	
	public Pokemon getPokemon(int i){
		if (i >= 0 && i < numPokemons){
			return pokemons[i];
		}else{
			return null;
		}
	}
	
}
