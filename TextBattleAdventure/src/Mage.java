/**
 * Name: 
  * Name:Farzad Hasan
 * Last Updated On: 06/2/22
 * APCS Period 2
 * Text Battle Project Part TwoB
 * 
 * This class is the represents a Mage object which is a Player. It must contain all of the fields and methods 
 * detailed in the project spec. You 
 * may add additional fields and methods if you like.
 */


public class Mage extends Player{
private int mana;
private int maxMana;

//Default constructor for Mage player.
public Mage(String name, int m) {
	super(name, 50, 5, 10);
	
	//If the mana is below 0, both maxMana and mana are
	//set to 50 by default.
	if ( m <= 0) {
		maxMana = 50;
		mana = 50;
	}
	else {
	//Otherwise they are set to the parameter.
		maxMana = m;
		mana = m;
	}
	
}

//This is the attack method for the monster. This method will
//determine the price of attacking (manaCost) by generating a 
//random value between 1 and the maxMana divided by 2.
public int attack(Monster monster) {
	int manaCost = (int)(Math.random()*(maxMana/2) + 1);
	if (mana - manaCost < 0) {
		
		//If there is not enough mana to complete the attack,
		//the mage will attack with 0 damage.
		System.out.println("Not enough mana!");
		return 0;
	}
	else {
		//If there is enough mana, the mage will attach with the super class
		//attack method.
		mana -= manaCost;
		System.out.println(super.getName() + " has " + mana + " mana left.");
		return super.attack(monster);
	}
	
	
}

//Method to add mana back to the Mage.
public void restoreMana(int m) {
	mana += m;
	if (mana > maxMana) {
		mana = maxMana;
	}
}

//Accessor method to return current amount of mana.
public int getMana() {
	return mana;
}

//Modifiying method to reduce the mana when used.
public void useMana(int n) {
	mana = mana-n;
	if (mana < 0) {
		mana = 0;
	}
}
}
