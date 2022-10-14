package util.observable;

@FunctionalInterface
public interface Observer<TState> 
{
	public void stateChanged(Observable<TState> observable, TState newState);

}
