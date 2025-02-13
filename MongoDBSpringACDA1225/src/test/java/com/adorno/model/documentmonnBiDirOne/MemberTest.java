package com.adorno.model.documentmonnBiDirOne;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.model.repositories.ClubRepository;
import com.adorno.model.repositories.MemberRepository;

@SpringBootTest
class MemberTest {

	@Autowired
	ClubRepository clubRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		//PRimero borramos la coleccion anterior (evita fallos) 
		mongoTemplate.dropCollection(Member.class);
		mongoTemplate.dropCollection(Club.class);
		//Creamos los datos
		List<Member> members = List.of(new Member("luis1"),
				new Member("luis2"),
				new Member("luis3"));
		List<Club> clubs = List.of(
		new Club("CArisimo1"),new Club("CArisimo2"),new Club("CArisimo3"));
		//PErsistimos los datos para crear los ids
		members.stream().forEach(member->memberRepository.save(member));
		clubs.stream().forEach(club->clubRepository.save(club));
		//rellenamos los lists
		for (Member member : members) {
			for (Club club : clubs) {
				
				member.getClubs().add(club);
				club.getMembers().add(member);
			}
		}
		//PErsistimos los datos para alojar los cambios
		members.stream().forEach(member->memberRepository.save(member));
		clubs.stream().forEach(club->clubRepository.save(club));
		
	}

}
