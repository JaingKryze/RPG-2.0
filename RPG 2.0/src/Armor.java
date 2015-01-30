
public class Armor extends Item
	{
	public Armor()
		{
		type = "armor";
		}
	public Armor(String n, int p, int d, int r)
		{
		name = n;
		type = "potion";
		price = p;
		def = d;
		}
	protected int def;
	public int getDef()
		{
		return def;
		}
	public void setDef(int def)
		{
		this.def = def;
		}

	@Override
	public void equipItem()
		{
		// add to equipment remove from inventory
		}

	@Override
	public void unequipItem()
		{
		// remove from equipment add to inventory
		}
	
	}
