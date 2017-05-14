package pokemon;

import ataques.Ataque;
import ataques.IronTail;
import ataques.QuickAttack;
import ataques.Thunderbolt;
import ataques.Thundershock;

public class Raichu extends Pokemon {
	public Raichu(){
		super("Raichu", 80, new Ataque[] {new Thunderbolt(), new QuickAttack(), new Thundershock(), new IronTail()});
	}
}
