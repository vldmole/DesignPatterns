package generators.perfectSquares;

import java.util.ArrayList;
import java.util.List;

import generators.AbstractSequenceGenerator;

public class PerfectSquaresSequenceGenerator extends AbstractSequenceGenerator
{
	@Override
	public List<Integer> generateSequence(int MAX)
	{
		List<Integer> sequence = new ArrayList<>();
		
		int base = 1;
		int square = base * base;
		while(square <= MAX)
		{
			sequence.add(square);
			base++;
			square = base * base;
		}
		
		return sequence;
	}

}
