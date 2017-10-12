package com.lix.polizas.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lix.dto.PaginationParams;
import com.lix.util.JsonDateSerializer;

public class PolizasPorVencerDto extends PaginationParams {
	String fileName;
	@JsonSerialize(using = JsonDateSerializer.class)
	Date fechaDesde;
	@JsonSerialize(using = JsonDateSerializer.class)
	Date fechaHasta;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}
