package treinador;

import item.Item;
import item.Potion;
import item.SuperPotion;

import java.util.Scanner;

import pokemon.Alakazam;
import pokemon.Charizard;
import pokemon.Pokemon;

public class Jogador extends Treinador{
private Scanner sc = new Scanner(System.in);;
	
	public Jogador() {
		super("Jogador", new Pokemon[] {new Alakazam(), new Charizard()}, new Item[] {new Potion(), new SuperPotion()}, 0);
	}
	
	public Jogador(int posicao) {
		super("Jogador", new Pokemon[] {new Alakazam(), new Charizard()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
	
	public Jogador(String nome) {
		super(nome, new Pokemon[] {new Alakazam(), new Charizard()}, new Item[] {new Potion(), new SuperPotion()}, 3);
	}
	
	public Jogador(String nome, int posicao) {
		super(nome, new Pokemon[] {new Alakazam(), new Charizard()}, new Item[] {new Potion(), new SuperPotion()}, posicao);
	}
	
	public int estrategia() {
		int num = 0;
		while (num > 4 || num < 1){
<<<<<<< HEAD
			System.out.println(getNome()+ ", escolha uma acao: 1-atacar; 2-usar item; 3-trocar pokémon; 4-fugir.");
=======
			System.out.println(getNome()+ ", escolha uma acao: 1-atacar; 2-usar item; 4-fugir.");
>>>>>>> 521a61a50e4a5349fed53ed6ab18fdb8d38da9be
			num = sc.nextInt();
		}
		return num;
	}
	
	public int escolheAtaque(){
		int num = 5;
		while ((num > getPokemonAtual().getNumAtaques()-1) || num < 0){
			System.out.println(getNome()+", escolha um ataque: ");
			for(int i = 0; i<getPokemonAtual().getNumAtaques()-1; i++){
				System.out.print(i+"-"+getPokemonAtual().getAtaque(i).getNome()+" ("+getPokemonAtual().getAtaque(i).getDano()+" de dano), ");
			}
			System.out.print(getPokemonAtual().getNumAtaques()-1+"-"+getPokemonAtual().getAtaque(getPokemonAtual().getNumAtaques()-1).getNome()+" ("+getPokemonAtual().getAtaque(getPokemonAtual().getNumAtaques()-1).getDano()+" de dano), ");
			num = sc.nextInt();
		}
		return num;
	}
	
	public int escolheItem(){ //arrumar
		int num = 5;
		while (num > 1 || num < 0){
			System.out.println(getNome()+", escolha um item: "+getBag());
			num = sc.nextInt();
		}
		return num;
	}
	
	public int trocaPokemon() {
		int num = 7;
		while(num < 0 || num > getNumPokemons()){
			System.out.println(getNome()+", escolha um pokémon: "+getTeam());
			num = sc.nextInt();
		}
		while(!getPokemon(num).vivo() || num==this.getIndex()){
			System.out.println(getNome()+", escolha um pokémon: "+getTeam());
			num = sc.nextInt();
		}

	return num;
	}
}