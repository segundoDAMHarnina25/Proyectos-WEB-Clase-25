package com.example.demo.model.entities;

import lombok.Data;
import lombok.NonNull;

@Data
public class Customer {
	@NonNull
	private Long id;
	@NonNull
	private String name;
}
