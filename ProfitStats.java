/**
 * Handle everything to do with monitoring and calculating profits and printing a simple financial report
 * 
 * @author Anthony Wall
 */
public class ProfitStats 
{
	//The cost in pence of a packed and lost item
	private static final int PACKED_COST = 10;
	private static final int LOST_COST = 20;
	
	//Set up the counters for each type of item
	private static int LOST_ITEMS;
	private static int PACKED_ITEMS;
	
	/**
	 * Increase the packed counter by 1
	 */
	public static void addPacked()
	{
		PACKED_ITEMS++;
	}
	
	/**
	 * Increase the lost counter by 1
	 */
	public static void addLost()
	{
		LOST_ITEMS++;
	}
	
	/**
	 * Calculate the profit of the system in pounds and pence
	 * 
	 * @return the double profit of the system
	 */
	public static double profit()
	{
		//Calculate each component in pence
		double packed = PACKED_ITEMS * PACKED_COST;
		double lost = LOST_ITEMS * LOST_COST;
		
		//Convert the profit into pounds and pence
		return (packed - lost) / 100;
	}
	
	/**
	 * Return the current value of the packed counter
	 */
	public static int getPacked()
	{
		return PACKED_ITEMS; 
	}
	
	/**
	 * Return the current value of the lost counter
	 */
	public static int getLost()
	{
		return LOST_ITEMS;
	}
	
	/**
	 * Reset all the counters for a fresh restart
	 */
	public static void reset()
	{
		LOST_ITEMS = 0;
		PACKED_ITEMS = 0;
	}
	
	/**
	 * Format and return a basic financial report detailing the number of both packed and lost items and
	 * the final profit
	 * 
	 * @return the formatted financial report
	 */
	public static String printDetails()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Financial Statistics" + "\n");
		sb.append("--------------------" + "\n");
		sb.append("Lost Items: " + ProfitStats.getLost() + "\n");
		sb.append("Packed Items: " + ProfitStats.getPacked() + "\n");
		sb.append("Final Profit: £" + ProfitStats.profit() + "\n\n");
		
		return sb.toString();
	}
}
