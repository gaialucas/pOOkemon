package treinador;

import java.util.Scanner;

import pokemon.Alakazam;
import pokemon.Charizard;
import pokemon.Pokemon;

public class Jogador extends Treinador{
private Scanner sc = new Scanner(System.in);;
	
	public Jogador() {
		super("Jogador", new Pokemon[] {new Alakazam(), new Charizard()}, 2);
	}
	
	public Jogador(String nome) {
		super(nome, new Pokemon[] {new Alakazam(), new Charizard()}, 2);
	}
	
	public int estrategia() {
		int num = 0;
		while (num > 4 || num < 1){
			System.out.println(getNome()+ ", escolha uma a��o: 1-atacar; 2-usar item; 4-fugir.");
			num = sc.nextInt();
		}
		return num;
	}
	
	public int escolheAtaque(){
		int num = 5;
		while ((num > getPokemon(getPokemonAtual()).getNumAtaques()-1) || num < 0){
			System.out.println(getNome()+", escolha um ataque: ");
			for(int i = 0; i<getPokemon(getPokemonAtual()).getNumAtaques()-1; i++){
				System.out.print(i+"-"+getPokemon(getPokemonAtual()).getAtaque(i).getNome()+" ("+getPokemon(getPokemonAtual()).getAtaque(i).getDano()+" de dano), ");
			}
			System.out.print(getPokemon(getPokemonAtual()).getNumAtaques()-1+"-"+getPokemon(getPokemonAtual()).getAtaque(getPokemon(getPokemonAtual()).getNumAtaques()-1).getNome()+" ("+getPokemon(getPokemonAtual()).getAtaque(getPokemon(getPokemonAtual()).getNumAtaques()-1).getDano()+" de dano), ");
			num = sc.nextInt();
		}
		return num;
	}
	
	public int escolheItem(){
		int num = 5;
		while (num > 1 || num < 0){
			System.out.println(getNome()+", escolha um item: 0-potion (restaura 20 de HP); 1-super potion (restaura 50 de HP)");
			num = sc.nextInt();
		}
		return num;
	}
}