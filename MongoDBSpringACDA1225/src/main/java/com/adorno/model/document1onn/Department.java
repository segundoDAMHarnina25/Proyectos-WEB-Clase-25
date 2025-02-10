package com.adorno.model.document1onn;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "department")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	private ObjectId id;
	@Indexed(unique = true)
	@NonNull
	private String denomination;
	@DBRef
	private List<Person> persons=new ArrayList<>();
}
