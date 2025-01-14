package com.example.demo.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Miembro {
	@NonNull
	@Setter
	private String dni;
	@NonNull
	@Setter
	private String nombre;
	@NonNull
	private byte edad;
}
