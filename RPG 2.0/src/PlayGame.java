import java.util.Scanner;


public class PlayGame
	{
	private static int yesNo;
	private static boolean reset;
	public static Player player;
	public static void main(String[] args)
		{
		player = createPlayer();
		}
	public static void run()
		{
		
		}
	public static Player createPlayer()
		{
		int vit = 1;
		int dxt = 1;
		int luck = 1;
		int str = 1;
		int statTotal = 6;
		System.out.println("Name your character.");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("You start with 8 stat points. You can put them into Vit (health), Str(attack power), Dxt(speed+dodge chance), and luck(critical hit chance + dodge chance).");
		boolean checkStatIn = true;
		do
			{
			System.out.println("How many points do you want in Vit?");
			vit = vit + input.nextInt();
			if (vit <= statTotal)
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
			str = input.nextInt();
			if (str <= statTotal)
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
			dxt = input.nextInt();
			if (dxt <= statTotal)
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
			luck = input.nextInt();
			if (luck <= statTotal)
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
	public static void combat()
		{
		//create combat thingy
		}
	}
