

public class Cheese extends Perishable {
	private static int spoilTime = 45;

	public Cheese()
	{
		super();

	}

	public void incrementAge()
	{
		age +=1;
		if(age > spoilTime)
		{
			spoiled = true;
			//FoodList.dispose((Food) this);
		}
	}
public void setSpoilTime(int time)
{
	spoilTime = time;
}



}
