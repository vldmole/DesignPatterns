package generators.cubicNumbers;

import java.util.ArrayList;
import java.util.List;

import generators.AbstractSequenceGenerator;

public class CubicNumbersSequenceGenerator
extends AbstractSequenceGenerator
{

	@Override
	public List<Integer> generateSequence(int MAX)
	{
		List<Integer> sequence = new ArrayList<>();
		
		int value =1;
		for(int i=2; value <= MAX; i++)
		{
			sequence.add(value);
			
			value = i*i*i;
		}
		
		return sequence;
	}

}
