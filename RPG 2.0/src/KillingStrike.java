
public class KillingStrike implements AttackBehavior
	{
	@Override
	public int attack(Mob a, Mob b)
		{
		int damage = 0;
		damage = a.getWeapon().getAtk()*2 + (a.getStr()*6) - (b.getArmor().getDef());
		//dodge chance or eva based on luck and dxt
		double rand = Math.random();
		if(rand<((double)(b.getLuck()*.01)+(double)(b.getDxt()*.002)+.1))
			{
			System.out.println("Attack Doged");
			damage=0;
			}
		rand = Math.random();
		//crit chance
		if(rand<((double)(b.getLuck()*.02)+.1))
			{
			System.out.println("Critical Hit");
			damage = damage*2;
			}
		rand = Math.random();
		if(rand<.5)
			{
			damage = 0;
			System.out.println("Attack Failed");
			}
		// make attack do 0 damge if it will not kill the enemy
		b.setCurrentHp(b.getCurrentHp()-damage);
		return damage;
		}
	}
