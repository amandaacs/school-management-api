package com.project.schoolmanagementapi.dto.aluno;

public record AlunoRequest(
        String nome,
        String matricula,
        Long turmaId
) {
}
