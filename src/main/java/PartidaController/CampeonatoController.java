package PartidaController;

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
import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.service.CadastroCampService;
import com.irontech.phbchamp.domain.service.CadastroPlayerService;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {
	
	@Autowired
	public CadastroCampService cadastroCamp;
	@Autowired
	public CampeonatoRepository campeonatoRepository;

	@GetMapping
	public List<Campeonato> campeonatos() {
		return campeonatoRepository.listar();
	}

	@GetMapping("/{campId}")
	public ResponseEntity<Campeonato> buscar(@PathVariable Long campId) {
		Campeonato camp = campeonatoRepository.buscar(campId);
		if (camp != null) {
			return ResponseEntity.status(HttpStatus.OK).body(camp);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Campeonato adicionar(@RequestBody Campeonato camp) {
		return cadastroCamp.salvar(camp);
	}
	
	

}
