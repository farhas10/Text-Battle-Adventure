
public class Ninja extends Player {
	private double hideChance;
	public Ninja(String name, double chance) {
		super(name, 80, 1, 15);
		hideChance = chance;
	}
	
	//When the monster attacks the ninja, the ninja has a chance that it will avoid the attack
	//by hiding. If the ninja does this, the monsters attack is worth nothing.
	//The ninja will attack the  monster like a regular player using the super class.
	public void takeDamage(int damage) {
		double willHide = Math.random();
		if (willHide < hideChance) {
			System.out.println(super.getName() + " has avoided the attack by hiding.");
			super.takeDamage(0);
		}
		else {
			super.takeDamage(damage);
		}
	}
}
