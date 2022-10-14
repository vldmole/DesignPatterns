package util.observable;

public interface Observable<TState> 
{
	public ObserverManager<TState> getObserverManager();
	public TState getState();
}
