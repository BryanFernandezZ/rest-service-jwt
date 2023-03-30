package com.example.restservicejwt.mapper;

import com.example.restservicejwt.dto.UsuarioDTO;
import com.example.restservicejwt.model.Usuario;

public class UsuarioMapper implements IUsuarioMapper{
    @Override
    public UsuarioDTO mapearDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getLogin(), usuario.getClave(), usuario.getNombre());
    }

    @Override
    public Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getCodigo(), usuarioDTO.getUsuario(), usuarioDTO.getClave(), usuarioDTO.getNombre());
    }
}
