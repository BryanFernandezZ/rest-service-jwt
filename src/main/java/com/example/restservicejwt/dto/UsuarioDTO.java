package com.example.restservicejwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer codigo;
    private String usuario;
    private String clave;
    private String nombre;
}
