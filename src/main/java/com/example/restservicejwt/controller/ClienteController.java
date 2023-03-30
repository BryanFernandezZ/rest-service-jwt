package com.example.restservicejwt.controller;

import com.example.restservicejwt.dto.ClienteDTO;
import com.example.restservicejwt.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ClienteDTO cliente = clienteService.findById(id);
        if (cliente == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) {
        if (clienteDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clienteService.save(clienteDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<?> saveAndFlush(@RequestBody ClienteDTO clienteDTO) {
        if (clienteDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ClienteDTO cliente = clienteService.findById(clienteDTO.getCodigo());
        if (cliente == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        clienteService.saveAndFlush(clienteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ClienteDTO cliente = clienteService.findById(id);
        if (cliente == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        clienteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
