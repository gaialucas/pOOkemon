package batalha;

import item.Item;
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
			return treinador1.getPokemon(treinador1.getPokemonAtual()).getNome() + "atacou " + treinador2.getPokemon(treinador2.getPokemonAtual()).getNome() + " com " + treinador1.getPokemon(treinador1.getPokemonAtual()).getAtaque(i).getNome(); 
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
			return treinador2.getPokemon(treinador2.getPokemonAtual()).getNome() + "atacou " + treinador1.getPokemon(treinador1.getPokemonAtual()).getNome() + " com " + treinador2.getPokemon(treinador2.getPokemonAtual()).getAtaque(i).getNome(); 
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
		public TrocarPokemon (Treinador t, int troca, long eventTime) {
			super(eventTime);
			treinador = t;
			novoPokemon = troca;
			
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
		public UsarItem (Treinador t,int escolhido, Item item, long eventTime) {
			super(eventTime);
			treinador = t;
			pokemon = escolhido;
			i = item;
		}
		
		public void action () {
			treinador.getPokemon(pokemon).mudaHP(i.getCura());
		}
		
		public String description () { 
			return "O treinador "+treinador.getNome()+" usou o " +i.getNome()+ " em "+treinador.getPokemon(pokemon).getNome(); 
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
			int i = 0;
			/*while (treinador1.getPerdeu() || treinador2.getPerdeu()) {
				addEvent(new Ataque12(1, i));
				addEvent(new Ataque21(1, i + 1000));
				i += 2000;
			}
			addEvent(new Ataque12(1, tm));
			addEvent(new Ataque21(1, tm + 1000));
			addEvent(new Ataque12(1, tm + 2000));
			addEvent(new Ataque21(1, tm + 3000));
			addEvent(new Ataque12(1, tm + 8000));
			addEvent(new Ataque21(1, tm + 9000));
			addEvent(new Ataque12(1, tm + 10000));*/
			addEvent(new Fugir(treinador1, tm));
			// Can even add a Restart object!
			addEvent(new Restart(tm + 20000));
		}
		public String description() {
			return "Restarting system";
		}
	}
	
	public static void main(String[] args) {
		Pokemon pokemon1, pokemon2, pokemon3;
		Treinador treinador1, treinador2;
		Ataque[] ataques1 = new Ataque[]{
				new Ataque("1.1", 10, 0),
				new Ataque("1.2", 20, 1),
				new Ataque("1.3", 30, 1),
				new Ataque("1.4", 40, 1),
		};
		Ataque[] ataques2 = new Ataque[]{
				new Ataque("2.1", 15, 0),
				new Ataque("2.2", 25, 1),
				new Ataque("2.3", 35, 1),
		};
		Pokemon[] pokemons1 = new Pokemon[]{
				new Pokemon(100, "Charmander", ataques1, 4),
				new Pokemon(90, "Pikachu", ataques2, 3),
		};
		treinador1 = new Treinador("Ash", pokemons1, 2);
		Ataque[] ataques3 = new Ataque[]{
				new Ataque("1.1", 10, 0),
				new Ataque("1.2", 20, 1),
				new Ataque("1.3", 30, 1),
				new Ataque("1.4", 40, 1),
		};
		Pokemon[] pokemons2 = new Pokemon[]{
				new Pokemon(110, "Charmeleon", ataques3, 4),
		};
		treinador2 = new Treinador("Red", pokemons2, 1);
		BatalhaPokemon batalha = new BatalhaPokemon(treinador1, treinador2);
		long tm = System.currentTimeMillis();
		batalha.addEvent(batalha.new Restart(tm));
		batalha.run();
		}
	
}
