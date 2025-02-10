package com.adorno.model.document1onnBiDir;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "members")
public class Member {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String name;
	
	private String email;
	
	

	
	
}
