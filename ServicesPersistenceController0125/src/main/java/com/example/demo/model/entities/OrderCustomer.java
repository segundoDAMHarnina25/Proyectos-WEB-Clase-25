package com.example.demo.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private LocalDate localdate;
	@NonNull
	@ManyToOne
	//Hay que evitar las referencias circulares
	@ToString.Exclude // Excluye del toString para evitar ciclos
	@EqualsAndHashCode.Exclude // Excluye del equals/hashCode para evitar problemas con colecciones
	private Customer customer;

	@OneToMany(mappedBy = "orderCustomer", cascade = CascadeType.ALL)
	private Set<OrderLine> lines = new HashSet<OrderLine>();

	public boolean addLine(OrderLine line) {
		return lines.add(line);
	}

}
