package com.example.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Socio {
	//validar como numero
	@Min(value = 10,message = "numero muy bajo")
	@Max(value = 1000, message="mumero muy alto")
	private int id;
	@NotBlank
	@Size(min =2,max=6)
	private String nombre;
	@Positive
	private int edad;
}
