/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.api.controller;

import com.irontech.phbchamp.domain.model.Configuracao;
import com.irontech.phbchamp.domain.repository.ConfiguracaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {
    
    @Autowired
    ConfiguracaoRepository configuracaoRepository;
    
    @GetMapping("/{configId}")
    public ResponseEntity<Configuracao> buscar(@PathVariable Long configId) {
        Configuracao config = configuracaoRepository.buscar(configId);
        if (config != null) {
            return ResponseEntity.status(HttpStatus.OK).body(config);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Configuracao adicionar(@RequestBody Configuracao configuracao) {
//        return configuracaoRepositiry.salvar(configuracao);
//    }

    @PutMapping("/{configId}")
    public ResponseEntity<Configuracao> atualizar(@PathVariable Long configId, @RequestBody Configuracao configuracao) {
        Configuracao configAtual = configuracaoRepository.buscar(configId);

        BeanUtils.copyProperties(configuracao, configAtual);
        configuracaoRepository.salvar(configAtual);

        return ResponseEntity.ok(configAtual);

    }
    
}
