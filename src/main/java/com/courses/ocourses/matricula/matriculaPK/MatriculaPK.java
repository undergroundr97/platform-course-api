package com.courses.ocourses.matricula.matriculaPK;

import com.courses.ocourses.cursos.Curso;
import com.courses.ocourses.usuario.Usuario;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

//@Entity
@Embeddable
public class MatriculaPK implements Serializable {

    private Long cursoId;
    private Long usuarioId;

    public MatriculaPK() {
    }

    public MatriculaPK(Curso curso, Usuario usuario) {
        this.cursoId = curso.getId();
        this.usuarioId = usuario.getId();
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaPK that = (MatriculaPK) o;
        return Objects.equals(cursoId, that.cursoId) && Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursoId, usuarioId);
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
