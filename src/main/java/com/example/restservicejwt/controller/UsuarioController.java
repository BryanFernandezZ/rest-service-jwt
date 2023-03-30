package com.example.restservicejwt.controller;

import com.example.restservicejwt.dto.UsuarioDTO;
import com.example.restservicejwt.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(path = "/guardar",  method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        usuarioDTO.setClave(encoder.encode(usuarioDTO.getClave()));
        service.save(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
