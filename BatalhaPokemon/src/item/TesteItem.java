package item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pokemon.Ataque;
import pokemon.Pokemon;

public class TesteItem {
	Item item1, item2;
	Pokemon pokemon;

	@Before
	public void setUp() throws Exception {
		item1 = new Item("Cura Pequena", 10);
		item2 = new Item("Cura Grande", 1000);
		Ataque[] ataques = new Ataque[]{
				new Ataque("1.1", 10, 0),
				new Ataque("1.2", 20, 1),
		};
		pokemon = new Pokemon(100, "Pikachu", ataques, 2);
	}

	@Test
	public void testeItem() {
		assertEquals(item1.getNome(), "Cura Pequena");
		assertEquals(item2.getNome(), "Cura Grande");
		assertEquals(item1.getCura(), 10);
		assertEquals(item2.getCura(), 1000);
		pokemon.mudaHP(item1.getCura());
		assertEquals(pokemon.getHP(), 100);
		pokemon.mudaHP(-30);
		assertEquals(pokemon.getHP(), 70);
		pokemon.mudaHP(item1.getCura());
		assertEquals(pokemon.getHP(), 80);
		pokemon.mudaHP(item2.getCura());
		assertEquals(pokemon.getHP(), 100);
	}

}
