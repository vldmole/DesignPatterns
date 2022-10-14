package util.observable;

import java.util.ArrayList;
import java.util.List;
 
class ObserverManagerImpl<TState> 
implements ObserverManager<TState>
{
	private List<Observer<TState>> observersList = new ArrayList<>();
	private Observable<TState> observable;
	
	//---------------------------------------------------------------------------------
	public ObserverManagerImpl(Observable<TState> observable)
	{
		this.observable = observable;
	}
	
	//---------------------------------------------------------------------------------
	@Override
	public void addObserver(Observer<TState> observer) 
	{
		observersList.add(observer);
	}

	//---------------------------------------------------------------------------------
	@Override
	public void removeObserver(Observer<TState> observer)
	{
		observersList.remove(observer);
	}

	//---------------------------------------------------------------------------------
	@Override
	public void removeAllObservers()
	{
		observersList.clear();
	}
	
	//---------------------------------------------------------------------------------
	public void notifyObservers(TState newState)
	{
		for(Observer<TState> observer : observersList)
		{
				observer.stateChanged(observable, newState);
		}
	}
}

