package com.project.schoolmanagementapi.controller;

import com.project.schoolmanagementapi.dto.aluno.AlunoRequest;
import com.project.schoolmanagementapi.dto.aluno.AlunoResponse;
import com.project.schoolmanagementapi.dto.aluno.AlunoSummary;
import com.project.schoolmanagementapi.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/alunos")
    public ResponseEntity<AlunoResponse> create(@RequestBody AlunoRequest request) {
        AlunoResponse response = alunoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<AlunoResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @GetMapping("/turmas/{id}/alunos")
    public ResponseEntity<List<AlunoSummary>> listByTurma(@PathVariable Integer id) {
        return ResponseEntity.ok(alunoService.listByTurma(id));
    }

}
