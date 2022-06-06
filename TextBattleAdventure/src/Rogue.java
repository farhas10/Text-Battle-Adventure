/**
 * Name: Farzad
 * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a Rogue object which is a Player. It must contain all of the fields and 
 * methods detailed in the project spec. You 
 * may add additional fields and methods if you like.
 */

//This is the basic constructor for a Rogue character
public class Rogue extends Player{
	//critChance represents the percent chance of a player to get extra
	//damage on the monster.
	private double critChance;
	public Rogue(String name, double cc) {
		super(name, 75, 1, 10);
		if (cc < 1 && cc > 0) {
			critChance = cc;
		}
		else {
			critChance = 0.1;
		}
		
	}
	public int attack(Monster monster) {
		//Rogue attacks by first attacking the monster as a regular player does.
		int dmg = (int)(Math.random() * (super.getMaxDamage() - super.getMinDamage() 
				+ 1)+ super.getMinDamage());
		monster.takeDamage(dmg);
		
		//Then is the player is able to get a critical hit, the monster once again
		//takes damage with the same value as before.
		double x = (Math.random());
		if (x < critChance) {
			System.out.println(super.getName() + " gets a critical hit!");
			monster.takeDamage(dmg);
			return dmg*2;
		}
		else {
			return dmg;
		}
		
		//Method created for testing purposes to retrieve the critChance.
	}
	public double getCrit() {
		return critChance;
	}
}
