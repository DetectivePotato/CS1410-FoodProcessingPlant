

public abstract class Food {
	protected Machine currentMachine;
	private boolean perishable;

	public Food(boolean perishable)
	{
		currentMachine = null;
		this.perishable = perishable;
	}
	public Machine getCurrentMachine()
	{
		return currentMachine;
	}

	public void setCurrentMachine(Machine m)
	{
		currentMachine = m;
	}
	
	public boolean isPerishable()
	{
		return perishable;
	}
}
