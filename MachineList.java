import java.util.ArrayList;
import java.util.Iterator;
/**
 * MachineList keeps track of all <code>Machine</code> objects in the system
 * It also provides methods to find the most optimal packer and next processor
 * 
 * @author Anthony Wall
 */
public class MachineList 
{
	//The two ArrayLists used to store the two types of machines in the system
	private static ArrayList<ProcessingMachine> PROCESSORS = new ArrayList<ProcessingMachine>();
	private static ArrayList<PackingMachine> PACKERS = new ArrayList<PackingMachine>();
	
	/**
	 * Add a new processor to the respective list
	 * 
	 * @param newProcessor the processor to add to the list
	 */
	public static void addProcessor(ProcessingMachine newProcessor)
	{
		if(newProcessor != null)
		{
			PROCESSORS.add(newProcessor);
		}
	}
	/**
	 * Add a new packer to the respective list
	 * 
	 * @param newPacker the packer to add to the list
	 */
	public static void addPacker(PackingMachine newPacker)
	{
		if(newPacker != null)
		{
			PACKERS.add(newPacker);
		}
	}
	
	/**
	 * Returns the next machine in the processing stage (or null if it is the final stage)
	 * 
	 * @param foodType the type of food being handled
	 * @param currentStage the current stage of processing
	 */
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
	
	/**
	 * Returns the packer with the shortest queue
	 */
	public static PackingMachine getBestPacker()
	{
		//Begin with the first packer in the list
		PackingMachine bestPacker = PACKERS.get(0);
		
		//Iterate through to see if any packers have a shorter queue
		for(PackingMachine testPacker : PACKERS)
		{
			if(testPacker.getQueueSize() < bestPacker.getQueueSize())
			{
				bestPacker = testPacker;
			}
		}
		
		return bestPacker;
	}
	
	/**
	 * Iterate through all the machines in the system and invoke their act methods
	 */
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
	
	/**
	 * Returns the number of Processing Machines in the system
	 */
	public static int getNumberofProcessors()
	{
		return PROCESSORS.size();
	}
	
	/**
	 * Returns the number of Packing Machines in the system
	 */
	public static int getNumberofPackers()
	{
		return PACKERS.size();
	}
	
	/**
	 * Returns a string detailing the machines in the system
	 */
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
	
	/**
	 * Reset and "delete" all machines currently in the system for a fresh restart
	 */
	public static void reset()
	{
		Iterator<ProcessingMachine> iterProc = PROCESSORS.iterator();
		
		while(iterProc.hasNext())
		{
			ProcessingMachine proc = iterProc.next();
			iterProc.remove();
			proc = null;
		}
		
		Iterator<PackingMachine> iterPack = PACKERS.iterator();
		
		while(iterPack.hasNext())
		{
			PackingMachine pack = iterPack.next();
			iterPack.remove();
			pack = null;
		}
	}
}
