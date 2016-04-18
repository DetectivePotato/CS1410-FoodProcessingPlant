/**
 * The Perishable class is a sub class of food but is still a super class itself
 * It is used to hold the methods required for the creation and spoilage of the Perishable Food objects
 * @author Sean Gladwish
 *
 */
public class Perishable extends Food{
	protected int age;
	protected boolean spoiled;
	protected int spoilTime;

	/**
	 * Constructor for all Perishable Food objects
	 * @param spoilTime is the time steps unit a Food objects spoils
	 * @param startingMachine the machine that the Food object starts in
	 */
	public Perishable(int spoilTime, Machine startingMachine)
	{
		super(true, startingMachine);
		age = 0;
		spoiled = false;
		this.spoilTime = spoilTime;
	}
	
	/**
	 * This method checks if the Perishable Food object has spoiled 
	 * @return this will return false until the Food object spoils
	 */
	public boolean isSpoiled()
	{
		return spoiled;
	}

	/**
	 *This method is for removing spoiled Perishable Food objects 
	 */
	public void spoil()
	{
		spoiled = true;
		FoodList.spoilFood(this);
	}
	
	/**
	 * This is the method for aging the Perishable Food objects until it spoils
	 */
	public void incrementAge()
	{
		age += 1;
		if(age >= spoilTime)
		{
		spoil();
		}
	}
	
	/**
	 * This method is for changing the spoil time of Perishable Food objects
	 * @param time is the new spoil time that is inputed
	 */
	public void setSpoilTime(int time)
	{
		spoilTime = time;
	}
}
