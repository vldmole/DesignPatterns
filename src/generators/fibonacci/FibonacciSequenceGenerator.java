package generators.fibonacci;

import java.util.ArrayList;
import java.util.List;

import generators.AbstractSequenceGenerator;

public class FibonacciSequenceGenerator
extends AbstractSequenceGenerator
{
	@Override
	public List<Integer> generateSequence(int MAX)
	{
		List<Integer> list = new ArrayList<>();
		
		int current = 1;
		int next = Integer.MIN_VALUE;
		int previous = 0;
		
		while(current <= MAX)
		{
			list.add(current);
			
			next = current + previous;
			previous = current;
			current = next;
		}
		
		return list;
	}
}
