
/*
 * Created on 6 dic 2013 ( Time 23:44:41 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.test.pagospolizas;

import java.util.LinkedList;
import java.util.List;

import com.lix.mock.tool.MockValues;
import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.polizas.model.Polizas;
import com.lix.test.clientes.ClientesMock;
import com.lix.test.companias.CompaniasMock;
import com.lix.test.polizas.PolizasMock;
import com.lix.test.secciones.SeccionesMock;

public class PagosPolizasMock {

	private static MockValues mockValues = new MockValues();
	
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public static  PagosPolizas createInstance() {
		Polizas poliza = PolizasMock.createInstance();
		PagosPolizas p = new PagosPolizas();
		// Init Data fields
		p.setFecha(mockValues.nextDate());
		p.setPolizas(poliza);
		p.setConcepto(mockValues.nextString(10));
		p.setFechaVencimiento(mockValues.nextDate());
		p.setImporte(mockValues.nextDouble());
		p.setNroRecibo(mockValues.nextInteger());
		// Init Link fields (if any)
		poliza.setCompanias( CompaniasMock.createInstance() ) ; // Companias 
		// setSecciones( TODO ) ; // Secciones 
		// setPagosPolizas( TODO ) ; // List<PagosCompanias> 
		poliza.setClientes( ClientesMock.createInstance() ) ; // Clientes 
		return p ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public static List<PagosPolizas> createList(int count) {
		List<PagosPolizas> list = new LinkedList<PagosPolizas>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}	
	
}
