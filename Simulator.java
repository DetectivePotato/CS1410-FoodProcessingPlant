
public class Simulator 
{

	public static void main(String[] args) 
	{
		ProcessingMachine cheeseProcessor = new ProcessingMachine(20, "Cheese", 1);
		ProcessingMachine blueCheeseProcessor = new ProcessingMachine(20, "BlueCheese", 1);
		ProcessingMachine soupProcessor = new ProcessingMachine(22, "SoupPowder", 1);
		
		PackingMachine packer1 = new PackingMachine(10);
		PackingMachine packer2 = new PackingMachine(10);
		
		System.out.println("Total Machines: " + (MachineList.getNumberofPackers() + MachineList.getNumberofProcessors()) );
		System.out.println("    Total Packers:    " + MachineList.getNumberofPackers());
		System.out.println("    Total Processors: " + MachineList.getNumberofProcessors());

	}

}
