CREATE TABLE turma (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigo TEXT NOT NULL,
    ano INTEGER NOT NULL
);

CREATE TABLE aluno (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    matricula TEXT NOT NULL UNIQUE,
    turma_id INTEGER NOT NULL,
    FOREIGN KEY (turma_id) REFERENCES turma(id)
);

CREATE TABLE disciplina (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL
);

CREATE TABLE nota (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  aluno_id INTEGER NOT NULL,
  disciplina_id INTEGER NOT NULL,
  valor REAL NOT NULL,
  FOREIGN KEY (aluno_id) REFERENCES aluno(id),
  FOREIGN KEY (disciplina_id) REFERENCES disciplina(id),
  UNIQUE (aluno_id, disciplina_id)
);