
public class Wolf extends Hostile
	{
	public Wolf()
		{
		maxHp = 30;
		currentHp = 30;
		str = 4;
		vit = 1;
		dxt = 3;
		luck = 2;
		mobAttackBehavior = new KillingStrike();
		name = "Wolf";
		expDrop = 20;
		drops.add(new SmallHealthPotion());
		dropChances.add(60.5);
		drops.add(new BeginnersSword());
		dropChances.add(25.0);	
		drops.add(new Eludicator());
		dropChances.add(1.0);
		weapon = new TrainingSword();
		armor = new NoArmor();
		}
	}
