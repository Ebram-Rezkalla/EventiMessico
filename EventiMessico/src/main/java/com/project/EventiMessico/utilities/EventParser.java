package com.project.EventiMessico.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.project.EventiMessico.model.Classification;
import com.project.EventiMessico.model.Event;
import com.project.EventiMessico.model.Price;
import com.sun.el.parser.ParseException;

import it.ldaac.meteoOOP.exceptions.BadRequestException;

/**
 * questa classe permette di richiamare l'API di ticketmaster per ottenere i dati riguardanti gli stati
 *  
 * @author EbramRezkalla , MorcosMasoud
 *
 */
public class EventParser  {
	
	private String  URL = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=9tikNZcknH9McxMSRlHAdgSIwWDDooAC";
	
	private int MarketId;
	
	/**
	 * Costruttore per Eventparser
	 * 
	 * @param marketid id dello stato che sara' usato per le chiamate verso ticketmaster
	 *
	 */
	public EventParser(int marketId) {
		super();
		MarketId = marketId;
	}
/**
 * 
 * 
 * @return marketid id dello stato che sara' usato per le chiamate verso ticketmaster
 */
	public int getMarketId() {
		return MarketId;
	}

	/**
	 * 
	 * 
	 * param marketid id dello stato che sara' usato per le chiamate verso ticketmaster
	 */
	
	public void setMarketId(int marketId) {
		MarketId = marketId;
	}
	
	/**
	 * Metodo che restituisce un vettore di eventi con le proprie informazioni 
	 * 
	 * @param marketid  id dello stato
	 * @return Vector<Event> un vector di eventi 
	 */

	public Vector<Event> callEvents (int marketid) throws ParseException, BadRequest, MalformedURLException, IOException
	{
		JSONParser parser = new JSONParser(null);
		
		Vector<Event> getback = new Vector<Event>();
				
		URLConnection ticketmaster = new URL(this.URLGenerator(marketid)).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(ticketmaster.getInputStream()));
		
		String inputLine = in.readLine();
		
		JSONObject response = (JSONObject)parser.parse(inputLine);
			
		JSONArray EventsArray = (JSONArray) response.get("events");
		
		for(int i=0; i<EventsArray.size(); i++)
		{
			JSONObject event = (JSONObject) EventsArray.get(i);
			
			String name=(String) event.get("name");
			String id=(String) event.get("id");
			String url=(String) event.get("url");
			
			JSONObject dates = (JSONObject) event.get("dates");	
			
			String date=(String) event.get("localDate");
			String time=(String) event.get("localTime");
			
			JSONObject price = (JSONObject) event.get("priceRanges");
			
			double min = Double.parseDouble(price.get("min").toString());
			double max = Double.parseDouble(price.get("max").toString());
			
			Price priceobj= new Price(min,max);
			
			JSONObject classification = (JSONObject) event.get("classifications");
			
			String segmentname=(String) classification.segment.get("name");
			String genrename=(String) classification.genre.get("name");
			
			Classification classificationobj = new Classification(segmentname,genrename);
			

			Event evento = new Event(name, id, url, date,time, classificationobj, priceobj );
							
			getback.add(evento);
		}
	return getback;
}
	/**
	 * Genera l'URL per chimare l'API di ticketmaster 
	 * 
	 * @param marketid id dello stato
	 * @return URL sotto forma di stringa per chiamare l'API di ticketmaster
	 */
	public String URLGenerator( int marketid )
	{
		URL += ("&marketid=" + marketid);
		return URL;
	}

}
