

import java.util.Random;

public class FoodFactory {

	private static double Q_PROBABILITY = 0.1;
	private static double P_PROBABILITY = 0.1;
	private static int SEED = 42;
	private static Random rnd = new Random(SEED);

	public static String generate()
	{ 
		double val = rnd.nextDouble();
		if(val <= Q_PROBABILITY)
		{
			//make item
			//return new SoupPowder();
			
			return "Made Non-Perishable";
		}
		
		if(val <= P_PROBABILITY)
		{
			//Make item
			//return new Cheese();
			return "Made Non-Perishable";
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

}
