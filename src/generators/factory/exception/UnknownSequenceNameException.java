package generators.factory.exception;

public class UnknownSequenceNameException 
         extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public UnknownSequenceNameException(String sequenceName)
	{
		super(String.format("Unknown sequence name '%s'", sequenceName));
	}
}
