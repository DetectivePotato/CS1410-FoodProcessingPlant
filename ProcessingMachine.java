/**
 * ProcessingMachine extends Machine implementing multiple stages of processing/
 * It also includes type checked queueing and dynamic outputs
 * 
 * @author Anthony Wall
 */
public class ProcessingMachine extends Machine 
{
	private String foodType;
	private int stage;
	static int PROCESSING_STAGES = 1;
	
	/**
	 * Construct a new ProcessingMachine
	 * 
	 * @param processingTime the time it takes for this machine to process an item
	 * @param foodType the only type of food this machine will accept
	 * @param newStage the stage that this machine will occupy
	 */
	public ProcessingMachine(int processingTime, String foodType, int newStage)
	{
		super(processingTime);
		this.foodType = foodType;
		stage = newStage;
		
		MachineList.addProcessor(this);
	}
	
	/**
	 * Ensure that only Food objects of the relevant type can be queued
	 */
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
	
	/**
	 * Outputs the Food object after processing either to the next processing stage or the best PackingMachine
	 */
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
			outputFood.setCurrentMachine(packer);
		}
	}
	
	/**
	 * Return the type of Food this machine accepts
	 */
	public String getFoodType()
	{
		return foodType;
	}
	
	/**
	 * Return the stage this machine occupies
	 */
	public int getStage()
	{
		return stage;
	}
	
	/**
	*	Change the current number of processing stages in the system
	*	@param newStages the new number of processing stages
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
