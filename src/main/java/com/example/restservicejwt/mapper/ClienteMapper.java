package com.example.restservicejwt.mapper;

import com.example.restservicejwt.dto.ClienteDTO;
import com.example.restservicejwt.model.Cliente;

public class ClienteMapper implements IClienteMapper{

    @Override
    public ClienteDTO mapearDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getIdCliente(), cliente.getNombreCliene(), cliente.getApellidoCliente(), cliente.getDireccionCliente());
    }

    @Override
    public Cliente mapearEntidad(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getCodigo(), clienteDTO.getNombre(), clienteDTO.getApellido(), clienteDTO.getDireccion());
    }
}
