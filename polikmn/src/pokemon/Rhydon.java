package pokemon;

import ataques.Ataque;
import ataques.DoubleKick;
import ataques.Earthquake;
import ataques.MegaPunch;
import ataques.RockSlide;

public class Rhydon extends Pokemon {
	public Rhydon(){
		super("Rhydon", 100, new Ataque[] {new RockSlide(), new Earthquake(), new MegaPunch(), new DoubleKick()});
	}
}
