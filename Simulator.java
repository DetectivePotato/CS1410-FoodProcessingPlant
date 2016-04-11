import java.lang.StringBuilder;

public class Simulator {

	private static int numberOfPackers;
	private static int packingTime = 10;
	private static int num_Steps;
	private double p;
	private double q;


	public void stop(){
		int b = 0;
		if(b > num_Steps)
		{

			//code to kill simulation
			b++;
		}
		else
			setup();

	}
	private void setup()
	{
		MachineFactory.generateMachines(packingTime, numberOfPackers);

		System.out.println(MachineList.printDetails());
	}

	private static void singleStep()
	{
		FoodList.ageFood();

		FoodFactory.generate();

		MachineList.activateMachines();
	}
	public void setPProbs(int pProbs)
	{

		p = pProbs;

	}

	public void setQProbs(int qProbs)
	{

		q = qProbs;

	}

	public void setProcessingStages(int newStages){

		ProcessingMachine.setProcessingStages(newStages);

	}
	public void setNumberOfPackers(int newPackerNum)
	{
		numberOfPackers = newPackerNum;
	}
	private void StringBuilder(String sb) {

		StringBuilder s1 = new StringBuilder("Items Lost: " + ProfitStats.LOST_ITEMS);
		StringBuilder s2 = new StringBuilder("Items Packed: " + ProfitStats.PACKED_ITEMS);
		System.out.println(s1 + "/n" + s2);
	}

	public void probsValue(){

		StringBuilder str =new StringBuilder("new P Value" + p);
		StringBuilder str1 = new StringBuilder("new Q value" + q);

		System.out.println(str + "/n" + str1);
	}




	static void Run()
	{
		while(num_Steps < 7200)
		{

			singleStep();
			num_Steps++;
		}

	}

}
