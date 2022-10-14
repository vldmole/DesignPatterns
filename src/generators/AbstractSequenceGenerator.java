package generators;

import java.util.List;

public abstract class AbstractSequenceGenerator 
implements ISequenceGenerator
{
	public abstract List<Integer> generateSequence(final int MAX);
}
