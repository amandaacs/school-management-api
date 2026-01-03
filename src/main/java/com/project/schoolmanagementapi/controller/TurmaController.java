package com.project.schoolmanagementapi.controller;

import com.project.schoolmanagementapi.dto.turma.TurmaRequest;
import com.project.schoolmanagementapi.dto.turma.TurmaResponse;
import com.project.schoolmanagementapi.dto.turma.TurmaSummary;
import com.project.schoolmanagementapi.service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public ResponseEntity<TurmaResponse> criar(@RequestBody TurmaRequest request){
        TurmaResponse response = turmaService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TurmaSummary>> list() {
        return ResponseEntity.ok(turmaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(turmaService.findById(id));
    }

}
