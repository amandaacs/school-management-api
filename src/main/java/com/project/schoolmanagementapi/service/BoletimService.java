package com.project.schoolmanagementapi.service;

import com.project.schoolmanagementapi.dto.boletim.BoletimResponse;
import com.project.schoolmanagementapi.dto.nota.NotaResponse;
import com.project.schoolmanagementapi.model.Aluno;
import com.project.schoolmanagementapi.repository.AlunoRepository;
import com.project.schoolmanagementapi.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimService {

    private final AlunoRepository alunoRepository;
    private final NotaRepository notaRepository;

    public BoletimService(AlunoRepository alunoRepository,
                          NotaRepository notaRepository) {
        this.alunoRepository = alunoRepository;
        this.notaRepository = notaRepository;
    }

    public BoletimResponse create(Integer alunoId){
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        List<NotaResponse> notas = notaRepository.findByAlunoId(aluno.getId())
                .stream()
                .map(nota -> new NotaResponse(
                        nota.getDisciplina().getNome(),
                        nota.getValor()
                ))
                .toList();

        return new BoletimResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getTurma().getCodigo(),
                aluno.getTurma().getAno(),
                notas
        );
    }

}
