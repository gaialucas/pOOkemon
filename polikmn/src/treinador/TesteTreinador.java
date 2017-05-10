package treinador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ataques.Ataque;
import pokemon.Pokemon;

public class TesteTreinador {
	Pokemon pokemon1, pokemon2;
	Treinador treinador;
	
	@Before
	/*public void setUp() throws Exception {
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
		Pokemon[] pokemons = new Pokemon[]{
				new Pokemon(100, "Charmander", ataques1, 4),
				new Pokemon(90, "Pikachu", ataques2, 3),
		};
		treinador = new Treinador("Ash", pokemons, 2);
	}*/

	@Test
	public void testeGets() {
		assertEquals(treinador.getNome(), "Ash");
		assertEquals(treinador.getNumPokemons(), 2);
		assertEquals(treinador.getNumPokemonsRestantes(), 2);
		assertEquals(treinador.getPokemon(0).getNome(), "Charmander");
		assertEquals(treinador.getPokemon(1).getHP(), 90);
		assertEquals(treinador.getPokemon(2), null);
		assertEquals(treinador.getPokemon(0).getAtaque(2).getDano(), 30);
	}
	
	@Test
	public void testePokemonsRestantes() {
		treinador.getPokemon(0).mudaHP(-100);
		if (treinador.getPokemon(0).getHP() == 0)
			treinador.pokemonMorre();
		assertEquals(treinador.getNumPokemonsRestantes(), 1);
		treinador.getPokemon(0).mudaHP(100);
		if (treinador.getPokemon(0).getHP() != 0)
			treinador.pokemonRevive();
		assertEquals(treinador.getNumPokemonsRestantes(), 2);
	}

}
