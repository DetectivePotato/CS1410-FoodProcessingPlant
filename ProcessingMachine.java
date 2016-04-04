

/**
 * ProcessingMachine extends Machine implementing multiple stages of processing/
 * It also includes type checked queueing and dynamic outputs
 * 
 * @author Anthony
 */
public class ProcessingMachine extends Machine 
{
	private String foodType;
	private int stage;
	static int PROCESSING_STAGES = 1;
	
	public ProcessingMachine(int processingTime, String foodType, int newStage)
	{
		super(processingTime);
		this.foodType = foodType;
		stage = newStage;
		
		MachineList.addProcessor(this);
	}
	
	public ProcessingMachine(int processingTime, String foodType, int newStage, int numStages)
	{
		this(processingTime, foodType, newStage);
		PROCESSING_STAGES = numStages;
	}
	
	public boolean queueItem(Food newFood)
	{
		if(newFood.getClass().getName().equals(foodType))
		{
			queue.add(newFood);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void output(Food outputFood)
	{
		if(stage != PROCESSING_STAGES)
		{
			ProcessingMachine processor = MachineList.getNextProcessor(foodType, stage);
			
			processor.queueItem(outputFood);
		}
		else
		{
			PackingMachine packer = MachineList.getBestPacker();

			packer.queueItem(outputFood);
		}
	}
	
	public String getFoodType()
	{
		return foodType;
	}
	
	public int getStage()
	{
		return stage;
	}
	
	/**
	*	Change the current number of processing stages in the system
	*	@param newStages the new number of procesing stages
	*/
	public void setProcessingStages(int newStages)
	{
		PROCESSING_STAGES = newStages;
	}

	/**
	*	Return the number of processing stages in the system
	*/
	public static int getProcessingStages()
	{
		return PROCESSING_STAGES;
	}
}
