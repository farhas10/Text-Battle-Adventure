/**
 * Name: 
  * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a MagePotion object which is an Item. It must contain all of the fields
 * and methods detailed in the project spec. You 
 * may add additional fields and methods if you like.
 */

public class ManaPotion extends Item{
	
	//Basic constructor for the mana potion.
	public ManaPotion(String rarity) {
		super("Mana Potion", rarity);
	}
	
	//The use method for the mana potion first checks if a 
	//player is a Mage. If so, then the player is restored a 
	//randome amount of mana using the getPoints methof from
	//the super class.
	public void use(Player player) {
		if (player instanceof Mage) {
			int points = super.getPoints();	
			((Mage)player).restoreMana(points);
			System.out.println(player.getName() + " used a " + super.toString() + " increasing their available mana by " + points + " points.");
	
		}
		
		//If the player is not a Mage, they are unable to use
		//the mana potion.
		else {
			System.out.println("Only a mage can use a Mana Potion!");

		}
	}
}
