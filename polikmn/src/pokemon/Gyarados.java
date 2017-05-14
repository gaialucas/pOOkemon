package pokemon;

import ataques.Ataque;
import ataques.Bounce;
import ataques.Earthquake;
import ataques.IceFang;
import ataques.Waterfall;

public class Gyarados extends Pokemon {
	public Gyarados(){
		super("Gyarados", 160, new Ataque[] {new Waterfall(), new IceFang(), new Bounce(), new Earthquake()});
	}
}
