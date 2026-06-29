package com.courses.ocourses.dashboard;


import com.courses.ocourses.usuario.Usuario;

import java.io.Serializable;

public class DashboardDTO implements Serializable {

    private String nome;
    private String sobrenome;
    private Integer totalCursos;



    public DashboardDTO(Usuario usuario){
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.totalCursos = usuario.getCursosMatriculados().size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getTotalCursos() {
        return totalCursos;
    }

    public void setTotalCursos(Integer totalCursos) {
        this.totalCursos = totalCursos;
    }


}
