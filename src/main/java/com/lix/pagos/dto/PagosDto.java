/*
 * Created on 14 nov 2013 ( Time 17:20:07 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.lix.pagos.dto;

import java.util.Date;

import com.lix.companias.model.Companias;
import com.lix.polizas.model.Polizas;

/**
 * Dto for "Pagos"
 * 
 * @author Telosys Tools Generator
 * 
 */
public class PagosDto {

	private Integer id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------

	private Date fecha;

	private Double importe;

	private String tipoPago;

	private String concepto;

	private Integer nroRecibo;

	private Date fechaVencimiento;

	private Polizas polizas;

	private Companias companias;

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	// --- DATABASE MAPPING : FECHA ( DATETIME )
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	// --- DATABASE MAPPING : IMPORTE ( DOUBLE )
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImporte() {
		return this.importe;
	}

	// --- DATABASE MAPPING : TIPO_PAGO ( VARCHAR )
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getTipoPago() {
		return this.tipoPago;
	}

	// --- DATABASE MAPPING : CONCEPTO ( VARCHAR )
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getConcepto() {
		return this.concepto;
	}

	// --- DATABASE MAPPING : NRO_RECIBO ( INT )
	public void setNroRecibo(Integer nroRecibo) {
		this.nroRecibo = nroRecibo;
	}

	public Integer getNroRecibo() {
		return this.nroRecibo;
	}

	// --- DATABASE MAPPING : FECHA_VENCIMIENTO ( DATETIME )
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------

	public void setPolizas(Polizas polizas) {
		this.polizas = polizas;
	}

	public Polizas getPolizas() {
		return this.polizas;
	}

	public void setCompanias(Companias companias) {
		this.companias = companias;
	}

	public Companias getCompanias() {
		return this.companias;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	public String toString() {
		return "";
		// return ReflectionToStringBuilder.toString(this);
	}

}