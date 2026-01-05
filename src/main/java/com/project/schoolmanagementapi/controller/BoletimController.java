package com.project.schoolmanagementapi.controller;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.project.schoolmanagementapi.dto.boletim.BoletimResponse;
import com.project.schoolmanagementapi.dto.nota.NotaResponse;
import com.project.schoolmanagementapi.service.BoletimService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/boletins")
public class BoletimController {

    private final BoletimService boletimService;

    public BoletimController(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<BoletimResponse> getBoletim(@PathVariable Integer id){
        return ResponseEntity.ok(boletimService.create(id));
    }

    @GetMapping("/alunos/{id}/pdf")
    public ResponseEntity<byte[]> getBoletimPdf(@PathVariable Integer id){

        BoletimResponse boletim = boletimService.create(id);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            document.add(new Paragraph("Boletim Escolar"));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Aluno: " + boletim.alunoNome()));
            document.add(new Paragraph("Matrícula: " + boletim.matricula()));
            document.add(new Paragraph(
                    "Turma: " + boletim.turmaCodigo() + " - " + boletim.turmaAno()
            ));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Disciplinas e Notas:"));

            for (NotaResponse nota : boletim.notas()) {
                document.add(new Paragraph(
                        "- " + nota.disciplina() + ": " + nota.valor()
                ));
            }

            document.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF!", e);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=boletim.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(outputStream.toByteArray());

    }

}
