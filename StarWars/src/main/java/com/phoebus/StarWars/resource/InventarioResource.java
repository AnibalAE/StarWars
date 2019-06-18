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

import com.phoebus.StarWars.model.Inventario;
import com.phoebus.StarWars.repository.InventarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Inventarios")
public class InventarioResource {
	
	@Autowired
	InventarioRepository inventarioRepository;
	
	@ApiOperation(value="Retorna uma lista de Inventário")
	@GetMapping("/inventarios")
	public List<Inventario> listaInventarios(){
		return inventarioRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um inventario unico")
	@GetMapping("/inventario/{id}")
	public Inventario listaInventarioUnico(@PathVariable(value="id") long id){
		return inventarioRepository.findById(id);
	}
	
	@ApiOperation(value="Adiciona um inventario")
	@PostMapping("/inventario")
	public Inventario salvaInventario(@RequestBody @Valid Inventario inventario) {
		return inventarioRepository.save(inventario);
	}
	
	@ApiOperation(value="Deleta um inventario")
	@DeleteMapping("/inventario")
	public void deletaInventario(@RequestBody @Valid Inventario inventario) {
		inventarioRepository.delete(inventario);
	}
	
	
}