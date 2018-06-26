package com.zup.poi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;

@Entity
public class Poi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cod;
	
	@NotBlank
	private String name;
	
	@DecimalMin("0")
	private long coordinatex;
	
	@DecimalMin("0")
	private long coordinatey;

	public Poi() {
		super();
	}
	
	public Poi(@NotBlank String name, @DecimalMin("0") long coordinatex, @DecimalMin("0") long coordinatey) {
		super();
		this.name = name;
		this.coordinatex = coordinatex;
		this.coordinatey = coordinatey;
	}

	public long getCod() {
		return this.cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCoordinatex() {
		return this.coordinatex;
	}

	public void setCoordinatex(long coordinatex) {
		this.coordinatex = coordinatex;
	}

	public long getCoordinatey() {
		return this.coordinatey;
	}

	public void setCoordinatey(long coordinatey) {
		this.coordinatey = coordinatey;
	}

	
}
