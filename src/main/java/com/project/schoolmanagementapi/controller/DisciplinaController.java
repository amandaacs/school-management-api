package com.project.schoolmanagementapi.controller;

import com.project.schoolmanagementapi.dto.disciplina.DisciplinaRequest;
import com.project.schoolmanagementapi.dto.disciplina.DisciplinaResponse;
import com.project.schoolmanagementapi.service.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponse> create(@RequestBody DisciplinaRequest request) {
        DisciplinaResponse response = disciplinaService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponse>> list() {
        return ResponseEntity.ok(disciplinaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(disciplinaService.findById(id));
    }

}
