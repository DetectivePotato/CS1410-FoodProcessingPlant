

public class Perishable extends Food{
	protected int age;
	protected boolean spoiled;

	public Perishable()
	{
		super();
		age = 0;
		spoiled = false;
	}
	public boolean isSpoiled()
	{
		return spoiled;
	}
}
