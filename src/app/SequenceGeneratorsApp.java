package app;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import app.control.ApplicationControl;
import app.model.ApplicationModel;
import app.view.ApplicationView;
import generators.factory.ISequenceGeneratorFactory;
import generators.factory.SequenceGeneratorFactory;

public class SequenceGeneratorsApp 
{
	private ApplicationView view;
	private ApplicationModel model;
	private ApplicationControl control;
	
	public SequenceGeneratorsApp()
	{
		ISequenceGeneratorFactory generatorFactory = SequenceGeneratorFactory.getInstance();
		
		model = new ApplicationModel();
		control = new ApplicationControl(model, generatorFactory);
		
		view = ApplicationView.create(listOfAvailableSequences());
		view.setModel(model);
		view.setControl(control);
		
		view.setVisible(true);
	}
	
	private List<AbstractMap.Entry<String, String>> listOfAvailableSequences()
	{
		List<AbstractMap.Entry<String, String>> lst = new ArrayList<>();
		
		lst.add(new AbstractMap.SimpleEntry<>("Fibonacci","Sequência de Fibonacci"));
		lst.add(new AbstractMap.SimpleEntry<>("CubicNumbers","Sequência de Números Cúbicos"));
		lst.add(new AbstractMap.SimpleEntry<>("PerfectSquares","Sequência de Quadrados Perfeitos"));
		lst.add(new AbstractMap.SimpleEntry<>("AtkinPrime","Sequência de Atkin"));
		lst.add(new AbstractMap.SimpleEntry<>("Erastothenes","Sequência de Erasthotenes"));
		
		return lst;
	}
	
	public static void main(String[] args)
	{
		new SequenceGeneratorsApp();
	}
}
