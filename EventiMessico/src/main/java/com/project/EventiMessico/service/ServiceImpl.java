package com.project.EventiMessico.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Vector;

import com.project.EventiMessico.Exception.DateNotValid;
import com.project.EventiMessico.Exception.ParamValueNotValid;
import com.project.EventiMessico.Exception.StateNameNotValid;
import com.project.EventiMessico.StatsFilters.Filters;
import com.project.EventiMessico.StatsFilters.Stats;
import com.project.EventiMessico.model.Event;
import com.project.EventiMessico.model.State;
import com.project.EventiMessico.utilities.EventParser;
import com.project.EventiMessico.utilities.UpdateEventdata;
import com.sun.el.parser.ParseException;


/** Questa classe Ã¨ l'implementazione dell'interfaccia Service.
 * Contiene i metodi che vengono utilizzati dal controller.
 * @author Ebram Rezkalla 
 * @author Morcos Masoud
 */

public class ServiceImpl implements Service{
	
	
	State[] list = new State[3];
	Stats Statistiche = null;
	Filters Filtri=null;


	/**
	 * Questo metodo  restituisce gli eventi di un determinato stato .
	 * @param il nome dello stato .
	 * @return tutti gli eventi riguradanti quel determinato stato.
	 */
public State getStateEvents(String statename) throws StateNameNotValid,  Exception {
		
		DownloadFromFile();
		
		if(!(StateNamecheck(statename))) {
			
			throw new  StateNameNotValid();
			
					
		} else {
		
		int marketID= marketid(statename);
		
		if(marketID==402)
				return list[0];
		else {
			if(marketID==403)
				return list[1];
			else {
				if(marketID==404)
					return list[2];
			}}}
		return null;
			
			
		}
	
/**
 * Questo metodo  restituisce le statistiche di un determinato stato .
 * @param il nome dello stato .
 * @return tutte le statistiche riguradanti quel determinato stato.
 */
public String getStateStats(String statename) throws StateNameNotValid, IOException, ParseException{
	
	DownloadFromFile();
	int Numtot,max,min,medio;
	String genre;
	String genre1;
	if(!(StateNamecheck(statename))) 
		
		throw new  StateNameNotValid();
	
	int marketID= marketid(statename);
		
	if(marketID==402) {
		Numtot= Statistiche.NumeroTotaleEventi(list[0]);
		 genre= Statistiche.NumeroEventiConGenere(list[0]);
		max=Statistiche.NumeroEventiMassimo(list[0]);
		min=Statistiche.NumeroEventiMinimo(list[0]);
		medio= Statistiche.NumeroEventiMedio(list[0]);
		String TotStats="Numero totale di eventi:"+Numtot+"\n\n"+genre+"\n\n Numero massimo di eventi al mese:"+max+"\n\n Numero minimo di eventi al mese:"+min+"\n\n Numero medio di eventi al mese:"+medio;
		return TotStats;
	
	}
else {
	if(marketID==403){
		
		Numtot= Statistiche.NumeroTotaleEventi(list[1]);
		 genre1= Statistiche.NumeroEventiConGenere(list[1]);
		max=Statistiche.NumeroEventiMassimo(list[1]);
		min=Statistiche.NumeroEventiMinimo(list[1]);
		medio= Statistiche.NumeroEventiMedio(list[1]);
		String TotStats="Numero totale di eventi:"+Numtot+"\n\n"+genre1+"\n\n Numero massimo di eventi al mese:"+max+"\n\n Numero minimo di eventi al mese:"+min+"\n\n Numero medio di eventi al mese:"+medio;
		return TotStats;
	
	}
	else {
		if(marketID==404){
			
			Numtot= Statistiche.NumeroTotaleEventi(list[2]);
			 genre1= Statistiche.NumeroEventiConGenere(list[2]);
			max=Statistiche.NumeroEventiMassimo(list[2]);
			min=Statistiche.NumeroEventiMinimo(list[2]);
			medio= Statistiche.NumeroEventiMedio(list[2]);
			String TotStats="Numero totale di eventi:"+Numtot+"\n\n"+genre1+"\n\n Numero massimo di eventi al mese:"+max+"\n\n Numero minimo di eventi al mese:"+min+"\n\n Numero medio di eventi al mese:"+medio;
			return TotStats;
		
		
	}}
}
	return null;
}

/*
 * **
 * Questo metodo  restituisce le statistiche globali di tutto il Messico .
 * @return tutte le statistiche del Messico.
 */
 */

public String getGlobalStats() throws StateNameNotValid, IOException, ParseException{
	
	DownloadFromFile();

	String maxState= Statistiche.getGlobalMax(list);
	
	String minState=Statistiche.getGlobalMin(list);
	
	String maxSport= Statistiche.getGlobalSportMax(list);
	
	String minSport= Statistiche.getGlobalSportMin(list);
	
	String maxArts= Statistiche.getGlobalArtsMax(list);
	
	String minArts=Statistiche.getGlobalArtsMin(list);
	
	String maxMusic=Statistiche.getGlobalMusicMin(list);
	
	String minMusic=Statistiche.getGlobalMusicMin(list);
	
	String AllGlobalStats="Stato con il maggiore numero di eventi:"+maxState+
			
			"\n\n Stato con il minore numero di eventi"+minState+
			"\n\n Stato con il maggiore numero di eventi sportivi:"+maxSport+
			"\n\n Stato con il minore numero di eventi sportivi:"+minSport+
			"\n\n Stato con il maggiore numero di eventi Artistci:"+maxArts+
			"\n\n Stato con il minore numero di eventi Artistici:"+minArts+
			"\n\n Stato con il maggiore numero di eventi Musicali "+maxMusic+
			"\n\n Stato con il minore numero di eventi Musicali "+minMusic;
	
	return AllGlobalStats;
			
}
/*
 * **
 * Questo metodo  che filtra in base a due stati le statistiche sul genre  in un determinato perido scelto dal'utente
 * @param il nome del primo stato .
 * @param il nome del secondo stato.
 * @param il genre 
 * @param la prima data
 * param la seconda data
 * @return  le statistche filtrate.
 */

	public String filter(String s1,String s2, String param , String from, String to ) throws StateNameNotValid, ParamValueNotValid,IOException, ParseException, Exception {
		
			DownloadFromFile();
			if(!(StateNamecheck(s1))) 
				
				throw new  StateNameNotValid();
			if(!(StateNamecheck(s2))) 
				
				throw new  StateNameNotValid();
			
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
			    Date datafrom= format.parse(from);
			    Date datato= format.parse(to);
			
			}
			
			catch (Exception e) {
				throw new DateNotValid();
			}
			
			int marketID1= marketid(s1);
			int marketID2=marketid(s2);
			if(param.equals("Sport_max")) {
				if(marketID1==402 && marketID2==403 ) {
					if(Filtri.SportMax(list[0], list[1], from, to)>0)
						return "Mexico City and Metropolitan Area ha  un numero maggiore di eventi sportivi ripetto a Monterrey nel perido tra "+from+" e "+to;
					else if (Filtri.SportMax(list[0], list[1], from, to)<0)
						return "Monterrey ha un numero maggiore di eventi sportivi ripetto a Mexico City and Metropolitan Area nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi sportivi nel perido tra "+from+" e "+to;
					
				}
				
				if(marketID1==402 && marketID2==404 ) {
					if(Filtri.SportMax(list[0], list[2], from, to)>0)
						return "Mexico City and Metropolitan Area ha un numero maggiore di eventi sportivi ripetto a Guadalajara nel perido tra"+from+" e "+to;
					else if (Filtri.SportMax(list[0], list[2], from, to)<0)
						return "Guadalajara ha un numero maggiore di eventi sportivi ripetto a Mexico City and Metropolitan Area nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi sportivi nel perido tra"+from+" e "+to;
					
				}
				
				if(marketID1==403 && marketID2==404 ) {
					if(Filtri.SportMax(list[1], list[2], from, to)>0)
						return "Monterrey ha un numero maggiore di eventi sportivi ripetto a Guadalajara nel perido tra"+from+" e "+to;
					else if (Filtri.SportMax(list[1], list[2], from, to)<0)
						return "Guadalajara ha un numero maggiore di eventi sportivi ripetto a Monterrey nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi sportivi nel perido tra"+from+" e "+to;
				
			
			}
				
		}
			if(param.equals("Arts_Max")) {
				if(marketID1==402 && marketID2==403 ) {
					if(Filtri.ArtsMax(list[0], list[1], from, to)>0)
						return "Mexico City and Metropolitan Area ha  un numero maggiore di eventi artistici ripetto a Monterrey nel perido tra "+from+" e "+to;
					else if (Filtri.ArtsMax(list[0], list[1], from, to)<0)
						return "Monterrey ha un numero maggiore di eventi artistici ripetto a Mexico City and Metropolitan Area nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi artistici nel perido tra "+from+" e "+to;
					
				}
				
				if(marketID1==402 && marketID2==404 ) {
					if(Filtri.ArtsMax(list[0], list[2], from, to)>0)
						return "Mexico City and Metropolitan Area ha un numero maggiore di eventi Artisci ripetto a Guadalajara nel perido tra"+from+" e "+to;
					else if (Filtri.ArtsMax(list[0], list[2], from, to)<0)
						return "Guadalajara ha un numero maggiore di eventi artistici ripetto a Mexico City and Metropolitan Area nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi artistici nel perido tra"+from+" e "+to;
					
				}
				
				if(marketID1==403 && marketID2==404 ) {
					if(Filtri.ArtsMax(list[1], list[2], from, to)>0)
						return "Monterrey ha un numero maggiore di eventi artistici ripetto a Guadalajara nel perido tra"+from+" e "+to;
					else if (Filtri.ArtsMax(list[1], list[2], from, to)<0)
						return "Guadalajara ha un numero maggiore di eventi artistici ripetto a Monterrey nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi artistici nel perido tra"+from+" e "+to;
				
			
			}
				
		}
			
			
			
			if(param.equals("Music_Max")) {
				if(marketID1==402 && marketID2==403 ) {
					if(Filtri.MusicMax(list[0], list[1], from, to)>0)
						return "Mexico City and Metropolitan Area ha  un numero maggiore di eventi musicali ripetto a Monterrey nel perido tra "+from+" e "+to;
					else if (Filtri.MusicMax(list[0], list[1], from, to)<0)
						return "Monterrey ha un numero maggiore di eventi musicali ripetto a Mexico City and Metropolitan Area nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi musicali nel perido tra "+from+" e "+to;
					
				}
				
				if(marketID1==402 && marketID2==404 ) {
					if(Filtri.MusicMax(list[0], list[2], from, to)>0)
						return "Mexico City and Metropolitan Area ha un numero maggiore di eventi musicali ripetto a Guadalajara nel perido tra"+from+" e "+to;
					else if (Filtri.MusicMax(list[0], list[2], from, to)<0)
						return "Guadalajara ha un numero maggiore di eventi musicali ripetto a Mexico City and Metropolitan Area nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi musicali nel perido tra"+from+" e "+to;
					
				}
				
				if(marketID1==403 && marketID2==404 ) {
					if(Filtri.MusicMax(list[1], list[2], from, to)>0)
						return "Monterrey ha un numero maggiore di eventi musicali ripetto a Guadalajara nel perido tra"+from+" e "+to;
					else if (Filtri.MusicMax(list[1], list[2], from, to)<0)
						return "Guadalajara ha un numero maggiore di eventi musicali ripetto a Monterrey nel perido tra"+from+" e "+to;
					else return "Entrambi gli stati hanno lo stesso numero di eventi musicali nel perido tra"+from+" e "+to;
				
			
			}
				
		} throw new ParamValueNotValid();
	}

		



	/*
	 * **
	 * Questo metodo  salva su un file JSON gli eventi di ogni stato
	 *
	 */
	


public void SaveOnFile() throws IOException
{
	
	
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("data.JSON")));
	
	JSONObject salva = new JSONObject();
	
	UpdateEventdata updateevent;
	salva = updateevent.getStateArray();
	
	JSONArray jsonArray = new JSONArray(Arrays.asList(salva));
	
	jsonArray.toString();
	
	out.println(jsonArray.toJSONString());
	
	out.close();
	
}
/*
 * **
 * Questo metodo  legge  da un file JSON e popola il vettore lista
 *
 */

public void DownloadFromFile() throws IOException, ParseException
{
	Scanner in = new Scanner(new BufferedReader(new FileReader("data.JSON")));
	
	String inputLine = in.nextLine();
	
	JSONParser parser = new JSONParser();
	
	JSONObject salva = (JSONObject) parser.parse(inputLine);
	
	JSONArray state = (JSONArray) slava.get();
		
	for (int i=0; i<state.length(); i++) {
	    list.add(state.getString(i) );
	}
	
}

/*
 * **
 * Questo metodo  per validare il nome dello stato
 *@param name nome dello stato
 *@return boolean tre se il nome dello stato e' giusto altrimenti return false
 */
public boolean StateNamecheck (String name) {
	
	if (name.equals("Mexico City and Metropolitan Area"))
		{ 
		return true;
		}
		else {
			if (name.equals("Monterrey"))
			{
				return true;
			}
			else {
				if (name.equals("Guadalajara"))
				{
					return true;
				} 
				else {
					return false;
				}}}
				
}
/*
 * **
 * Questo metodo  per validare il nome dello stato
 *@param name nome dello stato 
 *@return il Marketid per chiamare API
 */
public int marketid (String name) {
	
	if (name.equals("Mexico City and Metropolitan Area"))
		{ 
		return 402;
		}
		else {
			if (name.equals("Monterrey"))
			{
				return 403;
			}
			else {
				if (name.equals("Guadalajara"))
				{
					return 404;
				} 
				else {
					return 0;
				}}}
				
}
		
		}




