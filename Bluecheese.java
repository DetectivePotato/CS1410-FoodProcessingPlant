

public class Bluecheese extends Perishable{
	private static int spoilTime = 40;

	public Bluecheese()
	{
		super();
	}

	public void incrementAge()
	{
		age +=1;
		if(age > spoilTime)
		{
		//FoodList.dispose((Food) this);
		spoiled = true;	
		}
	}
	public void setSpoilTime(int time)
	{
		spoilTime = time;
	}
}
