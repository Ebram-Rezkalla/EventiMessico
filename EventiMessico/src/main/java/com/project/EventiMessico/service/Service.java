package com.project.EventiMessico.service;

import java.io.IOException;

import com.project.EventiMessico.Exception.ParamValueNotValid;
import com.project.EventiMessico.Exception.StateNameNotValid;
import com.project.EventiMessico.model.State;
import com.sun.el.parser.ParseException;


/** Questa classe e' l'interfaccia di ServiceImpl e contiene i metodi richiamati dal Controller.
 * @author Ebram Rezkalla 
 * @author Morcos Masoud
 */
public interface Service {
	
	public abstract State getStateEvents(String statename) throws StateNameNotValid, IOException, Exception ;
	
	public abstract void SaveOnFile() throws IOException ;
	
	public abstract void DownloadFromFile() throws IOException, ParseException;
	
	public abstract String getStateStats(String statename) throws StateNameNotValid, IOException, ParseException;
	
	public String getGlobalStats() throws StateNameNotValid, IOException, ParseException;
	
	public String filter(String s1,String s2, String param , String from, String to ) throws StateNameNotValid, ParamValueNotValid,IOException, ParseException, Exception ;
	
	public boolean StateNamecheck (String name);
	
	public int marketid (String name);
}
