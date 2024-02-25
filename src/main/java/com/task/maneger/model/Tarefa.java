package com.task.maneger.model;

import java.io.Serializable;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.task.maneger.status.TarefaStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tarefas")
@Data
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    public Tarefa(){
    }
    public Tarefa(Long id, String titulo, String descricao, TarefaStatusEnum status, Usuario responsavel, Usuario criador, int quantidadeHorasEstimadas, Integer quantidadeHorasRealizada, LocalTime dataCadastro, LocalTime dataAtualizacao){
        this.id=id;
        this.titulo=titulo;
        this.descricao=descricao;
        this.status=status;
        this.responsavel=responsavel;
        this.criador=criador;
        this.quantidadeHorasEstimadas=quantidadeHorasEstimadas;
        this.quantidadeHorasRealizada=quantidadeHorasRealizada;
        this.dataCadastro=dataCadastro;
        this.dataAtualizacao=dataAtualizacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Usuario criador;

    @Column(nullable = false)
    private int quantidadeHorasEstimadas;

    @Column
    private Usuario responsavel;

    @Column
    private Integer quantidadeHorasRealizada;

    @Column
    @CreationTimestamp
    private LocalTime dataCadastro;

    @Column
    @UpdateTimestamp
    private LocalTime dataAtualizacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TarefaStatusEnum status;
}
