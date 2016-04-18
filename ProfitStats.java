
public class ProfitStats 
{
	private static final int PACKED_COST = 10;
	private static final int LOST_COST = 20;
	
	private static int LOST_ITEMS;
	private static int PACKED_ITEMS;
	
	public static void addPacked()
	{
		PACKED_ITEMS++;
	}
	
	public static void addLost()
	{
		LOST_ITEMS++;
	}
	
	public static double profit()
	{
		double packed = PACKED_ITEMS * PACKED_COST;
		double lost = LOST_ITEMS * LOST_COST;
		
		return (packed - lost) / 100;
	}
	
	public static int getPacked()
	{
		return PACKED_ITEMS; 
	}
	public static int getLost()
	{
		return LOST_ITEMS;
	}
	
	public static void reset()
	{
		LOST_ITEMS = 0;
		PACKED_ITEMS = 0;
	}
	
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
