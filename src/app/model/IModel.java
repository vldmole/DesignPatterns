package app.model;

import util.observable.Observable;

public interface IModel extends Observable<ModelState>
{
	public ModelState getState();	
	public void setState(final ModelState state);
}
