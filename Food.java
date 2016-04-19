/**
 * The Food class is the top class of the food item Hierarchy
 * For holding the methods required to create different kinds of foods
 * @author Sean Gladwish
 *
 */
public abstract class Food {
	protected Machine currentMachine;
	private boolean perishable;

	
	/**
	 * Constructor for new Food objects
	 * 
	 * @param perishable is to see if the food is perishable or nonperishable
	 * @param startingMachine the machine to place the Food object in
	 */
	public Food(boolean perishable, Machine startingMachine)
	{
		currentMachine = startingMachine;
		this.perishable = perishable;
		FoodList.addFood(this);
	}
	
	/**
	 * This method is for getting the current machine of Food objects
	 * @return it returns the current machine of the Food objects
	 */
	public Machine getCurrentMachine()
	{
		return currentMachine;
	}

	/**
	 * This method is used to change the machine a Food object is currently in
	 * @param m is the new machine to be assigned
	 */
	public void setCurrentMachine(Machine m)
	{
		currentMachine = m;
	}
	
	/**
	 * This performs a check on the food objects to determine if the Food object is Perishable or not
	 * @return if the food is Perishable or Nonperishable
	 */
	public boolean isPerishable()
	{
		return perishable;
	}
}
