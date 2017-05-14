package pokemon;

import ataques.Ataque;
import ataques.QuickAttack;
import ataques.Spark;
import ataques.Tackle;
import ataques.Thunderbolt;

public class Pikachu extends Pokemon {
	public Pikachu(){
		super("Pikachu", 150, new Ataque[] {new Tackle(), new QuickAttack(), new Spark(), new Thunderbolt()});
	}
}
