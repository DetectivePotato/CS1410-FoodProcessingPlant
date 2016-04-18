
/**
 * PackingMachine extends the Machine class implementing simple queue and output methods
 * 
 * @author Anthony Wall
 */

public class PackingMachine extends Machine 
{
	
	public PackingMachine(int packingTime)
	{
		super(packingTime);
		
		MachineList.addPacker(this);
	}
	
	public boolean queueItem(Food newFood)
	{
		queue.add(newFood);
		return true;
	}
	public void output(Food outputFood)
	{
		FoodList.packFood(outputFood);
	}
}
