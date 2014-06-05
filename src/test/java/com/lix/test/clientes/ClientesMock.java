
/*
 * Created on 7 dic 2013 ( Time 00:03:55 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.test.clientes;

import java.util.LinkedList;
import java.util.List;

import com.lix.clientes.model.Clientes;
import com.lix.mock.tool.MockValues;

public class ClientesMock {

	private static MockValues mockValues = new MockValues();
	
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public static  Clientes createInstance() {
		Clientes entity = new Clientes();

		// Init Data fields
		entity.setNombre( mockValues.nextString(30) ) ; // java.lang.String 
		entity.setApellido( mockValues.nextString(30) ) ; // java.lang.String 
		entity.setDireccion( mockValues.nextString(100) ) ; // java.lang.String 
		entity.setTelefono( mockValues.nextString(30) ) ; // java.lang.String 
		entity.setEmail( mockValues.nextString(30) ) ; // java.lang.String 
		entity.setObservaciones( mockValues.nextString(100) ) ; // java.lang.String 
		entity.setFNacimiento( mockValues.nextDate() ) ; // java.util.Date 
		entity.setDnicuit( mockValues.nextString(30) ) ; // java.lang.String 
		// Init Link fields (if any)
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public static List<Clientes> createList(int count) {
		List<Clientes> list = new LinkedList<Clientes>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}	
	
}
