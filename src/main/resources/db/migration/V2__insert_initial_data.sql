INSERT INTO turma (codigo, ano) VALUES
                                  ('1º Ano A', 2025),
                                  ('1º Ano B', 2025),
                                  ('2º Ano A', 2025);

INSERT INTO aluno (nome, matricula, turma_id) VALUES
-- 1º Ano A
('João Silva', '2025001', 1),
('Maria Oliveira', '2025002', 1),
('Lucas Santos', '2025003', 1),
-- 1º Ano B
('Ana Costa', '2025101', 2),
('Pedro Lima', '2025102', 2),
('Beatriz Rocha', '2025103', 2),
-- 2º Ano A
('Rafael Martins', '2025201', 3),
('Carla Nogueira', '2025202', 3);

INSERT INTO disciplina (nome) VALUES
                                  ('Matemática'),
                                  ('Português'),
                                  ('História'),
                                  ('Geografia'),
                                  ('Ciências');

-- João Silva (1º Ano A)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (1, 1, 8.5),
                                                      (1, 2, 7.8),
                                                      (1, 3, 9.0),
                                                      (1, 4, 8.0),
                                                      (1, 5, 8.7);

-- Maria Oliveira (1º Ano A)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (2, 1, 9.2),
                                                      (2, 2, 8.9),
                                                      (2, 3, 8.5),
                                                      (2, 4, 9.0),
                                                      (2, 5, 9.1);

-- Lucas Santos (1º Ano A)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (3, 1, 7.0),
                                                      (3, 2, 6.8),
                                                      (3, 3, 7.5),
                                                      (3, 4, 7.2),
                                                      (3, 5, 7.0);

-- Ana Costa (1º Ano B)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (4, 1, 8.8),
                                                      (4, 2, 9.0),
                                                      (4, 3, 8.6),
                                                      (4, 4, 8.9),
                                                      (4, 5, 9.2);

-- Pedro Lima (1º Ano B)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (5, 1, 6.9),
                                                      (5, 2, 7.2),
                                                      (5, 3, 6.8),
                                                      (5, 4, 7.0),
                                                      (5, 5, 7.4);

-- Beatriz Rocha (1º Ano B)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (6, 1, 9.5),
                                                      (6, 2, 9.3),
                                                      (6, 3, 9.0),
                                                      (6, 4, 9.4),
                                                      (6, 5, 9.6);

-- Rafael Martins (2º Ano A)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (7, 1, 8.0),
                                                      (7, 2, 7.5),
                                                      (7, 3, 8.2),
                                                      (7, 4, 7.8),
                                                      (7, 5, 8.1);

-- Carla Nogueira (2º Ano A)
INSERT INTO nota (aluno_id, disciplina_id, valor) VALUES
                                                      (8, 1, 9.1),
                                                      (8, 2, 9.0),
                                                      (8, 3, 8.8),
                                                      (8, 4, 9.2),
                                                      (8, 5, 9.0);
