package com.adorno.model.document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.model.document1on1.Contract;
import com.adorno.model.document1on1.User;
import com.adorno.model.repositories.ContractRepository;
import com.adorno.model.repositories.UserRepository;

@SpringBootTest
class UserTest {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	User user;
	
	@BeforeEach
	void bef() {
		mongoTemplate.dropCollection(User.class);
		mongoTemplate.dropCollection(Contract.class);
		user =  User.builder()
				.id("1")
				.name("John")
				.email("yo@yo.es")
			.build();
		userRepository.save(user);
	}
	@Test
	void test() {
		Contract contract = Contract.builder().id("1").description("desc").user(user).build();
		contractRepository.save(contract);
	}

}
