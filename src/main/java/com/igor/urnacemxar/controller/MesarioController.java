package com.igor.urnacemxar.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.urnacemxar.entity.Mesario;
import com.igor.urnacemxar.services.MesarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/urna")
@RequiredArgsConstructor
@Transactional
@CrossOrigin("*")
public class MesarioController {
	
	private final MesarioService mesarioService;
	
	@GetMapping("/liberar/{id}")
	public ResponseEntity<Optional<Mesario>> listAll(@PathVariable Integer id){
		return ResponseEntity.ok(mesarioService.findById(id));
	}
	
	@PostMapping("/liberar")
	public ResponseEntity<Mesario> saveMesario(@RequestBody Mesario mesario){
		return new ResponseEntity<>(mesarioService.save(mesario), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/liberar/{id}")
	public Mesario replace(@RequestBody Mesario mesarioNovo, @PathVariable Integer id) {
		return mesarioService.replace(mesarioNovo, id);
	}
	
	@DeleteMapping("/liberar/{id}")
	public void delete(@PathVariable Integer id) {
		mesarioService.delete(id);
	}
}
