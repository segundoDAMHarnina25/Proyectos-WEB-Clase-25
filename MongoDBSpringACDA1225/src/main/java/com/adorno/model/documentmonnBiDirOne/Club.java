package com.adorno.model.documentmonnBiDirOne;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "clubs")
@Data
@Builder
public class Club {
	@Id
	private ObjectId id;
	@Indexed(unique = true)
	private String denomination;
}
