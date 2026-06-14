package com.courses.ocourses.matricula;

import com.courses.ocourses.matricula.matriculaPK.MatriculaPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "table_matriculas")
public class Matricula implements Serializable {

    @EmbeddedId
    private MatriculaPK id = new MatriculaPK();

    private LocalDateTime dataMatricula;
    private StatusMatricula status;
    private Integer progresso;
    private Double notaFinal;
    private LocalDateTime dataConclusao;

    public Matricula(MatriculaPK id, LocalDateTime dataMatricula, StatusMatricula status, Integer progresso) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.status = status;
        this.progresso = progresso;
    }

    public MatriculaPK getId() {
        return id;
    }

    public void setId(MatriculaPK id) {
        this.id = id;
    }

    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    public void setStatus(StatusMatricula status) {
        this.status = status;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id) && Objects.equals(dataMatricula, matricula.dataMatricula) && status == matricula.status && Objects.equals(progresso, matricula.progresso) && Objects.equals(notaFinal, matricula.notaFinal) && Objects.equals(dataConclusao, matricula.dataConclusao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataMatricula, status, progresso, notaFinal, dataConclusao);
    }

}
