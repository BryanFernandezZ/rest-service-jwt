package com.example.restservicejwt.controller;

import com.example.restservicejwt.dto.LoginDTO;
import com.example.restservicejwt.dto.TokenDTO;
import com.example.restservicejwt.security.UserDetailService;
import com.example.restservicejwt.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtUtil util;
    @Autowired
    private UserDetailService service;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        UserDetails usuario = service.loadUserByUsername(loginDTO.getUsername());
        if (encoder.matches(loginDTO.getPassword(), usuario.getPassword()))
            return new ResponseEntity<>(new TokenDTO("Bearer", util.generateToken(usuario.getUsername())), HttpStatus.OK);
        else throw new UsernameNotFoundException("Username y/o password incorrecto");
    }
}
