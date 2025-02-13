package com.adorno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adorno.model.documentmonnBiDir.Player;
import com.adorno.model.documentmonnBiDir.PlayerTeam;
import com.adorno.model.documentmonnBiDir.Team;
import com.adorno.model.repositories.PlayerRepository;
import com.adorno.model.repositories.PlayerTeamRepository;
import com.adorno.model.repositories.TeamRepository;

@Service
public class CompetitionService {
	private final PlayerTeamRepository playerTeamRepository;
	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;

	public CompetitionService(PlayerTeamRepository playerTeamRepository, TeamRepository teamRepository,
			PlayerRepository playerRepository) {
		super();
		this.playerTeamRepository = playerTeamRepository;
		this.teamRepository = teamRepository;
		this.playerRepository = playerRepository;
	}

	public List<Team> getAllTeamsByPlayerName(String playerName) {
		return playerRepository.findByName(playerName).map(
				player->{
					return playerTeamRepository.findByPlayer(player)
							.stream()
							.map(
									PlayerTeam::getTeam)
							.toList();
				})
		.orElse(new ArrayList<>());
	}
}
