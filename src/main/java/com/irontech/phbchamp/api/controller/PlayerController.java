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

import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.service.CadastroPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    public CadastroPlayerService cadastroPlayer;
    @Autowired
    public PlayerRepository playerRepository;

    @GetMapping
    public List<Player> players() {
        return playerRepository.listar();
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> buscar(@PathVariable Long playerId) {
        Player player = playerRepository.buscar(playerId);
        if (player != null) {
            return ResponseEntity.status(HttpStatus.OK).body(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Player adicionar(@RequestBody Player player) {
        return cadastroPlayer.salvar(player);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> atualizar(@PathVariable Long playerId, @RequestBody Player player) {
        Player playerAtual = playerRepository.buscar(playerId);

        BeanUtils.copyProperties(player, playerAtual);
        playerRepository.salvar(playerAtual);

        return ResponseEntity.ok(playerAtual);

    }
}
