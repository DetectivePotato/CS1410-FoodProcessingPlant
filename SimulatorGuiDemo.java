
public class SimulatorGuiDemo {
	private static  FoodFactory ff;
	private static MachineFactory mf;
	
	public static void main(String[] args){
		setup();
		SimulatorGUI sg = new SimulatorGUI(ff, mf);
	}
	
	private static void setup(){
		ff = new FoodFactory();
		mf = new MachineFactory();
	}
}
