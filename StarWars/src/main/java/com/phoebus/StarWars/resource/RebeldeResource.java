package com.phoebus.StarWars.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoebus.StarWars.model.Rebelde;
import com.phoebus.StarWars.repository.RebeldeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Rebeldes")
public class RebeldeResource {
	
	@Autowired
	RebeldeRepository rebeldeRepository;
	
	@ApiOperation(value="Retorna uma lista de Rebeldes")
	@GetMapping("/rebeldes")
	public List<Rebelde> listaRebeldes(){
		return rebeldeRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um rebelde unico")
	@GetMapping("/rebelde/{id}")
	public Rebelde listaRebeldeUnico(@PathVariable(value="id") long id){
		return rebeldeRepository.findById(id);
	}
	
	@ApiOperation(value="Adiciona um rebelde")
	@PostMapping("/rebelde")
	public Rebelde salvaRebelde(@RequestBody @Valid Rebelde rebelde) {
		return rebeldeRepository.save(rebelde);
	}
	
	@ApiOperation(value="Deleta um rebelde caso ele morra")
	@DeleteMapping("/rebelde")
	public void deletaRebelde(@RequestBody @Valid Rebelde rebelde) {
		rebeldeRepository.delete(rebelde);
	}
	
	@ApiOperation(value="Atualiza a localidade de um rebelde")
	@PutMapping("/rebelde/{id}")
	public Rebelde atualizaRebelde(@RequestBody @Valid Rebelde rebelde) {
		return rebeldeRepository.findById(id)
		           .map(record -> {
		               record.setLocalidade(rebelde.getLocalidade());
		               Rebelde updated = repository.save(record);
		               return ResponseEntity.ok().body(updated);
		           });
	}
	
	public Rebelde porcentagemTraidores(@RequestBody @Valid Rebelde rebelde) {
		return rebeldeRepository.count(rebelde.isTraidor());
	}
	
}