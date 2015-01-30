import java.util.ArrayList;
public class ItemRunner 
	{
	public static void main(String[] args) 
		{
		ArrayList<Item> items = new ArrayList<Item>();
		items.add( new ChainMail());
		items.add(new LeatherArmor());
		items.add(new Eludicator());
		items.add(new TrainingSword());
		items.add(new SmallHealthPotion());
		for(Item x : items)
			{
			System.out.println(x.getName());
			System.out.println("The price is " + x.getPrice());
			x.getItemAbilityBehavior().applyAbility();
			System.out.println("The type is " + x.getType());
			if(x.getType() == "weapon")
				{
				System.out.println("The attack power is " + ((Weapon) x).getAtk());
				}
			else if(x.getType() == "armor")
				{
				System.out.println("The defense power is " + ((Armor) x).getDef());
				}
			else if(x.getType() == "potion")
				{
				System.out.println("The health restore is " + ((Potion) x).getHpRestore());
				}
			System.out.println();
			}
		}
	}
