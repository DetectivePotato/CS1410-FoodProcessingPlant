/**
 * This is the a Perishable Food object
 * @author Sean Gladwish
 *
 */
public class Cheese extends Perishable {

	//The time it takes to spoil
	private static final int SPOIL_TIME = 45;
	
	/**
	 * Constructor that calls all its inputs from the above super class Perishable
	 * 
	 * @param startingMachine the machine to place the Food object in
	 */
	public Cheese(Machine startingMachine)
	{
		super(SPOIL_TIME, startingMachine);

	}
}
