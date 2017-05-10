package pokemon;

import ataques.Ataque;
import ataques.Confusion;
import ataques.ShadowBall;
import ataques.SludgeBomb;
import ataques.Thunderbolt;

public class Gengar extends Pokemon {
	public Gengar(){
		super("Gengar", 70, new Ataque[] {new SludgeBomb(), new ShadowBall(), new Confusion(), new Thunderbolt()});
	}
}
