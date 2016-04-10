/**
 * GUI for the food processor simulator
 * @author James Johnson
 * @version 07/04/2016
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SimulatorGUI {
	 
		private JFrame mainFrame;
		private JTextArea profits;	
		private Simulator simulator;
		private FoodFactory foodFac;
		private MachineFactory machineFac;
		
		public SimulatorGUI(FoodFactory foodFac, MachineFactory machineFac){
		final int blankSpace = 6;
		this.foodFac = foodFac;
		this.machineFac = machineFac;
		
		// Step 1: create the components
		JButton runButton = new JButton();
		JButton quitButton = new JButton();
		profits = new JTextArea();
		profits.setEditable(false);
		JScrollPane listScroller = new JScrollPane(profits);
		JTextField qProbability = new JTextField();
		JLabel qLabel = new JLabel("Q Probability");
		JTextField pProbability = new JTextField();
		JLabel pLabel = new JLabel("P Probability");
		JTextField numSteps = new JTextField();
		JLabel stepsLabel = new JLabel("Simulation Steps");
		JTextField numCheese = new JTextField();
		JLabel cheeseLabel = new JLabel("Cheese Processors:");
		JTextField numBlueCheese = new JTextField();
		JLabel blueCheeseLabel = new JLabel("Blue Cheese Processors:");
		JTextField numSoup = new JTextField();
		JLabel soupLabel = new JLabel("Soup powder Processors:");
		JTextField numPackers = new JTextField();
		JLabel packersLabel = new JLabel("Packers:");
		
		// Step 2: Set the properties of the components
		runButton.setText("Run");
		quitButton.setText("Quit");
		runButton.setToolTipText("Run the simulation using the values set for q, p and steps");
		quitButton.setToolTipText("Exit the application");
		numSteps.setToolTipText("Set the number of steps the simulation will run for");
		qProbability.setToolTipText("Set the probability for the creation of perishible foods.\n "
				+ "Values must be set between 0-1");
		pProbability.setToolTipText("set the probability for the creation of non-perishible foods.\n " 
				+ "Values must be set between 0-1");
		numCheese.setToolTipText("Set the number of cheese processing machines.");
		numBlueCheese.setToolTipText("Set the number of blue cheese processing machines.");
		numSoup.setToolTipText("Set the number of soup powder processing machines.");
		numPackers.setToolTipText("Set the number of packing machines.");
		listScroller.setPreferredSize(new Dimension(300,300));
		listScroller.setMinimumSize(new Dimension(200,200));
		
		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("Factory simulation");
		JPanel stepsBox = new JPanel();
		JPanel buttonBox = new JPanel();
		JPanel controlBox = new JPanel();
		JPanel pBox = new JPanel();
		JPanel qBox = new JPanel();
		JPanel inputBox = new JPanel();
		JPanel cheeseBox = new JPanel();
		JPanel blueCheeseBox = new JPanel();
		JPanel soupBox = new JPanel();
		JPanel packerBox = new JPanel();
		JPanel machineBox = new JPanel();
		JPanel processorBox = new JPanel();
		JPanel commandBox = new JPanel();
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		
		// Step 4: Specify LayoutManagers
		mainFrame.setLayout(new BorderLayout());
		buttonBox.setLayout(new FlowLayout());
		stepsBox.setLayout(new BorderLayout());
		controlBox.setLayout(new BorderLayout());
		pBox.setLayout(new BorderLayout());
		qBox.setLayout(new BorderLayout());
		inputBox.setLayout(new BorderLayout());
		JPanel profitBox = (JPanel) mainFrame.getContentPane();
		profitBox.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		cheeseBox.setLayout(new BorderLayout());
		blueCheeseBox.setLayout(new BorderLayout());
		soupBox.setLayout(new BorderLayout());
		packerBox.setLayout(new BorderLayout());
		machineBox.setLayout(new BorderLayout());
		processorBox.setLayout(new BorderLayout());
		commandBox.setLayout(new BorderLayout());
		
		
		// Step 5: Add components to containers
		packerBox.add(packersLabel, BorderLayout.WEST);
		packerBox.add(numPackers, BorderLayout.CENTER);
		soupBox.add(soupLabel, BorderLayout.WEST);
		soupBox.add(numSoup, BorderLayout.CENTER);
		blueCheeseBox.add(blueCheeseLabel, BorderLayout.WEST);
		blueCheeseBox.add(numBlueCheese, BorderLayout.CENTER);
		cheeseBox.add(cheeseLabel, BorderLayout.WEST);
		cheeseBox.add(numCheese, BorderLayout.CENTER);
		processorBox.add(cheeseBox, BorderLayout.NORTH);
		processorBox.add(blueCheeseBox, BorderLayout.CENTER);
		processorBox.add(soupBox, BorderLayout.SOUTH);
		machineBox.add(processorBox, BorderLayout.CENTER);
		machineBox.add(packerBox, BorderLayout.SOUTH);
		buttonBox.add(runButton);
		buttonBox.add(quitButton);
		stepsBox.add(stepsLabel,BorderLayout.WEST);
		stepsBox.add(numSteps, BorderLayout.CENTER);
		qBox.add(qLabel, BorderLayout.WEST);
		qBox.add(qProbability, BorderLayout.CENTER);
		pBox.add(pLabel, BorderLayout.WEST);
		pBox.add(pProbability, BorderLayout.CENTER);
		inputBox.add(stepsBox, BorderLayout.SOUTH);
		inputBox.add(qBox, BorderLayout.NORTH);
		inputBox.add(pBox, BorderLayout.CENTER);
		commandBox.add(machineBox, BorderLayout.CENTER);
		commandBox.add(inputBox, BorderLayout.SOUTH);
		controlBox.add(buttonBox, BorderLayout.SOUTH);
		controlBox.add(commandBox, BorderLayout.CENTER);
		mainFrame.add(controlBox, BorderLayout.SOUTH);
		mainFrame.add(listScroller, BorderLayout.NORTH);
		
		// Step 6: Arrange to handle events in the user interface
		quitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					exitApp();
		}
		});
		
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				runApp(numSteps.getText(), qProbability.getText(), pProbability.getText(), numPackers.getText()
						, numCheese.getText(), numBlueCheese.getText(), numSoup.getText());
			
			}
		});
		
		// Step 7: Display the GUI
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		}
		
		private void exitApp() {
			int response = JOptionPane.showConfirmDialog(mainFrame,
						"Do you want to quit",
						"Quit?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_OPTION){
				System.exit(0);
			}
			// Don't quit
		}
		
		private void runApp(String steps, String qProb, String pProb, String packers, String cheese
				, String cheeseBlue, String soup){
			int num = Integer.parseInt(steps);
			double q = Double.parseDouble(qProb);
			double p = Double.parseDouble(pProb);
			int pack = Integer.parseInt(packers);
			int c = Integer.parseInt(cheese);
			int bc = Integer.parseInt(cheeseBlue);
			int s = Integer.parseInt(soup);
			if(q<0 || q>1 || p<0 || p>1){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "One or more of the values is not in the range of 0 - 1.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(num<0){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "Number of steps in the simulation can not be negative.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(pack < 1 || c < 1 || bc < 1 || s < 1){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "Number of Machines must be at least 1.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Simulation steps = " + num);
				System.out.println("Probability of q =  " + q);
				System.out.println("Probability of p = " + p);
				profits.append("Simulation steps = " + num + "\n");
				profits.append("Probability of q = " + q + "\n");
				profits.append("Probability pf p = " + p + "\n");
				profits.append("Blue cheese processing machines = " + cheeseBlue + "\n");
				profits.append("Number of soup powder processing machines = " + soup + "\n");
				profits.append("Number of cheese processing machines = " + cheese + "\n");
				profits.append("Number of packing machines = " + packers + "\n");
				System.out.println(c);
				System.out.println(bc);
				System.out.println(s);
				System.out.println(pack);
				foodFac.setQ(q);
				foodFac.setP(p);
				for(int i=0; i< c; i++){
					int n = i+1;
				machineFac.makeProcessor("Cheese", n);
				}
				for(int i =0; i<bc; i++){
					int n = i+1;
					machineFac.makeProcessor("BlueCheese", n);
				}
				for(int i=0; i<s; i++){
					int n = i+1;
					machineFac.makeProcessor("SoupPowder", n);
				}
				machineFac.generateMachines(10, pack);
				
				
			}
		}
}


