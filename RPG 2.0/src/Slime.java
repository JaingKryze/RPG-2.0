
public class Slime extends Hostile
	{
	public Slime()
		{
		maxHp = 50;
		currentHp = 50;
		str = 2;
		vit = 1;
		dxt = 1;
		luck = 1;
		mobAttackBehavior = new BasicAttack();
		name = "Slime";
		expDrop = 5;
		drops.add(new SmallHealthPotion());
		dropChances.add(55.5);
		drops.add(new TrainingSword());
		dropChances.add(50.0);
		drops.add(new LeatherArmor());
		dropChances.add(50.0);
		weapon = new NoWeapon();
		armor = new NoArmor();
		}
	}
