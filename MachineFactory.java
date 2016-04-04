

/**
 * MachineFactory serves to generate all the machines required in the system.
 * 
 * @author Anthony Wall
 */
public class MachineFactory 
{
	private static int CHEESE_TIME = 20;
	private static int BLUECHESE_TIME = 20;
	private static int SOUP_TIME = 22;


	public static void generateMachines(int packTime, int numPackers)
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
				makeProcessor(FoodList.getFoodType(i), s);
				
			}
		}
		
		//Generate the specified number of packers
		for(int y = 0; y<numPackers; y++)
		{
			new PackingMachine(packTime);
		}
	}
	
	//Return the number of processing stages in the system
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
	private static void makeProcessor(String type, int stage)
	{
		//Default time
		int processTime = 20;

		switch(type)
		{
			case "Cheese":
				processTime = CHEESE_TIME;
				break;

			case "BlueCheese":
				processTime = BLUECHESE_TIME;
				break;

			case "SoupPowder":
				processTime = SOUP_TIME;
				break;
		}

		new ProcessingMachine(processTime, type, stage);

	}
}
