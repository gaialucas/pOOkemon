package pokemon;

import ataques.Ataque;
import ataques.DragonPulse;
import ataques.Flamethrower;
import ataques.HyperBeam;
import ataques.Outrage;

public class Dragonite extends Pokemon {
	public Dragonite(){
		super("Dragonite", 140, new Ataque[] {new DragonPulse(), new Outrage(), new HyperBeam(), new Flamethrower()});
	}
}
