package pokemon;

import ataques.Ataque;
import ataques.Cut;
import ataques.SludgeBomb;
import ataques.Solarbeam;
import ataques.VineWhip;

public class Venusaur extends Pokemon {
	public Venusaur(){
		super("Venusaur", 110, new Ataque[] {new VineWhip(), new SludgeBomb(), new Solarbeam(), new Cut()});
	}
}
