package pokemon;

import ataques.Ataque;
import ataques.Guillotine;
import ataques.QuickAttack;
import ataques.Takedown;
import ataques.XScissor;

public class Pinsir extends Pokemon {
	public Pinsir(){
		super("Pinsir", 90, new Ataque[] {new Guillotine(), new QuickAttack(), new XScissor(), new Takedown()});
	}
}
