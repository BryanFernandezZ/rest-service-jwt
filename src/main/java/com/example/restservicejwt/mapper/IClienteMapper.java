package com.example.restservicejwt.mapper;

import com.example.restservicejwt.dto.ClienteDTO;
import com.example.restservicejwt.model.Cliente;

public interface IClienteMapper {
    ClienteDTO mapearDTO(Cliente cliente);

    Cliente mapearEntidad(ClienteDTO clienteDTO);
}
