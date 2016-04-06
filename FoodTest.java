

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodTest {
	private Cheese c;
	private Bluecheese bc;

	@Before
	public void setup()
	{
		c = new Cheese(40);
		bc = new Bluecheese(45);
	}

	@Test
	public void testIncretmentAge(){
		assertFalse(c.isSpoiled());
		for(int i = 0; i<50; i++)
		{
			if(c == null)
				break;
			else
				FoodList.ageFood();
		}
		assertNull(c);
		assertNotNull(bc);
	}
	@Test
	public void testGetCurrentMachine()
	{
		assertEquals(c.getCurrentMachine(), null);

	}
}
