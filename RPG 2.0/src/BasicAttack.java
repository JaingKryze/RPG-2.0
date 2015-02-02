
public class BasicAttack implements AttackBehavior
	{

	@Override
	public int attack(Mob a, Mob b)
		{
		int damage = 0;
		damage = a.getWeapon().getAtk() + (a.getStr()*5) - (b.getArmor().getDef());
		
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
		b.setCurrentHp(b.getCurrentHp()-damage);
		return damage;
		}
	
	}
