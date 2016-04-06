/**
 * The simluator handles all actions in the system
 * - Create all the machines in the plant
 * - Generate food each step
 * - Increment age and act on machines each step
 * 
 * @author Anthony Wall
 *
 */
public class Simulator 
{
	private static int NUM_PACKERS = 2;
	private static int PACK_TIME = 20;
	private static int NUM_STEPS;
	
	public static void main(String[] args) 
	{
		try
		{
			NUM_STEPS = Integer.parseInt(args[0]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setup();

	}
	/**
	 * Creates all the machines required in the system
	 */
	private static void setup()
	{
		MachineFactory.generateMachines(PACK_TIME, NUM_PACKERS);
		
		System.out.println(MachineList.printDetails());
	}
	
	/**
	 * Perform all the required actions for simulation over a single step
	 */
	private static void oneStep()
	{
		//Increment the age of all food and perform spoil checking
		FoodList.ageFood();
		
		//Create a new food object randomly
		FoodFactory.generate();
		
		//Tell all machines to act
		MachineList.activateMachines();
	}

}
