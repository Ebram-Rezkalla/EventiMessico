package com.project.EventiMessico.testStatsFilters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.EventiMessico.StatsFilters.Filters;
import com.project.EventiMessico.model.Classification;
import com.project.EventiMessico.model.Event;
import com.project.EventiMessico.model.Price;
import com.project.EventiMessico.model.State;
/**
 * Questa classe ha lo scopo di testare i metodi della classe Filters
 *
 */
public class TestFilter {
	
		private Filters filtri;
		private State Stato1, Stato2;
		String from ;
		String to;
		Vector<Event> events1 = new Vector<Event>();
		Vector<Event> events2 = new Vector<Event>();
		private Event event, event1,event2;
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
			event1= new Event("Abierto", "17AZvbG62X1NsqR", "https://www.ticketmaster.com.mx/abierto-mexicano-de-tenis-miercoles-acapulco-guerrero-03-17-2021/event/140058FF8A8F176F","2021-04-17" , "18:00:00",classification , price);
			event2= new Event("Abierto", "17AZvbG62X1NsqR", "https://www.ticketmaster.com.mx/abierto-mexicano-de-tenis-miercoles-acapulco-guerrero-03-17-2021/event/140058FF8A8F176F","2021-05-17" , "18:00:00",classification , price);
			events1.set(0, event);
			events1.set(1, event1);
			events2.set(0, event);
			Stato1 = new State("Monterrey", 403, events1 );
			Stato2= new State("Guadalajara",404,events2);
			from="2021-01-17";
			to="2021-07-17";
		}

		@AfterEach
		void tearDown() throws Exception {
		}
		/**
	     * Questo Test verifica se numero di eventi sportivi e' giusto.
	     */
		@Test
		void testConfrontaData() throws Exception {
			assertEquals(1,filtri.SportMax(Stato1, Stato2, from, to));

		}
		
		
	}

