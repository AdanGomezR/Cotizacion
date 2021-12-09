package com.CotizaCreditos.CotizaCreditos.model;

public class Plazo {
	 private int semanas;
	 private double tasa_normal;
	 private double tasa_puntual;
	 private String nombre_plazo;
	public Plazo(int semanas, double tasa_normal, double tasa_puntual, String nombre_plazo) {
		super();
		this.semanas = semanas;
		this.tasa_normal = tasa_normal;
		this.tasa_puntual = tasa_puntual;
		this.nombre_plazo = nombre_plazo;
	}
	public int getSemanas() {
		return semanas;
	}
	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}
	public double getTasa_normal() {
		return tasa_normal;
	}
	public void setTasa_normal(double tasa_normal) {
		this.tasa_normal = tasa_normal;
	}
	public double getTasa_puntual() {
		return tasa_puntual;
	}
	public void setTasa_puntual(double tasa_puntual) {
		this.tasa_puntual = tasa_puntual;
	}
	
	public String getNombre_plazo() {
		return nombre_plazo;
	}
	public void setNombre_plazo(String nombre_plazo) {
		this.nombre_plazo = nombre_plazo;
	}
	@Override
	public String toString() {
		return "Plazo [semanas=" + semanas + ", tasa_normal=" + tasa_normal + ", tasa_puntual=" + tasa_puntual + "]";
	}
	 
	 

}
