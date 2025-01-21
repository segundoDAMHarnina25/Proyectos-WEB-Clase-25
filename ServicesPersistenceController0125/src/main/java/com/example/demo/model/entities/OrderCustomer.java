package com.example.demo.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NonNull;

@Data
public class OrderCustomer {
	@NonNull
	private Long id;
	@NonNull
	private LocalDate localdate;
	@NonNull
	private Customer customer;
	
	private Set<OrderLine> lines=new HashSet<OrderLine>();
	
	public boolean addLine(OrderLine line) {
		return lines.add(line);
	}

}
