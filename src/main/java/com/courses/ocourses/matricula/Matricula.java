package com.courses.ocourses.matricula;

import com.courses.ocourses.cursos.Curso;
import com.courses.ocourses.matricula.matriculaPK.MatriculaPK;
import com.courses.ocourses.usuario.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "table_matriculas")
public class Matricula implements Serializable {

    @EmbeddedId
    private MatriculaPK id;

    private LocalDateTime dataMatricula;
    private StatusMatricula status;
    private Integer progresso;
    private Double notaFinal;
    private LocalDateTime dataConclusao;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioMatriculado;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso cursoMatriculado;


    public Matricula() {
    }

    public Matricula(Usuario usuarioMatriculado, Curso cursoMatriculado){
        this.cursoMatriculado = cursoMatriculado;
        this.usuarioMatriculado = usuarioMatriculado;
    }

    public Matricula(LocalDateTime dataMatricula, StatusMatricula status, Usuario usuarioMatriculado, Curso cursoMatriculado) {
        this.dataMatricula = dataMatricula;
        this.status = status;
        this.usuarioMatriculado = usuarioMatriculado;
        this.cursoMatriculado = cursoMatriculado;
        this.id.setCursoId(cursoMatriculado.getId());
        this.id.setUsuarioId(usuarioMatriculado.getId());
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
