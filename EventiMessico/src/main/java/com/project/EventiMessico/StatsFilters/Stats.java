package com.project.EventiMessico.StatsFilters;

import java.util.Arrays;
import java.util.Vector;

import com.project.EventiMessico.model.Event;
import com.project.EventiMessico.model.State;
/**
 * Questa classe ha lo scopo di calcolare le statistiche 
 * 
 * 
 *
 */
public class Stats {
	
	/**
	 * Questo metodo calcola numero di eventi totale di un determinato stato
	 * @param state lo stato 
	 * @return il numero di eventi totale
	 */
	
	public int NumeroTotaleEventi (State state) {
		
		Vector<Event> events = new Vector<Event>();
		
		int eventsnum;
		
		events=state.getEvents();
		
		eventsnum=events.size();
		
		return eventsnum;
		
		/**
		 * Questo metodo calcola il numero di eventi per ogni genre Sport, Arts, Music
		 * 
		 * @param state lo stato 
		 * @return una stringa dove c'e scritto  il numero di eventi di ogni genre 
		 */
	}
	
	public String NumeroEventiConGenere(State state) {
		
		int Sport=0;
		int Arts =0;
		int Music=0;	
		String Genere;
		Vector<Event> events = new Vector<Event>();
		
		events=state.getEvents();
		
		for(int i=0 ;i<events.size();i++) {
			
			if(events.get(i).getClassification().getSegment().equals("Sports"))
				Sport+=1;
			if(events.get(i).getClassification().getSegment().equals("Arts & Theatre"))
				Arts+=1;
			if(events.get(i).getClassification().getSegment().equals("Music"))
				Music+=1;
			}
		
		Genere="Numero eventi Sport"+Sport+"\n\n Numero eventi Arte"+Arts+"\n\n Numero eventi Musica"+Music; 
		
		return Genere;
		
		
	}
	/**
	 * Questo metodo calocla il numero di eventi artistici
	 * @param state lo stato 
	 * @return il numero di eventi
	 */
	
	public int NumeroEventiArts(State state) {
		
		int Arts=0;
		Vector<Event> events = new Vector<Event>();
		
		events=state.getEvents();
		
		for(int i=0 ;i<events.size();i++) {
			
			if(events.get(i).getClassification().getSegment().equals("Arts & Theatre"))
				Arts+=1;
			}
		
		
		return Arts;
		}
	
	/**
	 * Questo metodo calocla il numero di eventi musicali
	 * @param state lo stato 
	 * @return il numero di eventi
	 */
	
	public int NumeroEventiMusic(State state) {
		
		int Music=0;
		Vector<Event> events = new Vector<Event>();
		
		events=state.getEvents();
		
		for(int i=0 ;i<events.size();i++) {
			
			if(events.get(i).getClassification().getSegment().equals("Music"))
				Music+=1;
			}
		
		
		return Music;
	}
	/**
	 * Questo metodo calocla il numero di eventi sportivi
	 * @param state lo stato 
	 * @return il numero di eventi
	 */
	public int NumeroEventiSport(State state) {
		
		int Sport=0;
		Vector<Event> events = new Vector<Event>();
		
		events=state.getEvents();
		
		for(int i=0 ;i<events.size();i++) {
			
			if(events.get(i).getClassification().getSegment().equals("Sports"))
				Sport+=1;
			}
		
		
		return Sport;
		
		
	}
	
	/**
	 * Questo metodo calocla il numero di eventi di ogni mese
	 * @param state lo stato 
	 * @return int [] vettore con il numero di eventi di ogn mese
	 */
	public int [] NumeroEventiMese(State state) {
		int x;
		int gennaio=0,febbraio=0,marzo=0,aprile=0,maggio=0,giugno=0,luglio=0,agosto=0,settembre=0,ottobre=0,novembre=0,dicembre=0;
		
		Vector<String> dati= new Vector<String>();
		
		Vector<Event> events = new Vector<Event>();
		
		events=state.getEvents();
		
		for(int i=0 ;i<events.size();i++) {
			
			dati.add(events.get(i).getDate());
			
		}
		
		
		for(int i=0;i<dati.size();i++) {
			
			for( x=1; x<12;x++){
				
				if(x<10) {
			
					for(int j=1;j<31;j++) {
					
						if(j<10) {
				
							if(dati.get(i).equals("2021-0"+x+"-0"+j)) {
						
							switch (x) {
							case 1: gennaio+=1;break;
							case 2: febbraio+=1;break;
							case 3: marzo+=1;break;
							case 4: aprile+=1;break;
							case 5: maggio+=1;break;
							case 6: giugno+=1;break;
							case 7: luglio+=1;break;
							case 8: agosto+=1;break;
							case 9: settembre+=1;break;
							
							}
						}}
							else {
						
								if(dati.get(i).equals("2021-0"+x+"-"+j)) {
								
								switch (x) {
								case 1: gennaio+=1;break;
								case 2: febbraio+=1;break;
								case 3: marzo+=1;break;
								case 4: aprile+=1;break;
								case 5: maggio+=1;break;
								case 6: giugno+=1;break;
								case 7: luglio+=1;break;
								case 8: agosto+=1;break;
								case 9: settembre+=1;break;
								
								}}}}}
								
					
							 else {
								
								for(int j=1;j<31;j++) {
									
									if(j<10) {
							
										if(dati.get(i).equals("2021-"+x+"-0"+j)) {
										
										switch (x) {	
										case 10: ottobre+=1;break;
										case 11: novembre+=1;break;
										case 12: dicembre+=1;break;
										}
									
									
									}}
										else {
									
											if(dati.get(i).equals("2021-"+x+"-"+j));{
											
											switch (x) {	
											case 10: ottobre+=1;break;
											case 11: novembre+=1;break;
											case 12: dicembre+=1;break;
											}
										}
							
									}
								}
							 }
			
						}
		
					}
		int [] mesi= {gennaio,febbraio,marzo,aprile,maggio,giugno,luglio,agosto,settembre,ottobre,novembre,dicembre};
			
				return mesi;
		
				}
	/**
	 * Questo metodo trova il  mese con il massimo numero di eventi
	 * @param state lo stato 
	 * @return int  il numero massimo tra tutti i mesi
	 */
	 public int  NumeroEventiMassimo(State state) {
		 	
		 	int [] MaxMese= new int [12];
		 	
		 	MaxMese= NumeroEventiMese(state);
		 	
		 	 int max = Arrays.stream(MaxMese).max().getAsInt();
		 	 
		 	 return max;
		 
		 }
	 /**
		 * Questo metodo trova il  mese con il minimo numero di eventi
		 * @param state lo stato 
		 * @return int  il numero minimo tra tutti i mesi
		 */
	 public int  NumeroEventiMinimo(State state) {
		 
		 int [] MinMese= new int [12];
		 	
		 	MinMese= NumeroEventiMese(state);
		 	
		 	 int min= Arrays.stream(MinMese).min().getAsInt();
		 	 
		 	 return min;
		 
		  }
	 /**
		 * Questo metodo trova il  mese con il medio numero di eventi
		 * @param state lo stato 
		 * @return int  il numero medio tra tutti i mesi
		 */
	 public int  NumeroEventiMedio(State state) {
		 
		 int [] MediaMese= new int [12];
	 		
	 	 int media=0;

		 	MediaMese= NumeroEventiMese(state);
		 	
		 	for (int i=0;i<12;i++) {
		 		
		 	media+=MediaMese[i];
		 		
		 	}
		 	
		 	return (media/12);
		 		
	 }
	 
	 /**
		 * Questo metodo trova lo stato con il maggiore numero di eventi
		 * @param list  vettore contente tutti gli stati  
		 * @return String   il nome dello stato con il maggiore numero di eventi 
		 */
	 
	 public String getGlobalMax(State [] list) {
		 
		 int [] max=new int[3];
		 
		 max[0]=NumeroTotaleEventi(list[0]);
		 
		 max[1]=NumeroTotaleEventi(list[1]);
		 
		 max[2]=NumeroTotaleEventi(list[2]);
		 
		 return getNameStateMax(max);
	 	 		

		 
	 }
	 /**
		 * Questo metodo trova lo stato con il minore numero di eventi
		 * @param list  vettore contente tutti gli stati  
		 * @return String   il nome dello stato con il minore numero di eventi 
		 */

	 public String getGlobalMin(State [] list) {
		 
		 
		 int [] min=new int[3];
		 
		 min[0]=NumeroTotaleEventi(list[0]);
		 
		 min[1]=NumeroTotaleEventi(list[1]);
		 
		 min[2]=NumeroTotaleEventi(list[2]);
		 
		 return getNameStateMin(min);
		 
	 }
	 /**
		 * Questo metodo trova lo stato con il maggiore numero di eventi sportivi
		 * @param list  vettore contente tutti gli stati  
		 * @return String   il nome dello stato con il maggiore numero di eventi sportivi
		 */
	 public String getGlobalSportMax(State [] list) {
		 
		 int [] MaxSport=new int[3];
		 
		 MaxSport[0]=NumeroEventiSport(list[0]);
		 
		 MaxSport[1]=NumeroEventiSport(list[1]);
		 
		 MaxSport[2]=NumeroEventiSport(list[2]);
		 
		 return getNameStateMax(MaxSport);
		 
	 }
	 /**
		 * Questo metodo trova lo stato con il maggiore numero di eventi musicali
		 * @param list  vettore contente tutti gli stati  
		 * @return String   il nome dello stato con il maggiore numero di eventi musicali
		 */
	 
 public String getGlobalMusicMax(State [] list) {
		 
		 int [] MaxMusic=new int[3];
		 
		 MaxMusic[0]=NumeroEventiMusic(list[0]);
		 
		 MaxMusic[1]=NumeroEventiMusic(list[1]);
		 
		 MaxMusic[2]=NumeroEventiMusic(list[2]);
		 
		 return getNameStateMax(MaxMusic);
 }
 /**
	 * Questo metodo trova lo stato con il maggiore numero di eventi Artistici
	 * @param list  vettore contente tutti gli stati  
	 * @return String   il nome dello stato con il maggiore numero di eventi Artistici
	 */
 
 public String getGlobalArtsMax(State [] list) {
	 
	 int [] MaxArts=new int[3];
	 
	 MaxArts[0]=NumeroEventiArts(list[0]);
	 
	 MaxArts[1]=NumeroEventiArts(list[1]);
	 
	 MaxArts[2]=NumeroEventiArts(list[2]);
	
	 return getNameStateMax(MaxArts);
}
 
 /**
	 * Questo metodo trova lo stato con il minore numero di eventi sportivi
	 * @param list  vettore contente tutti gli stati  
	 * @return String   il nome dello stato con il minore numero di eventi sportivi
	 */
 public String getGlobalSportMin(State [] list) {
	 
	 int [] MinSport=new int[3];
	 
	 MinSport[0]=NumeroEventiSport(list[0]);
	 
	 MinSport[1]=NumeroEventiSport(list[1]);
	 
	 MinSport[2]=NumeroEventiSport(list[2]);
	 
	 return getNameStateMin(MinSport);
	 
 }
 /**
	 * Questo metodo trova lo stato con il minore numero di eventi musicali
	 * @param list  vettore contente tutti gli stati  
	 * @return String   il nome dello stato con il minore numero di eventi musicali
	 */
 public String getGlobalMusicMin(State [] list) {
	 
	 int [] MinMusic=new int[3];
	 
	 MinMusic[0]=NumeroEventiMusic(list[0]);
	 
	 MinMusic[1]=NumeroEventiMusic(list[1]);
	 
	 MinMusic[2]=NumeroEventiMusic(list[2]);
	 
	 return getNameStateMin(MinMusic);
}
 /**
	 * Questo metodo trova lo stato con il minore numero di eventi Artistici
	 * @param list  vettore contente tutti gli stati  
	 * @return String   il nome dello stato con il minore numero di eventi Artistici
	 */
public String getGlobalArtsMin(State [] list) {
	 
	 int [] MinArts=new int[3];
	 
	 MinArts[0]=NumeroEventiArts(list[0]);
	 
	 MinArts[1]=NumeroEventiArts(list[1]);
	 
	 MinArts[2]=NumeroEventiArts(list[2]);
	
	 return getNameStateMin(MinArts);
}
 
/**
 * Questo metodo aiuta a trovare il nome dello stato con il maggiore numero di eventi in genrale 
 * @param int []  vettore contente tutti gli eventi di un determinato genre o in genrale  
 * @return String   il nome dello stato con il maggiore numero di eventi 
 */

 	public String getNameStateMax(int [] max) {
 		
 		if (max[0]>max[1]) {
 	 		if(max[0]>max[2])
 	 			return "Mexico City and Metropolitan Area";
 	 		else return "Guadalajara";
 	 	} else
 	 	{	
 	 		if (max[1]>max[2])
 	 			return "Monterrey";
 	 		else return "Guadalajara";
 	 	}
 		
 	}
 	/**
 	 * Questo metodo aiuta a trovare il nome dello stato con il minore numero di eventi in genrale 
 	 * @param int []  vettore contente tutti gli eventi di un determinato genre o in genrale  
 	 * @return String   il nome dello stato con il minore numero di eventi 
 	 */
 	public String getNameStateMin(int [] min) {
 		
 		
 		if (min[0]<min[1]) {
 	 		if(min[0]<min[2])
 	 			return "Mexico City and Metropolitan Area";
 	 		else return "Guadalajara";
 	 	} else
 	 	{	
 	 		if (min[1]<min[2])
 	 			return "Monterrey";
 	 		else return "Guadalajara";
 	 	}
 		
 		
 	}
 
 
	}


