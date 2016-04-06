import java.util.ArrayList;

public class MachineList 
{
	private static ArrayList<ProcessingMachine> PROCESSORS = new ArrayList<ProcessingMachine>();
	private static ArrayList<PackingMachine> PACKERS = new ArrayList<PackingMachine>();
	
	public static void addProcessor(ProcessingMachine newProcessor)
	{
		if(newProcessor != null)
		{
			PROCESSORS.add(newProcessor);
		}
	}
	
	public static void addPacker(PackingMachine newPacker)
	{
		if(newPacker != null)
		{
			PACKERS.add(newPacker);
		}
	}
	
	public static ProcessingMachine getNextProcessor(String foodType, int currentStage)
	{
		for(ProcessingMachine processor : PROCESSORS)
		{
			if(processor.getFoodType().equals(foodType) && processor.getStage() == (currentStage + 1))
			{
				return processor;
			}
		}
		
		return null;
	}
	
	public static PackingMachine getBestPacker()
	{
		PackingMachine bestPacker = PACKERS.get(0);
		
		for(PackingMachine testPacker : PACKERS)
		{
			if(testPacker.getQueueSize() < bestPacker.getQueueSize())
			{
				bestPacker = testPacker;
			}
		}
		
		return bestPacker;
	}
	
	public static void activateMachines()
	{
		for(ProcessingMachine processor : PROCESSORS)
		{
			processor.act();
		}
		
		for(PackingMachine packer : PACKERS)
		{
			packer.act();
		}
	}
	
	public static int getNumberofProcessors()
	{
		return PROCESSORS.size();
	}
	
	public static int getNumberofPackers()
	{
		return PACKERS.size();
	}
	
	public static String printDetails()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Machines\n");
		sb.append("\nProcessors: ");
		sb.append(getNumberofProcessors());
		sb.append("\nPackers:    ");
		sb.append(getNumberofPackers());
		
		return sb.toString();
	}
}
