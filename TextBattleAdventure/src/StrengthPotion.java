/**
 * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a StrenghPotion object which is an Item. It must contain all of the fields 
 * and methods detailed in the project spec. You 
 * may add additional fields and methods if you like.
 */

//Basic constructor for a strength potion. 
public class StrengthPotion extends Item {
	public StrengthPotion(String rarity) {
		super("Strength Potion", rarity);
	}
	
	//When the player uses the potion, the player will increase their min and max
	//damage by a random amount of points.
	public void use(Player player) {
		int x = super.getPoints();
		player.getStronger(x);
		System.out.println(player.getName() + " used a " + super.toString() +
				" increasing their min and max damage by " + x + " points." );
		
	}
}
