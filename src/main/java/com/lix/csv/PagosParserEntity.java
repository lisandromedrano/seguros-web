package com.lix.csv;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lix.companias.model.Companias;
import com.lix.pagos.model.Pagos;
import com.lix.polizas.model.Polizas;

public class PagosParserEntity extends Pagos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Companias companias;

	private Integer nroRecibo;

	private Polizas polizas;

	private String tipoPago;

	public Companias getCompanias() {
		return companias;
	}

	public void setCompanias(Companias companias) {
		this.companias = companias;
	}

	public Integer getNroRecibo() {
		return nroRecibo;
	}

	public void setNroRecibo(Integer nroRecibo) {
		this.nroRecibo = nroRecibo;
	}

	public Polizas getPolizas() {
		return polizas;
	}

	public void setPolizas(Polizas polizas) {
		this.polizas = polizas;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
