

/**
 * MachineFactory serves to generate all the machines required in the system.
 * 
 * @author Anthony Wall
 */
public class MachineFactory 
{
	
	public static void generateMachines(int perishableTime, int nonPerishableTime, int packTime, int numPackers)
	{
		//Find out how many processing stages are being used
		int stages = getProcessingStages();
		//Create a set of machines for the required amount of stages
		for(int s = 1; s <= stages; s++)
		{
			//Create one machine per food type
			for(int i = 0; i < FoodList.getNumFoodTypes(); i++)
			{
				//Create a machine based off the food type
				makeProcessor(FoodList.getFoodType(i), s, perishableTime, nonPerishableTime);
				
			}
		}
		
		//Generate the specified number of packers
		for(int y = 0; y<numPackers; y++)
		{
			new PackingMachine(packTime);
		}
	}
	
	/**
	 * Return the number of processing stages in the system
	 */
	private static int getProcessingStages()
	{
		return ProcessingMachine.getProcessingStages();
	}

	/**
	 * Generate a processing machine based on the type of food provided
	 * 
	 * @param type The type of food
	 * @param stage The processing stage this machine will occupy
	 */
	private static void makeProcessor(String type, int stage, int perishableTime, int nonPerishableTime)
	{
		//Default time
		int processTime = 20;

		switch(type)
		{
			case "Cheese":
				processTime = perishableTime;
				break;

			case "BlueCheese":
				processTime = perishableTime;
				break;

			case "SoupPowder":
				processTime = nonPerishableTime;
				break;
		}

		new ProcessingMachine(processTime, type, stage);

	}
}
