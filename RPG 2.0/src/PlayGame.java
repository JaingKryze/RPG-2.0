import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PlayGame
	{
	private static int yesNo;
	private static boolean reset;
	public static Player player;
	public static int x = 0;
	public static int y = 0;
	public static Location[][] map;
	public static void main(String[] args) throws InterruptedException
		{
		System.out.println("Welcome to my rpg.");
		System.out.println("Warning attempts to break this game will be punished severly, this game will auto save.");
		map = createMap();
		player = readFromFile();
		writeSave();
		run();
		}
	public static void run() throws InterruptedException
		{
		do
			{
			//view inventory command
			viewMainMenu();
			player = combat(player);
			writeSave();
			}
		while(player.getCurrentHp()>0);
		System.out.println("You died game over");
		}
	public static void displayNearByMap(Location[][] map)
		{
		for(int i = -1; i<2; i++)
			{
			for(int j = -1; j<2; j++)
				{
				if((x+i)>=0&&(y+j)>=0&&map[i][j]!=(null))
					{
					System.out.printf("%15s", map[x+i][y+j].getName());
					}
				else
					{
					System.out.printf("%15s", "empty");
					}
				}
			System.out.println();
			}
		}
	public static void	movement() throws InterruptedException
		{
		boolean north = false;
		boolean south = false;
		boolean east = false;
		boolean west = false;
		int movesToMake = map[x][y].getLength();
		for(movesToMake= map[x][y].getLength(); movesToMake>0; movesToMake--)
			{
			combat(player);
			}
		if(movesToMake==0)
			{
			boolean dir = true;
			do
				{
				String direction;
				displayNearByMap(map);
				System.out.print("Would you like to move ");
				if(y-1>=0 && map[x][y-1]!=null)
					{
					System.out.print(" north");
					north = true;
					}
				if(y+1>=0 && map[x][y+1]!=null)
					{
					System.out.print(" south");
					south = true;
					}
				if(x-1>=0 && map[x-1][y]!=null)
					{
					System.out.print(" east");
					east = true;
					}
				if(x-1>=0 && map[x-1][y]!=null)
					{
					System.out.print(" west");
					west = true;
					}
				System.out.println();
				Scanner input = new Scanner(System.in);
				direction=input.nextLine().toLowerCase();
				if(input.equals("north")&&north==true)
					{
					y--;
					dir = true;
					}
				else if(input.equals("south")&&south==true)
					{
					y++;
					dir = true;
					}
				else if(input.equals("east")&&east==true)
					{
					x--;
					dir = true;
					}
				else if(input.equals("west")&&west==true)
					{
					x++;
					dir = true;
					}
				else
					{
					System.out.println("Please make sure your input was typed correctly it could not be recognized, include no spaces and correct spelling.");
					dir = false;
					}
				}
			while(dir==false);
			}
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
			num = input.hasNextInt() ? input.nextInt():0;
			if (num <= statTotal && num>=0)
				{
			    vit = vit + num;
				statTotal = statTotal-(num);
				checkStatIn = true;
				System.out.println("You put " + num + " points in vit.");
				}
			else
				{
				System.out.println("Pick a number less than or equal to " + statTotal + ".");
				checkStatIn = false;
				}
			}
		while(checkStatIn == false);
		input.reset();
		checkStatIn = true;
		do
			{
			System.out.println("How many points do you want in Str?");
			Scanner input2 = new Scanner(System.in);
			num = input2.hasNextInt() ? input2.nextInt():0;
			if (num <= statTotal && num>=0)
				{
				str = str + num;
				statTotal = statTotal-(num);
				checkStatIn = true;
				System.out.println("You put " + num + " points in str.");
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
			Scanner input2 = new Scanner(System.in);
			num = input2.hasNextInt() ? input2.nextInt():0;
			if (num <= statTotal && num >=0)
				{
				dxt = dxt + num;
				statTotal = statTotal-(num);
				checkStatIn = true;
				System.out.println("You put " + num + " points in dxt.");
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
			Scanner input2 = new Scanner(System.in);
			num = input2.hasNextInt() ? input2.nextInt():0;
			if (num <= statTotal && num>=0)
				{
				statTotal = statTotal-(num);
				checkStatIn = true;
				luck = luck + num;
				System.out.println("You put " + num + " points in luck.");
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
	public static Location[][] createMap()
		{
		Location[][] map = new Location[5][5];
		map[0][0] = new Location("Village", 0 , 0, true);
		map[0][1] = new Location("Field", 1, 5, false);
		map[1][0] = new Location("Field", 1, 5, false);
		map[2][0] = new Location("Field", 1, 5, false);
		map[2][1] = new Location("Village", 0, 0, false);
		map[1][2] = new Location("Forest", 2, 5, false);
		map[0][3] = new Location("Cave", 3, 5, false);
		map[1][3] = new Location("Dungeon", 4, 1, false);
		return map;
		}
	public static Player combat(Player player) throws InterruptedException
		{
		double v = Math.random();
		if(v<=.1)
			{
			village();
			return player;
			}
		Scanner input = new Scanner(System.in);
		Mob enemy;
		ArrayList<Item> drops = new ArrayList<Item>(); 
		switch(player.getLvl())
			{
			case 1:
				{
				double rand = Math.random();
				if(rand>=.5)
					{
					enemy = new Slime();
					}
				else
					{
					enemy = new Wolf();
					}
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
		Thread.sleep(100);
		System.out.println("The " + enemy.getName() + " has " + enemy.getCurrentHp() + " HP.");
		Thread.sleep(100);
		System.out.println(player.getName() + " has " + player.getCurrentHp() + " HP.");
		Thread.sleep(100);
		while(enemy.getCurrentHp()>0&&player.getCurrentHp()>0)
			{
			if(player.getDxt()>=enemy.getDxt())
				{
				int skill;
				do
					{
					System.out.println("What skill would you like to use (enter the number). (1) basic attack. (2) killing strike.");
					Scanner input2 = new Scanner(System.in);
					skill = input2.hasNextInt() ? input2.nextInt():0;
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
						break;
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
						Scanner input2 = new Scanner(System.in);
						skill = input2.hasNextInt() ? input2.nextInt():0;
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
			System.out.println("You have defeated the " + enemy.getName());
			System.out.println("Your current exp is " + player.getExp() + "/" + player.getExpNeeded());
			Thread.sleep(1000);
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
				int num;
				Scanner input2 = new Scanner(System.in);
				num = input2.hasNextInt() ? input2.nextInt():0;
				if(num==1)
					{
					player.setWeapon((Weapon) i);
					}
				else
					{
					player.setWallet(player.getWallet() + i.sell());
					}
				}
			else if(i.getType()=="armor")
				{
				System.out.println(" Defense: " + ((Armor)i).getDef());
				System.out.println("Your current armor has a defense of " + player.getArmor().getDef());
				System.out.println("Would you like to equip the " + i.getName() +" type 1 for yes 2 for no.");
				int num;
				Scanner input2 = new Scanner(System.in);
				num = input2.hasNextInt() ? input2.nextInt():0;
				if(num==1)
					{
					player.setArmor((Armor) i);
					}
				else
					{
					player.setWallet(player.getWallet() + i.sell());
					}
				}
			else if(i.getType()=="potion")
				{
				System.out.println(" Healing power: " + ((Potion)i).getHpRestore());
				System.out.println("Would you like to use the " + i.getName() +" type 1 for yes 2 for no.");
				//System.out.println("Would you like to add the " + i.getName() +" to your inventory type 1 for yes 2 for no.");
				int num;
				Scanner input2 = new Scanner(System.in);
				num = input2.hasNextInt() ? input2.nextInt():0;
				if(num==1)
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
				else
					{
					player.setWallet(player.getWallet() + i.sell());
					}
				}
			}
		return player;
		}
	public static void writeSave()
		{
        try {
        	String fileName = "rpg2.0_save.txt";
	        File file = new File(fileName);
			if (!file.exists()) 
				{
				file.createNewFile();
				}	
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(file.getAbsoluteFile());

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            if(player.getCurrentHp()>0)
            	{
            	bufferedWriter.write(" " + 1);
            	}
            else
            	{
            	bufferedWriter.write(" " + -1);
            	}
            bufferedWriter.newLine();
            bufferedWriter.write(" " + player.getMaxHp());
            bufferedWriter.write(" " + player.getCurrentHp());
            bufferedWriter.write(" " + player.getStr());
            bufferedWriter.write(" " + player.getVit());
            bufferedWriter.write(" " + player.getDxt());
            bufferedWriter.write(" " + player.getLuck());
            bufferedWriter.write(" " + player.getName());
            bufferedWriter.write(" " + player.getLvl());
            bufferedWriter.write(" " + player.getExp());
            bufferedWriter.write(" " + player.getExpNeeded());
            //bufferedWriter.write(" " + player.getInventory());
            bufferedWriter.newLine();
            bufferedWriter.write(" " + player.getArmor().getName());
            bufferedWriter.newLine();
            bufferedWriter.write(" " + player.getWeapon().getName());
            // Always close files.
            bufferedWriter.close();
            System.out.println("Saved");
        	}
        catch(IOException e) {
            e.printStackTrace();
            // Or we could just do this:
            // ex.printStackTrace();
			}
		}
	public static Player readFromFile() throws InterruptedException
		{
		 String fileName = "rpg2.0_save.txt";

	        // This will reference one line at a time
	        String line = null;
	        String a;
	        String w;
	        Armor armor;
	        Weapon weapon;
//	        File file = new File(fileName);
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            if((bufferedReader.readLine()).equals(" 1"))
	            	{
	            	Scanner input = new Scanner(System.in);
	            	System.out.println("Save data detected would you like to load? (1) yes (2) no");
	            	if(input.nextLine().equals("1"))
	            		{
	            		
	            		}
	            	else
	            		{
	            		return PlayGame.createPlayer();
	            		}
	            	line = bufferedReader.readLine();
	                String[] l = line.split(" ");
	                a = bufferedReader.readLine();
	                if(a.equals(" Chain Mail"))
	                	{
	                	armor = new ChainMail();
	                	}
	                else
	                	{
	                	armor = new LeatherArmor();
	                	}
	                w= bufferedReader.readLine();
	                if(w.equals(" Beginners Sword"))
	                	{
	                	weapon = new BeginnersSword();
	                	}
	                else
	                	{
	                	weapon = new TrainingSword();
	                	}
	                AttackBehavior ab = new BasicAttack();
	                Item [] inventory = new Item[30];
	                bufferedReader.close();
	                System.out.println("Welcome back " + l[7]);
	                return new Player(Integer.parseInt(l[1]), Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]), Integer.parseInt(l[5]), Integer.parseInt(l[6]), ab, l[7], Integer.parseInt(l[8]), Integer.parseInt(l[9]), Integer.parseInt(l[10]), inventory, armor, weapon);
	            	}

	            // Always close files.
	            bufferedReader.close();			
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");				
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");					
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	        return createPlayer();
		}
	public static void viewMainMenu()
		{
		System.out.println("Would you like to view the menu? (1) yes (2) no");
		int num;
		Scanner input2 = new Scanner(System.in);
		num = input2.hasNextInt() ? input2.nextInt():0;
		if(num==1)
			{
			System.out.println("Type your selection");
			System.out.println("(1) View Stats");
			System.out.println("(2) View Armor");
			System.out.println("(3) View Weapon");
			System.out.println("(4) Return");
			//implement options 2 and 3
			Scanner input3 = new Scanner(System.in);
			num = input3.hasNextInt() ? input3.nextInt():0;
			if(num==1)
				{
				viewStats();
				}
			else if(num==2)
				{
				viewArmor();
				}
			else if(num==3)
				{
				viewWeapon();
				}
			else
				{
				System.out.println("You will now exit the menu.");
				}
			}
		else
			{
			System.out.println("Ok");
			}
		return;
		}
	public static void viewStats()
		{
		System.out.println("HP: " + player.getCurrentHp()+ "/" + player.getMaxHp());
		System.out.println("Vit:" + player.getVit());
		System.out.println("Str:" + player.getStr());
		System.out.println("Dxt:" + player.getDxt());
		System.out.println("Luck:" + player.getLuck());
		viewMainMenu();
		}
	public static void viewArmor()
		{
		System.out.println("Def: " + player.getArmor().getDef());
		System.out.println("Price: " + player.getArmor().getPrice());
		viewMainMenu();
		}
	public static void viewWeapon()
		{
		System.out.println("Atk: " + player.getWeapon().getAtk());
		System.out.println("Price: " + player.getWeapon().getPrice());
		viewMainMenu();
		}
	public static void village()
		{
		boolean leave = false;
		int num;
		System.out.println("You encounter a village.");
		System.out.println("You have " + player.getWallet() + " gold from items you sold.");
		do
			{
			System.out.println("Would you like to refine your (1)weapon(cost: " + player.getWeapon().getPrice()+") or (2)armor(cost: "+ player.getArmor().getPrice()+"). (type 3 to leave)");
			Scanner input2 = new Scanner(System.in);
			num = input2.hasNextInt() ? input2.nextInt():-1;
			if(num==1)
				{
				if(player.getWallet()>player.getWeapon().getPrice())
					{
					player.setWallet(player.getWallet()-player.getWeapon().getPrice());
					player.getWeapon().setAtk(player.getWeapon().getAtk()+1);
					player.getWeapon().setPrice(player.getWeapon().getPrice()*2);
					System.out.println("You have refined your " + player.getWeapon().getName());
					}
				else
					{
					System.out.println("You only have " + player.getWallet() + " gold.");
					}
				}
			else if(num==2)
				{
				if(player.getWallet()>player.getArmor().getPrice())
					{
					player.setWallet(player.getWallet()-player.getArmor().getPrice());
					player.getArmor().setDef(player.getArmor().getDef()+1);
					player.getArmor().setPrice(player.getArmor().getPrice()*2);
					System.out.println("You have refined your " + player.getArmor().getName());
					}
				else
					{
					System.out.println("You only have " + player.getWallet() + " gold.");
					}
				}
			else if(num==-1)
				{
				System.out.println("The villagers grow angry at your attempts to break this magnificent game.");
				System.out.println("They break your weapon and armor in retaliation");
				player.setArmor(new NoArmor());
				player.setWeapon(new NoWeapon());
				leave = true;
				}
			else
				{
				leave = true;
				}
			}
		while(leave==false);
		if(num!=-1)
			{
			System.out.println("The villagers let you rest in their village for the night.");
			System.out.println("You leave the village feeling rested");
			new SmallHealthPotion().useItem();
			new SmallHealthPotion().useItem();
			new SmallHealthPotion().useItem();
			}
		else
			{
			System.out.println("You decide to leave the village");
			}
		}
	}
