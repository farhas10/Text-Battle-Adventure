import java.util.ArrayList;

/**
 * Name: Farzad Hasan
 * Last Updated On: 6.2.22
 * Mrs. Kankelborg
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a Player object. It must contain all of the fields and
 * methods detailed in the project spec. You may add additional fields and methods if you
 * like.
 */
public class Player {
	// This is all the variables for the player.
	
	private int minDmg;
	private int maxDmg;
	private String name;
	private int health;
	private int maxHealth;
	
	//This is the array list which contains the players inventory.
	private ArrayList<Item> Inventory = new ArrayList<Item>();
	
	//The following massive blurbs of code are just constructors for the
	//player object used throughout the game.
	public Player(String n) {
		// This sets the basic properties of player.
		name = n;
		health = 100;
		maxHealth = 100;
		minDmg = 1;
		maxDmg = 10;
		Inventory.add(0,new HealthPotion("Lesser"));
		Inventory.add(1,new HealthPotion("Lesser"));
		Inventory.add(2,new StrengthPotion("Lesser"));
		Inventory.add(3,new StrengthPotion("Lesser"));
		Inventory.add(4,new ManaPotion("Lesser"));
	}
	//Player object is created below by taking user inputs.
	public Player(String na, int h, int minD, int maxD) {
		name = na;
		health = h;
		minDmg = minD;
		maxDmg = maxD;
		if(health < 1) {
			health = 100;
		}
		maxHealth = health;
		if(minDmg < 1) {
			minDmg = 1;
		}
		if(maxDmg < minDmg) {
			maxDmg = minDmg + 10;
		}
		Inventory.add(0,new HealthPotion("Lesser"));
		Inventory.add(1,new HealthPotion("Lesser"));
		Inventory.add(2,new StrengthPotion("Lesser"));
		Inventory.add(3,new StrengthPotion("Lesser"));
		Inventory.add(4,new ManaPotion("Lesser"));
	}
	//Setting default values.
	public Player(String na, ArrayList <Item> inv) {
		
		name = na;
		health = 100;
		maxHealth = 100;
		minDmg = 1;
		maxDmg = 10;
		if(inv == null) {
			Inventory.add(0,new HealthPotion("Lesser"));
			Inventory.add(1,new HealthPotion("Lesser"));
			Inventory.add(2,new StrengthPotion("Lesser"));
			Inventory.add(3,new StrengthPotion("Lesser"));
			Inventory.add(4,new ManaPotion("Lesser"));
		}
		else {
			Inventory = inv;
		}
	}
	
	public void setMaxDamage(int d) {
		maxDmg += d;
	}
	//Accessor method to retrieve damage.
	
	public int getMaxDamage() {
		return maxDmg;
	}
	//Accessor method to retrieve name.
	public String getName() {
		return name;
	}
	//Accessor method to retrieve damage.
	public int getMinDamage() {
		return minDmg;
	}
	//Accessor method to retrieve health.
	public int getHealth() {
		return health;
	}
	
	// adding combat functions
	public void healDamage(int num) {
		health += num;
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	public void getStronger(int s) {
		minDmg += s;
		maxDmg += s;
	}
	public void takeDamage(int damage) {
		health += -damage;
		if(health < 0) {
			health = 0;
		}
	}
	
	//Accessor method to retrieve current player inventory.
	public ArrayList <Item> InvP(){
		return Inventory;
	}
	
	public String getInventory() {
		//inventory is printed out by using loops.
		String strin = "";
		for (int i = 0; i<Inventory.size(); i++) {
			if (Inventory.get(i) == null) {
				strin += i + 1 + ": empty slot ";
			}
			else {
				strin += i + 1 + ": " + Inventory.get(i).toString() + " ";
			}
		}
		if (Inventory.size() == 0) {
			strin = "No Items";
		}
		return strin;
	}
	
	//Use item method is implemented to determine if a player has made
	//a valid selection, and if so, the item to be used.
	public void useItem(int index) {
		if(index > Inventory.size() - 1 || index < 0) {
			System.out.println("Invalid Selection - Missed Turn");
		}
		else if (Inventory.get(index) == null) {
			System.out.println("Invalid Selection - Missed Turn");
		}
		else {
			Inventory.get(index).use(this);
			Inventory.remove(index);
		}                             
		
	}
	//A method that adds a new Item to the player Inventory.
	public void receiveItem (Item x) {
		Inventory.add(x);
	}
	
	
	public int attack(Monster m) {
		//A RNG is used to randomly attack the monster.
		int num = (int)(Math.random() * (maxDmg - minDmg + 1)+ minDmg) ;
		m.takeDamage(num);
		return num;
	}
	//Prints out the current state of the player.
	public String toString() {
		if (health > 0) {
			return name + " has " + health + " health left.";
		}
		else {
			return name + " is dead.";
		}
	}
	
	
}