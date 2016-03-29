import java.util.ArrayDeque;

public abstract class Machine 
{	
	protected int machineTime;
	protected static final int REPAIR_TIME = 60;
	protected static int PROCESSING_STAGES = 1;
	protected int timeCounter;
	protected ArrayDeque<Food> queue;
	protected Food currentItem;
	protected boolean jammed;
	
	public Machine(int newTime)
	{
		this.machineTime = newTime;
		timeCounter = 0;
		queue = new ArrayDeque<Food>();
		currentItem = null;
	}
	
	public void act()
	{
		if(isJammed())
		{
			if(timeCounter == REPAIR_TIME)
			{
				//TO-DO: Move to Jam Method
				currentItem = null;
				ProfitStats.addLost();
			}
			else
			{
				timeCounter++;
			}
		}
		else
		{
			if(queue.size() > 0 && currentItem == null)
			{
				currentItem = queue.removeFirst();
				timeCounter = 1;
			}
			else if(timeCounter == this.machineTime)
			{
				output(currentItem);
				currentItem = null;
			}
			else
			{
				timeCounter++;
			}
		}
	}
	
	public void jamMachine()
	{
		jammed = true;
		timeCounter = 0;
	}
	
	public void remove(Food food)
	{
		currentItem = null;
	}
	
	public boolean contains(Food food)
	{
		return queue.contains(food);
	}
	
	public int getQueueSize()
	{
		return queue.size();
	}
	
	public int getMachineTime()
	{
		return machineTime;
	}
	public int getCounter()
	{
		return timeCounter;
	}
	
	public boolean isJammed()
	{
		return jammed;
	}
	public void setProcessingStages(int newStages)
	{
		PROCESSING_STAGES = newStages;
	}
	
	public abstract boolean queueItem(Food newFood);
	
	public abstract void output(Food outputItem);
}
