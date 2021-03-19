package com.project.EventiMessico.model;


/**
 * Questa classe descrive il prezzo dell'evento
 * @author EbramRezkalla , MorcosMasoud
 *
 */

public class Price {
	

	private double min;
    private double max;

    /**
	 * Costruttore per Price
	 * 
	 * @param min    prezzo minimo
	 * @param max    prezzo massimo
	 
	 */
     
     public Price(double min, double max) {
 		super();
 		this.min = min;
 		this.max = max;
 	}

     /**
 	 * @return min    prezzo minimo
 	 */

	public double getMin() {
		return min;
	}


	/**
 	 * @param min    prezzo minimo
 	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
 	 * @return max    prezzo massimo
 	 */

	public double getMax() {
		return max;
	}


	/**
 	 * @param max    prezzo massimo
 	 */
	public void setMax(double max) {
		this.max = max;
	}
     
     
}


