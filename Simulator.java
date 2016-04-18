/**
 * The simulator handles all actions in the system
 * - Create all the machines in the plant
 * - Generate food each step
 * - Increment age and act on machines each step
 * 
 * @author Steve Forrest
 * @author Anthony Wall
 *
 */
public class Simulator 
{
	private static int NUM_PACKERS = 2;
	private static int PACK_TIME;
	private static int NUM_STEPS;
	private static int PERISHABLE_TIME;
	private static int NONPERISHABLE_TIME;
	private static int STEP = 0;
	
	public static String run(int numSteps, double qProb, double pProb, int packTime, int perishableTime, int nonPerishableTime, int numPackers)
	{
		reset();
		
		NUM_STEPS = numSteps;
		FoodFactory.setQ(qProb/100);
		FoodFactory.setP(pProb/100);
		PACK_TIME = packTime;
		NUM_PACKERS = numPackers;
		PERISHABLE_TIME = perishableTime;
		NONPERISHABLE_TIME = nonPerishableTime;
		
		setup();
		
		while(STEP < NUM_STEPS)
		{
			oneStep();
			System.out.println(STEP);
			STEP++;
		}
		
		System.out.println("Food in list at end: " + FoodList.getNum());
		return ProfitStats.printDetails();

	}
	
	/**
	 * Creates all the machines required in the system
	 */
	private static void setup()
	{
		MachineFactory.generateMachines(PERISHABLE_TIME, NONPERISHABLE_TIME, PACK_TIME, NUM_PACKERS);
		
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
	
	private static void reset()
	{
		MachineList.reset();
		FoodList.reset();
		ProfitStats.reset();	
		FoodFactory.reset();
		STEP = 0;
	}

}
