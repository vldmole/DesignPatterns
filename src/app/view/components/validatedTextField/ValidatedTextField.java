package app.view.components.validatedTextField;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;



public class ValidatedTextField extends JTextField
{
	private static final long serialVersionUID = 1L;
	private IValidator validator;
	
	//------------------------------------------------------------------------------
	public ValidatedTextField()
	{
		super.addKeyListener(this.keyListener);
		super.setOpaque(true);
	}
	
	//------------------------------------------------------------------------------
	public void setValidator(IValidator validator)
	{
		this.validator = validator;
	}
	
	//------------------------------------------------------------------------------
	public boolean isContentValid()
	{
		if(validator==null)
			return true;
		
		return validator.isValid(super.getText());
	}
	
	//------------------------------------------------------------------------------
	private void decorate()
	{
		if( isContentValid() )
			super.setBackground(Color.WHITE);
		else
			super.setBackground(Color.YELLOW);	
	}
	
	//------------------------------------------------------------------------------
	private final KeyListener keyListener = new KeyAdapter() 
	{
		@Override
		public void keyReleased(KeyEvent keyEvent)
		{
			decorate();
		}
	};

	//-------------------------------------------------------------------------------
	@Override
	public void setText(String text)
	{
		super.setText(text);
		decorate();
	}
}
