# School Management API

API REST desenvolvida em **Java com Spring Boot**, utilizando **Spring Data JPA** e **SQLite**, com o objetivo de gerenciar **turmas, alunos, disciplinas, notas** e gerar o **boletim escolar** de um aluno.

Este projeto foi desenvolvido como desafio técnico, seguindo boas práticas de arquitetura em camadas (Controller, Service, Repository) e uso de DTOs para transferência de dados.

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- SQLite
- Maven

---

## Arquitetura

O projeto segue o padrão **MVC**, organizado em camadas:

- **Controller** → Exposição dos endpoints REST
- **Service** → Regras de negócio
- **Repository** → Acesso ao banco de dados
- **DTO** → Entrada e saída de dados
- **Model (Entity)** → Mapeamento das tabelas

---

## Modelagem do Banco de Dados

Principais entidades:

- **Turma**
- **Aluno**
- **Disciplina**
- **Nota**

Relacionamentos:
- Uma **Turma** possui vários **Alunos**
- Um **Aluno** pertence a uma **Turma**
- Uma **Nota** relaciona **Aluno** + **Disciplina**

---

## Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven

### Passos

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/school-management-api.git

# Entrar no projeto
cd school-management-api

# Executar a aplicação
mvn spring-boot:run

# A aplicação será iniciada em:
http://localhost:808
```
---

## Endpoints Principais

### Turmas
- Listar turmas 
```
GET /turmas
```

### Alunos
- Listar alunos por turma
```
GET /alunos/turma/{turmaId}
```

### Disciplinas
- Listar disciplinas
```
GET /disciplinas
```

### Notas
- Cadastrar nota
```
POST /notas
```
Exemplo de body
```
{
  "alunoId": 1,
  "disciplinaId": 2,
  "valor": 8.5
}
```

### Boletim
- GET /boletim/alunos/{id}
```
GET /boletins/alunos/{id}
```
Exemplo de resposta
```
{
  "alunoId": 1,
  "alunoNome": "Maria Silva",
  "matricula": "2024001",
  "turmaCodigo": "3A",
  "turmaAno": 2024,
  "notas": [
    {
      "disciplina": "Matemática",
      "valor": 8.5
    },
    {
      "disciplina": "Português",
      "valor": 7.0
    }
  ]
}
```

## Funcionalidades Implementadas

- Cadastro e listagem de turmas
- Listagem de alunos por turma
- Cadastro de disciplinas
- Lançamento de notas
- Geração de boletim consolidado por aluno
- Uso de DTOs para resposta da API
- Banco SQLite integrado via JPA/Hibernate

## Observações Técnicas

1. O Boletim não é uma entidade persistida, sendo gerado dinamicamente a partir dos dados do banco.


2. O projeto utiliza hibernate-community-dialects para suporte ao SQLite.


3. O banco de dados é local, não exigindo instalação externa.


## Diagrama do Banco de Dados

![Diagrama do banco](database-diagram.svg)

## Autora

### Amanda Costa
Estudante de TI com foco em desenvolvimento backend e APIs REST.
Experiência com Java, Spring Boot, .NET, Angular e React.

## Licença

Este projeto foi desenvolvido para fins educacionais e de avaliação técnica.



