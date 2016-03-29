

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodTest {
	private Cheese c;
	private Bluecheese bc;

	@Before
	public void setup()
	{
		c = new Cheese();
		bc = new Bluecheese();
	}

	@Test
	public void testIncretmentAge(){
		assertFalse(c.isSpoiled());
		for(int i = 0; i<50; i++){
			if(c == null)
				break;
			c.incrementAge();
		}
		assertTrue(c.isSpoiled());

		assertFalse(bc.isSpoiled());
		for(int i = 0; i<50; i++){
			bc.incrementAge();
		}
		assertTrue(bc.isSpoiled());
	}
	@Test
	public void testGetCurrentMachine()
	{
		assertEquals(c.getCurrentMachine(), null);

	}
}
