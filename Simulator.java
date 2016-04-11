import java.lang.StringBuilder;
/**
 * 
 * @author Steve Forrest
 * @author Sean Gladwish
 *
 *the Simulator class sets up the machines in the factory. it states what will happen at each step which is a second
 *and monitors parameters set by the GUI. The fields are
 */
public class Simulator {

	private static int numberOfPackers;
	private static int packingTime = 10;
	private static int perishableProcessorTime ;
	private static int nonePerishableProcessorTime;
	private static int num_Steps;
	private double p;
	private double q;

	/**
	 * 
	 * @param args arraay of command line arguments
	 */
	public static void main(String[] args){
		setup();
		int i = 0;
		while(i < num_Steps){
		singleStep();
		}
		i++;
		
		
	}
	/**
	 * This will allow the code to be set up so long as the number of steps does not exceed maximum number of allowed steps. 
	 */
	public void stop(){
		int b = 0;
		if(b > num_Steps)
		{

			b++;
		}
		else
			setup();

	}
	/**
	 * Setup method creates the machine taking the method from the machineFactory 
	 * class and parameters takien from the fields.
	 */
	private static void setup()
	{
		MachineFactory.generateMachines(packingTime, numberOfPackers);

		System.out.println(MachineList.printDetails());
	}
/**
 * will advance the simultion by one second nd use the according 
 * methods for instance ages food by one second.
 */
	private static void singleStep()
	{
		FoodList.ageFood();

		FoodFactory.generate();

		MachineList.activateMachines();
	}
	/**
	 * sets the Probability of p
	 * @param pProbs is the value of p's probability
	 */
	public void setPProbs(int pProbs)
	{

		p = pProbs;
		FoodFactory.setP(p);

	}
/**
 * 
 * sets the Probability of q
 * @param qProbs is the value of q's probability
 */
	public void setQProbs(int qProbs)
	{

		q = qProbs;
		FoodFactory.setQ(q);
	}
/**
 * sets the amount of processing mcines the food will go through before 
 * reaching the packing machine
 * @param newStages is number f stages the food passes throygh
 */
	public void setProcessingStages(int newStages){

		ProcessingMachine.setProcessingStages(newStages);

	}
	/**
	 * Sets the amont of packers
	 * @param newPackerNum
	 */
	public void setNumberOfPackers(int newPackerNum)
	{
		numberOfPackers = newPackerNum;
	}
	/**
	 * Prints details of statistics resultedd by the simulator
	 * @param sb
	 */
	private static void printProfits() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Items Lost: " + ProfitStats.getLost() + "\n");
		sb.append("Items Packed: " + ProfitStats.getPacked());
		System.out.println(sb.toString());
		
	}
/**
 * details the probability values of p and q
 */
	public void probsValue(){

		StringBuilder sb = new StringBuilder();
		
		sb.append("new P Value" + p + "\n");
		sb.append("New Q value" + q);
		
		
		System.out.println(sb.toString());
	}


/**
 *runs the Class 
 */
	static void Run()
	{
		while(num_Steps < 7200)
		{

			singleStep();
			num_Steps++;
		}

	}

}
