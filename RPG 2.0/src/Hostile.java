import java.util.ArrayList;
public class Hostile extends Mob
	{
	protected int expDrop;
	protected ArrayList<Item> drops = new ArrayList<Item>();
	protected ArrayList<Double> dropChances = new ArrayList<Double>();
	public Hostile()
		{
		
		}
	public Hostile(int mHp, int cHp, int s, int v, int d, int l, AttackBehavior aB, String n, int ex, ArrayList<Item> dr, ArrayList<Double> dC, Armor a, Weapon w)
		{
		maxHp = v*50+50;
		currentHp = cHp;
		str = s;
		vit = v;
		dxt = d;
		luck = l;
		mobAttackBehavior = aB;
		name = n;
		drops=dr;
		expDrop = ex;
		dropChances = dC;
		weapon = w;
		armor = a;
		}
	//drop chances rarity is percent
	public ArrayList<Item> generateDrops(Hostile hos)
		{
		ArrayList<Item> itemDrops = new ArrayList<Item>();
		int count = 0;
		for(Item d: hos.getDrops())
			{
			double chance = Math.random()*100;
			if(hos.getDropChances().get(count)>chance)
				{
				itemDrops.add(d);
				}
			count++;
			}
		return itemDrops;
		}
	
	public int getExpDrop()
		{
		return expDrop;
		}
	public void setExpDrop(int expDrop)
		{
		this.expDrop = expDrop;
		}
	public ArrayList<Item> getDrops()
		{
		return drops;
		}
	public void setDrops(ArrayList<Item> drops)
		{
		this.drops = drops;
		}
	public ArrayList<Double> getDropChances()
		{
		return dropChances;
		}
	public void setDropChances(ArrayList<Double> dropChances)
		{
		this.dropChances = dropChances;
		}
	}
