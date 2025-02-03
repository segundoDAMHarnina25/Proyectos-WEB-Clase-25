package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.Objects;

//Tratado como un VO de los de verdad
public final class CreditCard {
	//El valor debe ser 16 digitos numericos
	private final String numero;
	// validacion de nombre normal
	private final String titular;
	// que sea siempre en el futuro
	private final LocalDate caducidad;
	//Dentro de un conjunto de entidades (usa enum)
	private final String entidad;
	//Siempre tres digitos numericos
	private final String cvv;
	//Hay que lanzar una excepcion concreta por cada tipo de fallo posible
	
	public CreditCard(String numero, String titular, LocalDate caducidad, String entidad, String cvv) throws Exception {
		super();
		if(numero==null) throw new Exception();
		if(titular==null)throw new Exception();
		if(caducidad.isBefore(LocalDate.now()))throw new Exception();
		if(entidad==null)throw new Exception();
		if(cvv==null)throw new Exception();
		this.numero = numero;
		this.titular = titular;
		this.caducidad = caducidad;
		this.entidad = entidad;
		this.cvv = cvv;
	}

	private String getNumero() {
		return numero;
	}

	private String getTitular() {
		return titular;
	}

	private LocalDate getCaducidad() {
		return caducidad;
	}

	private String getEntidad() {
		return entidad;
	}

	private String getCvv() {
		return cvv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caducidad, cvv, entidad, numero, titular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return Objects.equals(caducidad, other.caducidad) && Objects.equals(cvv, other.cvv)
				&& Objects.equals(entidad, other.entidad) && Objects.equals(numero, other.numero)
				&& Objects.equals(titular, other.titular);
	}

	@Override
	public String toString() {
		return "CreditCard [numero=" + numero + ", titular=" + titular + ", caducidad=" + caducidad + ", entidad="
				+ entidad + ", cvv=" + cvv + "]";
	}
	
}
