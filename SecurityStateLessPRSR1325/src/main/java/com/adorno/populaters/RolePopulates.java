package com.adorno.populaters;

import org.springframework.stereotype.Component;

import com.adorno.model.ERole;
import com.adorno.model.RoleEntity;
import com.adorno.model.dtos.UserCreateDTO;
import com.adorno.repositories.RoleRepository;
import com.adorno.services.UserService;

@Component
public class RolePopulates {
	private final RoleRepository roleRepository;
	private final UserService userService;

	public RolePopulates(RoleRepository roleRepository, UserService userService) {
		super();
		this.roleRepository = roleRepository;
		this.userService=userService;
		populateRoles();
		populateUsers();
	}

	public void populateRoles() {
		for (ERole erole : ERole.values()) {
			if (roleRepository.findByName(erole).isEmpty())
				roleRepository.save(new RoleEntity(erole));
		}
	}
	public void populateUsers() {
		UserCreateDTO userCreateDTO = new UserCreateDTO("duque@dolor.es", "cayetano", "1Zzzzzz;", "ADMIN","USER");
		userService.createUser(userCreateDTO);
	}
}
