import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MachineTest 
{
	private static ProcessingMachine processor;
	private static PackingMachine packer;
	
	private static Cheese cheese1;
	
	@Before
	public void setUp() throws Exception 
	{
		packer = new PackingMachine(3);
		processor = new ProcessingMachine(2, "Cheese", 1);
		
		cheese1 = new Cheese(40);
	}

	@Test
	public void testQueing() 
	{
		processor.queueItem(cheese1);
		packer.queueItem(cheese1);
		
		assertTrue(processor.contains(cheese1));
	}
	
	@Test
	public void testOutput()
	{
		processor.queueItem(cheese1);
		
		System.out.println("Processor Queue Size: " + processor.getQueueSize());
		
		for(int i = 0; i < 3; i++)
		{
			processor.act();
			System.out.println("Time Count: " + processor.getCounter());
		}
		
		System.out.println("Packer Queue Size: " + packer.getQueueSize());
		System.out.println("Processor Queue Size: " + processor.getQueueSize());
		assertTrue(packer.contains(cheese1));
		
		for(int y = 0; y < 4; y++)
		{
			packer.act();
		}
		
		assertEquals(0.1, ProfitStats.profit(), 0.001);
	}
	
	@After
	public void tearDown()
	{
		packer = null;
		processor = null;
		cheese1 = null;
	}
}
