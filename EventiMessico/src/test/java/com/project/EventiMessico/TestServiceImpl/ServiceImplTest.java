package com.project.EventiMessico.TestServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.EventiMessico.model.State;
import com.project.EventiMessico.service.ServiceImpl;

/**
 * Questa classe ha lo scopo di testare i metodi di ServiceImplTest
 *
 */
public class ServiceImplTest {
	
	String statename;
	ServiceImpl service;
	State state;
	
	/**
     * Inizializza i componenti necessari per testare i metodi.
     * @throws Exception
     */
	@BeforeEach
	void setUp() throws Exception {
		statename="Monterrey";
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	/** testa il metodo getStateEvents **/
	@Test
	void testConfrontaData() throws Exception {
		assertEquals(state.getName()=="Monterrey",service.getStateEvents(statename));

	}

	
	
	

}
