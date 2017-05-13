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
<<<<<<< HEAD

=======
	
>>>>>>> 521a61a50e4a5349fed53ed6ab18fdb8d38da9be
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nomeTreinador){
		nome = nomeTreinador;
	}
	
<<<<<<< HEAD
	public String getBag() {
		StringBuilder aux = new StringBuilder();
=======
	public String[] getBag() {
		String[] s = new String[bag.length];
>>>>>>> 521a61a50e4a5349fed53ed6ab18fdb8d38da9be
		for(int i = 0; i < bag.length; i++) {
			aux.append(i+": ");
			aux.append(bag[i].getNome()+" ");
		}
		String s = aux.toString();
		return s;
	}
	
	public String getTeam() {
		StringBuilder aux = new StringBuilder();
		for(int i = 0; i < pokemons.length; i++) {
			aux.append(i+": ");
			aux.append(pokemons[i].getNome()+" ");
		}
		String s = aux.toString();
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
		while(!getPokemon(aux).vivo() || aux==this.getIndex()){
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
	
	public int estrategia() {
		Random r = new Random();
		if (getPokemonAtual().getHP() <= 30){ //usa item neste caso
			return 2;
		}else{
			int action = r.nextInt(100);
			if(action < 1) return 4;//1% de chance de fugir
			else if (action < 26) return 2; //25% de chance de usar item
			else if (action < 35 && this.getNumPokemonsRestantes()!=1) return 3; //9% de chance de trocar, caso ele mais de 1 pkmn sobrando
			else return 1; //65% de chance de atacar
		}
	}
	
	public int escolheItem(){
		Random r = new Random();
		return r.nextInt(bag.length);
	}
	
	public int escolheAtaque(){
		Random r = new Random();
		return r.nextInt(getPokemonAtual().getNumAtaques());
	}
}