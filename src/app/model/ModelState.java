package app.model;

import java.util.Collections;
import java.util.List;

public final class ModelState 
{
	public final String sequenceName;
	public final List<Integer> sequence;
	
	//------------------------------------------------------------
	public ModelState(String sequenceName, List<Integer> sequence)
	{
		this.sequenceName = sequenceName;
		this.sequence =  Collections.unmodifiableList(sequence);
	}
}
