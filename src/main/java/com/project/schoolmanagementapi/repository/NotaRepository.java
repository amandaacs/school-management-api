package com.project.schoolmanagementapi.repository;

import com.project.schoolmanagementapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota,Long> {

    List<Nota> findByAlunoId(Long alunoId);

    Optional<Nota> findByAlunoIdAndDisciplinaId(Long  alunoId, Long disciplinaId);

}
