package com.lix.cliente.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lix.polizas.model.Polizas;

/**
 * Clientes generated by MyEclipse - Hibernate Tools
 */
@Entity
@Table(name = "clientes")
public class Cliente implements java.io.Serializable {

	// Fields
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "dnicuit")
	private String dnicuit;
	@Column(name = "email")
	private String email;
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "f_nacimiento")
	private Date f_nacimiento;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
	private List<Polizas> polizas;

	// Constructors

	/** default constructor */
	public Cliente() {
	}

	/** minimal constructor */
	public Cliente(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Cliente(Long id, String nombre, String apellido, String direccion, String telefono, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// public ClientIdx getClientIdx(){
	// return new ClientIdx(id,nombre,apellido);
	// }

	/**
	 * @return the polizas
	 */
	public List<Polizas> getPolizas() {
		return polizas;
	}

	/**
	 * @param polizas
	 *            the polizas to set
	 */
	public void setPolizas(List<Polizas> polizas) {
		this.polizas = polizas;
	}

	// public void addPoliza(Poliza poliza){
	// poliza.setCliente(this);
	// if(polizas==null)
	// polizas=new LinkedHashSet<Poliza>();
	//
	// if(!polizas.contains(poliza))
	// polizas.add(poliza);
	// }
	// public void removePoliza(Poliza poliza){
	// if(polizas!=null&&polizas.contains(poliza))
	// polizas.remove(poliza);
	// }

	/**
	 * @return the dnicuit
	 */
	public String getDnicuit() {
		return dnicuit;
	}

	/**
	 * @param dnicuit
	 *            the dnicuit to set
	 */
	public void setDnicuit(String dnicuit) {
		this.dnicuit = dnicuit;
	}

	/**
	 * @return the f_nacimiento
	 */
	public Date getF_nacimiento() {
		return f_nacimiento;
	}

	/**
	 * @param f_nacimiento
	 *            the f_nacimiento to set
	 */
	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}