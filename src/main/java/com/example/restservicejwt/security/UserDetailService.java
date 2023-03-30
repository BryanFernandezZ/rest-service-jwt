package com.example.restservicejwt.security;

import com.example.restservicejwt.model.Usuario;
import com.example.restservicejwt.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(username);

        if (usuario != null)
            return new User(usuario.getLogin(), usuario.getClave(), new ArrayList<>());
        else throw new UsernameNotFoundException("No existe el usuario " + username);
    }
}
