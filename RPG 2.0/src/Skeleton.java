
public class Skeleton extends Hostile
	{
	public Skeleton()
		{
		maxHp = 150;
		currentHp = 150;
		str = 4;
		vit = 3;
		dxt = 3;
		luck = 3;
		mobAttackBehavior = new BasicAttack();
		name = "Skeleton";
		expDrop = 30;
		drops.add(new SmallHealthPotion());
		dropChances.add(100.0);
		drops.add(new BeginnersSword());
		dropChances.add(25.0);
		drops.add(new ChainMail());
		dropChances.add(25.0);
		drops.add(new Eludicator());
		dropChances.add(2.0);
		weapon = new TrainingSword();
		armor = new LeatherArmor();
		}
	}
