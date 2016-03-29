


public class ProcessingMachine extends Machine 
{
	private String foodType;
	private int stage;
	private int currentStage = 1;
	
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
		if(currentStage != PROCESSING_STAGES)
		{
			ProcessingMachine processor = MachineList.getNextProcessor(foodType, stage);
			
			processor.queueItem(outputFood);
			currentStage++;
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
}
