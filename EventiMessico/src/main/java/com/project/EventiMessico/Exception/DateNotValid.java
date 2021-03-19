package com.project.EventiMessico.Exception;

public class DateNotValid  extends Exception{
	/**
	 * Costruttore per DateNotValid
	 */
	public DateNotValid() {
		super("La Data non valida utilizzare questa forma [yyyy-mm-dd]");
	}

}
