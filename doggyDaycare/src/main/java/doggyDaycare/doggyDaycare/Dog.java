package doggyDaycare.doggyDaycare;

public class Dog 
{
	private long id;
	private String name;
	private int lastVisit;
	
	public Dog(String name)
	{
		this.name = name;
		this.lastVisit = 0;
	}
	
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getLastVisit()
	{
		return lastVisit;
	}
	public void setLastVisit(int lastVisit)
	{
		this.lastVisit = lastVisit;
	}
}
