package com.example.demo.model.entities;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
	@NonNull
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private int minStock, maxStock,currentStock;
	@NonNull
	private BigDecimal price;
}
