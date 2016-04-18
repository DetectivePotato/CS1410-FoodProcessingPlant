/**
 * GUI for the food processor simulator
 * @author James Johnson
 * @version 07/04/2016
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SimulatorGUI {
	 
		private JFrame mainFrame;
		private JTextArea profits;	

		public static void main(String[] args)
		{
			new SimulatorGUI();
		}
		
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
		final JTextField packerTime = new JTextField();
		JLabel packersLabel = new JLabel("Packing Time:");
		final LabelledSlider qSlider = new LabelledSlider("Q Probability: ", 1, 5,3);
		final LabelledSlider pSlider = new LabelledSlider("P Probability: ", 1, 5,3);
		final JTextField  numPackers = new JTextField();
		JLabel numPackerLabel = new JLabel("Number of packers:");
		
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
		numNonPerishable.setToolTipText("Set the nummber of steps it takes for a Non-perishable processing machine to process an item.");
		packerTime.setToolTipText("Set the number of steps it takes a packing machine to pack an item.");
		qSlider.setMajorTickSpacing(5);
		pSlider.setMajorTickSpacing(5);
		numPackers.setToolTipText("Set the the numver of packing machines");
		listScroller.setPreferredSize(new Dimension(300,300));
		listScroller.setMinimumSize(new Dimension(200,200));
		
		
		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("Factory simulation");
		JPanel numPackBox = new JPanel();
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
		qProbBox.setLayout(new BorderLayout());
		pProbBox.setLayout(new BorderLayout());
		numPackBox.setLayout(new BorderLayout());
		
		// Step 5: Add components to containers
		numPackBox.add(numPackerLabel, BorderLayout.WEST);
		numPackBox.add(numPackers, BorderLayout.CENTER);
		pProbBox.add(pSlider, BorderLayout.CENTER);
		qProbBox.add(qSlider, BorderLayout.CENTER);
		packerBox.add(packersLabel, BorderLayout.WEST);
		packerBox.add(packerTime, BorderLayout.CENTER);
		nPerishBox.add(nPerishLabel, BorderLayout.WEST);
		nPerishBox.add(numNonPerishable, BorderLayout.CENTER);
		perishBox.add(perishLabel, BorderLayout.WEST);
		perishBox.add(numPerishable, BorderLayout.CENTER);
		processorBox.add(perishBox, BorderLayout.NORTH);
		processorBox.add(nPerishBox, BorderLayout.SOUTH);
		machineBox.add(numPackBox, BorderLayout.NORTH);
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
		 mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				exitApp();
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					exitApp();
		}
		});
		
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				
			runApp(numSteps.getText(), qSlider.getValue(), pSlider.getValue(), packerTime.getText()
						, numPerishable.getText(),  numNonPerishable.getText(), numPackers.getText() );
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
		
		private void runApp(String numSteps, double qProb, double pProb, String packerTime, String perishable
				, String nonPerishable, String numPackers)
		{	
			try
			{
				int numberSteps = Integer.parseInt(numSteps);
				int packingTime = Integer.parseInt(packerTime);
				int perishableTime = Integer.parseInt(perishable);
				int nonPerishableTime = Integer.parseInt(nonPerishable);
				int numberPackers = Integer.parseInt(numPackers);
				
				
				if(numberSteps <= 0 || numberSteps > 7200)
				{
					JOptionPane.showMessageDialog(mainFrame,
							"Number of steps must be between 1 and 7200!");
				}
				
				if(numberPackers <= 0)
				{
					JOptionPane.showMessageDialog(mainFrame,
							"Number of packers must be greater than 0!");
				}
				
				if(packingTime <= 0)
				{
					JOptionPane.showMessageDialog(mainFrame,
							"Packing Time must be greater than 0!");
				}
				
				if(perishableTime <= 0)
				{
					JOptionPane.showMessageDialog(mainFrame,
							"Perishable time must be greater than 0!");
				}
				
				if(nonPerishableTime <= 0)
				{
					JOptionPane.showMessageDialog(mainFrame,
							"Non-Perishable time must be greater than 0!");
				}
				
				String results = Simulator.run(numberSteps, qProb, pProb, packingTime, perishableTime, nonPerishableTime, numberPackers);
				
				displayString(results);
			}
			catch(Exception e)
			{
				
			}

		}
		
	private void displayString(String text){
		profits.append(text);
	}
}



