package br.com.api.alunoproa.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.api.alunoproa.entity.AlunoProaEntity;
import br.com.api.alunoproa.service.AlunoProaService;
import br.com.api.alunoproa.vo.AlunoProaVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno-proa")
public class AlunoProaController {

	@Autowired
	AlunoProaService alunoProaService;

	@PostMapping
	public ResponseEntity<Object> salvarAlunoProa(@RequestBody @Valid AlunoProaVO alunoProaVO) {

		var alunoProaEntity = new AlunoProaEntity();
		BeanUtils.copyProperties(alunoProaVO, alunoProaEntity);
		alunoProaEntity.setRegistraData(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoProaService.salvar(alunoProaEntity));
	}

	@GetMapping
	public ResponseEntity<List<AlunoProaEntity>> getAllAlunoProa() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoProaService.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteControleSoftware(@PathVariable(value = "id") Long id) {
		Optional<AlunoProaEntity> controleSoftwareEntityOptional = alunoProaService.findById(id);
		if (!controleSoftwareEntityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO: O ID solicitado não foi encontrado!");
		}
		alunoProaService.delete(controleSoftwareEntityOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("SUCESSO: Deletado com Sucesso!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateControleSoftware(@PathVariable(value = "id") Long id,
			@RequestBody @Valid AlunoProaVO alunoProaVO) {
		Optional<AlunoProaEntity> alunoProaEntityOptional = alunoProaService.findById(id);
		if (!alunoProaEntityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO: O ID solicitado não foi encontrado!");
		}
		AlunoProaEntity alunoProaEntity = alunoProaEntityOptional.get();
		alunoProaEntity.setCpfAluno(alunoProaVO.getCpfAluno());
		alunoProaEntity.setNomeAluno(alunoProaVO.getNomeAluno());
		alunoProaEntity.setIdadeAluno(alunoProaVO.getIdadeAluno());
		alunoProaEntity.setNumeroEquipe(alunoProaVO.getNumeroEquipe());
		alunoProaEntity.setRegistraData(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

		return ResponseEntity.status(HttpStatus.OK).body(alunoProaService.salvar(alunoProaEntity));

	}
}