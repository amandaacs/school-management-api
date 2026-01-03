package com.project.schoolmanagementapi.repository;

import com.project.schoolmanagementapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    List<Aluno> findByTurma(Long turmaId);

}
