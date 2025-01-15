package modelo.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private LocalDate localDate;
	private Long personaID;

	public Contrato(LocalDate localDate, Long personaID) {
		super();
		this.localDate = localDate;
		this.personaID = personaID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Long getPersonaID() {
		return personaID;
	}

	public void setPersonaID(Long personaID) {
		this.personaID = personaID;
	}

}
