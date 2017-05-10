package pokemon;

import ataques.Ataque;
import ataques.DoubleKick;
import ataques.DynamicPunch;
import ataques.IcePunch;
import ataques.MegaPunch;

public class Machamp extends Pokemon {
	public Machamp(){
		super("Machamp", 80, new Ataque[] {new DoubleKick(), new DynamicPunch(), new MegaPunch(), new IcePunch()});
	}
}
