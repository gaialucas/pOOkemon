package pokemon;

import ataques.Ataque;
import ataques.Blizzard;
import ataques.IceBeam;
import ataques.Psychic;
import ataques.Thunderbolt;

public class Jynx extends Pokemon {
	public Jynx(){
		super("Jynx", 100, new Ataque[] {new IceBeam(), new Blizzard(), new Psychic(), new Thunderbolt()});
	}
}
