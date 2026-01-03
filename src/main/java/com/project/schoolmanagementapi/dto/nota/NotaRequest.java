package com.project.schoolmanagementapi.dto.nota;

public record NotaRequest(
        Integer alunoId,
        Integer disciplinaId,
        Double valor
) {
}
