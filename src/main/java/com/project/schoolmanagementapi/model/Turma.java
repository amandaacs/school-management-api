package com.project.schoolmanagementapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "turma")
@Getter
@Setter
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private Integer ano;

    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
    private List<Aluno> alunos;

}
