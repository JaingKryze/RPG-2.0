
public interface AttackBehavior
	{
	public  int damage = 0;
	//can not use private in a interface
	public int attack(Mob a, Mob b)throws InterruptedException;
	}
