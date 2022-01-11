package com.irontech.phbchamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.service.CadastroPlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	public CadastroPlayerService cadastroPlayer;
	@Autowired
	public PlayerRepository playerRepository;
	
	@GetMapping
	public List<Player> players(){
		return playerRepository.listar();
	}
}
