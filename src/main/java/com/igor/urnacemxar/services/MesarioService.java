package com.igor.urnacemxar.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.igor.urnacemxar.entity.Mesario;
import com.igor.urnacemxar.repository.MesarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MesarioService {
	
	private final MesarioRepository mesarioRepository;
	
	public Optional<Mesario> findById(Integer id){
		return mesarioRepository.findById(id);
	}
	
	public Mesario save(Mesario mesario) {
		return mesarioRepository.save(mesario);
	}
	
	public void delete(Integer id) {
		mesarioRepository.deleteById(id);
	}
	
	public Mesario replace(Mesario mesario, Integer id) {
		Mesario mesarioAtual = mesarioRepository.findById(id).get();
		BeanUtils.copyProperties(mesario, mesarioAtual, "id");
		return mesarioRepository.save(mesarioAtual);
	}
	
	
	
	
}
