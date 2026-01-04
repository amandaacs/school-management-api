package com.project.schoolmanagementapi.controller;

import com.project.schoolmanagementapi.dto.boletim.BoletimResponse;
import com.project.schoolmanagementapi.service.BoletimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boletins")
public class BoletimController {

    private final BoletimService boletimService;

    public BoletimController(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<BoletimResponse> getBoletim(@PathVariable Integer id){
        return ResponseEntity.ok(boletimService.create(id));
    }

}
