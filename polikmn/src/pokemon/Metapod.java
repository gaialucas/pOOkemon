package pokemon;

import ataques.Ataque;
import ataques.Harden;

public class Metapod extends Pokemon {
	public Metapod(){
		super("Metapod", 40, new Ataque[] {new Harden()});
	}
}
