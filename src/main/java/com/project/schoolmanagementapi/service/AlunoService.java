package com.project.schoolmanagementapi.service;

import com.project.schoolmanagementapi.dto.aluno.AlunoRequest;
import com.project.schoolmanagementapi.dto.aluno.AlunoResponse;
import com.project.schoolmanagementapi.dto.aluno.AlunoSummary;
import com.project.schoolmanagementapi.dto.turma.TurmaResponse;
import com.project.schoolmanagementapi.dto.turma.TurmaSummary;
import com.project.schoolmanagementapi.model.Aluno;
import com.project.schoolmanagementapi.model.Turma;
import com.project.schoolmanagementapi.repository.AlunoRepository;
import com.project.schoolmanagementapi.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    public AlunoService(TurmaRepository turmaRepository,  AlunoRepository alunoRepository) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse create(AlunoRequest request) {
        Turma turma = turmaRepository.findById(request.turmaId())
                .orElseThrow(() -> new RuntimeException("Turma não  encontrada"));

        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setMatricula(request.matricula());
        aluno.setTurma(turma);

        Aluno salvo = alunoRepository.save(aluno);

        return toResponse(salvo);
    }

    public List<AlunoSummary> listByTurma(Integer turmaId) {

        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        return  alunoRepository.findByTurma(turma)
                .stream()
                .map(this::toSummary)
                .toList();
    }

    public AlunoResponse findById(Integer alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return toResponse(aluno);
    }

    private AlunoResponse toResponse(Aluno aluno) {

        Turma turma = aluno.getTurma();

        return  new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getMatricula(),
                new TurmaSummary(
                        turma.getId(),
                        turma.getCodigo(),
                        turma.getAno()
                )
        );

    }

    private AlunoSummary toSummary(Aluno aluno) {
        return new AlunoSummary(
                aluno.getId(),
                aluno.getNome(),
                aluno.getMatricula()
        );

    }

}
