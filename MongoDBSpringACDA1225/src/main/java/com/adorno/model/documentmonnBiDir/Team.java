package com.adorno.model.documentmonnBiDir;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "teams")
@Data
@Builder
public class Team {
	@Id
	private String id;
	private String nonmbre;
}
