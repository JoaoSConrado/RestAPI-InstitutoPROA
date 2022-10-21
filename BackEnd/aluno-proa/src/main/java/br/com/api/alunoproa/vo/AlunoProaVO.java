package br.com.api.alunoproa.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AlunoProaVO {

	@NotBlank
	@Size(max = 11)
	private String cpfAluno;

	@NotBlank
	private String nomeAluno;

	private Integer idadeAluno;

	private Integer numeroEquipe;

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

}
