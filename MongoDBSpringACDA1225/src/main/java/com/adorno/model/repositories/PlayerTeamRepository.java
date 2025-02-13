package com.adorno.model.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.documentmonnBiDir.Player;
import com.adorno.model.documentmonnBiDir.PlayerTeam;

public interface PlayerTeamRepository extends MongoRepository<PlayerTeam, ObjectId> {

	List<PlayerTeam> findByPlayer(Player player);

}
