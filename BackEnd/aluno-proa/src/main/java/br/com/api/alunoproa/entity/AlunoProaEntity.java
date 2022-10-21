package br.com.api.alunoproa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_ALUNO_PROA")
public class AlunoProaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 11)
	private String cpfAluno;

	@Column(nullable = false, length = 130)
	private String nomeAluno;

	@Column(nullable = false)
	private Integer idadeAluno;

	@Column(nullable = false)
	private Integer numeroEquipe;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime registraData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Integer getIdadeAluno() {
		return idadeAluno;
	}

	public void setIdadeAluno(Integer idadeAluno) {
		this.idadeAluno = idadeAluno;
	}

	public Integer getNumeroEquipe() {
		return numeroEquipe;
	}

	public void setNumeroEquipe(Integer numeroEquipe) {
		this.numeroEquipe = numeroEquipe;
	}

	public LocalDateTime getRegistraData() {
		return registraData;
	}

	public void setRegistraData(LocalDateTime registraData) {
		this.registraData = registraData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
