import java.util.Random;
/**
 * FoodFactory handles the random generation of food at each step
 * and assigning it to the correct machines in the system
 * 
 * @author Steve Forrest
 * @author Anthony Wall
 *
 */
public class FoodFactory {
	//Probability of creating a non-perishable item
	private static double Q_PROBABILITY = 0.05;
	//Probability of creating a perishable item
	private static double P_PROBABILITY = 0.02;
	//The seed value to be used in the Random number generator
	private static int SEED = 999999999;
	//The random number generator
	private static Random rnd = new Random(SEED);

	/**
	 * Generates Food objects based on the random number generator
	 * and puts them in the correct processing machine
	 * 
	 * @return
	 */
	public static void generate()
	{ 
		//Generate the random number
		double val = rnd.nextDouble();
		
		//Check if a non-perishable object is to be made
		if(val <= Q_PROBABILITY)
		{
			//Store the processing machine that the Food object will be queued in
			ProcessingMachine processor = MachineList.getNextProcessor("SoupPowder", 0);
			
			//Create the food object and then queue it
			processor.queueItem(new SoupPowder(processor));
			
			//Console log
			System.out.println("Made Non-Perishable");
		}
		//Check if a perishable object is to be made
		if(val <= P_PROBABILITY)
		{
			ProcessingMachine processorCheese = MachineList.getNextProcessor("Cheese", 0);
			ProcessingMachine processorBCheese = MachineList.getNextProcessor("BlueCheese", 0);
			
			processorCheese.queueItem(new BlueCheese(processorCheese));
			processorBCheese.queueItem(new BlueCheese(processorBCheese));
			
			System.out.println("Made Perishables");
		}
	}
	/**
	 * Set the probability of a non-perishable item being made
	 * 
	 * @param newVal the new probability
	 */
	public static void setQ(double newVal)
	{
		Q_PROBABILITY = newVal;
	}

	/**
	 * Set the probability of a perishable item being made
	 * 
	 * @param newVal the new probability
	 */
	public static void setP(double newVal)
	{
		P_PROBABILITY = newVal;
	}
	/**
	 * Set the seed to be used for the random number generator
	 * 
	 * @param seed the new seed value
	 */
	public static void setSeed(int seed)
	{
		SEED = seed;
		rnd.setSeed(SEED);
	}
	/**
	 * Return the probability of making a non-perishable item
	 */
	public static double getQ()
	{
		return Q_PROBABILITY;
	}

	/**
	 * Return the probability of making a perishable item
	 */
	public static double getP()
	{
		return P_PROBABILITY;
	}
	
	/**
	 * Return the currently used seed
	 */
	public static int getSeed()
	{
		return SEED;
	}
	
	/**
	 * Reset the random number generator
	 */
	public static void reset()
	{
		rnd = new Random(SEED);
	}

}
