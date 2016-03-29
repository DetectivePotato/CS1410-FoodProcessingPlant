

public abstract class Food {
	protected Machine currentMachine;

	public Food()
	{
		currentMachine = null;
	}
	public Machine getCurrentMachine()
	{
		return currentMachine;
	}

	public void setCurrentMachine(Machine m)
	{
		currentMachine = m;
	}
}
