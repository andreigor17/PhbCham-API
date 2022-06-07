/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.api.controller;

import com.irontech.phbchamp.domain.model.PickBan;
import com.irontech.phbchamp.domain.repository.PickBanRepository;
import com.irontech.phbchamp.domain.service.PickBanService;
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
 * @author andreigor
 */
@RestController
@RequestMapping("/pickban")
public class PickBanController {

    @Autowired
    public PickBanService pickBanService;
    @Autowired
    public PickBanRepository pickBanRepository;

    @GetMapping
    public List<PickBan> players() {
        return pickBanRepository.listar();
    }

    @GetMapping("/{pickbanId}")
    public ResponseEntity<PickBan> buscar(@PathVariable Long pickbanId) {
        PickBan pb = pickBanRepository.buscar(pickbanId);
        if (pb != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pb);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PickBan adicionar(@RequestBody PickBan pb) {
        return pickBanService.salvar(pb);
    }

    @PutMapping("/{pickbanId}")
    public ResponseEntity<PickBan> atualizar(@PathVariable Long pickbanId, @RequestBody PickBan pb) {
        PickBan pbAtual = pickBanRepository.buscar(pickbanId);

        BeanUtils.copyProperties(pb, pbAtual);
        pickBanRepository.salvar(pbAtual);

        return ResponseEntity.ok(pbAtual);

    }

}
