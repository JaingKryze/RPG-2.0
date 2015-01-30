
public class BasicAttack implements AttackBehavior
	{

	@Override
	public int attack(Mob a, Mob b)
		{
		int damage = 0;
		damage = a.getWeapon().getAtk() + (a.getStr()*5) - (b.getArmor().getDef());
		
		//dodge chance or eva based on luck and dxt
		double rand = Math.random();
		if(rand<((b.getLuck()*.01)+(b.getDxt()*.002)))
			{
			damage=0;
			}
		rand = Math.random();
		if(rand<((b.getLuck()*.02)))
			{
			damage = damage*2;
			}
		b.setCurrentHp(b.getCurrentHp()-damage);
		return damage;
		}
	
	}
