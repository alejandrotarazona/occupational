package com.hxplus.occupational.request;

public class UserRequest {

	private Long id;
	private Long ci;
	private Long rif;
	private String primerNombre;
	private String primerApellido;
	private String direccionHabitacion;
	private String nroTelefono;
	private String email;

	public Long getId() {
		return id;
	}

	public Long getCi() {
		return ci;
	}

	public Long getRif() {
		return rif;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getDireccionHabitacion() {
		return direccionHabitacion;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCi(Long ci) {
		this.ci = ci;
	}

	public void setRif(Long rif) {
		this.rif = rif;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public void setDireccionHabitacion(String direccionHabitacion) {
		this.direccionHabitacion = direccionHabitacion;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
