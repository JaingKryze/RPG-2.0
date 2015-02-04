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
		int statTotal = 6;
		System.out.println("Name your character.");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("You start with 6 stat points. You can put them into Vit (health), Str(attack power), Dxt(speed+dodge chance), and luck(critical hit chance + dodge chance).");
		boolean checkStatIn = true;
		int num;
		do
			{
			System.out.println("How many points do you want in Vit?");
			num = input.nextInt();
			if (num <= statTotal)
				{
			    vit = vit + num;
				statTotal = statTotal-(num);
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
			num = input.nextInt();
			if (num <= statTotal)
				{
				str = str + num;
				statTotal = statTotal-(num);
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
			num = input.nextInt();
			if (num <= statTotal)
				{
				dxt = dxt + num;
				statTotal = statTotal-(num);
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
			num = input.nextInt();
			if (num <= statTotal)
				{
				statTotal = statTotal-(num);
				checkStatIn = true;
				luck = luck + num;
				}
			else
				{
				System.out.println("Pick a number less than or equal to " + statTotal + ".");
				checkStatIn = false;
				}
			}
		while(checkStatIn == false);
		Item [] inventory = new Item[30];
		int maxHp = vit*50;
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
			case 2:
				{
				enemy = new Skeleton();
				break;
				}
			default:
				{
				enemy = new Skeleton();
				break;
				}
			}
		System.out.println("You encounter a " + enemy.getName());
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
				System.out.println("Would you like to use the " + i.getName() +" type 1 for yes 2 for no.");
				//System.out.println("Would you like to add the " + i.getName() +" to your inventory type 1 for yes 2 for no.");
				if(input.nextInt()==1)
					{
					i.useItem();
//					//add error handling
//					Item[] inventory = player.getInventory();
//					for(int j = 0; j<30; j++)
//						{
//						if(inventory[j]==(null))
//							{
//							inventory[j] = i;
//							j=30;
//							player.setInventory(inventory);
//							}
//						}
					}
				}
			
			}
		}
	}
