package app.view.components.validators;

import app.view.components.validatedTextField.IValidator;

public class IntegerRangeValidator
implements IValidator
{

	private int MIN_VALUE = Integer.MIN_VALUE;
	private int MAX_VALUE = Integer.MAX_VALUE;
	
	//-------------------------------------------------------------------------------
	public IntegerRangeValidator(final int minValue, final int maxValue)
	{
		if(minValue > maxValue)
			throw new RuntimeException("Invalid - minValue should be lower than maxValue");
		
		this.MIN_VALUE = minValue;
		this.MAX_VALUE = maxValue;
	}
	
	//-------------------------------------------------------------------------------
	private boolean isWithinTheRange(int value)
	{
		return ((value >= MIN_VALUE) && (value <= MAX_VALUE));
	}
	
	//-------------------------------------------------------------------------------
	@Override
	public boolean isValid(String text)
	{
		if(MIN_VALUE < 0 && text.equalsIgnoreCase("-"))
			return true;
		
		try
		{
			int value = Integer.parseInt(text);
			return isWithinTheRange(value);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
	}
}
