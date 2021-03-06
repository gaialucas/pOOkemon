package batalha;

import java.util.Random;

import item.Item;
import treinador.Ash;
import treinador.BugCatcherBili;
import treinador.Hugo;
import treinador.Jogador;
import treinador.Lance;
import treinador.PokemonUnico;
import treinador.Red;
import treinador.Treinador;
import treinador.YoungsterJoey;

public class BatalhaPokemon extends Controller {
	private static int mapa[] = {0, 1, 1, 1};//0: chão comum (sem pokemon); 1: gramado (pode ter pokemon);
	
	private class Ataque extends Event {
		private int i;
		private Treinador treinador1, treinador2;
		public Ataque (Treinador atacante, Treinador defensor, int atkEscolhido, long eventTime) {
			super(eventTime);
			i = atkEscolhido;
			treinador1 = atacante;
			treinador2 = defensor;
		}
		
		public void action () {
			//System.out.println(i+" "+treinador1.getPokemonAtual().getNumAtaques());
			treinador2.getPokemonAtual().mudaHP(-(treinador1.getPokemonAtual().getAtaque(i).getDano()));
		}
		
		public String description () { 
			return treinador1.getPokemonAtual().getNome() + " usou " + treinador1.getPokemonAtual().getAtaque(i).getNome()+"\n"+treinador2.getPokemonAtual().getNome()+" HP:"+treinador2.getPokemonAtual().getHP()+"/"+treinador2.getPokemonAtual().getMaxHP(); 
		}
	}
	
	private class Fugir extends Event {
		private Treinador treinador;
		public Fugir (Treinador t, long eventTime) {
			super(eventTime);
			treinador = t;
		}
		
		public void action () {
			treinador.setFugiu();
		}
		
		public String description () { 
			return treinador.getNome()+" fugiu da batalha!"; 
		}

	}
	
	private class TrocarPokemon extends Event {
		private Treinador treinador;
		private int novoPokemon;
		public TrocarPokemon (Treinador t, int indiceTroca, long eventTime) {
			super(eventTime);
			treinador = t;
			novoPokemon = indiceTroca;
			
		}
		
		public void action () {
			treinador.setPokemonAtual(novoPokemon);
		}
		
		public String description () { 
			return treinador.getNome()+" trocou para "+treinador.getPokemonAtual().getNome(); 
		}

	}
	
	private class UsarItem extends Event {
		private Treinador treinador/*, oponente*/;
		private int pokemon;
		private Item i;
		public UsarItem (Treinador t/*, Treinador t2*/, int indicePokemonEscolhido, Item item, long eventTime) {
			super(eventTime);
			treinador = t;
			/*oponente = t2;*/
			pokemon = indicePokemonEscolhido;
			i = item;
		}
		
		public void action () {
			treinador.getPokemon(pokemon).mudaHP(i.getCura());
		}
		
		public String description () { 
			return treinador.getNome()+" usou " +i.getNome()+ " em "+treinador.getPokemon(pokemon).getNome()+" (HP: "+treinador.getPokemon(pokemon).getHP()+"/"+treinador.getPokemon(pokemon).getMaxHP()+")";
		}

	}
	
	
	private class Andar extends Event {
		private Treinador treinador;
		private int direcao;
		public Andar (Treinador t, int direcaoEscolhida, long eventTime) {
			super(eventTime);
			treinador = t;
			direcao = direcaoEscolhida;
		}
		
		public void action () {
			if(treinador.getPosicao() + direcao >= 0 && treinador.getPosicao() + direcao < mapa.length){
				treinador.setPosicao(treinador.getPosicao()+direcao); //o metodo so muda se andar para um campo valido no vetor[0..5]
			}
		}
		
		public String description () {
			if(treinador.getPosicao() + direcao >= 0 && treinador.getPosicao() + direcao < mapa.length){
				if (mapa[treinador.getPosicao()] == 0){
					return treinador.getNome()+" está na posição "+treinador.getPosicao()+" (chao comum).";
				}else{
					return treinador.getNome()+" está na posição "+treinador.getPosicao()+" (gramado).";
				}
			}else return "Treinador parado.";
		}

	}
	
	public void batalha(Treinador treinador1, Treinador treinador2, long tm){
		int i = 0;
		int comando1, comando2; //comando dos jogadores 1 e 2
		if(PokemonUnico.class.isInstance(treinador2)){
			System.out.println("Um "+treinador2.getNome()+" selvagem apareceu! ");
		}else System.out.println(treinador2.getNome()+" desafiou "+treinador1.getNome()+"!");
		do{/* Enquanto nenuhm jogador ganhou a batalha */
			comando1 = treinador1.estrategia();
			comando2 = treinador2.estrategia();
			if(comando1 >= comando2) { //1 prevalece
				switch(comando1){
				case 1:
					int atk1 = treinador1.escolheAtaque();
					int atk2 = treinador2.escolheAtaque();
					if (treinador1.getPokemonAtual().getAtaque(atk1).getPrioridadeAtaque() >= treinador2.getPokemonAtual().getAtaque(atk2).getPrioridadeAtaque()){ //primeiro tem prioridade ou ambos tem a mesma prioridade
						addEvent(new Ataque(treinador1, treinador2, atk1, tm + i));
						run();
						i+=1000;
						//checa se o pokemon defensor está vivo
						if(treinador2.getPokemonAtual().vivo()){
							addEvent(new Ataque(treinador2, treinador1, atk2, tm + i));
						}else{//caso morto, troca de pkmn ou anuncia derrota
							System.out.println(treinador2.getPokemonAtual().getNome()+" morreu!");
							treinador2.pokemonMorre();
							if(treinador2.restaPokemons()){
								addEvent(new TrocarPokemon(treinador2, treinador2.trocaPokemon(), tm + i));
							}else{
								treinador2.setPerdeu();
							}
						}
						run();
						i+=1000;
						//checa se o pokemon atacante está vivo
						if(!treinador1.getPokemonAtual().vivo()) {//caso morto, troca ou anuncia derrota
							System.out.println(treinador1.getPokemonAtual().getNome()+" morreu!");
							treinador1.pokemonMorre();
							if(treinador1.restaPokemons()){
								addEvent(new TrocarPokemon(treinador1, treinador1.trocaPokemon(), tm + i));
								run();
								i+=1000;
							}else{
								treinador1.setPerdeu();
							}
						}
					}else{// segundo ataque tem prioridade
						addEvent(new Ataque(treinador2, treinador1, atk2, tm + i));
						run();
						i+=1000;
						//checa se o pokemon defensor está vivo
						if(treinador1.getPokemonAtual().vivo()){
							addEvent(new Ataque(treinador1, treinador2, treinador1.escolheAtaque(), tm + i));
						}else{//caso morto, troca ou anuncia derrota
							System.out.println(treinador1.getPokemonAtual().getNome()+" morreu!");
							treinador1.pokemonMorre();
							if(treinador1.restaPokemons()){
								addEvent(new TrocarPokemon(treinador1, treinador1.trocaPokemon(), tm + i));
							}else{
								treinador1.setPerdeu();
							}
						}
						run();
						i+=1000;
						//checa se o pokemon atacante está vivo
						if(!treinador2.getPokemonAtual().vivo()) {//caso morto, troca ou anuncia derrota
							System.out.println(treinador2.getPokemonAtual().getNome()+" morreu!");
							treinador2.pokemonMorre();
							if(treinador2.restaPokemons()){
								addEvent(new TrocarPokemon(treinador2, treinador2.trocaPokemon(), tm + i));
								run();
								i+=1000;
							}else{
								treinador2.setPerdeu();
							}
						}
					}
					break;
				case 2:
					addEvent(new UsarItem(treinador1, treinador1.getIndex(), treinador1.getItem(treinador1.escolheItem()), tm + i));
					run();
					i+=1000;
					switch(comando2){//o que o outro jogador escolheu
					case 1: //ataque
						addEvent(new Ataque(treinador2, treinador1, treinador2.escolheAtaque(), tm + i));
						run();
						i+=1000;
						//checa se o pokemon defensor está vivo
						if(!treinador1.getPokemonAtual().vivo()){
							System.out.println(treinador1.getPokemonAtual().getNome()+" morreu!");
							treinador1.pokemonMorre();
							if(treinador1.restaPokemons()){
								addEvent(new TrocarPokemon(treinador1, treinador1.trocaPokemon(), tm + i));
								run();
								i+=1000;
							}else{
								treinador1.setPerdeu();
							}
						}
						break;
					case 2: //item
						addEvent(new UsarItem(treinador2, treinador2.getIndex(), treinador2.getItem(treinador2.escolheItem()), tm + i));
						run();
						i+=1000;
						break;
					}
					break;
				case 3:
					addEvent(new TrocarPokemon(treinador1, treinador1.trocaPokemon(), tm + i));
					run();
					i+=1000;
					switch(comando2){//o que o outro jogador escolheu
					case 1: //ataque
						addEvent(new Ataque(treinador2, treinador1, treinador2.escolheAtaque(), tm + i));
						run();
						i+=1000;
						//checa se o pokemon defensor está vivo
						if(!treinador1.getPokemonAtual().vivo()){
							System.out.println(treinador1.getPokemonAtual().getNome()+" morreu!");
							treinador1.pokemonMorre();
							if(treinador1.restaPokemons()){
								addEvent(new TrocarPokemon(treinador1, treinador1.trocaPokemon(), tm + i));
								run();
								i+=1000;
							}else{
								treinador1.setPerdeu();
							}
						}
						break;
					case 2: //item
						addEvent(new UsarItem(treinador2, treinador2.getIndex(), treinador2.getItem(treinador2.escolheItem()), tm + i));
						run();
						i+=1000;
						break;
					case 3: 
						addEvent(new TrocarPokemon(treinador2, treinador2.trocaPokemon(), tm + i));
						run();
						i+=1000;
						break;
					}
					break;
				case 4:
					addEvent(new Fugir(treinador1, tm + i));
					run();
					i+=1000;
					break;
				}
				
			}else{//comando 2 possui maior prioridade
				switch(comando2){
				case 2:
					addEvent(new UsarItem(treinador2, treinador2.getIndex(), treinador2.getItem(treinador2.escolheItem()), tm + i));
					run();
					i+=1000;
					addEvent(new Ataque(treinador1, treinador2, treinador1.escolheAtaque(), tm + i));
					run();
					i+=1000;
					//checa se o pokemon defensor está vivo
					if(!treinador2.getPokemonAtual().vivo()){
						System.out.println(treinador2.getPokemonAtual().getNome()+" morreu!");
						treinador2.pokemonMorre();
						if(treinador2.restaPokemons()){
							addEvent(new TrocarPokemon(treinador2, treinador2.trocaPokemon(), tm + i));
							run();
							i+=1000;
						}else{
							treinador2.setPerdeu();
						}
					}
					break;
				case 3:
					addEvent(new TrocarPokemon(treinador2, treinador2.trocaPokemon(), tm + i));
					run();
					i+=1000;
					switch(comando1){
					case 1:
						addEvent(new Ataque(treinador1, treinador2, treinador1.escolheAtaque(), tm + i));
						run();
						i+=1000;
						//checa se o pokemon defensor está vivo
						if(!treinador2.getPokemonAtual().vivo()){
							System.out.println(treinador2.getPokemonAtual().getNome()+" morreu!");
							treinador2.pokemonMorre();
							if(treinador2.restaPokemons()){
								addEvent(new TrocarPokemon(treinador2, treinador2.trocaPokemon(), tm + i));
								run();
								i+=1000;
							}else{
								treinador2.setPerdeu();
							}
						}
						break;
					case 2:
						addEvent(new UsarItem(treinador1, treinador1.getIndex(), treinador1.getItem(treinador1.escolheItem()), tm + i));
						run();
						i+=1000;
						break;
					}
					break;
				case 4:
					addEvent(new Fugir(treinador2, tm + i));
					run();
					i+=1000;
					break;
				}
			}
			tm = System.currentTimeMillis();
			i = 0;
			
		}while(!(treinador1.getPerdeu()||treinador2.getPerdeu()));
		
		//Condições de derrota
		if(treinador1.getPerdeu()){
			System.out.println(treinador2.getNome()+" ganhou!");
		}else{
			System.out.println(treinador1.getNome()+" ganhou!");
		}
	}
	
	public int encontraBatalha(Treinador treinador1, Treinador treinador2){
		if ((treinador1.getPosicao() == treinador2.getPosicao()) && !treinador2.getPerdeu()){ //se estao na mesma posicao e o treinador 2 ainda nao foi derrotado
			return 2; //batalha
		}
		if (mapa[treinador1.getPosicao()] == 0){
			return 0; //nada
		}else{
			Random r = new Random();
			int aux = r.nextInt(3); // um terço de chance de encontrar
			if (aux == 1)
				return 1; //encontra pokemon
			else
				return 0; //nada
		}
	}
	
		public static void main(String[] args) {
			Treinador treinador1, treinador3, treinador4;
			Treinador[] treinador2 = {new Red(), new YoungsterJoey(), new Lance(), new BugCatcherBili(), new Hugo()};
			treinador1 = new Ash();
			treinador4 = new Jogador("João");
			long tm;
			int direcao, i = 0;
			Random r = new Random();
			BatalhaPokemon batalha = new BatalhaPokemon();
			/*batalha.addEvent(batalha.new Restart(tm));
			batalha.run(); teste dos comandos*/
			tm = System.currentTimeMillis();
			//condições iniciais
			batalha.addEvent(batalha.new Andar(treinador1, 0, tm + i));
			batalha.run();
			i+=1000;
			while (!treinador1.getPerdeu()){
				direcao = r.nextInt(2);
				if (direcao == 1){
					batalha.addEvent(batalha.new Andar(treinador1, 1, tm + i));
				}else{
					batalha.addEvent(batalha.new Andar(treinador1, -1, tm + i));
				}
				i+=1000;
				batalha.run();
				switch (batalha.encontraBatalha(treinador1, treinador4)){
				case 0:
					System.out.println("Não aconteceu nada.");
					break;
				case 1:
					System.out.println("Encontrou um pokemon.");
					treinador3 = new PokemonUnico(r.nextInt(15)+1);
					batalha.batalha(treinador1, treinador3, tm + i);
					tm = System.currentTimeMillis();
					i = 0;
					//batalha contra um pokemon
					break;
				case 2:
					int aux = r.nextInt(treinador2.length);
					if(!treinador2[aux].getPerdeu()){ //trocar para treinador4 caso queira ser o oponente.
						System.out.println("Encontrou um treinador.");
						batalha.batalha(treinador1, treinador2[aux], tm + i); //vide acima
					}
					tm = System.currentTimeMillis();
					i = 0;
					break;
				}
				if(treinador1.getFugiu()){
					treinador1.controleDerrota();
				}
			}
			System.out.println("Fim - treinador sem pokemons para continuar.");
		}
	
}