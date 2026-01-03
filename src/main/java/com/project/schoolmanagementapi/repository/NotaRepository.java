package com.project.schoolmanagementapi.repository;

import com.project.schoolmanagementapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota,Integer> {

    List<Nota> findByAlunoId(Integer alunoId);

    Optional<Nota> findByAlunoIdAndDisciplinaId(Integer alunoId, Integer disciplinaId);

}
