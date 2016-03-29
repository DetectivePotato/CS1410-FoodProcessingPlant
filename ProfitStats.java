
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
	
	public static float profit()
	{
		float packed = PACKED_ITEMS * PACKED_COST;
		float lost = LOST_ITEMS * LOST_COST;
		
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
	
}
