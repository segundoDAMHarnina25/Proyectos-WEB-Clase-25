package com.adorno.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email(message = "no cumple el formato")
	@NotBlank(message = "no puede estar en blanco")
	@Size(max = 80, message = "email demasiado largo")
	private String email;
	@NotBlank(message = "no puede estar en blanco")
	@Size(max = 30, message = "demasiado grande tu username")
	@Column(unique = true)
	private String username;
	@NotBlank(message = "no puede estar en blanco")
	//probklemas con este patron porque habria que descodificar
	//la contraseña para que pasase los criterior
	//por lo tanto esto debe hacerse antes de la codificacion en el mapper
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d;,\\.]{8,}$", message = "Debe tener al menos 8 caracteres, contener al menos una mayúscula, una minúscula, un número y un símbolo entre coma, punto y coma, o punto")
	private String password;

	public UserEntity(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	//por la forma en que guardamos los roles, cuando ya se han 
	//terminado las transac de alta de roles
	/*
	 * Cuando vas a almacenar los roles del Usert, sacas los roles del 
	 * repo. y eso es un problema porque no estan en persistencia.
	 * Al poner detach nos permite guardar un objeto almacenado pero 
	 * que no se encuentra en situacion de persist en este momento
	 * recordaos que una vez que termina la operacion (usando JPARepo)
	 * la transaccion se acaba luego la persistencia tambien
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private Set<RoleEntity> roles;
}
