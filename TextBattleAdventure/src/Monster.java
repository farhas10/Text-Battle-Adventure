/**
 * Name: Farzad Hasan
 * Last Updated On: 6.2.22
 * Mrs. Kankelborg
 * APCS Period 2
 * Text Battle Project Part Two
 * 
 * This class is the represents a Monster object. It must contain all of the fields and
 * methods detailed in the project spec. You may add additional fields and methods if you
 * like.
 */
public class Monster {
	private String type;
	private int health;
	private int maxHealth;
	private int minDmg;
	private int maxDmg;
	//constructor for the Monster. 
	public Monster(String typ, int hea, int minD, int maxD){
		
		minDmg = minD;
		maxDmg = maxD;
		type = typ;
		health = hea;
		maxHealth = hea;
		if (health < 1) {
			health = 100;
		}
		if (minDmg <= 0) {
			minDmg = 1;
		}
		if (maxDmg <= minDmg) {
			maxDmg = minDmg +10;
		}
	}
	public Monster(String t) {
		
		//This sets the pre-condition
		health = 100;
		minDmg = 1;
		maxDmg = 10;
		type = t;
		
	}
	
	public String getType() {
		return type;
		//accessor method
	}
	public int getHealth() {
		return health;
		//accessor method
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	// allow monster to attack, and take damage
	public int attack(Player p) {
		int val = (int)((Math.random() * (maxDmg - minDmg+1)) + minDmg);
		p.takeDamage(val);
		return val;
	}
	public void takeDamage(int d) {
		health -= d;
		if (health < 0) {
			health = 0;
			//resets health of the item.
		}
	}
	//displaying monster status
	public String toString() {
		if (health == 0) {
			return "The " + type + " is dead.";
		}
		return "The " + type + " has " + health + " health left.";
	}
	
	//Method used for accessing the minimum damage.
	public int getMinDamage() {
		return minDmg;
	}
	//Method used for accessing the maximum damage.
	public int getMaxDamage() {
		return maxDmg;
	}
	
	public void setMaxDamage(int d) {
		maxDmg += d;
	}
}

