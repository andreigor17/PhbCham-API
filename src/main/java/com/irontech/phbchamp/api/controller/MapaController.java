/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.api.controller;

import com.irontech.phbchamp.domain.model.Mapas;
import com.irontech.phbchamp.domain.repository.MapaRepository;
import com.irontech.phbchamp.domain.service.MapaService;
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
@RequestMapping("/mapas")
public class MapaController {
    
     @Autowired
    public MapaService mapaService;
    @Autowired
    public MapaRepository mapaRepository;
    
    @GetMapping
    public List<Mapas> players() {
        return mapaRepository.listar();
    }

    @GetMapping("/{mapaId}")
    public ResponseEntity<Mapas> buscar(@PathVariable Long mapaId) {
        Mapas mapa = mapaRepository.buscar(mapaId);
        if (mapa != null) {
            return ResponseEntity.status(HttpStatus.OK).body(mapa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mapas adicionar(@RequestBody Mapas mapas) {
        return mapaService.salvar(mapas);
    }

    @PutMapping("/{mapaId}")
    public ResponseEntity<Mapas> atualizar(@PathVariable Long mapaId, @RequestBody Mapas mapa) {
        Mapas mapaAtual = mapaRepository.buscar(mapaId);

        BeanUtils.copyProperties(mapa, mapaAtual);
        mapaRepository.salvar(mapaAtual);

        return ResponseEntity.ok(mapaAtual);

    }
    
}
