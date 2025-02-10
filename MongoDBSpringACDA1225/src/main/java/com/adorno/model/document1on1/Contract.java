package com.adorno.model.document1on1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "contracts")
public class Contract {
	@Id
	private String id;
	private String description;
	//Sin referencia de bd a user. incuye el objeto
//	private User user;
	@DBRef
	private User user;
}
