package batalha;

import item.Item;
import item.Potion;
import item.SuperPotion;
import treinador.Ash;
import treinador.Jogador;
import treinador.Red;
import treinador.Treinador;

public class BatalhaPokemon extends Controller {
	private Treinador treinador1, treinador2;
	
	public BatalhaPokemon (Treinador t1, Treinador t2) {
		treinador1 = t1;
		treinador2 = t2;
	}
	
	private class Ataque12 extends Event {
		private int i;
		public Ataque12 (int atkEscolhido, long eventTime) {
			super(eventTime);
			i = atkEscolhido;
		}
		
		public void action () {
			treinador2.getPokemon(treinador2.getPokemonAtual()).mudaHP(-(treinador1.getPokemon(treinador1.getPokemonAtual()).getAtaque(i).getDano()));
		}
		
		public String description () { 
			return treinador1.getPokemon(treinador1.getPokemonAtual()).getNome() + " (HP: "+treinador1.getPokemon(treinador1.getPokemonAtual()).getHP()+"/"+treinador1.getPokemon(treinador1.getPokemonAtual()).getMaxHP()+") atacou " + treinador2.getPokemon(treinador2.getPokemonAtual()).getNome() + " (HP: "+treinador2.getPokemon(treinador2.getPokemonAtual()).getHP()+"/"+treinador2.getPokemon(treinador2.getPokemonAtual()).getMaxHP()+") com " + treinador1.getPokemon(treinador1.getPokemonAtual()).getAtaque(i).getNome(); 
		}
	}
	
	private class Ataque21 extends Event {
		private int i;
		public Ataque21 (int atkEscolhido, long eventTime) {
			super(eventTime);
			i = atkEscolhido;
		}
		
		public void action () {
			treinador1.getPokemon(treinador1.getPokemonAtual()).mudaHP(-(treinador2.getPokemon(treinador2.getPokemonAtual()).getAtaque(i).getDano()));
		}
		
		public String description () { 
			return treinador2.getPokemon(treinador2.getPokemonAtual()).getNome() + " (HP: "+treinador2.getPokemon(treinador2.getPokemonAtual()).getHP()+"/"+treinador2.getPokemon(treinador2.getPokemonAtual()).getMaxHP()+") atacou " + treinador1.getPokemon(treinador1.getPokemonAtual()).getNome() + " (HP: "+treinador1.getPokemon(treinador1.getPokemonAtual()).getHP()+"/"+treinador1.getPokemon(treinador1.getPokemonAtual()).getMaxHP()+") com " + treinador2.getPokemon(treinador2.getPokemonAtual()).getAtaque(i).getNome(); 
		}

	}
	
	private class Fugir extends Event {
		private Treinador treinador;
		public Fugir (Treinador t, long eventTime) {
			super(eventTime);
			treinador = t;
		}
		
		public void action () {
			treinador.setPerdeu();
		}
		
		public String description () { 
			return "O treinador "+treinador.getNome()+" fugiu da batalha!"; 
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
			return "O treinador "+treinador.getNome()+" trocou para "+treinador.getPokemon(treinador.getPokemonAtual()).getNome(); 
		}

	}
	
	private class UsarItem extends Event {
		private Treinador treinador;
		private int pokemon;
		private Item i;
		public UsarItem (Treinador t,int indicePokemonEscolhido, Item item, long eventTime) {
			super(eventTime);
			treinador = t;
			pokemon = indicePokemonEscolhido;
			i = item;
		}
		
		public void action () {
			treinador.getPokemon(pokemon).mudaHP(i.getCura());
		}
		
		public String description () { 
			return "O treinador "+treinador.getNome()+" usou o " +i.getNome()+ " em "+treinador.getPokemon(pokemon).getNome()+" (HP: "+treinador.getPokemon(treinador.getPokemonAtual()).getHP()+"/"+treinador.getPokemon(treinador.getPokemonAtual()).getMaxHP()+")"; 
		}

	}
	
	private class Restart extends Event {
		public Restart(long eventTime) {
			super(eventTime);
		}
		public void action() {
			long tm = System.currentTimeMillis();
			// Instead of hard-wiring, you could parse
			// configuration information from a text
			// file here:
			//teste
			addEvent(new Ataque12(1, tm));
			addEvent(new Ataque21(1, tm + 1000));
			addEvent(new UsarItem(treinador1, 0, new Potion(), tm + 1500));
			addEvent(new Ataque12(1, tm + 2000));
			addEvent(new Ataque21(1, tm + 3000));
			addEvent(new UsarItem(treinador2, 0, new SuperPotion(), tm + 3500));
			addEvent(new Ataque12(1, tm + 4000));
			addEvent(new Ataque21(1, tm + 5000));
			addEvent(new TrocarPokemon(treinador1, 1, tm + 6000));
			addEvent(new UsarItem(treinador2, 0, new Potion(), tm + 6500));
			addEvent(new Ataque12(1, tm + 7000));
			addEvent(new Ataque21(1, tm + 8000));
			addEvent(new Fugir(treinador1, tm + 9000));
		}
		public String description() {
			return "Restarting system";
		}
	}
	
	public void batalha(long tm){
		int i = 0;
		int comando1, comando2; //comando dos jogadores 1 e 2
		int ataque1, ataque2; //ataques escolhidos
		do{ /*enquanto nenhum dos dois treinadores ganhou a batalha*/
			comando1 = treinador1.estrategia();
			comando2 = treinador2.estrategia();
			if (comando1 > comando2){ //1 antes
				switch (comando1){
				case 2:
					if (treinador1.escolheItem() == 1){
						addEvent(new UsarItem(treinador1, treinador1.getPokemonAtual(), new SuperPotion(), tm + i));
					}else{
						addEvent(new UsarItem(treinador1, treinador1.getPokemonAtual(), new Potion(), tm + i));
					}
					i+=1000;
					run();
					//comando1 = 2 ==> comando2 = 1 
					ataque2 = treinador2.escolheAtaque();
					addEvent(new Ataque21(ataque2, tm + i));	
					run();
					i+=1000;
					/*verifica se o pokemon do treinador 1 esta vivo e o troca caso necessario/possivel*/
					if (treinador1.getPokemon(treinador1.getPokemonAtual()).getHP() == 0){
						System.out.println(treinador1.getPokemon(treinador1.getPokemonAtual()).getNome()+" sem HP");
						treinador1.pokemonMorre();
						if (!treinador1.restaPokemons()){
							treinador1.setPerdeu();
						}else{
							addEvent(new TrocarPokemon(treinador1, treinador1.getPokemonAtual()+1, tm + i));
							run();
							i+=1000;
						}
					}
					break;
				case 3: //as trocas estao sendo feitas quando o pokemon fica fora de combate
					break;
				case 4:
					addEvent(new Fugir(treinador1, tm + i));
					run();
					break;
				}
			}else{
				if (comando2 > comando1){//2 antes
					switch (comando2){
					case 2:
						if (treinador2.escolheItem() == 1){
							addEvent(new UsarItem(treinador2, treinador2.getPokemonAtual(), new SuperPotion(), tm + i));
						}else{
							addEvent(new UsarItem(treinador2, treinador2.getPokemonAtual(), new Potion(), tm + i));
						}
						i+=1000;
						run();
						//comando2 = 2 ==> comando1 = 1 
						ataque1 = treinador1.escolheAtaque();
						addEvent(new Ataque12(ataque1, tm + i));	
						run();
						i+=1000;
						/*verifica se o pokemon do treinador 1 esta vivo e o troca caso necessario/possivel*/
						if (treinador2.getPokemon(treinador2.getPokemonAtual()).getHP() == 0){
							System.out.println(treinador2.getPokemon(treinador2.getPokemonAtual()).getNome()+" sem HP");
							treinador2.pokemonMorre();
							if (!treinador2.restaPokemons()){
								treinador2.setPerdeu();
							}else{
								addEvent(new TrocarPokemon(treinador2, treinador2.getPokemonAtual()+1, tm + i));
								run();
								i+=1000;
							}
						}
						break;
					case 3: //as trocas estao sendo feitas quando o pokemon fica fora de combate
						break;
					case 4:
						addEvent(new Fugir(treinador2, tm + i));
						run();
						break;
					}
				}else{
					if (comando1 == 1){ //verifica prioridade de ataque
						ataque1 = treinador1.escolheAtaque();
						ataque2 = treinador2.escolheAtaque();
						if (treinador1.getPokemon(treinador1.getPokemonAtual()).getAtaque(ataque1).getPrioridadeAtaque() >= treinador2.getPokemon(treinador2.getPokemonAtual()).getAtaque(ataque2).getPrioridadeAtaque()){ //primeiro tem prioridade ou ambos tem a mesma prioridade
							addEvent(new Ataque12(ataque1, tm + i));
							run();
							i+=1000;
							/*verifica se o pokemon do treinador 2 esta vivo para atacar (senao o troca caso possivel)*/
							if (treinador2.getPokemon(treinador2.getPokemonAtual()).getHP() == 0){
								System.out.println(treinador2.getPokemon(treinador2.getPokemonAtual()).getNome()+" sem HP");
								treinador2.pokemonMorre();
								if (!treinador2.restaPokemons()){
										treinador2.setPerdeu();
								}else{
									addEvent(new TrocarPokemon(treinador2, treinador2.getPokemonAtual()+1, tm + i));
								}
							}else{
								addEvent(new Ataque21(ataque2, tm + i));
							}			
							run();
							i+=1000;
							/*verifica se o pokemon do treinador 1 esta vivo e o troca caso necessario/possivel*/
							if (treinador1.getPokemon(treinador1.getPokemonAtual()).getHP() == 0){
								System.out.println(treinador1.getPokemon(treinador1.getPokemonAtual()).getNome()+" sem HP");
								treinador1.pokemonMorre();
								if (!treinador1.restaPokemons()){
									treinador1.setPerdeu();
								}else{
									addEvent(new TrocarPokemon(treinador1, treinador1.getPokemonAtual()+1, tm + i));
									run();
									i+=1000;
								}
							}
						}else{ //segundo tem prioridade
							addEvent(new Ataque21(ataque2, tm + i));
							run();
							i+=1000;
							/*verifica se o pokemon do treinador 1 esta vivo para atacar (senao o troca caso possivel)*/
							if (treinador1.getPokemon(treinador1.getPokemonAtual()).getHP() == 0){
								System.out.println(treinador1.getPokemon(treinador1.getPokemonAtual()).getNome()+" sem HP");
								treinador1.pokemonMorre();
								if (!treinador1.restaPokemons()){
										treinador1.setPerdeu();
								}else{
									addEvent(new TrocarPokemon(treinador1, treinador1.getPokemonAtual()+1, tm + i));
								}
							}else{
								addEvent(new Ataque12(ataque1, tm + i));
							}			
							run();
							i+=1000;
							/*verifica se o pokemon do treinador 2 esta vivo e o troca caso necessario/possivel*/
							if (treinador2.getPokemon(treinador2.getPokemonAtual()).getHP() == 0){
								System.out.println(treinador2.getPokemon(treinador2.getPokemonAtual()).getNome()+" sem HP");
								treinador2.pokemonMorre();
								if (!treinador2.restaPokemons()){
									treinador2.setPerdeu();
								}else{
									addEvent(new TrocarPokemon(treinador2, treinador2.getPokemonAtual()+1, tm + i));
									run();
									i+=1000;
								}
							}
						}
					}else{ //a ordem não influencia
						switch (comando1){
						case 2:
							if (treinador1.escolheItem() == 1){
								addEvent(new UsarItem(treinador1, treinador1.getPokemonAtual(), new SuperPotion(), tm + i));
							}else{
								addEvent(new UsarItem(treinador1, treinador1.getPokemonAtual(), new Potion(), tm + i));
							}
							i+=1000;
							run();
							if (treinador2.escolheItem() == 1){
								addEvent(new UsarItem(treinador2, treinador2.getPokemonAtual(), new SuperPotion(), tm + i));
							}else{
								addEvent(new UsarItem(treinador2, treinador2.getPokemonAtual(), new Potion(), tm + i));
							}
							i+=1000;
							run();
							break;
						case 3: //as trocas estao sendo feitas quando o pokemon fica fora de combate
							break;
						case 4:
							addEvent(new Fugir(treinador1, tm + i));
							run();
							break;
						}
					}
				}
			}
		} while (!(treinador1.getPerdeu() || treinador2.getPerdeu()));
		if (treinador1.getPerdeu()){
			System.out.println("O treinador "+treinador2.getNome()+" venceu.");
		}else{
			System.out.println("O treinador "+treinador1.getNome()+" venceu.");
		}
	}
		public static void main(String[] args) {
			Treinador treinador1, treinador2, treinador3, treinador4;
			treinador1 = new Ash();
			treinador2 = new Red();
			treinador3 = new Jogador("João");
			treinador4 = new Jogador("José");
			long tm = System.currentTimeMillis();
			BatalhaPokemon batalha = new BatalhaPokemon(treinador1, treinador2);
			/*batalha.addEvent(batalha.new Restart(tm));
			batalha.run(); teste dos comandos*/
			batalha.batalha(tm);
			
		}
	
}