package com.project.EventiMessico.model;

/**
 * Questa classe descrive le classificazioni di ogni evento 
 * @author EbramRezkalla , MorcosMasoud
 *
 */


public class Classification {
	
	private String segment;
	private String genre;
	
	/**
	 * costruttore della classe Classification
	 * @param segment  la classifica dell' evento 
	 *@param genre     il genre dell'evento
	 */
	
	public Classification(String segment, String genre) {
		super();
		this.segment = segment;
		this.genre = genre;
	}
/*
 * @return segment  la classifica dell' evento 
 * 
 */
	public String getSegment() {
		return segment;
	}
/*
 * 
 * @param segment  la classifica dell' evento 
 * 
 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
/*
 * 
 * 	 *@return genre     il genre dell'evento

 * 
 */
	public String getGenre() {
		return genre;
	}
/*
 * 
 * 
 * 	@param genre     il genre dell'evento

 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	
}
