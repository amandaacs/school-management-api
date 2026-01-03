package com.project.schoolmanagementapi.dto.nota;

public record NotaRequest(
        Long alunoId,
        Long disciplinaId,
        Double valor
) {
}
