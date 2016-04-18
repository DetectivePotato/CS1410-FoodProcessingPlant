import java.util.ArrayDeque;

/**
*	The Machine abstract class provides the key functions of all types of machines.
*	Machine offers the ability to incorporate jamming/repairing aswell as queueing and processing of objects
*
*	@author Anthony Wall
*	@version 0.3 (01/04/2016)
*/

public abstract class Machine 
{	
	protected int machineTime;
	protected static final int REPAIR_TIME = 60;
	protected int timeCounter;
	protected ArrayDeque<Food> queue;
	protected Food currentItem;
	protected boolean jammed;
	
	/**
	*	Constructor for all Machine objects	
	*	@param newTime the time it takes to perform the machine's action in seconds
	*/
	public Machine(int newTime)
	{
		this.machineTime = newTime;
		timeCounter = 1;
		queue = new ArrayDeque<Food>();
		currentItem = null;
		jammed = false;
	}
	
	/**
	*	Performs the basic actions, here the action is simply storing an object for the required time
	*	Jamming is also incoporated using a shared counter to elapse time
	*
	*/
	public void act()
	{
		//Check if the machine is jammed
		if(isJammed())
		{
			//The machine has been repaired when the required time has elapsed
			if(timeCounter == REPAIR_TIME)
			{
				jammed = false;
				
			}
			else
			{
				timeCounter++;
			}
		}
		else
		{
			//Check if there is an object being processed, if not check if one is avaliable in the queue
			if(queue.size() > 0 && currentItem == null)
			{
				//Get the first object in the queue
				currentItem = queue.removeFirst();
				timeCounter = 1;
			}
			//Nothing is available to act upon so simply idle
			else if(queue.size() == 0 && currentItem == null || currentItem == null)
			{
				//Do nothing
			}
			//Action has finished
			else if(timeCounter == this.machineTime)
			{
				output(currentItem);
				//Clear the machine for the next object
				currentItem = null;
			}
			//Else continue the action and increment the timer
			else
			{
				timeCounter++;
			}
		}
	}
	
	/**
	*	Jam the machine whilst removing the current object, tracking the loss and resetting the timer
	*/
	public void jamMachine()
	{
		jammed = true;
		timeCounter = 1;
		currentItem = null;
		ProfitStats.addLost();
	}
	
	/**
	*	Remove an object from the Machine 
	*/
	public void remove(Food food)
	{
		currentItem = null;
	}
	
	/**
	*	Check if a Machine's queue contains a certain object
	*	@param food The object to search for
	*/
	public boolean contains(Food food)
	{
		return queue.contains(food);
	}
	
	/**
	*	Return the size of the queue
	*/
	public int getQueueSize()
	{
		return queue.size();
	}
	
	/**
	*	Return the machine's action time
	*/
	public int getMachineTime()
	{
		return machineTime;
	}
	
	/**
	*	Return the current time of the machine's counter
	*/
	public int getCounter()
	{
		return timeCounter;
	}
	
	/**
	*	Return if the machine is jammed
	*/
	public boolean isJammed()
	{
		return jammed;
	}
	
	public abstract boolean queueItem(Food newFood);
	
	public abstract void output(Food outputItem);
}
