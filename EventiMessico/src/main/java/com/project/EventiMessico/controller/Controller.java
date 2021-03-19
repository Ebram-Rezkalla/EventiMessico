
package com.project.EventiMessico.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.project.EventiMessico.Exception.DateNotValid;
import com.project.EventiMessico.Exception.ParamValueNotValid;
import com.project.EventiMessico.Exception.StateNameNotValid;
import com.project.EventiMessico.StatsFilters.Filters;
import com.project.EventiMessico.service.ServiceImpl;
import com.sun.el.parser.ParseException;




/**
 * Questa classe gestisce tutte le chiamate al server che il client puo' richiedere
 * @author EbramRezkalla , MorcosMasoud
 *
 */
@RestController
public class Controller {
	// service su quale si basa il programma
	@Autowired
	ServiceImpl service;
	
	/**
	 * Rotta per cercare gli eventi di un determinato stato passato dall'utente
	 * 
	 * @param body contiene il nome dello stato passato dall'utente
	 * @return gli eventi dello stato passato
	 * @throws oParseException Se il parsing genera errori
	 * @throws BadRequest Se la richiesta all'API di Ticketmaster non va a buon fine
	 * @throws IOException per gli errori di scrittura e lettura da file
	 * @throws StateNameNotValid se il nome dello stato non valido
	 */
	
	@PostMapping(value="/StateEvents")
    public ResponseEntity<Object> getStateEvents (@RequestBody String body) 
    		throws  StateNameNotValid, IOException, BadRequest,ParseException {
		
		JSONObject request = new JSONObject(body);

		String stateName = request.getString("State");

		return new ResponseEntity<> (service.getStateEvents(stateName).toString(), HttpStatus.OK);
        
        }
	
	/**
	 * Rotta per le statistiche di ogni stato
	 * 
	 * @param body contiene il nome dello stato passato dall'utente
	 * @return tutte le statistiche riguardanti quel determinato stato
	 * @throws ParseException Se il parsing del body genera eccezioni
	 * @throws BadRequest Se la richiesta all'API di Ticketmaster non va a buon fine
	 * @throws IOException per gli errori di scrittura e lettura da file
	 * @throws StateNameNotValid se il nome dello stato non valido
	 */
	
	@PostMapping(value="/StateStatistic")
    public ResponseEntity<String> getStateStatistics (@RequestBody String body) 
    		throws  StateNameNotValid, IOException, BadRequest,ParseException {
		
		JSONObject request = new JSONObject(body);

		String stateName = request.getString("State");

		return new ResponseEntity<> (service.getStateStats(stateName), HttpStatus.OK);
        
        }
	
	/**
	 * Rotta per le statistiche globali del Messico
	 * 
	 * @return tutte le statistiche del Messico
	 * @throws ParseException Se il parsing del body genera eccezioni
	 * @throws BadRequest Se la richiesta all'API di Ticketmaster non va a buon fine
	 * @throws IOException per gli errori di scrittura e lettura da file
	 */
	
	@GetMapping(value="/MexicoStatistics")
    public ResponseEntity<String> getMexicoStatistics() throws   IOException, BadRequest,ParseException {
		
		String Stats = service.getGlobalStats();
		
		return new ResponseEntity<> (Stats, HttpStatus.OK);
    }
	
	/**
	 * Rotta che filtra in base a due stati le statistiche sul genre  in un determinato perido scelto dal'utente  
	 * 
	 * L'utente deve inserire :
	 * 
	 * {
     *     "Stati": [
     *        {
     *          "name1": "Mexico City and Metropolitan Area"
     *        },
     *        {
     *          "name2": "Monterrey"
     *        }
     *        ],
     *     "genre": "Sport",
     *     "from":"2021-03-17",
     *     "to":"2021-08-17"
     *     
     *  }
	 * 
	 * @param come sopra indicato.
	 * @return le statistche filtrate.  
	 * @throws StateNameNotValid se il nome dello stato non valido
	 * @throws IOException se ci sono errori di input da file.
	 * @throws  ParseException Se il parsing del body genera eccezioni
	 * @throws BadRequest Se la richiesta all'API di Ticketmaster non va a buon fine
	 * @throws ParamValueNotValid se il genre non e' valido.
	 * @throws DateNotValid se le date forniti dall'untete non sono valide
	 */
	
	
	@PostMapping("/filters")
	public ResponseEntity<String> Filters(@RequestBody String body)
			
			throws  StateNameNotValid, IOException, BadRequest,ParseException, ParamValueNotValid,DateNotValid {
		
		JSONObject object = new JSONObject(body);
        JSONArray array = new JSONArray();

 

        array = object.getJSONArray("Stati");
        
        
        String name1 = object.getString("name1");
        String name2 = object.getString("name2");
        String param = object.getString("genre");
        String from = object.getString("from");
        String to = object.getString("to");		
        
        
		
		try {
        	return new ResponseEntity<>(service.filter(name1, name, param, from, to),HttpStatus.OK);
        }
		catch(Exception e) {
	        	return new ResponseEntity<>(StateNameNotValid(),HttpStatus.BAD_REQUEST);
	        }
		catch(Exception e) {
        	return new ResponseEntity<>(ParamValueNotValid(),HttpStatus.BAD_REQUEST);
        }
		catch(Exception e) {
        	return new ResponseEntity<>(DateNotValid(),HttpStatus.BAD_REQUEST);
        }
		
		
	}
	
	

	
	}
