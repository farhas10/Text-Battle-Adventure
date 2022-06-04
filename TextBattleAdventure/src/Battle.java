import java.util.Scanner;

import javax.swing.JFrame;

/**
 * Name:Farzad Hasan
 * Last Updated On: 6/2/22
 * Mrs. Kankelborg
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the application class. Your main method must meet all the requirements in the 
 * specification on turn in but is otherwise for your testing purposes only. My test code will call
 * your startBattle method directly with my own version of the code you will write in main. 
 * 
 * This part of the project controls the battle
 * it starts the battle and prints out the inputs into the console.
 *  
 */

public class Battle {
	
	//This is the start battle method, basically what is used to play the game.
	public static void startBattle(Player player, Monster monster, Scanner input) {
		System.out.println(player.getName() +" has encountered a " + monster.getType() +"!");
		int tracker = 0;
		//Main loop that keeps the game playing till the monster defeats the player or the 
		//player chooses to quit.
		while(player.getHealth()!=0 && monster.getHealth()!= 0) {
			//tracker that increments as rounds progress.
			tracker++;
			System.out.println();
			System.out.println("********************************** ROUND "+tracker
					+" **********************************");
			System.out.println();
			//displays inventory to the player.
			System.out.println("Your inventory holds: " + player.getInventory());
	
			//Lets player choose their inventory item.
			System.out.print("Type an inventory slot number or 0 to attack: ");
			int selection = input.nextInt();
			System.out.println();
			
			
			//if 0 is chosen, then the regular player class is called to attack the monster
			//based on the type of player.
			if(selection==0) {
				System.out.println(player.getName() + " attacks the " + monster.getType() + " for " 
			+ player.attack(monster) + " damage.");
				
				//will check if the monster gets defeated by the player, and if not displays the
				//current health.
				if(monster.getHealth()>0) {
					System.out.println("The " + monster.getType()+" has " + monster.getHealth() + " health left.");
				}
				//If the monster is dead, the round ends and the player is awarded loot and may
				//choose to play the game.
				else {
					System.out.println("The " + monster.getType()+" is dead.");
					System.out.println();
					System.out.println(player.getName()+" has defeated the " + monster.getType());
				}				
			}
			
			//if the player chooses a different item other than 0, the inventory is searched for
			//to use that item.
			else {
				//if the player makes an irrelevant/invalid selection, they have missed their turn,
				//else they use the item.
				if(selection-1>=player.InvP().size()||selection-1<0) {
					System.out.println("Invalid Selection – Missed Turn");
				}
				else if(player.InvP().get(selection-1)==null) {
					System.out.println("Invalid Selection – Missed Turn");
				}
				else {
					player.useItem(selection-1);
				}
				
			}
			if(monster.getHealth()>0) {
				System.out.println();
				System.out.println("The " + monster.getType() + " attacks " + player.getName() + 
						" for " + monster.attack(player)+ " damage.");
				//if the monster defeats the player, the game is over and the program ends.
				if(player.getHealth()>0) {
					System.out.println(player.getName()+ " has " + player.getHealth() + " health left.");
				}
				else {
					System.out.println(player.getName()+ " is dead.");
					System.out.println();
					System.out.println("The " + monster.getType()+" has defeated " + player.getName());
				}
				System.out.println();
			}
			
			
		}
		if(player.getHealth()>0) {
			int heal = (int) (Math.random()*20 + 1);
			player.healDamage(heal);
			System.out.println(player.getName()+ " has been rewarded with " + heal +" points of health back.");
			//If the player wins whilst the monster has died, they are rewarded health points back. Additionally
			//the getLoot method is called to give the player some type of prize.
			Item loot = getLoot(player);
			player.receiveItem(loot);
			System.out.println(player.getName()+" has been rewarded with a "+ loot +".");
			
		}
	}
	
	public static Item getLoot(Player player) {
		//A double chance is declared which is a random value between 0 and 1. This value will be evaluated
		//against other values which represent percent chances of the rarity being assigned to an item. For
		//example, there is a 5% chance of getting an epic and a 10% chance of getting a greater item.
		
		double chance = Math.random();
		String rarity;
		if(chance<=.05) {
			rarity = "Epic";
		}
		else if(chance<=.15) {
			rarity = "Greater";
		}
		else if(chance<=.35) {
			rarity = "Basic";
		}
		else {
			rarity = "Lesser";
		}
		double type = Math.random();
		//Same system of number generation is used as above, and this time it is used to evaluate what type
		// of potion is given to the character. For example, if you are a Mage, you have a 20% chance of 
		//getting a mana potion. The rarity is used as a parameter to create the new item.
		if(player instanceof Mage) {
			if(type<=.20) {
				return new ManaPotion(rarity);
			}
			else if(type<=.40) {
				return new StrengthPotion(rarity);
			}
			else {
				return new HealthPotion(rarity);
			}
		}
		else {
			if(type<=.20) {
				return new StrengthPotion(rarity);
			}
			else {
				return new HealthPotion(rarity);
			}
		}
	}
	
	//This is the main method used for testing and initial player settings.
	
	public static void main(String[] args) {
		
		//GUI Setup Begins Here
		JFrame frame = new JFrame();
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.println();
		System.out.print("Choose your class: Rogue, Warrior, or Mage. ");
		String type = input.next();
		System.out.println();
		String[] types = {"Shrek","Godzilla","massiveWompus"};
		//depending on what type of class the player chooses to have, a new player is created
		//using that subclass.
		Player player;
		if(type.equals("Rogue")) {
			player = new Rogue(name,0.3);
		}
		else if(type.equals("Warrior")) {
			player = new Warrior(name,0.3);
		}
		else{
			player = new Mage(name,50);
		}
		//Using the above list of possible monsters, a random monster is generated.
		int chance = (int)(Math.random()*2);
		Monster monster = new Monster(types[chance]);
		boolean replay = true;
		//this is a global variable which keeps the game going until the user opts to end or they
		//die.
		while(replay && player.getHealth()>0) {
			startBattle(player,monster,input);
			//the code below will re-cast a new monster for the next game so things don't get boring :)
			chance = (int) (Math.random()*2 + 0);
			monster = new Monster(types[chance]);			
			
			//this last statement checks to see if the player is dead. If so, they do not get a new item.
			if(player.getHealth()>0) {
				
				//here the player is asked if they want to keep playing.
				System.out.println("Do you want to keep playing? Type no to end. ");
				String cont = input.next();
				System.out.println();
				if(cont.equals("no") || cont.equals("No")) {
					//again this is where the global boolean is assigned a value to continue/end the game loop.
					replay = false;
				}
			}
			else {
				replay = false;
			}
			
		}
	}

}



