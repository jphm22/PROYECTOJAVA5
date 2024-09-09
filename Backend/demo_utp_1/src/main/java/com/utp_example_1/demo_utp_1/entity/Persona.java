package com.utp_example_1.demo_utp_1.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_persona", schema="public")
public class Persona implements Serializable{
	  private static final long serialVersionUID = -4404733423008657622L;
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tt_persona_idpersona_seq")
	@SequenceGenerator(name="tt_persona_idpersona_seq", sequenceName="tt_persona_idpersona_seq", allocationSize=1)
	@Id
	@Column(name = "IDPERSONA")
	private Long idpersona;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APPATERNO")
	private String appaterno;
	
	@Column(name = "APPMATERNO")
	private String apmaterno;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "EDAD")
	private Integer edad;

	
	
	
	

	public Long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppaterno() {
		return appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public String getApmaterno() {
		return apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	
	
	
	
	
}
