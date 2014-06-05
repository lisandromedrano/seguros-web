/*
 * Created on 14 nov 2013 ( Time 17:20:05 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.lix.companias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lix.polizas.model.Polizas;

/**
 * Persistent class for entity stored in table "companias"
 * 
 * @author Telosys Tools Generator
 * 
 */

@Entity
@Table(name = "companias" )
public class Companias implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Column(name = "NOMBRE", length = 30)
	private String nombre;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------
	// @OneToMany(mappedBy = "companias", targetEntity = Pagos.class)
	// private List<Pagos> pagos;

	@OneToMany(mappedBy = "companias", targetEntity = Polizas.class)
	private List<Polizas> polizas;

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public Companias() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : NOMBRE ( VARCHAR )
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		return "";
		// return ReflectionToStringBuilder.toString(this);
	}

	// public List<Pagos> getPagos() {
	// return pagos;
	// }
	//
	// public void setPagos(List<Pagos> pagos) {
	// this.pagos = pagos;
	// }

	public List<Polizas> getPolizas() {
		return polizas;
	}

	public void setPolizas(List<Polizas> polizas) {
		this.polizas = polizas;
	}

}
