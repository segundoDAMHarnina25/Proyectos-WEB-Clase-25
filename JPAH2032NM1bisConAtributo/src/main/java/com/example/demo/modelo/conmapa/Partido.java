package com.example.demo.modelo.conmapa;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyJoinColumn;
import lombok.NonNull;

@Entity
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private int homeGoals,awayGoals;
	/*
	 * 
	 * @ElementCollection: Indica que jugadores no es una relación entre entidades,
	 * sino una colección de elementos embebidos. Desde el piunti de vista de jpa
	 * 
	 *  * @CollectionTable: Especifica la tabla intermedia (jugador_partido en este
	 * caso).
	 * 
	 * * @MapKeyJoinColumn: Define el campo que actuará como clave (Item) en la tabla
	 * intermedia.
	 * 
	 * @Column: Define el campo que almacenará el valor (Integer).
	 */
	@ElementCollection
	@CollectionTable(name = "jugador_partido", joinColumns = @JoinColumn(name = "partido_id"))
	@MapKeyJoinColumn(name = "jugador_id")
	@Column(name = "quantity")
	private Map<Jugador, Integer> participacion = new HashMap<>();
}
