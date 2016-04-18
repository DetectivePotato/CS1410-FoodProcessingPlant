

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodTest {
	private Cheese c;
	//private Bluecheese bc;
	private ProcessingMachine mac;
	private ProcessingMachine mac2;

	@Before
	public void setup()
	{
		mac = new ProcessingMachine(50, "Cheese", 1);
		c = new Cheese(mac);
		//mac2 = new ProcessingMachine(50, "BlueCheese", 1);
		//bc = new Bluecheese(mac2);
		
		mac.queueItem(c);
		c.setCurrentMachine(mac);
		
		//mac2.queueItem(bc);
		//bc.setCurrentMachine(mac2);
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
		//assertNotNull(bc);
	}
	@Test
	public void testGetCurrentMachine()
	{
		assertEquals(c.getCurrentMachine(), mac);

	}
}
