package com.adorno.model.document1onn;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "persons")
public class Person {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String name;
	
	private String email;
	@DBRef
	private Department department;
	
}
