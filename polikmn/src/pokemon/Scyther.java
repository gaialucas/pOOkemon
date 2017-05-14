package pokemon;

import ataques.Ataque;
import ataques.DoubleKick;
import ataques.QuickAttack;
import ataques.WingAttack;
import ataques.XScissor;

public class Scyther extends Pokemon {
	public Scyther(){
		super("Scyther", 80, new Ataque[] {new XScissor(), new WingAttack(), new QuickAttack(), new DoubleKick()});
	}
}
