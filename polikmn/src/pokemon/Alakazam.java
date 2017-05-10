package pokemon;

import ataques.Ataque;
import ataques.Confusion;
import ataques.HyperBeam;
import ataques.Psychic;
import ataques.ShadowBall;

public class Alakazam extends Pokemon {
	public Alakazam(){
		super("Alakazam", 60, new Ataque[] {new Confusion(), new Psychic(), new ShadowBall(), new HyperBeam()});
	}
}
