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

import com.irontech.phbchamp.domain.model.Estatisticas;
import com.irontech.phbchamp.domain.model.Team;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;
import com.irontech.phbchamp.domain.repository.EstatisticasRepository;
import com.irontech.phbchamp.domain.repository.TeamRepository;
import com.irontech.phbchamp.domain.service.CadastroEstatisticasService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {

    @Autowired
    public CadastroEstatisticasService cadastroEstatisticasService;

    @Autowired
    public EstatisticasRepository estatisticasRepository;
    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    public CampeonatoRepository campeonatoRepository;

    @GetMapping
    public List<Estatisticas> estatisticas() {
        return estatisticasRepository.listar();
    }

    @GetMapping("/{estId}")
    public ResponseEntity<Estatisticas> buscar(@PathVariable Long estId) {
        Estatisticas est = estatisticasRepository.buscar(estId);
        if (est != null) {
            return ResponseEntity.status(HttpStatus.OK).body(est);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Estatisticas adicionar(@RequestBody Estatisticas estatisticas) {
        return cadastroEstatisticasService.salvar(estatisticas);
    }

    @GetMapping("estatisticasPorTime/{teamId}/{campId2}")
    public List<Estatisticas> estatisticasPorTime(@PathVariable Long teamId, @PathVariable Long campId2) {
        Team t = new Team();
        Campeonato c = new Campeonato();
        
        if (teamId != null) {
            t = teamRepository.buscar(teamId);
        }

        if (campId2 != null) {
            c = campeonatoRepository.buscar(campId2);
        }

        return estatisticasRepository.estatisticaPorTime(t, c);
    }

    @PutMapping("/{estatsId}")
    public ResponseEntity<Estatisticas> atualizar(@PathVariable Long estatsId, @RequestBody Estatisticas estats) {
        Estatisticas estatsAtual = estatisticasRepository.buscar(estatsId);

        BeanUtils.copyProperties(estats, estatsAtual);
        estatisticasRepository.salvar(estatsAtual);

        return ResponseEntity.ok(estatsAtual);

    }
}
