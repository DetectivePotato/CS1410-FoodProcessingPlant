import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;

/**
 * Enhanced version of standard Swing JSlider widget
 * Slight change. Appropiate labels added for the range of p and q probabilities.
 * @author Ian T. Nabney
 * @version 13/03/2005
 */


public class LabelledSlider extends JComponent {
	
	private static final long serialVersionUID = 6511929653284188062L;
	private String labelString;
	private JLabel label;
	private JSlider slider;
	
	public LabelledSlider(String text, int min, int max, int value) {
		this.setDoubleBuffered(true);
		label = new JLabel(text + value);
		labelString = new String(text);
		slider = new JSlider(min, max, value);
		// Create label table.
		Hashtable<Integer, JLabel> decimalValues = new Hashtable<Integer, JLabel>();
		// Create labels.
		decimalValues.put(new Integer(0), new JLabel("0.00"));
		decimalValues.put(new Integer(1), new JLabel("0.01"));
		decimalValues.put(new Integer(2), new JLabel("0.02"));
		decimalValues.put(new Integer(3), new JLabel("0.03"));
		decimalValues.put(new Integer(4), new JLabel("0.04"));
		decimalValues.put(new Integer(5), new JLabel("0.05"));
		slider.setLabelTable(decimalValues);
		// Set slider properties
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new SliderListener());
		
		
		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.NORTH);
		this.add(slider, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createEtchedBorder());
		
	}
	
	public void setMajorTickSpacing(int spacing) {
		slider.setMajorTickSpacing(spacing);
		repaint();
	}
	
	public double getValue() {
		return slider.getValue();
	}
	
	private class SliderListener implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			if (!slider.getValueIsAdjusting()) {
				int number = slider.getValue();
				label.setText(labelString + "0.0" + number);
			}
		}
	}
}
