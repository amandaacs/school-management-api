package com.project.schoolmanagementapi.service;

import com.project.schoolmanagementapi.dto.nota.NotaRequest;
import com.project.schoolmanagementapi.dto.nota.NotaResponse;
import com.project.schoolmanagementapi.model.Aluno;
import com.project.schoolmanagementapi.model.Disciplina;
import com.project.schoolmanagementapi.model.Nota;
import com.project.schoolmanagementapi.repository.AlunoRepository;
import com.project.schoolmanagementapi.repository.DisciplinaRepository;
import com.project.schoolmanagementapi.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    public NotaService(NotaRepository notaRepository,
                       AlunoRepository alunoRepository,
                       DisciplinaRepository disciplinaRepository) {
        this.notaRepository = notaRepository;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public NotaResponse create(NotaRequest request) {
        Aluno aluno = alunoRepository.findById(request.alunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(request.disciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        notaRepository.findByAlunoIdAndDisciplinaId(request.alunoId(), disciplina.getId())
                .ifPresent(nota -> {
                    throw new RuntimeException("Nota já lançada para esta disciplina");
                });

        Nota nota = new Nota();
        nota.setAluno(aluno);
        nota.setDisciplina(disciplina);
        nota.setValor(request.valor());

        Nota salva =  notaRepository.save(nota);

        return toResponse(salva);
    }

    public List<NotaResponse> listByAluno(Integer alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return notaRepository.findByAlunoId(aluno.getId())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private NotaResponse toResponse(Nota nota) {
        return new NotaResponse(
                nota.getDisciplina().getNome(),
                nota.getValor()
        );
    }

}
