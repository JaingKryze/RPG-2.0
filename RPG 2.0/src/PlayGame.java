import java.util.ArrayList;
import java.util.Scanner;


public class PlayGame
	{
	private static int yesNo;
	private static boolean reset;
	public static Player player;
	public static void main(String[] args) throws InterruptedException
		{
		player = createPlayer();
		run();
		}
	public static void run() throws InterruptedException
		{
		do
			{
			Potion p = new SmallHealthPotion();
			p.useItem();
			//view inventory command
			combat(player);
			}
		while(player.getCurrentHp()>0);
		System.out.println("You died game over");
		}
	public static Player createPlayer() throws InterruptedException
		{
		int vit = 1;
		int dxt = 1;
		int luck = 1;
		int str = 1;
		int statTotal = 8;
		System.out.println("Name your character.");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("You start with 8 stat points. You can put them into Vit (health), Str(attack power), Dxt(speed+dodge chance), and luck(critical hit chance + dodge chance).");
		boolean checkStatIn = true;
		do
			{
			System.out.println("How many points do you want in Vit?");
			vit = vit + input.nextInt();
			if (vit-1 <= statTotal)
				{
				statTotal = statTotal-(vit-1);
				checkStatIn = true;
				}
			else
				{
				System.out.println("Pick a number less than or equal to " + statTotal + ".");
				checkStatIn = false;
				}
			}
		while(checkStatIn == false);
		checkStatIn = true;
		do
			{
			System.out.println("How many points do you want in Str?");
			str = str + input.nextInt();
			if (str-1 <= statTotal)
				{
				statTotal = statTotal-(str-1);
				checkStatIn = true;
				}
			else
				{
				System.out.println("Pick a number less than or equal to " + statTotal + ".");
				checkStatIn = false;
				}
			}
		while(checkStatIn == false);
		checkStatIn = true;
		do
			{
			System.out.println("How many points do you want in Dxt?");
			dxt = dxt + input.nextInt();
			if (dxt-1 <= statTotal)
				{
				statTotal = statTotal-(dxt-1);
				checkStatIn = true;
				}
			else
				{
				System.out.println("Pick a number less than or equal to " + statTotal + ".");
				checkStatIn = false;
				}
			}
		while(checkStatIn == false);
		checkStatIn = true;
		do
			{
			System.out.println("How many points do you want in luck?");
			luck = luck + input.nextInt();
			if (luck-1 <= statTotal)
				{
				statTotal = statTotal-(luck-1);
				checkStatIn = true;
				}
			else
				{
				System.out.println("Pick a number less than or equal to " + statTotal + ".");
				checkStatIn = false;
				}
			}
		while(checkStatIn == false);
		Item [] inventory = new Item[30];
		while(checkStatIn == false);
		int maxHp = vit*50 + 50;
		return new Player(maxHp, maxHp, str, vit, dxt, luck, new BasicAttack(), name, 1, 0, 100, inventory, new LeatherArmor(), new TrainingSword());
		}
	public static void createMap()
		{
		//make a basic map
		}
	public static void combat(Player player) throws InterruptedException
		{
		Scanner input = new Scanner(System.in);
		Mob enemy;
		ArrayList<Item> drops = new ArrayList<Item>(); 
		switch(player.getLvl())
			{
			case 1:
				{
				enemy = new Slime();
				break;
				}
			default:
				{
				enemy = new Slime();
				break;
				}
			}
		System.out.println("The " + enemy.getName() + " has " + enemy.getCurrentHp() + " HP.");
		System.out.println(player.getName() + " has " + player.getCurrentHp() + " HP.");
		while(enemy.getCurrentHp()>0&&player.getCurrentHp()>0)
			{
			if(player.getDxt()>=enemy.getDxt())
				{
				int skill;
				do
					{
					System.out.println("What skill would you like to use (enter the number). (1) basic attack. (2) killing strike.");
					Scanner askSkill = new Scanner(System.in);
					skill = askSkill.nextInt();
					if (!(skill>=1)||!(skill<=2))
						{
						System.out.println("Please select a valid skill.");
						}
					}
				while(!(skill>=1)||!(skill<=2));
				switch (skill)
					{
					case 1:
						{
						player.setMobAttackBehavior((AttackBehavior) new BasicAttack());
						break;
						}
					case 2:
						{
						player.setMobAttackBehavior((AttackBehavior) new KillingStrike());
						}
					}
				player.performAttack(player, enemy);
				if(enemy.getCurrentHp()>0&&player.getCurrentHp()>0)
					{
					enemy.performAttack(enemy, player);
					}
				}
			else
				{
				enemy.performAttack(enemy, player);
				if(enemy.getCurrentHp()>0&&player.getCurrentHp()>0)
					{
					int skill;
					do
						{
						System.out.println("What skill would you like to use (enter the number). (1) basic attack. (2) killing strike.");
						Scanner askSkill = new Scanner(System.in);
						skill = askSkill.nextInt();
						if (!(skill>=1)||!(skill<=2))
							{
							System.out.println("Please select a valid skill.");
							}
						}
					while(!(skill>=1)||!(skill<=2));
					switch (skill)
						{
						case 1:
							{
							player.setMobAttackBehavior((AttackBehavior) new BasicAttack());
							break;
							}
						case 2:
							{
							player.setMobAttackBehavior((AttackBehavior) new KillingStrike());
							}
						}
					player.performAttack(player, enemy);
					}
				}
			}
		if(enemy.getCurrentHp()<=0)
			{
			player.setExp(player.getExp()+((Hostile)enemy).getExpDrop());
			drops = ((Hostile)enemy).generateDrops((Hostile)enemy);
			}
		for(Item i: drops)
			{
			System.out.println("A " + i.getName() + " was dropped.");
			System.out.print("Price: " + i.getPrice());
			if(i.getType()=="weapon")
				{
				System.out.println(" Attack Power: " + ((Weapon)i).getAtk());
				System.out.println("Your current weapon has an Attack Power of " + player.getWeapon().getAtk());
				System.out.println("Would you like to equip the " + i.getName() +" type 1 for yes 2 for no.");
				if(input.nextInt()==1)
					{
					player.setWeapon((Weapon) i);
					}
				}
			else if(i.getType()=="armor")
				{
				System.out.println(" Defense: " + ((Armor)i).getDef());
				System.out.println("Your current armor has a defense of " + player.getArmor().getDef());
				System.out.println("Would you like to equip the " + i.getName() +" type 1 for yes 2 for no.");
				if(input.nextInt()==1)
					{
					player.setArmor((Armor) i);
					}
				}
			else if(i.getType()=="potion")
				{
				System.out.println(" Healing power: " + ((Potion)i).getHpRestore());
				System.out.println("Would you like to add the " + i.getName() +" to your inventory type 1 for yes 2 for no.");
				if(input.nextInt()==1)
					{
					//add error handling
					Item[] inventory = player.getInventory();
					for(int j = 0; j<30; j++)
						{
						if(inventory[j]==(null))
							{
							inventory[j] = i;
							j=30;
							player.setInventory(inventory);
							}
						}
					}
				}
			
			}
		}
	}
