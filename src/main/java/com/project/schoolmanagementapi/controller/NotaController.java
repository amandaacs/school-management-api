package com.project.schoolmanagementapi.controller;

import com.project.schoolmanagementapi.dto.nota.NotaRequest;
import com.project.schoolmanagementapi.dto.nota.NotaResponse;
import com.project.schoolmanagementapi.service.NotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public ResponseEntity<NotaResponse> create(@RequestBody NotaRequest request){
        NotaResponse response = notaService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<List<NotaResponse>> findByAluno(@PathVariable Integer id){
        return ResponseEntity.ok(notaService.listByAluno(id));
    }

}
