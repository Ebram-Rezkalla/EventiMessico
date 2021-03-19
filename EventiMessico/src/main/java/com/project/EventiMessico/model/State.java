
package com.project.EventiMessico.model;

import java.util.Vector;

/**
 * Questa classe descrive le proprieta'  di ogni stato
 * @author EbramRezkalla , MorcosMasoud
 *
 */
public class State {

	private String name;
	private int id;
	private Vector<Event> events = new Vector<Event>();
	
	
	
	/**
	 * Costruttore per state
	 * 
	 * @param name   nome dello stato
	 * @param id        Codice dello stato
	 * @param Event	    Vettore della classe Event che contiene informazioni di ogni evento. 
	 */
	public State (String name, int id , Vector<Event> vector)
	{
		this.name = name;
		this.id = id;
		this.events = vector;
	}

	/**
	 * @return name   nome dello stato
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name   nome dello stato
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return id   id dello stato
	 */

	public int getId() {
		return id;
	}

	/**
	 * @param id   id dello stato
	 */
		
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return events  eventi dello stato
	 */

	public Vector<Event> getEvents() {
		return events;
	}

	/**
	 * @param events  eventi dello stato
	 */

	public void setEvents(Vector<Event> events) {
		this.events = events;
	}

}


