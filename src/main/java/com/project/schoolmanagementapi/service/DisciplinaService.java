package com.project.schoolmanagementapi.service;

import com.project.schoolmanagementapi.dto.disciplina.DisciplinaRequest;
import com.project.schoolmanagementapi.dto.disciplina.DisciplinaResponse;
import com.project.schoolmanagementapi.model.Disciplina;
import com.project.schoolmanagementapi.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public DisciplinaResponse create(DisciplinaRequest request) {
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(request.nome());

        Disciplina salva =  disciplinaRepository.save(disciplina);

        return toResponse(salva);
    }

    public List<DisciplinaResponse> list() {
        return disciplinaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public DisciplinaResponse findById(Integer id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        return toResponse(disciplina);
    }

    private DisciplinaResponse toResponse(Disciplina disciplina) {
        return new DisciplinaResponse(
          disciplina.getId(),
          disciplina.getNome()
        );
    }

}
