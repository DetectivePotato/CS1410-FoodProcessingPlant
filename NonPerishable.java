/**
 * The Nonperishable class is a sub class of food but is still a super class itself
 * It is used to create Nonperishable Food objects
 * @author Sean Gladwish
 *
 */
public class NonPerishable extends Food{

	/**
	 * Constructor For New Nonperishable Food objects
	 * 
	 * @param startingMachine The machine that the food starts in
	 */
	public NonPerishable(Machine startingMachine)
	{
		super(false, startingMachine);
	}
}
