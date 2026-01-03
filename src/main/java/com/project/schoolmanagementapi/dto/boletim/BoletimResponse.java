package com.project.schoolmanagementapi.dto.boletim;

import com.project.schoolmanagementapi.dto.nota.NotaResponse;

import java.util.List;

public record BoletimResponse(
        Integer alunoId,
        String alunoNome,
        String matricula,
        String turmaCodigo,
        Integer turmaAno,
        List<NotaResponse> notas
) {
}
