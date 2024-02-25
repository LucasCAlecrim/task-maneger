package com.task.maneger.model;

import java.io.Serializable;

import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true,length = 50)
    private String username;

    @Column(length = 150)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name="usuario_id"),
    inverseJoinColumns = @JoinColumn(name ="role_id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id" , "role_id"}))
    private List<Role>roles;
}
