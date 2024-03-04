package com.task.maneger.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.task.maneger.model.Usuario;
import com.task.maneger.repository.RoleRepository;
import com.task.maneger.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setRoles(usuario.getRoles()
                .stream()
                .map(role -> iRoleRepository.findByNome(role.getNome()))
                .toList());

        usuario.setPassword(PasswordEncoder.encode(usuario.getPassword()));
        return this.iUsuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        usuario.setRoles(usuario.getRoles()
                .stream()
                .map(role -> iRoleRepository.findByNome(role.getNome()))
                .toList());

        usuario.setPassword(PasswordEncoder.encode(usuario.getPassword()));
        return this.iUsuarioRepository.save(usuario);
    }

    @SuppressWarnings("null")
    public Optional<Usuario> obeterUsuarioId(Long usuarioId) {
        return this.iUsuarioRepository.findById(usuarioId);
    }

    @SuppressWarnings("null")
    public void ecluirUsuario(Usuario usuario) {
        this.iUsuarioRepository.deleteById(usuario.getId());
    }

    public List<Usuario> obtemUsuarios() {
        return this.iUsuarioRepository.findAll();
    }

    @Autowired
    private UsuarioRepository iUsuarioRepository;
    @Autowired
    private RoleRepository iRoleRepository;
    @Autowired
    PasswordEncoder PasswordEncoder;
}
