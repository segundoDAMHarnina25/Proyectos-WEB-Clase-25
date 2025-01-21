package com.example.demo.model.entities;

import lombok.Data;
import lombok.NonNull;

@Data
public class Offer {
	@NonNull
	private Long id;
	@NonNull
	private Item item;
	@NonNull
	private int savePercentage;
}
