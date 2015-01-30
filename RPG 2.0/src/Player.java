import java.util.ArrayList;
public class Player extends Mob
	{
	int lvl;
	int exp;
	int expNeeded;
	Item[] inventory = new Item[30];
	public Player(int mHp, int cHp, int s, int v, int d, int l, AttackBehavior aB, String n, int lv, int xp, int xpN, Item[] i, Armor a, Weapon w)
		{
		maxHp = v*50+50;
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
		this.exp = exp;
		}
	public int getExpNeeded()
		{
		return expNeeded;
		}
	public void setExpNeeded(int expNeeded)
		{
		this.expNeeded = expNeeded;
		}
	}
