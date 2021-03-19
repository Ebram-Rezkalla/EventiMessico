package com.project.EventiMessico.utilities;

import java.util.TimerTask;
import com.project.EventiMessico.model.State;
import com.project.EventiMessico.service.ServiceImpl;

/**
 * Questa classe ha lo scopo di aggiornare i dati di ogni stato ogni tre ore dal sito Ticketmaster
 *
 */



public class UpdateEventdata  extends TimerTask {
	
	private State [] StateArray= new State [3]; 
	private long finale=10800000; /*tre ore*/
	EventParser eventparser;
	
	/**
	 * Costruttore per UpdateEventdata
	 * 
	 * @param  Durata di aggiornamento e aggiunta dei nuovi dati in millisecondi
	 */
	public UpdateEventdata(long delay) {
		super();
		
		this.finale = System.currentTimeMillis()+delay;
	}
	
	
	/**
	 * questo metodo aggiorna i dati
	 * 
	 * 
	 **/
	@Override
	public void run() {
		
		if(System.currentTimeMillis() < this.finale)
		{
			State MexicoCity = new State ("Mexico City and Metropolitan Area", 402,eventparser.callEvents(402)));
				
			State Monterrey = new State ("Monterrey",403,eventparser.callEvents(403));		
			
			State Guadalajara = new State ("Guadalajara",404,eventparser.callEvents(404));
			
			State [] StateArray= { MexicoCity, Monterrey,Guadalajara};
			ServiceImpl service ;
			service.SaveOnFile();
		}
		else
			this.cancel();
	}
	/**
	 * 
	 * @return State [] vettore di stati
	 */
	public State[] getStateArray() {
		return StateArray;
		
	}
	
	


}
