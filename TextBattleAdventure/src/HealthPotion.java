/**
 * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a HealthPotion object which is an Item. It must contain all of the fields and methods 
 * detailed in the project spec. You 
 * may add additional fields and methods if you like.
 */

public class HealthPotion extends Item {
	
	//Basic constructor for the health potion item.
	public HealthPotion(String rarity){
		super("Health Potion", rarity);
	}
	
	//Use method for the potion which increasing the current
	//player health value.
	public void use(Player player) {
		int points = super.getPoints();
		player.healDamage(points);
		System.out.println(player.getName() + " used a " + super.toString() + " increasing their "
				+ "available health by " + points + " points.");
	}
	
}
