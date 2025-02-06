package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResumenDTO {
	private String nombre="joe";
	private int edad=9;
}
