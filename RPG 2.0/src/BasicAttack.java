
public class BasicAttack implements AttackBehavior
	{

	@Override
	public int attack(Mob a, Mob b) throws InterruptedException
		{
		int damage = 0;
		damage = a.getWeapon().getAtk() + (a.getStr()*3) - (b.getArmor().getDef());
		
		//dodge chance or eva based on luck and dxt
		double rand = Math.random();
		if(rand<((double)(b.getLuck()*.01)+(double)(b.getDxt()*.002)+.1))
			{
			Thread.sleep(250);
			System.out.println("Attack Dodged");
			damage=0;
			}
		rand = Math.random();
		//crit chance
		if(rand<((double)(b.getLuck()*.02)+.1) && damage!=0)
			{
			Thread.sleep(250);
			System.out.println("Critical Hit");
			damage = damage*2;
			}
		if(damage<0)
			{
			damage=0;
			}
		Thread.sleep(250);
		if(a.getType().equals("player"))
			{
			System.out.println("You deal " + damage + " damage.");
			b.setCurrentHp(b.getCurrentHp()-damage);
			Thread.sleep(250);
			if(b.getCurrentHp()<0)
				{
				System.out.println(b.getName() + " has been killed");
				}
			else
				{
				System.out.println(b.getName() + " now has "+ b.getCurrentHp() + " HP.");
				}
			}
		else
			{
			System.out.println("The " + a.getName() + " deals " + damage + " damage.");
			b.setCurrentHp(b.getCurrentHp()-damage);
			Thread.sleep(250);
			if(b.getCurrentHp()<0)
				{
				System.out.println(b.getName() + " has been killed");
				}
			else
				{
				System.out.println(b.getName() + " now has "+ b.getCurrentHp() + " HP.");
				}
			}
		Thread.sleep(250);
		return damage;
		}
	
	}
