package com.project.EventiMessico.StatsFilters;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.project.EventiMessico.model.Event;
import com.project.EventiMessico.model.State;

/*
 * Questa classe ha lo scopo di filtirare 
 */
public class Filters {

	State stato;


	
	/**
	 * Questo metodo calcola il numero maggiore di eventi sportivi tra due stati
	 * @param State1 il primo stato
	 * @param State2 il secondo stato
	 * @param la data di inizio 
	 * @param la data di fine 
	 * @return 1 se il numero di eventi sportivi del primo stato e' maggiore rispetto al secondo e return 0 se sono uguali e return -1 altrimenti.
	 * 
	 **/
	public int  SportMax(State s1, State s2, String From , String to ) throws ParseException {
		
		Vector<Event> eventS1 = new Vector<Event>();
		
		Vector<Event> eventS2 = new Vector<Event>();
		
		Vector<Event> eventS1sports= new Vector<Event>();
		
		Vector<Event> eventS2sports= new Vector<Event>();
		
		eventS1= s1.getEvents();
		eventS2= s2.getEvents();
	    
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    
	    Date datafrom= format.parse(From);
		
	    Date datato=format.parse(to);
		
		int Stato1=0,Stato2=0;
		
		for(int i=0; i< eventS1.size();i++) {
			
			if (eventS1.get(i).getClassification().getSegment().equals("Sports"))
				eventS1sports.add(eventS1.get(i));
			}
		
		for(int i=0; i< eventS1sports.size();i++) {
			Date data= format.parse(eventS1sports.get(i).getDate());
					
			if (data.compareTo(datafrom)>0 && data.compareTo(datato)<0 )
				Stato1+=1;
			}
		
		
		for(int i=0; i< eventS2.size();i++) {
			
			if (eventS2.get(i).getClassification().getSegment().equals("Sports"))
				eventS2sports.add(eventS2.get(i));
			}
		
		for(int i=0; i< eventS2sports.size();i++) {
			Date data= format.parse(eventS2sports.get(i).getDate());
					
			if (data.compareTo(datafrom)>0 && data.compareTo(datato)<0 )
				Stato2+=1;
			}
		
		if (Stato1>Stato2)
			return 1; 
		else if (Stato1==Stato2)
			return 0;
		else return -1; 
		
		/**
		 * Questo metodo calcola il numero maggiore di eventi artistici tra due stati
		 * @param State1 il primo stato
		 * @param State2 il secondo stato
		 * @param la data di inizio 
		 * @param la data di fine 
		 * @return 1 se il numero di eventi sportivi del primo stato e' maggiore rispetto al secondo e return 0 se sono uguali e return -1 altrimenti.
		 * 
		 **/
	}
	
public int  ArtsMax(State s1, State s2, String From , String to ) throws ParseException {
		
		Vector<Event> eventS1 = new Vector<Event>();
		
		Vector<Event> eventS2 = new Vector<Event>();
		
		Vector<Event> eventS1Arts= new Vector<Event>();
		
		Vector<Event> eventS2Arts= new Vector<Event>();
		
		eventS1= s1.getEvents();
		eventS2= s2.getEvents();
	    
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    
	    Date datafrom= format.parse(From);
		
	    Date datato=format.parse(to);
		
		int Stato1=0,Stato2=0;
		
		for(int i=0; i< eventS1.size();i++) {
			
			if (eventS1.get(i).getClassification().getSegment().equals("Arts & Theatre"))
				eventS1Arts.add(eventS1.get(i));
			}
		
		for(int i=0; i< eventS1Arts.size();i++) {
			Date data= format.parse(eventS1Arts.get(i).getDate());
					
			if (data.compareTo(datafrom)>0 && data.compareTo(datato)<0 )
				Stato1+=1;
			}
		
		
		for(int i=0; i< eventS2.size();i++) {
			
			if (eventS2.get(i).getClassification().getSegment().equals("Arts & Theatre"))
				eventS2Arts.add(eventS2.get(i));
			}
		
		for(int i=0; i< eventS2Arts.size();i++) {
			Date data= format.parse(eventS2Arts.get(i).getDate());
					
			if (data.compareTo(datafrom)>0 && data.compareTo(datato)<0 )
				Stato2+=1;
			}
		
		if (Stato1>Stato2)
			return 1; 
		else if (Stato1==Stato2)
			return 0;
		else return -1; 
		
	}

/**
 * Questo metodo calcola il numero maggiore di eventi musicali tra due stati
 * @param State1 il primo stato
 * @param State2 il secondo stato
 * @param la data di inizio 
 * @param la data di fine 
 * @return 1 se il numero di eventi sportivi del primo stato e' maggiore rispetto al secondo e return 0 se sono uguali e return -1 altrimenti.
 * 
 **/

public int  MusicMax(State s1, State s2, String From , String to ) throws ParseException {
	
	Vector<Event> eventS1 = new Vector<Event>();
	
	Vector<Event> eventS2 = new Vector<Event>();
	
	Vector<Event> eventS1Music= new Vector<Event>();
	
	Vector<Event> eventS2Music= new Vector<Event>();
	
	eventS1= s1.getEvents();
	eventS2= s2.getEvents();
    
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    Date datafrom= format.parse(From);
	
    Date datato=format.parse(to);
	
	int Stato1=0,Stato2=0;
	
	for(int i=0; i< eventS1.size();i++) {
		
		if (eventS1.get(i).getClassification().getSegment().equals("Music"))
			eventS1Music.add(eventS1.get(i));
		}
	
	for(int i=0; i< eventS1Music.size();i++) {
		Date data= format.parse(eventS1Music.get(i).getDate());
				
		if (data.compareTo(datafrom)>0 && data.compareTo(datato)<0 )
			Stato1+=1;
		}
	
	
	for(int i=0; i< eventS2.size();i++) {
		
		if (eventS2.get(i).getClassification().getSegment().equals("Music"))
			eventS2Music.add(eventS2.get(i));
		}
	
	for(int i=0; i< eventS1Music.size();i++) {
		Date data= format.parse(eventS2Music.get(i).getDate());
				
		if (data.compareTo(datafrom)>0 && data.compareTo(datato)<0 )
			Stato2+=1;
		}
	
	if (Stato1>Stato2)
		return 1; 
	else if (Stato1==Stato2)
		return 0;
	else return -1; 
	
}


}
	