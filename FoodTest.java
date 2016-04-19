import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Test the creation of Food objects and the perishable specific aging methods
 * 
 * @author Anthony Wall
 */
public class FoodTest {
	private Cheese c;
	private ProcessingMachine mac;

	@Before
	public void setup()
	{
		mac = new ProcessingMachine(50, "Cheese", 1);
		c = new Cheese(mac);
		
		mac.queueItem(c);
	}

	@Test
	public void testIncretmentAge(){
		//Prevent a false positive
		assertFalse(c.isSpoiled());
		//Ensure that the Cheese object is present in the Food List
		assertEquals(FoodList.getNum(), 1);
		
		//Iterate through until the food is spoiled
		for(int i = 0; i<45; i++)
		{
			if(c == null)
				break;
			else
				FoodList.ageFood();
		}
		
		//Ensure that the food item has been removed
		assertEquals(FoodList.getNum(), 0);
	}
	@Test
	public void testGetCurrentMachine()
	{
		assertEquals(c.getCurrentMachine(), mac);

	}
}
