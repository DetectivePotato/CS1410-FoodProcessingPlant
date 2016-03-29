
public class MachineFactory 
{
	public static void generateMachines()
	{
		for(int s = 1; s <= Machine.getProcessingStages(); s++)
		{
			for(int i = 0; i < FoodList.getNumFoodTypes(); i++)
			{
				new ProcessingMachine(20, FoodList.getFoodType(i), s);
			}
		}
	}
}
