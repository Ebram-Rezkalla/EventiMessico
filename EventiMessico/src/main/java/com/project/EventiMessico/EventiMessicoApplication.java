package com.project.EventiMessico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.EventiMessico.service.Service;
import com.project.EventiMessico.service.ServiceImpl;
import com.project.EventiMessico.utilities.UpdateEventdata;


/**
 * 
 * Classe contenente il metodo main del programma
 * 
 * @author EbramRezkalla , MorcosMasoud
 */


@SpringBootApplication
public class EventiMessicoApplication {
	
	/**
	 * Main dell'applicazione
	 * @param args argomenti passati dall'utente.
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(EventiMessicoApplication.class, args);
		
		UpdateEventdata Update = new UpdateEventdata(10800000);
		Update.run();
		
		
	}

}
