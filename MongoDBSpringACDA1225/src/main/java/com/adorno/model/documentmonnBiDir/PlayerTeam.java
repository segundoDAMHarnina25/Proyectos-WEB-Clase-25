package com.adorno.model.documentmonnBiDir;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document(collection = "playersteams")
public class PlayerTeam {
	@Id
	private ObjectId id;
	@DBRef
	@NonNull
	private Player player;
	@DBRef
	@NonNull
	private Team team;
}
