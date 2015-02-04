import java.util.ArrayList;
import java.util.Scanner;
public class Player extends Mob
	{
	protected int lvl;
	protected int exp;
	protected int expNeeded;
	protected Item[] inventory = new Item[30];
	public Player(int mHp, int cHp, int s, int v, int d, int l, AttackBehavior aB, String n, int lv, int xp, int xpN, Item[] i, Armor a, Weapon w)
		{
		type = "player";
		maxHp = v*50;
		currentHp = cHp;
		str = s;
		vit = v;
		dxt = d;
		luck = l;
		mobAttackBehavior = aB;
		name = n;
		lvl = lv;
		exp = xp;
		expNeeded = xpN;
		inventory = i;
		weapon = w;
		armor = a;
		}
	public Item[] getInventory()
		{
		return inventory;
		}
	public void setInventory(Item[] inventory)
		{
		this.inventory = inventory;
		}
	public int getLvl()
		{
		return lvl;
		}
	public void setLvl(int lvl)
		{
		this.lvl = lvl;
		}
	public int getExp()
		{
		return exp;
		}
	public void setExp(int exp)
		{
		if(exp<expNeeded)
			{
			this.exp = exp;
			}
		else
			{
			levelUp();
			this.exp = 0;
			}
		}
	public int getExpNeeded()
		{
		return expNeeded;
		}
	public void setExpNeeded(int expNeeded)
		{
		this.expNeeded = expNeeded;
		}
	
	public void levelUp()
		{
		int num;
		int statTotal = 3;
		Scanner input = new Scanner(System.in);
		System.out.println("Level up you have 3 stat points. You can put them into Vit" + vit + " (health), Str" + str + " (attack power), Dxt" +dxt +" (speed+dodge chance), and luck"+ luck +"(critical hit chance + dodge chance).");
		boolean checkStatIn = true;
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
		maxHp = vit*50;
		currentHp = maxHp;
		lvl++;
		expNeeded = lvl*100;
		}
	}
