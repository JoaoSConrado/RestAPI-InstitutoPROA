package br.com.api.alunoproa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.alunoproa.entity.AlunoProaEntity;
import br.com.api.alunoproa.repository.AlunoProaRepository;

@Service
public class AlunoProaService {

	@Autowired
	AlunoProaRepository alunoProaRepository;

	@Transactional
	public AlunoProaEntity salvar(AlunoProaEntity alunoProaEntity) {
		return alunoProaRepository.save(alunoProaEntity);
	}
	
	public List<AlunoProaEntity> findAll() {
		return alunoProaRepository.findAll();
	}
	
	public Optional<AlunoProaEntity> findById(Long id) {
		return alunoProaRepository.findById(id);
	}
	
	@Transactional
	public void delete(AlunoProaEntity alunoProaEntity) {
		alunoProaRepository.delete(alunoProaEntity);
	}

}
