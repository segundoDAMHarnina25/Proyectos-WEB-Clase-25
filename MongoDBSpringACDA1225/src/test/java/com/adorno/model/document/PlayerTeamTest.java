package com.adorno.model.document;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.model.documentmonnBiDir.Team;
import com.adorno.model.repositories.PlayerRepository;
import com.adorno.model.repositories.PlayerTeamRepository;
import com.adorno.model.repositories.TeamRepository;

@SpringBootTest
class PlayerTeamTest {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerTeamRepository playerTeamRepository;
	@Test
	void test() {
		mongoTemplate.dropCollection(Team.class);
		Team team = new Team("Betis");
		teamRepository.save(team);
		Team team2 = new Team("Betis");
		teamRepository.save(team2);
	}

}
