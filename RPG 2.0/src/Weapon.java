

public class Weapon extends Item
	{
	public Weapon()
		{
		type = "weapon";
		}
	protected int atk;
	
	@Override
	public void equipItem()
		{
		// add item to equipment remove from inventory
		}

	@Override
	public void unequipItem()
		{
		// remove item from equip add to inventory
		
		}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	}
