/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.api.controller;

import com.irontech.phbchamp.domain.model.Jogo;
import com.irontech.phbchamp.domain.repository.JogoRepository;
import com.irontech.phbchamp.domain.service.CadastroJogoService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    public CadastroJogoService cadastroJogoService;
    @Autowired
    public JogoRepository jogoRepository;

    @GetMapping
    public List<Jogo> jogos() {
        return jogoRepository.listar();
    }

    @GetMapping("/{jogoId}")
    public ResponseEntity<Jogo> buscar(@PathVariable Long jogoId) {
        Jogo jogo = jogoRepository.buscar(jogoId);
        if (jogo != null) {
            return ResponseEntity.status(HttpStatus.OK).body(jogo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Jogo adicionar(@RequestBody Jogo jogo) {
        return cadastroJogoService.salvar(jogo);
    }

    @PutMapping("/{jogoId}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long jogoId, @RequestBody Jogo jogo) {
        Jogo jogoAtual = jogoRepository.buscar(jogoId);

        BeanUtils.copyProperties(jogo, jogoAtual);
        jogoRepository.salvar(jogoAtual);

        return ResponseEntity.ok(jogoAtual);

    }

    @PutMapping("excluir/{jogoId2}")
    public ResponseEntity<Jogo> excluir(@PathVariable Long jogoId2) {
        jogoRepository.remover(jogoId2);
        Jogo jogoAtual = jogoRepository.buscar(jogoId2);
        return ResponseEntity.ok(jogoAtual);

    }

}
