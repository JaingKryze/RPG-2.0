
public class Location
	{
	String name;
	int lvl;
	int length;
	boolean position;
	public Location(String n, int lv, int ln, boolean p)
		{
		name = n;
		lvl = lv;
		length = ln;
		position = p;
		}
	
	public String getName()
		{
		return name;
		}
	public void setName(String name)
		{
		this.name = name;
		}
	public int getLvl()
		{
		return lvl;
		}
	public void setLvl(int lvl)
		{
		this.lvl = lvl;
		}
	public int getLength()
		{
		return length;
		}
	public void setLength(int length)
		{
		this.length = length;
		}
	public boolean isPosition()
		{
		return position;
		}
	public void setPosition(boolean position)
		{
		this.position = position;
		}
	}
