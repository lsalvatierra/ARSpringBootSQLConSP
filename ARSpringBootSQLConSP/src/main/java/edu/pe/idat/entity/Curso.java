package edu.pe.idat.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id
	private String idcurso;
	
	private String nomcurso;
	
	private Integer credito;
	
	
	public Curso() {

	}

	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}

	public String getNomcurso() {
		return nomcurso;
	}

	public void setNomcurso(String nomcurso) {
		this.nomcurso = nomcurso;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}
	
	

}
