package br.com.api.alunoproa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.alunoproa.entity.AlunoProaEntity;

@Repository
public interface AlunoProaRepository extends JpaRepository<AlunoProaEntity, Long> {

}
