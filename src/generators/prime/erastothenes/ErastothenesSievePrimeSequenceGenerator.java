package generators.prime.erastothenes;

import java.util.ArrayList;
import java.util.List;

import generators.AbstractSequenceGenerator;

public class ErastothenesSievePrimeSequenceGenerator
extends AbstractSequenceGenerator
{
	private List<Integer> candidates;
	
	//--------------------------------------------------------------------
	private void generateCandidates(final int MAX)
	{
		this.candidates = new ArrayList<>(MAX);

		for(int number = 2; number <= MAX; number++)
			candidates.add(number);
	}
	
	//--------------------------------------------------------------------
	private void markMultiplesWithZero()
	{
		if(candidates.size() < 1)
			return;
		
		final int lastNumber = candidates.get(candidates.size()-1);
		final int MAX_BASE = lastNumber/2 +1;
		
		for (int base = 2; base < MAX_BASE; base += base == 2 ? 1 : 2){
			for(int i = (2*base-2); i < candidates.size(); i += base)
				candidates.set(i,0);
		}
	}
	
	//--------------------------------------------------------------------
	private List<Integer> collectPrimes()
	{
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0; i<candidates.size(); i++)
		{
			int number = candidates.get(i);
			if (number != 0)
				result.add(number);
		}
		
		result.trimToSize();
		return result;
	}
	
	//--------------------------------------------------------------------
	@Override
	public List<Integer> generateSequence(final int MAX)
	{
		generateCandidates(MAX < 2 ? 0 : MAX);
		markMultiplesWithZero();
		return collectPrimes();		
	}
}
