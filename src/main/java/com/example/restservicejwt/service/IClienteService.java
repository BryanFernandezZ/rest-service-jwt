package com.example.restservicejwt.service;

import com.example.restservicejwt.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> findAll();
    ClienteDTO findById(Integer id);
    void save(ClienteDTO clienteDTO);
    void saveAndFlush(ClienteDTO clienteDTO);
    void deleteById(Integer id);
}
