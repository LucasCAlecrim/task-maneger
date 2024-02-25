package com.task.maneger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.maneger.model.Role;
import com.task.maneger.permissoes.PermissaoEnum;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNome(PermissaoEnum nome);
    
}
