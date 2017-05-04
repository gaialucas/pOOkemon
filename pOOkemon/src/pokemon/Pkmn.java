package pokemon;

public class Pkmn {
	private String nome;
	private int maxHP, HP, Atk, Def, SpA, SpD, Spd;
	private String Attacks[];
	
	public Pkmn (String name, int life, int atk, int def, 
				 int spa, int spd, int speed) {
		HP = maxHP = life;
		Atk = atk; Def = def; SpA = spa; SpD = spd; Spd = speed;
	}

}
