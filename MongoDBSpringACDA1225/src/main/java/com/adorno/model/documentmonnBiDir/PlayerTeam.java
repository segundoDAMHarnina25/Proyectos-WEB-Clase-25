package com.adorno.model.documentmonnBiDir;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document(collection = "players")
public class PlayerTeam {
	@Id
	private Object id;
	@DBRef
	@NonNull
	private Player player;
	@DBRef
	@NonNull
	private Team team;
}
