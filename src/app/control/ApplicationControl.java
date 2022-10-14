package app.control;

import java.util.List;

import app.model.IModel;
import app.model.ModelState;
import generators.ISequenceGenerator;
import generators.factory.ISequenceGeneratorFactory;

public class ApplicationControl implements IControl
{
	private final ISequenceGeneratorFactory factory;
	private final IModel model;
	
	//-------------------------------------------------------------------------
	public ApplicationControl(IModel model, ISequenceGeneratorFactory factory)
	{
		this.model = model;
		this.factory = factory;
	}
	
	//-------------------------------------------------------------------------
	@Override
	public void generateSequence(String sequenceName, int max) 
	{
		ISequenceGenerator generator = factory.createGenerator(sequenceName);
		
		List<Integer> sequence = generator.generateSequence(max);
		
		model.setState(new ModelState(sequenceName, sequence));
	}
}
