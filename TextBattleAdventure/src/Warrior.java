/**
 * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a Mage object which is a Player. It must contain all of the f
 * fields and methods detailed in the project spec. You 
 * may add additional fields and methods if you like.
 */

//Basic constructor for warrior.
public class Warrior extends Player{
	
	//The warrior will take a value shieldStrength which is 
	//used to calculate the amount of damage deflected from
	//the player.
	private double shieldStrength;
	public Warrior(String name, double ss) {
		super(name, 125, 5, 15);
		if (ss < 1 && ss > 0) {
			shieldStrength = ss;
		}
		else {
			shieldStrength = 0.1;
		}
		
	}
	
	//This method allows the warrior to take damage.
	//If the shieldStrength times the damage is less than 1,
	//the warrior blocks one point of damage. Otherwise, the 
	//warrior blocks the calculated amount.
	public void takeDamage(int damage) {
		if (shieldStrength * damage >= 1) {
			int newDamage = (int)(damage * shieldStrength);
		super.takeDamage(damage - newDamage);
		System.out.println(super.getName() + " blocks " + newDamage + " points of damage.");
		
		}
		else {
			super.takeDamage(damage - 1);
			System.out.println(super.getName() + " blocks 1 points of damage.");
		}
	}
	//This method is for testing and returns the shieldStrength.
	public double getBlock() {
		return shieldStrength;
	}

}
