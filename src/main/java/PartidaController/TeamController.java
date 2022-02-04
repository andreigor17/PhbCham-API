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

import com.irontech.phbchamp.domain.model.Team;
import com.irontech.phbchamp.domain.repository.TeamRepository;
import com.irontech.phbchamp.domain.service.CadastroTeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	public CadastroTeamService cadastroTeam;
	@Autowired
	public TeamRepository teamRepository;

	@GetMapping
	public List<Team> players() {
		return teamRepository.listar();
	}

	@GetMapping("/{teamId}")
	public ResponseEntity<Team> buscar(@PathVariable Long teamId) {
		Team team = teamRepository.buscar(teamId);
		if (team != null) {
			return ResponseEntity.status(HttpStatus.OK).body(team);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Team adicionar(@RequestBody Team team) {
		return cadastroTeam.salvar(team);
		
	}

}
