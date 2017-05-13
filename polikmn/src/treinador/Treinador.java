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
	private int posicaoMapa;
	
	public Treinador(String nomeTreinador, Pokemon[] pokemonsTreinador, Item[] itens, int posicao){
		nome = nomeTreinador;
		pokemons = pokemonsTreinador;
		numPokemonsRestantes = pokemonsTreinador.length;
		bag = itens;
		posicaoMapa = posicao;
	}
	
	public Treinador(Item[] itens, int posicao){
		bag = itens;
		posicaoMapa = posicao;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nomeTreinador){
		nome = nomeTreinador;
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
	
	public void setPokemons(Pokemon[] pokemonsTreinador){
		pokemons = pokemonsTreinador;
		numPokemonsRestantes = pokemonsTreinador.length;
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
	
	public int getPosicao(){
		return posicaoMapa;
	}
	
	public void setPosicao(int posicao){
		if (posicao >= 0 && posicao < 4){ //referente ao mapa: vetor de 0 a 3
			posicaoMapa = posicao;
		}
	}
	
	public void setPerdeu() {
		perdeu = true;
	}
	
	abstract public int estrategia();
	abstract public int escolheAtaque();
	abstract public int escolheItem();
	
}