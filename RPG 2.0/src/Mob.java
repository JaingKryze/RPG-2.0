
public abstract class Mob
	{
	protected Weapon weapon;
	protected Armor armor;
	protected String name;
	protected AttackBehavior mobAttackBehavior;
	protected int maxHp;
	protected int currentHp;
	protected int str;
	protected int vit;
	protected int dxt;
	protected int luck;
	public Weapon getWeapon()
		{
		return weapon;
		}
	public void setWeapon(Weapon weapon)
		{
		this.weapon = weapon;
		}
	public Armor getArmor()
		{
		return armor;
		}
	public void setArmor(Armor armor)
		{
		this.armor = armor;
		}
	public String getName()
		{
		return name;
		}
	public void setName(String name)
		{
		this.name = name;
		}
	public AttackBehavior getMobAttackBehavior()
		{
		return mobAttackBehavior;
		}
	public void setMobAttackBehavior(AttackBehavior mobAttackBehavior)
		{
		this.mobAttackBehavior = mobAttackBehavior;
		}
	public int getMaxHp()
		{
		return maxHp;
		}
	public void setMaxHp(int maxHp)
		{
		this.maxHp = maxHp;
		}
	public int getCurrentHp()
		{
		return currentHp;
		}
	public void setCurrentHp(int currentHp)
		{
		this.currentHp = currentHp;
		}
	public int getStr()
		{
		return str;
		}
	public void setStr(int str)
		{
		this.str = str;
		}
	public int getVit()
		{
		return vit;
		}
	public void setVit(int vit)
		{
		this.vit = vit;
		}
	public int getDxt()
		{
		return dxt;
		}
	public void setDxt(int dxt)
		{
		this.dxt = dxt;
		}
	public int getLuck()
		{
		return luck;
		}
	public void setLuck(int luck)
		{
		this.luck = luck;
		}
	public int performAttack(Mob a, Mob b)
		{
		return mobAttackBehavior.attack(a,b);
		}
	}
