package com.lix.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lix.util.JsonDateSerializer;

public class PolizaDto {
	private Long id;
	private int orden;
	private String nroPoliza;
	private String riesgoACubrir;
	private String bienACubrir;
	private String observaciones;
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date vigenciaDesde;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getNroPoliza() {
		return nroPoliza;
	}

	public void setNroPoliza(String nroPoliza) {
		this.nroPoliza = nroPoliza;
	}

	public String getRiesgoACubrir() {
		return riesgoACubrir;
	}

	public void setRiesgoACubrir(String riesgoACubrir) {
		this.riesgoACubrir = riesgoACubrir;
	}

	public String getBienACubrir() {
		return bienACubrir;
	}

	public void setBienACubrir(String bienACubrir) {
		this.bienACubrir = bienACubrir;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getVigenciaDesde() {
		return vigenciaDesde;
	}

	public void setVigenciaDesde(Date vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

}
