package app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import app.view.components.validatedTextField.ValidatedTextField;
import app.view.components.validators.IntegerRangeValidator;

public class ApplicationView 
{
	private JFrame frame = null;
	private JTextArea sequenceTextArea = null;
	private ValidatedTextField sequenceLimitTextField = null;
	private JTextField sequenceSizeTextField = null;
	private JLabel sequenceNameLabel = null;
	private JButton generateSequenceButton = null;
	String sequenceName = null;
	
	//------------------------------------------------------------------------
	private ApplicationView()
	{
		/* this should be instantiated by the factory method only*/
	}
	
	//------------------------------------------------------------------------
	public void setVisible(boolean visible)
	{
		frame.setVisible(visible);
	}
	
	//------------------------------------------------------------------------
	public
	void setSequence(List<Integer> sequence) 
	{
		sequenceTextArea.setText("");
		
		for(Integer value : sequence)
			sequenceTextArea.append(String.format("%d, ",value));
		
		sequenceTextArea.append(" ...");
	}
	
		
	//-----------------------------------------------------------------------------------------
	// method factory
	//-----------------------------------------------------------------------------------------
	static public 
	ApplicationView create()
	{
		final ApplicationView appView = new ApplicationView();
		
		appView.sequenceTextArea = createSequenceTextArea();
		appView.sequenceLimitTextField = createSequenceLimitField();
		appView.sequenceNameLabel = createSequenceNameLabel();
		appView.sequenceSizeTextField = createSequenceSizeTextField();
		appView.generateSequenceButton = new JButton("Gerar a sequência");
			
		appView.frame = createFrame(appView);
		
		return appView;
	}

	//-----------------------------------------------------------------------------------------
	static 
	JTextArea createSequenceTextArea()
	{
		JTextArea textArea = new JTextArea();
		textArea.enableInputMethods(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
	
		return textArea;
	}
	
	//-----------------------------------------------------------------------------------------
	static 
	ValidatedTextField createSequenceLimitField()
	{
		ValidatedTextField textField = new ValidatedTextField();
		textField.setValidator(new IntegerRangeValidator(1, 1_000_000));
		
		return textField;
	}
	
	//-----------------------------------------------------------------------------------------
	static
	JLabel createSequenceNameLabel()
	{
		JLabel label = new JLabel();
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 15);
		label.setFont(font);
		
		return label;
	}
	
	//-----------------------------------------------------------------------------------------
	static
	JTextField createSequenceSizeTextField()
	{
		JTextField textField = new JTextField();
		textField.setEditable(false);
		
		return textField;
	}
	
	//-----------------------------------------------------------------------------------------
	static
	JFrame createFrame(final ApplicationView appView)
	{
		JFrame frame = new JFrame("Gerador de Sequências Numéricas");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800,600));
		frame.getContentPane().setLayout(new BorderLayout());
		
		JScrollPane scrollPane = createVerticalScrollPaneFor(appView.sequenceTextArea); 
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		frame.getContentPane().add(createSouthPanel(appView), BorderLayout.SOUTH);
			
		frame.pack();
				
		return frame;
	}
	
	//-----------------------------------------------------------------------------------------
	static
	JScrollPane createVerticalScrollPaneFor(JTextArea textArea)
	{
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		return scrollPane;
	}
	
	//-----------------------------------------------------------------------------------------
	static
	JPanel createSouthPanel(final ApplicationView appView)
	{
		JPanel bagPane = new JPanel(new GridBagLayout());
		//GridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight,
		//                   double weightx, double weighty, int anchor, int fill,
		//                   Insets insets, int ipadx, int ipady)
		GridBagConstraints gbc;
		JPanel pane;
		
		JLabel label = new JLabel("Gerar sequência até: ? (<1.000.000)");
		pane = createPanelFor(label, appView.sequenceLimitTextField);
		gbc = new GridBagConstraints(0, 0, 1, 1, 0.4, 1, GridBagConstraints.LINE_START, 
				GridBagConstraints.BOTH, new Insets(2,2,2,2), 2, 2);
		bagPane.add(pane, gbc);
		
		pane = createPanelFor(appView.sequenceNameLabel, appView.sequenceSizeTextField);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0.4, 1, GridBagConstraints.LINE_START, 
				GridBagConstraints.BOTH, new Insets(2,2,2,2), 2, 2);
		bagPane.add(pane, gbc);
		
		gbc = new GridBagConstraints(2, 0, 1, 1, 0.2, 1, GridBagConstraints.LINE_START, 
				GridBagConstraints.BOTH, new Insets(2,2,2,2), 2, 2);
		bagPane.add(appView.generateSequenceButton);
		
		return bagPane;
	}
	
	//-----------------------------------------------------------------------------------------
	static
	JPanel createPanelFor(JLabel label, JTextField textField)
	{
		label.setLabelFor(textField);
		
		JPanel pane = new JPanel(new GridLayout(2, 1, 2, 2));
		pane.add(label);
		pane.add(textField);
		
		return pane;
	}
}
