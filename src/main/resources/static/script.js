document.addEventListener("DOMContentLoaded", carregarDisciplinas);

function carregarDisciplinas() {
    fetch("/disciplinas")
        .then(res => res.json())
        .then(data => {
            const select = document.getElementById("disciplinaId");

            select.innerHTML = '<option value="">Selecione a disciplina</option>';

            data.forEach(d => {
                const option = document.createElement("option");
                option.value = d.id;
                option.textContent = d.nome;
                select.appendChild(option);
            });
        })
        .catch(err => {
            console.error("Erro ao carregar disciplinas", err);
        });
}


function listarTurmas() {

    fetch("/turmas")
        .then(res => res.json())
        .then(data => {
            document.getElementById("turmasOutput").textContent =
                JSON.stringify(data, null, 2);
        });

}

function listarAlunos() {
    const turmaId = document.getElementById("turmaId").value;
    fetch(`/turmas/${turmaId}/alunos`)
        .then(res => res.json())
        .then(data => {
            document.getElementById("alunosOutput").textContent =
                JSON.stringify(data, null, 2)
        })
}

function lancarNota() {

    const body = {
        alunoId: document.getElementById("alunoNotaId").value,
        disciplinaId: document.getElementById("disciplinaId").value,
        valor: document.getElementById("valorNota").value
    };

    fetch("/notas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
    })
        .then(res => res.json())
        .then(data => {
            document.getElementById("notaOutput").textContent =
                JSON.stringify(data, null, 2);
        })

}

function verBoletim() {

    const alunoId = document.getElementById("alunoBoletimId").value;

    fetch(`/boletins/alunos/${alunoId}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById("boletimOutput").textContent =
                JSON.stringify(data, null, 2);
        })

}

function baixarPdf() {

    const alunoId = document.getElementById("alunoBoletimId").value;

    window.open(`/boletins/alunos/${alunoId}/pdf`, "_blank");

}