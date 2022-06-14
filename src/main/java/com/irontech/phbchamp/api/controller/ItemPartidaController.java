/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.api.controller;

import com.irontech.phbchamp.domain.model.ItemPartida;
import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.ItemPartidaRepository;
import com.irontech.phbchamp.domain.service.ItemPartidaServico;
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
@RequestMapping("/itemPartidas")
public class ItemPartidaController {

    @Autowired
    public ItemPartidaRepository itemPartidaRepository;
    @Autowired
    public ItemPartidaServico itemPartidaService;

    @GetMapping
    public List<ItemPartida> partidas() {
        return itemPartidaRepository.listar();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ItemPartida adicionar(@RequestBody ItemPartida p) {
        return itemPartidaService.salvar(p);

    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemPartida> atualizar(@PathVariable Long itemId, @RequestBody ItemPartida item) {
        System.out.println("teste");
        ItemPartida itemAtual = itemPartidaRepository.buscar(itemId);

        BeanUtils.copyProperties(item, itemAtual);
        itemPartidaRepository.salvar(itemAtual);

        return ResponseEntity.ok(itemAtual);

    }

}
