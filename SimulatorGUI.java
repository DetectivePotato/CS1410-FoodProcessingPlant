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
		JTextField qProbability = new JTextField();
		JLabel qLabel = new JLabel("Q Probability");
		JTextField pProbability = new JTextField();
		JLabel pLabel = new JLabel("P Probability");
		JTextField numSteps = new JTextField();
		JLabel stepsLabel = new JLabel("Simulation Steps");
		
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
		listScroller.setPreferredSize(new Dimension(300,300));
		listScroller.setMinimumSize(new Dimension(200,200));
		
		// Step 3: Create containers to hold the components
		mainFrame = new JFrame("Factory simulation");
		JPanel stepsBox = new JPanel();
		JPanel commandBox = new JPanel();
		JPanel controlBox = new JPanel();
		JPanel pBox = new JPanel();
		JPanel qBox = new JPanel();
		JPanel inputBox = new JPanel();
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// Step 4: Specify LayoutManagers
		mainFrame.setLayout(new BorderLayout());
		commandBox.setLayout(new FlowLayout());
		stepsBox.setLayout(new BorderLayout());
		controlBox.setLayout(new BorderLayout());
		pBox.setLayout(new BorderLayout());
		qBox.setLayout(new BorderLayout());
		inputBox.setLayout(new BorderLayout());
		JPanel profitBox = (JPanel) mainFrame.getContentPane();
		profitBox.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		// Step 5: Add components to containers
		commandBox.add(runButton);
		commandBox.add(quitButton);
		stepsBox.add(stepsLabel,BorderLayout.WEST);
		stepsBox.add(numSteps, BorderLayout.CENTER);
		qBox.add(qLabel, BorderLayout.WEST);
		qBox.add(qProbability, BorderLayout.CENTER);
		pBox.add(pLabel, BorderLayout.WEST);
		pBox.add(pProbability, BorderLayout.CENTER);
		inputBox.add(stepsBox, BorderLayout.SOUTH);
		inputBox.add(qBox, BorderLayout.NORTH);
		inputBox.add(pBox, BorderLayout.CENTER);
		controlBox.add(commandBox, BorderLayout.SOUTH);
		controlBox.add(inputBox, BorderLayout.CENTER);
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
				runApp(numSteps.getText(), qProbability.getText(), pProbability.getText());
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
		
		private void runApp(String steps, String qProb, String pProb){
			int num = Integer.parseInt(steps);
			double q = Double.parseDouble(qProb);
			double p = Double.parseDouble(pProb);
			if(q<0 || q>1 || p<0 || p>1){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "One or more of the values is not in the range of 0 - 1.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(num<0){
				JFrame errorFrame = new JFrame();
				JOptionPane.showMessageDialog(errorFrame, "Number of steps in the simulation can not be negative.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Simulation steps = " + steps);
				System.out.println("Probability of q =  " + qProb);
				System.out.println("Probability of p = " + pProb);
				profits.append("Simulation steps = " + steps + "\n");
				profits.append("Probability of q = " + qProb + "\n");
				profits.append("Probability pf p = " + pProb + "\n");
			}
		}
}


