package com.lix.dto;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.lix.util.JsonDateSerializer;

public class ClienteDto {

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String dnicuit;
	private String email;
	private String observaciones;
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date f_nacimiento;
	private List<PolizaDto> polizas;

	// private Set polizas;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDnicuit() {
		return dnicuit;
	}

	public void setDnicuit(String dnicuit) {
		this.dnicuit = dnicuit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getF_nacimiento() {
		return f_nacimiento;
	}

	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	public List<PolizaDto> getPolizas() {
		return polizas;
	}

	public void setPolizas(List<PolizaDto> polizas) {
		this.polizas = polizas;
	}
}
