package generators.prime.atkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generators.AbstractSequenceGenerator;

public class AtkinSievePrimeSequenceGenerator 
extends AbstractSequenceGenerator 
{
	private int limit;
	private List<Integer> primes;
	private boolean[] sieve;
	
	//-----------------------------------------------------------
	private void init(int limit)
	{
		this.limit = limit;
		this.primes = new ArrayList<>(limit/10);
		this.sieve = new boolean[limit];
		Arrays.fill(this.sieve, false);
	}
	
	//-----------------------------------------------------------
	private void flipSievePosition(int position)
	{
		sieve[position] = !sieve[position];
	}

	//-----------------------------------------------------------
	private void markSievePositionAsFalse(int sievePosition)
	{
		sieve[sievePosition] = false;
	}
	
	//-----------------------------------------------------------
	private boolean isPrime(int value)
	{
		int sievePosition = value;
		return sieve[sievePosition];
	}
	
	//-----------------------------------------------------------
	@Override
	public List<Integer> generateSequence(final int MAX)
	{
		init( (MAX < 2) ? 0 : MAX+1);
		
		if(MAX < 2)
			return primes;
		
		int testingLimit = (int) (Math.ceil(Math.sqrt(MAX))); 
		
		for (int i=0; i<testingLimit; i++)
		{
			for(int j=0; j<testingLimit; j++)
			{
				// n = 4*i^2 + j^2
				int n = 4*i*i + j*j;
				if (n < limit && (n % 12 == 1 || n % 12 == 5))				
					flipSievePosition(n);

				// n = 3*i^2 + j^2
				n = 3*i*i + j*j;
				if (n < limit && n % 12 == 7)				
					flipSievePosition(n);				

				// n = 3*i^2 - j^2
				n = 3*i*i - j*j;
				if (n < limit && i > j && n % 12 == 11)					
					flipSievePosition(n);
			}
		}
		
		for (int i=5; i<testingLimit; i++)
		{
			if (isPrime(i))
			{
				int k = i*i;
				for (int j=k; j<limit; j+=k)
				{
					markSievePositionAsFalse(j);
				}
				
			}
		}
	
		if(MAX > 1)
			primes.add(2);
		if(MAX > 2)
			primes.add(3);
		
		for(int value=5; value < sieve.length; value++)
		{
			if(isPrime(value))
				primes.add(value);
		}
		
		return primes;
	}
}