
public class Potion extends Item
	{
	public Potion()
		{
		type = "potion";
		}
	public Potion(String n, int p, int hp)
		{
		name = n;
		type = "potion";
		price = p;
		hpRestore = hp;
		}
	public int getHpRestore() {
		return hpRestore;
	}
	public void setHpRestore(int hpRestore) {
		this.hpRestore = hpRestore;
	}
	protected int hpRestore;
	
	//fix this to use encapsulation
	@Override
	public void useItem()
		{
		if(PlayGame.player.getCurrentHp()+hpRestore > PlayGame.player.getVit()*50)
			{
			PlayGame.player.setCurrentHp(PlayGame.player.getMaxHp());
			}
		else
			{
			PlayGame.player.setCurrentHp(PlayGame.player.getCurrentHp()+hpRestore);
			}
		}
	@Override
	public void equipItem()
		{
		System.out.println("This item can not be equiped.");
		}
	@Override
	public void unequipItem()
		{
		System.out.println("This item can not be equiped.");
		}
	}
