package com.example.demo.model.entities;

import lombok.Data;
import lombok.NonNull;

@Data
public class OrderLine {
	@NonNull
	private int number;
	@NonNull
	private Item item;
	@NonNull
	private int quantity;
}
