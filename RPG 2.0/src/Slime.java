
public class Slime extends Hostile
	{
	public Slime()
		{
		maxHp = 100;
		currentHp = 100;
		str = 2;
		vit = 2;
		dxt = 1;
		luck = 1;
		mobAttackBehavior = new BasicAttack();
		name = "Slime";
		expDrop = 20;
		drops.add(new SmallHealthPotion());
		dropChances.add(55.5);
		drops.add(new ChainMail());
		dropChances.add(25.0);
		drops.add(new Eludicator());
		dropChances.add(1.0);
		weapon = new NoWeapon();
		armor = new LeatherArmor();
		}
	}
