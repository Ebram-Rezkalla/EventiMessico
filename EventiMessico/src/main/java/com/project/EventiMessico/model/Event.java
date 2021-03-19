package com.project.EventiMessico.model;

/**
 * Questa classe descrive le proprieta'  di ogni evento
 * @author EbramRezkalla , MorcosMasoud
 *
 */
public class Event {
	private String name;
	private String id;
	private String url;
	private String Date;
	private String Time;
	private Price price;
	private Classification classification;
	
	/**
	 * Costruttore per event
	 * 
	 * @param name   nome dell'evento
	 * @param id        Codice dell'evento
	 * @param url	    il sito dell'evento 
	 * @param date		data dell'evento
	 * @param time		l'orario dell'evento
	 * @param Classification classe Classification che contiene le classifiche dell'evento
	 * @param  price			il prezzo dell'evento 
	 */
	public Event(String name, String id, String url, String date, String time, Classification classification,
			Price price) {
		super();
		this.name = name;
		this.id = id;
		this.url = url;
		this.Date = date;
		this.Time = time;
		this.classification = classification;
		this.price = price;
	}
	/**
	 * 
	 * @param name   nome dell'evento
	 * @param id        Codice dell'evento
	 * @param url	    il sito dell'evento 
	 * @param date		data dell'evento
	 * @param time		l'orario dell'evento
	 * @param Classification classe Classification che contiene le classifiche dell'evento
	 * @para  price			il prezzo dell'evento 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name   nome dell'evento
	 * */
	public void setName(String name) {
		this.name = name;
	}
    /** * @param id        Codice dell'evento
     **/
	public String getId() {
		return id;
	}
	/** * @return id        Codice dell'evento
     **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return url	il sito dell'evento 
	 */
	public String getUrl() {
		return url;
	}
/*
 * 
 * @param url	il sito dell'evento 
 * 
 */
	public void setUrl(String url) {
		this.url = url;
	}
	/*
	 * 
	 * @return date		data dell'evento
	 */

	public String getDate() {
		return Date;
	}
	/*
	 * 
	 * @param date		data dell'evento
	 */
	public void setDate(String date) {
		Date = date;
	}
	/*
	 * 
	 * @return time		l'orario dell'evento
	 */
	public String getTime() {
		return Time;
	}
/*
 * @param time		l'orario dell'evento
 * 
 */
	public void setTime(String time) {
		Time = time;
	}
/*
 * * @return Classification classe Classification che contiene le classifiche dell'evento
 * 
 */
	public Classification getClassification() {
		return classification;
	}
/*
 * 
 * * @param Classification classe Classification che contiene le classifiche dell'evento
 * 
 */
	public void setClassification(Classification classification) {
		this.classification = classification;
	}
/*
 *  * @return  price			il prezzo dell'evento 
 * 
 */
	public Price getPrice() {
		return price;
	}
	/*
	 *  * @param  price			il prezzo dell'evento 
	 * 
	 */
	public void setPrice(Price price) {
		this.price = price;
	}
	
	
	
	
	
	
}
