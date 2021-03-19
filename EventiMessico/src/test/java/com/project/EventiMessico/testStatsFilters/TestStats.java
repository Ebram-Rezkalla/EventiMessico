package com.project.EventiMessico.testStatsFilters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.EventiMessico.StatsFilters.Stats;
import com.project.EventiMessico.model.Classification;
import com.project.EventiMessico.model.Event;
import com.project.EventiMessico.model.Price;
import com.project.EventiMessico.model.State;
/**
 * Questa classe ha lo scopo di testare i metodi della classe Stats
 *
 */


public class TestStats {
	
	private Stats stats;
	
	private State Stato;
	Vector<Event> events = new Vector<Event>();
	private Event event, event1;
	private Price price;
	private Classification classification;
	

	/**
     * Inizializza i componenti necessari a testare i metodi.
     * @throws Exception
     */
	
	@BeforeEach
	void setUp() throws Exception {
		
		price=new Price(990.0, 1760.0);
		classification= new Classification("Sport", "Tennis");
		event= new Event("Abierto", "17AZvbG62X1NsqR", "https://www.ticketmaster.com.mx/abierto-mexicano-de-tenis-miercoles-acapulco-guerrero-03-17-2021/event/140058FF8A8F176F","2021-03-17" , "18:00:00",classification , price);
		event1= new Event("Abierto", "17AZvbG62X1NsqR", "https://www.ticketmaster.com.mx/abierto-mexicano-de-tenis-miercoles-acapulco-guerrero-03-17-2021/event/140058FF8A8F176F","2021-03-23" , "18:00:00",classification , price);
		events.set(0, event);
		events.set(1, event1);
		Stato = new State("Monterrey", 403, events );
	}

	@AfterEach
	void tearDown() throws Exception {
	}
/**
 * 
 * Questo testa se il numero totale di eventi di un determinato stato e' corretto;
 */
	@Test
	void testConfrontaData() throws Exception {
		assertEquals(2,stats.NumeroTotaleEventi(Stato));

	}

}
