package com.example.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Person {
    
	private int id;
	@NonNull
    private String name;
	@NonNull
    private int age;
	@NonNull
	private String provincia;

}
