
public class PoisionPotion extends Item{
	
	//Basic Constructor for the potion
	public PoisionPotion(String rarity){
		super("Poison Potion", rarity);
	}
	
	
	public void use(Player player) {
		
		//A random amount of player damage will be generated
		int damage = (int)(Math.random()*5 +1);
		player.takeDamage(damage);
		
		//players available amount of possible maximum damage by 3.
		player.setMaxDamage(damage * 3);
		System.out.println("At the cost of your health, you can now possibly do three times the damage.");
	}
}
