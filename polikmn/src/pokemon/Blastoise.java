package pokemon;

import ataques.Ataque;
import ataques.HydroPump;
import ataques.IceBeam;
import ataques.MegaPunch;
import ataques.Surf;

public class Blastoise extends Pokemon {
	public Blastoise(){
		super("Blastoise", 120, new Ataque[] {new Surf(), new HydroPump(), new IceBeam(), new MegaPunch()});
	}
}
