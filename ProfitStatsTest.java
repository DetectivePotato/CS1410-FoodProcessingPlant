import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
/**
 * Test the arithmatic functions of the ProfitStats class
 * 
 * @author Anthony wall
 */
public class ProfitStatsTest {

	@BeforeClass
	public static void setUp()
	{
		for(int i = 0; i < 23; i++)
		{
			ProfitStats.addPacked();
		}
		
		for (int y = 0; y < 5; y++)
		{
			ProfitStats.addLost();
		}
	}
	
	@Test
	public void testProfit() 
	{		
		assertEquals(1.30, ProfitStats.profit(), 0.0001);
		
		ProfitStats.reset();
	}
	
}
