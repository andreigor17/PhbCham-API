package com.irontech.phbchamp.api.controller;

import com.irontech.phbchamp.domain.model.Campeonato;
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

import com.irontech.phbchamp.domain.model.Partida;
import com.irontech.phbchamp.domain.repository.PartidaRepository;
import com.irontech.phbchamp.domain.service.CadastroPartidaService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PutMapping;

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

    @GetMapping("partidasPorCamp/{campId}")
    public ResponseEntity<List<Partida>> buscarPartidaPorCamp(@PathVariable String campId) {
        List<Partida> p = cadastroPartidaService.partidasPorCamp(campId);

        if (p != null) {
            return ResponseEntity.status(HttpStatus.OK).body(p);
        } else {
            return ResponseEntity.notFound().build();

        }

    }

    @PutMapping("/{partidaId}")
    public ResponseEntity<Partida> atualizar(@PathVariable Long partidaId, @RequestBody Partida partida) {
        Partida partidaAtual = partidaRepository.buscar(partidaId);

        BeanUtils.copyProperties(partida, partidaAtual);
        partidaRepository.salvar(partidaAtual);

        return ResponseEntity.ok(partidaAtual);

    }

}
