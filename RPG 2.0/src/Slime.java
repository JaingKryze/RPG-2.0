
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
		expDrop = 20;
		drops.add(new SmallHealthPotion());
		dropChances.add(55.5);
		drops.add(new BeginnersSword());
		dropChances.add(25.0);
		drops.add(new ChainMail());
		dropChances.add(25.0);	
		weapon = new TrainingSword();
		armor = new LeatherArmor();
		}
	}
