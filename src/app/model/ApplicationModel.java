package app.model;

import java.util.ArrayList;

import util.observable.Observable;
import util.observable.ObserverManager;


public class ApplicationModel 
implements Observable<ModelState>, IModel
{	
	private 
	ModelState state = new ModelState("", new ArrayList<>());
	
	public final 
	ObserverManager<ModelState> observerManager = ObserverManager.create(this);

	//-------------------------------------------------------------------
	@Override
	public final 
	void setState(final ModelState state) 
	{
		this.state = state;
		observerManager.notifyObservers(state);
	}
	
	//-------------------------------------------------------------------
	@Override
	public final 
	ModelState getState() 
	{
		return this.state;
	}

	
	//-------------------------------------------------------------------
	@Override
	public final ObserverManager<ModelState> getObserverManager() 
	{
		return observerManager;
	}
}
