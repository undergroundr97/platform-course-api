package com.courses.ocourses.pagamento;

import com.courses.ocourses.matricula.Matricula;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "table_pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataPagamento;
    private Double valor;
    private MetodoPagamento metodoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento")
    private StatusPagamento status;

    @ManyToOne
    private Matricula matricula;

    public Pagamento() {
    }

    public Pagamento(Long id, LocalDateTime dataPagamento, Double valor, MetodoPagamento metodoPagamento, Matricula matricula) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.matricula = matricula;
        this.status = StatusPagamento.PENDENTE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && Objects.equals(dataPagamento, pagamento.dataPagamento) && Objects.equals(valor, pagamento.valor) && metodoPagamento == pagamento.metodoPagamento && Objects.equals(matricula, pagamento.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataPagamento, valor, metodoPagamento, matricula);
    }
}
