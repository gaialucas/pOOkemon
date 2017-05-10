package pokemon;

import ataques.AerialAce;
import ataques.Ataque;
import ataques.QuickAttack;
import ataques.Takedown;
import ataques.WingAttack;

public class Pidgeot extends Pokemon {
	public Pidgeot(){
		super("Pidgeot", 70, new Ataque[] {new Takedown(), new QuickAttack(), new WingAttack(), new AerialAce()});
	}
}
