package com.example.demo.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"item_id","orderCustomer_id"})
})
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@NonNull
	private Item item;
	@NonNull
	private int quantity;
	@NonNull
	@ManyToOne
	@ToString.Exclude // Excluye del toString para evitar ciclos
	@EqualsAndHashCode.Exclude // Excluye del equals/hashCode para evitar problemas con colecciones
	private OrderCustomer orderCustomer;
}
