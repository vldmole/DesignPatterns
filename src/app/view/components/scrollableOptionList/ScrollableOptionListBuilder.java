package app.view.components.scrollableOptionList;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ScrollableOptionListBuilder
{
	private List<Entry<String,String>> optionsList = null;
	private ActionListener actionListener = null;
	
	//---------------------------------------------------------------------------
	public ScrollableOptionListBuilder()
	{
		//nothing
	}
	
	//---------------------------------------------------------------------------
	public ScrollableOptionListBuilder optionList(List<Entry<String,String>> list)
	{
		optionsList = list;
		return this;
	}
	
	//---------------------------------------------------------------------------
	public ScrollableOptionListBuilder actionListener(ActionListener listener)
	{
		actionListener = listener;
		return this;
	}
	
	//---------------------------------------------------------------------------
	public JScrollPane build()
	{
		JPanel pane = new JPanel(new GridLayout(optionsList.size(), 1));
		ButtonGroup group = new ButtonGroup(); 
		
		for(Entry<String,String> entry : optionsList)
		{
			JRadioButton radioButton = new JRadioButton(entry.getValue());
			radioButton.setActionCommand(entry.getKey());
			radioButton.addActionListener(actionListener);
			
			group.add(radioButton);
			pane.add(radioButton);
		}
		
		if(group.getElements().hasMoreElements())
			group.getElements().nextElement().setSelected(true);
		
		JScrollPane scrollPane = new JScrollPane(pane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		return scrollPane;
	}
	
	
	//--test---------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		List<Entry<String,String>> optionsList = new ArrayList<>();
		optionsList.add(new AbstractMap.SimpleEntry<>("ZERO","Gerador de Zeros"));
		optionsList.add(new AbstractMap.SimpleEntry<>("UM","Gerador de Uns"));
		optionsList.add(new AbstractMap.SimpleEntry<>("DOIS","Gerador de Dois"));
		optionsList.add(new AbstractMap.SimpleEntry<>("TRES","Gerador de Tres"));
		optionsList.add(new AbstractMap.SimpleEntry<>("QUATRO","Gerador de Quatros"));
		optionsList.add(new AbstractMap.SimpleEntry<>("CINCO","Gerador de Cincos"));
		optionsList.add(new AbstractMap.SimpleEntry<>("SEIS","Gerador de Seis"));
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ScrollableOptionListBuilder builder = new ScrollableOptionListBuilder();
		JScrollPane scrollableOptionList = builder
				.optionList(optionsList)
				.actionListener((actionEvent)->System.out.println(actionEvent.getActionCommand()))
				.build();
		
		frame.getContentPane().add(scrollableOptionList);
		frame.pack();
		frame.setVisible(true);
	}
}
