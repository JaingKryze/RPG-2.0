
public class KillingStrike implements AttackBehavior
	{
	@Override
	public int attack(Mob a, Mob b) throws InterruptedException
		{
		int damage = 0;
		damage = (int)(a.getWeapon().getAtk()*2.5) + (a.getStr()*4) - (b.getArmor().getDef());
		//dodge chance or eva based on luck and dxt
		double rand = Math.random();
		if(rand<((double)(b.getLuck()*.01)+(double)(b.getDxt()*.002)+.05))
			{
			Thread.sleep(250);
			System.out.println("Attack Dodged");
			damage=0;
			}
		rand = Math.random();
		//crit chance
		if(rand<((double)(b.getLuck()*.02)+.2))
			{
			Thread.sleep(250);
			System.out.println("Critical Hit");
			damage = damage*2;
			}
		rand = Math.random();
		if(rand<.1)
			{
			Thread.sleep(250);
			damage = 0;
			System.out.println("Attack Failed");
			}
		if(damage<0)
			{
			damage=0;
			}
		if(a.getType().equals("player"))
			{
			Thread.sleep(250);
			System.out.println("You deal " + damage + " damage.");
			Thread.sleep(250);
			b.setCurrentHp(b.getCurrentHp()-damage);
			System.out.println(b.getName() + " now has "+ b.getCurrentHp() + " HP.");
			}
		else
			{
			Thread.sleep(250);
			System.out.println("The " + a.getName() + " deals " + damage + " damage.");
			Thread.sleep(250);
			b.setCurrentHp(b.getCurrentHp()-damage);
			System.out.println(b.getName() + " now has "+ b.getCurrentHp() + " HP.");
			}
		if(b.getCurrentHp()>0&&damage!=0)
			{
			Thread.sleep(250);
			System.out.println("The attack failed to kill " + b.getName() + ", " + b.getName() + " counter attacks.");
			Thread.sleep(250);
			b.performAttack(b, a);
			}
		Thread.sleep(250);
		return damage;
		}
	}
