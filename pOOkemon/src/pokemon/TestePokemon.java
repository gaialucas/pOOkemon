package pokemon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestePokemon {
	Pokemon pokemon1, pokemon2;
	
	@Before
	public void setUp() throws Exception {
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
		pokemon1 = new Pokemon(100, "Charmander", ataques1, 4);
		pokemon2 = new Pokemon(90, "Pikachu", ataques2, 3);
		
	}

	@Test
	public void testeGets() {
		assertEquals(pokemon1.getNome(), "Charmander");
		assertEquals(pokemon2.getNome(), "Pikachu");
		assertEquals(pokemon1.getHP(), 100);
		assertEquals(pokemon2.getHP(), 90);
		assertEquals(pokemon1.getNumAtaques(), 4);
		assertEquals(pokemon2.getNumAtaques(), 3);
		assertEquals(pokemon1.getAtaque(0).getNome(), "1.1");
		assertEquals(pokemon1.getAtaque(1).getNome(), "1.2");
		assertEquals(pokemon1.getAtaque(2).getNome(), "1.3");
		assertEquals(pokemon1.getAtaque(3).getNome(), "1.4");
		assertEquals(pokemon2.getAtaque(0).getNome(), "2.1");
		assertEquals(pokemon2.getAtaque(1).getNome(), "2.2");
		assertEquals(pokemon2.getAtaque(2).getNome(), "2.3");
		assertEquals(pokemon2.getAtaque(3), null);
		assertEquals(pokemon1.getAtaque(0).getDano(), 10);
		assertEquals(pokemon1.getAtaque(1).getDano(), 20);
		assertEquals(pokemon1.getAtaque(2).getDano(), 30);
		assertEquals(pokemon1.getAtaque(3).getDano(), 40);
		assertEquals(pokemon2.getAtaque(0).getDano(), 15);
		assertEquals(pokemon2.getAtaque(1).getDano(), 25);
		assertEquals(pokemon2.getAtaque(2).getDano(), 35);
		assertEquals(pokemon1.getAtaque(0).getPrioridadeAtaque(), 0);
		assertEquals(pokemon1.getAtaque(1).getPrioridadeAtaque(), 1);
		assertEquals(pokemon1.getAtaque(2).getPrioridadeAtaque(), 1);
		assertEquals(pokemon1.getAtaque(3).getPrioridadeAtaque(), 1);
		assertEquals(pokemon2.getAtaque(0).getPrioridadeAtaque(), 0);
		assertEquals(pokemon2.getAtaque(1).getPrioridadeAtaque(), 1);
		assertEquals(pokemon2.getAtaque(2).getPrioridadeAtaque(), 1);
	}
	
	@Test
	public void testeMudaHP() {
		pokemon1.mudaHP(-10);
		assertEquals(pokemon1.getHP(), 90);
		assertEquals(pokemon1.vivo(), true);
		pokemon1.mudaHP(-150);
		assertEquals(pokemon1.getHP(), 0);
		assertEquals(pokemon1.vivo(), false);
		pokemon1.mudaHP(1);
		assertEquals(pokemon1.getHP(), 1);
		assertEquals(pokemon1.vivo(), true);
		pokemon1.mudaHP(200);
		assertEquals(pokemon1.getHP(), 100);
		pokemon2.mudaHP(10);
		assertEquals(pokemon2.getHP(), 90);
		assertEquals(pokemon2.vivo(), true);
		pokemon2.mudaHP(-150);
		assertEquals(pokemon2.getHP(), 0);
		assertEquals(pokemon2.vivo(), false);
		pokemon2.mudaHP(1);
		assertEquals(pokemon2.getHP(), 1);
		pokemon2.mudaHP(200);
		assertEquals(pokemon2.getHP(), 90);
	}
}
