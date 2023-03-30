package com.example.restservicejwt.service;

import com.example.restservicejwt.dto.ClienteDTO;
import com.example.restservicejwt.mapper.ClienteMapper;
import com.example.restservicejwt.model.Cliente;
import com.example.restservicejwt.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImp implements IClienteService {

    private final ClienteMapper clienteMapper = new ClienteMapper();

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(c -> clienteMapper.mapearDTO(c)).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) return clienteMapper.mapearDTO(cliente);
        return null;
    }

    @Override
    public void save(ClienteDTO clienteDTO) {
        clienteRepository.save(clienteMapper.mapearEntidad(clienteDTO));
    }

    @Override
    public void saveAndFlush(ClienteDTO clienteDTO) {
        clienteRepository.saveAndFlush(clienteMapper.mapearEntidad(clienteDTO));
    }

    @Override
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}
