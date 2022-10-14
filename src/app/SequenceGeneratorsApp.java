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
		
		lst.add(new AbstractMap.SimpleEntry<>("Fibonacci","Sequ�ncia de Fibonacci"));
		lst.add(new AbstractMap.SimpleEntry<>("CubicNumbers","Sequ�ncia de N�meros C�bicos"));
		lst.add(new AbstractMap.SimpleEntry<>("PerfectSquares","Sequ�ncia de Quadrados Perfeitos"));
		lst.add(new AbstractMap.SimpleEntry<>("AtkinPrime","Sequ�ncia de Atkin"));
		lst.add(new AbstractMap.SimpleEntry<>("Erastothenes","Sequ�ncia de Erasthotenes"));
		
		return lst;
	}
	
	public static void main(String[] args)
	{
		new SequenceGeneratorsApp();
	}
}
