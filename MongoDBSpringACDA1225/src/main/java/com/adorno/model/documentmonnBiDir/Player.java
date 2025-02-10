package com.adorno.model.documentmonnBiDir;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "players")
public class Player {
	@Id
	private ObjectId id;
	
	@Indexed(unique = true)
	private String name;
	
	private String email;
	
	

	
	
}
