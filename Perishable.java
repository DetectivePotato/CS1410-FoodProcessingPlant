

public class Perishable extends Food{
	protected int age;
	protected boolean spoiled;
	protected int spoilTime;

	public Perishable(int spoilTime)
	{
		super(true);
		age = 0;
		spoiled = false;
		this.spoilTime = spoilTime;
	}
	public boolean isSpoiled()
	{
		return spoiled;
	}

	public void spoil()
	{
		spoiled = true;
		FoodList.spoilFood(this);
	}
	
	public void incrementAge()
	{
		age += 1;
		if(age >= spoilTime)
		{
		spoil();
		}
	}
	public void setSpoilTime(int time)
	{
		spoilTime = time;
	}
}
