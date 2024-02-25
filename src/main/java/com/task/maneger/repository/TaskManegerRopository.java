package com.task.maneger.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.maneger.model.Tarefa;

@Repository
public interface TaskManegerRopository extends JpaRepository<Tarefa, Long> {

    Tarefa findByTituloDescricao(String titulo, String descricao);

    Page<Tarefa> findByTituloContainingOrderByDataAtualizacaoDesc(String titulo, Pageable pageable);

    Page<Tarefa> findAllByOrderByDataAtualizacaoDesc(Pageable Pegeable);

}
