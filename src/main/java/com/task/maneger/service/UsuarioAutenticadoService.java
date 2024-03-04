package com.task.maneger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.maneger.model.Usuario;
import com.task.maneger.repository.UsuarioRepository;

import jakarta.transaction.TransactionScoped;

@Service
@TransactionScoped
public class UsuarioAutenticadoService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = iUsuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário" + username + "não foi encontrado"));
        List<SimpleGrantedAuthority> roles = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome().toString()))
                .toList();

        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    @Autowired
    private UsuarioRepository iUsuarioRepository;
}
