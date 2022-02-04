package com.irontech.phbchamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irontech.phbchamp.domain.model.Campeonato;
import com.irontech.phbchamp.domain.model.Estatisticas;
import com.irontech.phbchamp.domain.model.Partida;
import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;
import com.irontech.phbchamp.domain.repository.PartidaRepository;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.service.CadastroCampService;
import com.irontech.phbchamp.domain.service.CadastroPartidaService;
import com.irontech.phbchamp.domain.service.CadastroPlayerService;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
	
	@Autowired
	public PartidaRepository partidaRepository;
	@Autowired
	public CadastroPartidaService cadastroPartidaService;

	@GetMapping
	public List<Partida> partidas() {
		return partidaRepository.listar();
	}

	@GetMapping("/{partidaId}")
	public ResponseEntity<Partida> buscar(@PathVariable Long partidaId) {
		Partida p = partidaRepository.buscar(partidaId);
		if (p != null) {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Partida adicionar(@RequestBody Partida p) {
		return cadastroPartidaService.salvar(p);
		
	}
	
	@GetMapping("/partidaPorCamp")
	public List<Partida> partidaPorCamp(Campeonato camp) {
		return cadastroPartidaService.partidasPorCamp(camp);
	}

}
