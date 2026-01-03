package com.project.schoolmanagementapi.service;

import com.project.schoolmanagementapi.dto.turma.TurmaRequest;
import com.project.schoolmanagementapi.dto.turma.TurmaResponse;
import com.project.schoolmanagementapi.dto.turma.TurmaSummary;
import com.project.schoolmanagementapi.model.Turma;
import com.project.schoolmanagementapi.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaResponse create(TurmaRequest request) {
        Turma turma = new Turma();
        turma.setCodigo(request.codigo());
        turma.setAno(request.ano());

        Turma salva = turmaRepository.save(turma);

        return toResponse(salva);
    }

    public List<TurmaSummary> list() {
        return turmaRepository.findAll()
                .stream()
                .map(this::toSummary)
                .toList();
    }

    public TurmaResponse findById(Integer id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        return toResponse(turma);
    }

    private TurmaResponse toResponse(Turma turma) {

        return  new TurmaResponse(
                turma.getId(),
                turma.getCodigo(),
                turma.getAno()
        );

    }

    private TurmaSummary toSummary(Turma turma) {
        return new TurmaSummary(
                turma.getId(),
                turma.getCodigo(),
                turma.getAno()
        );
    }


}
