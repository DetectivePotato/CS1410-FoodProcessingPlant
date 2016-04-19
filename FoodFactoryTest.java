import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Tests the functions of the FoodFactory class
 * 
 * @author Anthony Wall
 */
public class FoodFactoryTest 
{

	@Test
	public void testGenerate() 
	{
		//Set values so as to ensure only a SoupPowder is created
		FoodFactory.setSeed(100000000);
		FoodFactory.setQ(0.2);
		FoodFactory.setP(0);
		
		//Create a machine to prevent the generate method from throwing a NullPointerException
		new ProcessingMachine(20, "SoupPowder", 1);
		
		//Ensure no arbitrary Food objects in the system
		assertEquals(0, FoodList.getNum());
		
		//Run the generate method
		FoodFactory.generate();
		
		//Ensure that only one food item has been created
		assertEquals(1, FoodList.getNum());
		
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
