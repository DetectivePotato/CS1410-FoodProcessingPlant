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

	private static double Q_PROBABILITY = 0.05;
	private static double P_PROBABILITY = 0.02;
	private static int SEED = 999999999;
	private static Random rnd = new Random(SEED);

	/**
	 * Generates Food objects based on the random number generator
	 * and puts them in the correct processing machine
	 * 
	 * @return
	 */
	public static String generate()
	{ 
		//Generate the random number
		double val = rnd.nextDouble();
		
		//Check if a non-perishable object is to be made
		if(val <= Q_PROBABILITY)
		{
			ProcessingMachine processor = MachineList.getNextProcessor("SoupPowder", 0);
			
			processor.queueItem(new SoupPowder(processor));
			System.out.println("Made Non-Perishable");
		}
		
		if(val <= P_PROBABILITY)
		{
			ProcessingMachine processorCheese = MachineList.getNextProcessor("Cheese", 0);
			ProcessingMachine processorBCheese = MachineList.getNextProcessor("BlueCheese", 0);
			
			processorCheese.queueItem(new BlueCheese(processorCheese));
			processorBCheese.queueItem(new BlueCheese(processorBCheese));
			
			System.out.println("Made Perishables");
		}
		
		return "" + val;
	}

	public static void setQ(double newVal)
	{
		Q_PROBABILITY = newVal;
	}

	public static void setP(double newVal)
	{
		P_PROBABILITY = newVal;
	}

	public static void setSeed(int seed)
	{
		SEED = seed;
		rnd.setSeed(SEED);
	}
	
	public static double getQ()
	{
		return Q_PROBABILITY;
	}
	
	public static double getP()
	{
		return P_PROBABILITY;
	}
	
	public static int getSeed()
	{
		return SEED;
	}
	public static void reset()
	{
		rnd = new Random(SEED);
	}

}
