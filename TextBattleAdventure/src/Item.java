/**
 * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents an Item object. It must contain all of the fields and
 * methods detailed in the project spec. You may add additional fields and methods if you
 * like.
 */
public class Item {
	
	//this sets the type of item.
	private String type;
	//this will set the rarity of the item as a String.
	private String rarity;
	public Item(String ty, String rarity) {
		type = ty;
		
		//If the rarity is none of the allowed types, then the rarity will be set to lesser by default.
		if ((rarity.equals("Lesser") || rarity.equals("Basic") || rarity.equals("Greater") || rarity.equals("Epic"))) {
			this.rarity = rarity;
		}
		else{
			this.rarity = "Lesser";
		}
	}
	//Basic constructor for the Item.
	public Item() {
		type = "Unknown Item";
		this.rarity = "Lesser";
	}
	//Method used to return the rarity & type of the Item.
	public String toString() {
		return rarity + " " + type;
	}
	
	//Generic method used to use an item. Although subclasses will handle
	//the items separately.
	public void use(Player player) {
			System.out.println(player.getName() +  " used an item with an unclear result.");
	}
	
	//Method which returns the rarity of an Item.
	public String returnRarity() {
		return rarity;
	}
	
	//Method which returns the amount of points associated with
	//each rarity level.
	public int getPoints() {
		int rng = 0;
		if (rarity.equals("Lesser")) {
			
			return rng = (int)(Math.random()*5 + 1);
		}
		else if (rarity.equals("Basic")) {
			return rng = (int)(Math.random()*5 + 6);
		}
		else if (rarity.equals("Greater")) {
			return rng = (int)(Math.random()*5 + 11);
		}
		else if (rarity.equals("Epic")) {
			return rng = (int)(Math.random()*5 + 16);
		}
		else {
			return rng;
		}
	}
}


