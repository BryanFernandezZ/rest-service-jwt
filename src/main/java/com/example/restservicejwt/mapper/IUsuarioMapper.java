package com.example.restservicejwt.mapper;

import com.example.restservicejwt.dto.UsuarioDTO;
import com.example.restservicejwt.model.Usuario;

public interface IUsuarioMapper {
    UsuarioDTO mapearDTO(Usuario usuario);

    Usuario mapearEntidad(UsuarioDTO usuarioDTO);
}
