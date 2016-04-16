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

		
		public SimulatorGUI(){
		final int blankSpace = 6;

		
		// Step 1: create the components
		JButton runButton = new JButton();
		JButton quitButton = new JButton();
		profits = new JTextArea();
		profits.setEditable(false);
		JScrollPane listScroller = new JScrollPane(profits);
		final JTextField qProbability = new JTextField();
		JLabel qLabel = new JLabel("Q Probability");
		final JTextField pProbability = new JTextField();
		JLabel pLabel = new JLabel("P Probability");
		final JTextField numSteps = new JTextField();
		JLabel stepsLabel = new JLabel("Simulation Steps");
		final JTextField numPerishable = new JTextField();
		JLabel perishLabel = new JLabel("perishable Processing Time:");
		final JTextField numNonPerishable = new JTextField();
		JLabel nPerishLabel = new JLabel("Non-perishable Processing time:");
		final JTextField numPackers = new JTextField();
		JLabel packersLabel = new JLabel("Packing Time:");
		final JTextField stages = new JTextField();
		JLabel stagesLabel = new JLabel("Number of stages");
		final LabelledSlider qSlider = new LabelledSlider("Q Probability: ", 1, 5,3);
		final LabelledSlider pSlider = new LabelledSlider("P Probability: ", 1, 5,3);
		
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
		numPerishable.setToolTipText("Set the number of steps it takes for a perishable processing machine to process its item.");
		stages.setToolTipText("Set the number of stages.");
		numNonPerishable.setToolTipText("Set the nummber of steps it takes for a Non-perishable processing machine to process an item.");
		numPackers.setToolTipText("Set the number of steps it takes a packing machine to pack an item.");
		qSlider.setMajorTickSpacing(5);
		pSlider.setMajorTickSpacing(5);
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
		JPanel perishBox = new JPanel();
		JPanel nPerishBox = new JPanel();
		JPanel packerBox = new JPanel();
		JPanel machineBox = new JPanel();
		JPanel processorBox = new JPanel();
		JPanel commandBox = new JPanel();
		JPanel stageBox = new JPanel();
		JPanel qProbBox = new JPanel();
		JPanel pProbBox = new JPanel();
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
		perishBox.setLayout(new BorderLayout());
		nPerishBox.setLayout(new BorderLayout());
		packerBox.setLayout(new BorderLayout());
		machineBox.setLayout(new BorderLayout());
		processorBox.setLayout(new BorderLayout());
		commandBox.setLayout(new BorderLayout());
		stageBox.setLayout(new BorderLayout());
		qProbBox.setLayout(new BorderLayout());
		pProbBox.setLayout(new BorderLayout());
		
		// Step 5: Add components to containers
		pProbBox.add(pSlider, BorderLayout.CENTER);
		qProbBox.add(qSlider, BorderLayout.CENTER);
		stageBox.add(stages, BorderLayout.CENTER);
		stageBox.add(stagesLabel, BorderLayout.WEST);
		packerBox.add(packersLabel, BorderLayout.WEST);
		packerBox.add(numPackers, BorderLayout.CENTER);
		nPerishBox.add(nPerishLabel, BorderLayout.WEST);
		nPerishBox.add(numNonPerishable, BorderLayout.CENTER);
		perishBox.add(perishLabel, BorderLayout.WEST);
		perishBox.add(numPerishable, BorderLayout.CENTER);
		processorBox.add(perishBox, BorderLayout.NORTH);
		processorBox.add(stageBox, BorderLayout.CENTER);
		processorBox.add(nPerishBox, BorderLayout.SOUTH);
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
		inputBox.add(stepsBox, BorderLayout.NORTH);
		inputBox.add(qProbBox, BorderLayout.CENTER);
		inputBox.add(pProbBox, BorderLayout.SOUTH);
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
				
				runApp(numSteps.getText(), qSlider.getValue(), pSlider.getValue(), numPackers.getText()
						, numPerishable.getText(),  numNonPerishable.getText(), stages.getText());
			
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
		
		private void runApp(String steps, double qProb, double pProb, String packers, String perishable
				, String nonPerishable, String stages){
			int num = Integer.parseInt(steps);
			double p = pProb;
			double q = qProb;
			int pack = Integer.parseInt(packers);
			int perish = Integer.parseInt(perishable);
			int nperish = Integer.parseInt(nonPerishable);
			int stage = Integer.parseInt(stages);
			if(num<1 || num>7200){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "Value set for Steps is not in the range of 1-7200.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(pack < 1 ||  nperish < 1 || perish < 1){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "Steps for packing or processing must be greater than or equal to 1.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(stage < 1){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "Stage must be greater than or equal to 1.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Simulation steps = " + num);
				System.out.println("Probability of q =  " + q);
				System.out.println("Probability of p = " + p);
				profits.append("Simulation steps = " + num + "\n");
				profits.append("Probability of q = " + q + "\n");
				profits.append("Probability pf p = " + p + "\n");
				System.out.println(perish);
				System.out.println(nperish);
				System.out.println(stage);
				System.out.println(pack);

		}
	}
}



