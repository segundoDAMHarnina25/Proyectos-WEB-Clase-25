package com.adorno.model.documentmonnBiDirOne;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document(collection = "members")
public class Member {
	@Id
	private ObjectId id;
	@NonNull
	@Indexed(unique = true,background = true)
	private String name;
	private String email;
	
	@DBRef
	private List<Club> clubs=new ArrayList<>();
	
	

	
	
}
