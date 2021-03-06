/*
 * Created on 14 nov 2013 ( Date ISO 2013-11-14 - Time 17:18:40 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.persistence.commons.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * JPA operation interface
 * Provided by Telosys Tools for JPA testing
 *
 */
public interface JpaOperation {

	/**
	 * Executes a JPA operation using the given EntityManager
	 * @param em the EntityManager to be used
	 * @return
	 * @throws PersistenceException
	 */
	public Object exectue(EntityManager em) throws PersistenceException;
	
}
