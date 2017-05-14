package pokemon;

import ataques.Ataque;
import ataques.DragonPulse;
import ataques.FireBlast;
import ataques.Flamethrower;
import ataques.WingAttack;

public class Charizard extends Pokemon {
	public Charizard(){
		super("Charizard", 110, new Ataque[] {new Flamethrower(), new FireBlast(), new WingAttack(), new DragonPulse()});
	}
}
