package generators.factory;

import generators.ISequenceGenerator;
import generators.cubicNumbers.CubicNumbersSequenceGenerator;
import generators.factory.exception.UnknownSequenceNameException;
import generators.fibonacci.FibonacciSequenceGenerator;
import generators.perfectSquares.PerfectSquaresSequenceGenerator;
import generators.prime.atkin.AtkinSievePrimeSequenceGenerator;
import generators.prime.erastothenes.ErastothenesSievePrimeSequenceGenerator;

public class SequenceGeneratorFactory
      implements ISequenceGeneratorFactory
{
    static private
    SequenceGeneratorFactory singleton = null;
	
	public static 
	SequenceGeneratorFactory getInstance()
	{
		if( singleton == null )
			singleton = new SequenceGeneratorFactory();
		
		return singleton;
	}
	
	private SequenceGeneratorFactory()
	{
		/* Singleton Pattern */
	}
	
	@Override
	public ISequenceGenerator createGenerator(String sequenceName) 
	{
		sequenceName = sequenceName.trim();
		
		if("Fibonacci".equalsIgnoreCase(sequenceName))
			return new FibonacciSequenceGenerator();
		
		if("CubicNumbers".equalsIgnoreCase(sequenceName))
			return new CubicNumbersSequenceGenerator();
		
		if("PerfectSquares".equalsIgnoreCase(sequenceName))
			return new PerfectSquaresSequenceGenerator();
		
		if("AtkinPrime".equalsIgnoreCase(sequenceName))
			return new AtkinSievePrimeSequenceGenerator();
		
		if("Erastothenes".equalsIgnoreCase(sequenceName))
			return new ErastothenesSievePrimeSequenceGenerator();
		
		throw new UnknownSequenceNameException(sequenceName);
	}
}
