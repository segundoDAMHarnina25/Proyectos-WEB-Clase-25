package com.adorno.model.documentmonnBiDir;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "teams")
@Data
@RequiredArgsConstructor
public class Team {
	@Id
	private ObjectId id;
	@Indexed(unique = true)
	@NonNull
	private String nonmbre;
}
