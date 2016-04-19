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
	//Define all the required simulation variables
	private static int NUM_PACKERS;
	private static int PACK_TIME;
	private static int NUM_STEPS;
	private static int PERISHABLE_TIME;
	private static int NONPERISHABLE_TIME;
	private static int STEP = 0;
	
	/**
	 * Reset the system to prevent feedback, format and initialise all the simulation variables, setup all the machines
	 * in the system, iterate the required step actions for the duration of the simulation and return the 
	 * financial report to the GUI
	 * 
	 * @param numSteps the total number of steps to run the simulation for
	 * 
	 * @param qProb the probability of creating a non-perishable item
	 * @param pProb the probability of creating a perishable item
	 * 
	 * @param packTime the time it takes for PackingMachines to act
	 * @param perishableTime the time it takes for perishable food ProcessingMachines to act
	 * @param nonPerishableTime the time it takes for non-perishable food ProcessingMachines to act
	 * 
	 * @param numPackers the number of PackingMachines in the system
	 * 
	 * @return the final financial report to the GUI
	 */
	public static String run(int numSteps, double qProb, double pProb, int packTime, int perishableTime, int nonPerishableTime, int numPackers)
	{
		//Reset the system
		reset();
		
		//Initialise all the simulation variables
		NUM_STEPS = numSteps;
		FoodFactory.setQ(qProb/100);
		FoodFactory.setP(pProb/100);
		PACK_TIME = packTime;
		NUM_PACKERS = numPackers;
		PERISHABLE_TIME = perishableTime;
		NONPERISHABLE_TIME = nonPerishableTime;
		
		//Create all the machines in the system
		setup();
		
		//Iterate the simulation
		while(STEP < NUM_STEPS)
		{
			oneStep();
			System.out.println(STEP);
			STEP++;
		}
		
		//Debug log
		System.out.println("Food in list at end: " + FoodList.getNum());
		
		//Return the financial report
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
	
	/**
	 * Resets everything in the system to allow for a fresh restart
	 */
	private static void reset()
	{
		MachineList.reset();
		FoodList.reset();
		ProfitStats.reset();	
		FoodFactory.reset();
		STEP = 0;
	}

}
