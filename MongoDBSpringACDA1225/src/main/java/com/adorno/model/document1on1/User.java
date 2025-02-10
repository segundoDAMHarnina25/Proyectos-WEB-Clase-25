package com.adorno.model.document1on1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "users")
public class User {
	@Id
	private String id;
	private String name;
	private String email;
}
