package com.example.restservicejwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Integer codigo;
    private String nombre;
    private String apellido;
    private String direccion;
}
