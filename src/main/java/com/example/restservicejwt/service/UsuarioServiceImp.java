package com.example.restservicejwt.service;

import com.example.restservicejwt.dto.UsuarioDTO;
import com.example.restservicejwt.mapper.UsuarioMapper;
import com.example.restservicejwt.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements IUsuarioService{

    private final UsuarioMapper usuarioMapper =  new UsuarioMapper();

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public void save(UsuarioDTO usuarioDTO) {
        repository.save(usuarioMapper.mapearEntidad(usuarioDTO));
    }
}
