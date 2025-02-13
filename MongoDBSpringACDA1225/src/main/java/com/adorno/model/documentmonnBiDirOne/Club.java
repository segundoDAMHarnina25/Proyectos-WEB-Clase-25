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

@Document(collection = "clubs")
@Data
@RequiredArgsConstructor
public class Club {
	@Id
	private ObjectId id;
	@NonNull
	@Indexed(unique = true)
	private String denomination;
	@DBRef
	private List<Member> members=new ArrayList<>();
}
