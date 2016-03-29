import static org.junit.Assert.*;

import org.junit.Test;

public class FoodFactoryTest 
{

	@Test
	public void testGenerate() 
	{
		FoodFactory.setSeed(100000000);
		FoodFactory.setQ(0.2);
		assertEquals("Made Non-Perishable", FoodFactory.generate());
		
	}

	@Test
	public void testSetQ() 
	{
		FoodFactory.setQ(0.2);
		assertEquals(0.2, FoodFactory.getQ(), 0.001);
	}

	@Test
	public void testSetP() 
	{
		FoodFactory.setP(0.4);
		assertEquals(0.4, FoodFactory.getP(), 0.001);
	}

	@Test
	public void testSetSeed() 
	{
		FoodFactory.setSeed(100);
		assertEquals(100, FoodFactory.getSeed());
	}

}
