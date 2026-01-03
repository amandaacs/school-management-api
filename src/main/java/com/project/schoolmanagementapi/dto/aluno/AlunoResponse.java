package com.project.schoolmanagementapi.dto.aluno;

import com.project.schoolmanagementapi.dto.turma.TurmaSummary;

public record AlunoResponse(
        Integer id,
        String nome,
        String matricula,
        TurmaSummary turma
) {
}
