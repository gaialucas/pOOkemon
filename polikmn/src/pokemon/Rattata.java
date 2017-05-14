package pokemon;

import ataques.Ataque;
import ataques.QuickAttack;
import ataques.Tackle;
import ataques.TailWhip;

public class Rattata extends Pokemon {
	public Rattata(){
		super("Rattata", 50, new Ataque[] {new Tackle(), new QuickAttack(), new TailWhip()});
	}
}
