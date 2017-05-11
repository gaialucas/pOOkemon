package treinador;

import java.util.Random;

import item.Item;
import pokemon.Pokemon;

public abstract class Treinador {
	private String nome;
	private Pokemon[] pokemons;
	private int numPokemonsRestantes;
	private int pkmnAtual = 0;
	private boolean perdeu = false;
	private Item[] bag;
	
	public Treinador(String nomeTreinador, Pokemon[] pokemonsTreinador, Item[] itens){
		nome = nomeTreinador;
		pokemons = pokemonsTreinador;
		numPokemonsRestantes = pokemonsTreinador.length;
		bag = itens;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String[] getBag() {
		String[] s = new String[bag.length];
		for(int i = 0; i < bag.length; i++) {
			s[i] = bag[i].getNome();
		}
		return s;
	}
	
	public Item getItem(int i) {
		return bag[i];
	}
	
	public int getNumPokemonsRestantes(){
		return numPokemonsRestantes;
	}
	
	public int getNumPokemons(){
		return pokemons.length;
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
		if (i >= 0 && i < pokemons.length){
			return pokemons[i];
		}else{
			return null;
		}
	}
	
	public int trocaPokemon(){
		Random r = new Random();
		int aux = r.nextInt(pokemons.length);
		while(!getPokemon(aux).vivo()){
			aux = r.nextInt(pokemons.length);
		}
		return aux;
	}
	
	public Pokemon getPokemonAtual(){
		return getPokemon(pkmnAtual);
	}
	
	public int getIndex(){
		return pkmnAtual;
	}
	
	public void setPokemonAtual(int i) {
		if (i >= 0 && i < pokemons.length)	pkmnAtual = i;
	}
	
	public boolean getPerdeu(){
		return perdeu;
	}
	
	public void setPerdeu() {
		perdeu = true;
	}
	
	abstract public int estrategia();
	abstract public int escolheAtaque();
	abstract public int escolheItem();
	
}
