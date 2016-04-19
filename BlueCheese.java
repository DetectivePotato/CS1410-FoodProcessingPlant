/**
 * A subclass of perishable, representing Blue Cheese in the system
 * @author Sean Gladwish
 *
 */
public class BlueCheese extends Perishable{

	//The time it takes to spoil
	private static final int SPOIL_TIME = 40;
	
	/**
	 * Constructor that calls all its inputs from the above super class Perishable
	 * 
	 * @param startingMachine the machine to place the Food object in
	 */
	public BlueCheese(Machine startingMachine)
	{
		super(SPOIL_TIME, startingMachine);
	}

	
}
